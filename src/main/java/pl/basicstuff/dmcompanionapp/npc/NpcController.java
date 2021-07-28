package pl.basicstuff.dmcompanionapp.npc;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String npcForm(Model model) {
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
        return "redirect:create";
    }
    @GetMapping("/list")
    public String npcList(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        List<Npc> npcs = npcService.findNpcsByUserId(customUser.getUser().getId());
        model.addAttribute("npcs", npcs);
        return "npc/npc-list";
    }


}
