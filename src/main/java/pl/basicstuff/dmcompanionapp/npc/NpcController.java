package pl.basicstuff.dmcompanionapp.npc;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.basicstuff.dmcompanionapp.data.alignment.Alignment;
import pl.basicstuff.dmcompanionapp.data.alignment.AlignmentService;
import pl.basicstuff.dmcompanionapp.user.CurrentUser;
import pl.basicstuff.dmcompanionapp.user.User;
import pl.basicstuff.dmcompanionapp.user.service.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
@RequiredArgsConstructor
@RequestMapping("/npc")
public class NpcController {
    private final NpcService npcService;
    private final UserService userService;
    private final AlignmentService alignmentService;



    @ModelAttribute("alignments")
    public List<Alignment> getAlignments() {
        return alignmentService.alignmentsList();
    }


    @GetMapping("/create")
    public String npcCreateForm(Model model) {
        model.addAttribute("npc", new Npc());
        return "npc/npc-form";
    }

    @PostMapping("/create")

    public String npcSave(@Valid Npc npc, BindingResult result, Principal principal, RedirectAttributes attributes) {
        User entityUser = userService.findById(userId(principal));
        if (result.hasErrors()) {
            return "npc/npc-form";
        }
        npc.setUser(entityUser);
        npcService.saveNpc(npc);
        attributes.addFlashAttribute("Success", "Bohater niezależny został zapisany");
        return "redirect:/npc/list";
    }

    @GetMapping("/list")
    public String npcList(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        List<Npc> npcs = npcService.findNpcsByUserId(customUser.getUser().getId());
        model.addAttribute("npcs", npcs);
        return "npc/npc-list";
    }

    @GetMapping("/edit/{id}")
    public String npcEditForm(@PathVariable Long id, Model model, Principal principal) {
        Long currentUser = userId(principal);
        Long npcUser = getNpc(id).getUser().getId();
        if (currentUser != npcUser) {
            return "403";
        }
        model.addAttribute("npc", getNpc(id));
        return "npc/npc-form";
    }

    @PostMapping("/edit/{id}")
    public String npcEditSave(@Valid Npc npc, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            return "npc/npc-form";
        }
        npcService.updateNpc(npc);
        attributes.addFlashAttribute("Success", "Bohater niezależny został nadpisany");
        return "redirect:/npc/list";
    }

    @RequestMapping("/confirm/{id}")
    public String confirm(@PathVariable long id, Model model, Principal principal) {
        Long currentUser = userId(principal);
        Long npcUser = getNpc(id).getUser().getId();
        if (currentUser != npcUser) {
            return "403";
        }
        model.addAttribute("npc", npcService.findNpcById(id));
        return "npc/npc-confirm";
    }

    @RequestMapping("/delete/{id}")
    public String deleteNpc(@PathVariable Long id, RedirectAttributes attributes, Principal principal) {
        Long currentUser = userId(principal);
        Long npcUser = getNpc(id).getUser().getId();
        if (currentUser != npcUser) {
            return "403";
        }

        npcService.deleteNpc(getNpc(id));
        attributes.addFlashAttribute("Success", "Bohater niezależny został usunięty");
        return "redirect:/npc/list";
    }

    @GetMapping("/view/{id}")
    public String npcReadForm(@PathVariable Long id, Model model, Principal principal) {
        Long currentUser = userId(principal);
        Long npcUser = getNpc(id).getUser().getId();
        if (currentUser != npcUser) {
            return "403";
        }


        model.addAttribute("npc", npcStringToHtml(getNpc(id)));
        return "npc/npc-view";
    }

    @GetMapping("/random")
    public String npcRandomForm(Model model) {
        model.addAttribute("npc", npcService.getRandomNpc(randomSex()));
        return "npc/npc-form";
    }

    @PostMapping("/random")

    public String npcRandom(@Valid Npc npc, BindingResult result, Principal principal, RedirectAttributes attributes) {
        User entityUser = userService.findById(userId(principal));
        if (result.hasErrors()) {
            return "npc/npc-form";
        }
        npc.setUser(entityUser);
        npcService.saveNpc(npc);
        attributes.addFlashAttribute("Success", "Bohater niezależny został zapisany");
        return "redirect:/npc/list";
    }


    public Npc getNpc(Long id) {
        return npcService.findNpcById(id);
    }


    public Npc npcStringToHtml(Npc npc) {
        npc.setHistory(npc.getHistory().replaceAll("(\r\n|\n)", "<br>"));
        npc.setAbilities(npc.getAbilities().replaceAll("(\r\n|\n)", "<br />"));
        npc.setAppearance(npc.getAppearance().replaceAll("(\r\n|\n)", "<br />"));
        npc.setBond(npc.getBond().replaceAll("(\r\n|\n)", "<br />"));
        npc.setFlawOrSecret(npc.getFlawOrSecret().replaceAll("(\r\n|\n)", "<br />"));
        npc.setIdeal(npc.getIdeal().replaceAll("(\r\n|\n)", "<br />"));
        npc.setInteraction(npc.getInteraction().replaceAll("(\r\n|\n)", "<br />"));
        npc.setMannerism(npc.getMannerism().replaceAll("(\r\n|\n)", "<br />"));
        npc.setTalent(npc.getTalent().replaceAll("(\r\n|\n)", "<br />"));
        npc.setUsefulKnowledge(npc.getUsefulKnowledge().replaceAll("(\r\n|\n)", "<br />"));

        return npc;
    }

    public Long userId(Principal principal) {
        return userService.findByUserName(principal.getName()).getId();
    }

    public String randomSex() {
        Random random = new Random();
        List<String> sexes = new ArrayList<>(Arrays.asList("M", "F"));
        return sexes.get(random.nextInt(sexes.size()));
    }


}
