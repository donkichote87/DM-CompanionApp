package pl.basicstuff.dmcompanionapp.npc;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.basicstuff.dmcompanionapp.user.CurrentUser;
import pl.basicstuff.dmcompanionapp.user.User;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/npc")
public class NpcController {
    private final NpcService npcService;

    @GetMapping("/create")
    public String npcCreateForm(Model model) {
        model.addAttribute("npc", new Npc());
        return "npc/npc-form";
    }

    @PostMapping("/create")

    public String npcSave(@Valid Npc npc, BindingResult result, @AuthenticationPrincipal CurrentUser customUser, RedirectAttributes attributes) {
        User entityUser = customUser.getUser();
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
    public String npcEditForm(@PathVariable Long id, Model model, @AuthenticationPrincipal CurrentUser customUser) {
        Long currentUser = customUser.getUser().getId();
        Long npcUser = getNpc(id).getUser().getId();
        if (currentUser != npcUser) {
            return "403";
        }
        model.addAttribute("npc", getNpc(id));
        return "npc/npc-form";
    }

    @PostMapping("/edit/{id}")
    public String npcEditSave(@Valid Npc npc, BindingResult result, RedirectAttributes attributes, @AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        if (result.hasErrors()) {
            return "npc/npc-form";
        }
        npcService.updateNpc(npc);
        attributes.addFlashAttribute("Success", "Bohater niezależny został zapisany");
        return "redirect:/npc/list";
    }

    @RequestMapping("/confirm/{id}")
    public String confirm(@PathVariable long id, Model model, @AuthenticationPrincipal CurrentUser customUser) {
        Long currentUser = customUser.getUser().getId();
        Long npcUser = getNpc(id).getUser().getId();
        if (currentUser != npcUser) {
            return "403";
        }
        model.addAttribute("npc", npcService.findNpcById(id));
        return "npc/npc-confirm";
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id, RedirectAttributes attributes, @AuthenticationPrincipal CurrentUser customUser) {
        Long currentUser = customUser.getUser().getId();
        Long npcUser = getNpc(id).getUser().getId();
        if (currentUser != npcUser) {
            return "403";
        }

        npcService.deleteNpc(getNpc(id));
        attributes.addFlashAttribute("Success", "Bohater niezależny został usunięty");
        return "redirect:/npc/list";
    }

    @GetMapping("/view/{id}")
    public String npcReadForm(@PathVariable Long id, Model model, @AuthenticationPrincipal CurrentUser customUser) {
        Long currentUser = customUser.getUser().getId();
        Long npcUser = getNpc(id).getUser().getId();
        if (currentUser != npcUser) {
            return "403";
        }


        model.addAttribute("npc", npcStringToHtml(getNpc(id)));
        return "npc/npc-view";
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
}
