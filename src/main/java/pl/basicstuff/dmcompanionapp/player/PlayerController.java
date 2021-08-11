package pl.basicstuff.dmcompanionapp.player;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.basicstuff.dmcompanionapp.data.alignment.Alignment;
import pl.basicstuff.dmcompanionapp.data.alignment.AlignmentService;
import pl.basicstuff.dmcompanionapp.data.background.Background;
import pl.basicstuff.dmcompanionapp.data.background.BackgroundService;
import pl.basicstuff.dmcompanionapp.data.characterclass.CharacterClass;
import pl.basicstuff.dmcompanionapp.data.characterclass.CharacterClassService;
import pl.basicstuff.dmcompanionapp.data.race.Race;
import pl.basicstuff.dmcompanionapp.data.race.RaceService;
import pl.basicstuff.dmcompanionapp.npc.Npc;
import pl.basicstuff.dmcompanionapp.user.CurrentUser;
import pl.basicstuff.dmcompanionapp.user.User;
import pl.basicstuff.dmcompanionapp.user.service.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;
    private final CharacterClassService characterClassService;
    private final RaceService raceService;
    private final BackgroundService backgroundService;
    private final UserService userService;
    private final AlignmentService alignmentService;

    @ModelAttribute("races")
    public List<Race> getRaces() {
        return raceService.racesList();
    }

    @ModelAttribute("characterClasses")
    public List<CharacterClass> getClasses() {
        return characterClassService.classesList();
    }

    @ModelAttribute("backgrounds")
    public List<Background> getBackgrounds() {
        return backgroundService.backgroundsList();
    }

    @ModelAttribute("alignments")
    public List<Alignment> getAlignments() {
        return alignmentService.alignmentsList();
    }

    @GetMapping("/create")
    public String playerCreateForm(Model model) {
        model.addAttribute("player", new Player());
        return "player/player-form";
    }

    @PostMapping("/create")
    public String playerSave(@Valid Player player, BindingResult result, Principal principal, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "player/player-form";
        }
        player.setUser(userService.findByUserName(principal.getName()));
        playerService.savePlayer(player);
        attributes.addFlashAttribute("Success", "Postać gracza została zapisana");
        return "redirect:/player/list";
    }

    @GetMapping("/list")
    public String playerList(Principal principal, Model model) {
        List<Player> players = playerService.findAllByUserIdOrderByIdDesc(userId(principal));
        model.addAttribute("players", players);
        return "player/player-list";
    }

    @GetMapping("/edit/{id}")
    public String playerEditForm(@PathVariable Long id, Model model, Principal principal) {
        Long currentUser = userId(principal);
        Long playerUser = getPlayer(id).getUser().getId();
        if (currentUser != playerUser) {
            return "403";
        }
        model.addAttribute("player", getPlayer(id));
        return "player/player-form";
    }

    @PostMapping("/edit/{id}")
    public String playerEditSave(@Valid Player player, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "player/player-form";
        }
        playerService.updatePlayer(player);
        attributes.addFlashAttribute("Success", "Postać gracza została nadpisana");
        return "redirect:/player/list";
    }

    @RequestMapping("/confirm/{id}")
    public String confirm(@PathVariable long id, Model model, Principal principal) {
        Long currentUser = userId(principal);
        Long playerUser = getPlayer(id).getUser().getId();
        if (currentUser != playerUser) {
            return "403";
        }
        model.addAttribute("player", playerService.findPlayerById(id));
        return "player/player-confirm";
    }

    @RequestMapping("/delete/{id}")
    public String deletePlayer(@PathVariable Long id, RedirectAttributes attributes, Principal principal) {
        Long currentUser = userId(principal);
        Long playerUser = getPlayer(id).getUser().getId();
        if (currentUser != playerUser) {
            return "403";
        }

        playerService.deletePlayer(getPlayer(id));
        attributes.addFlashAttribute("Success", "Postać gracza została usunięta");
        return "redirect:/player/list";
    }

    @GetMapping("/view/{id}")
    public String playerReadForm(@PathVariable Long id, Model model, Principal principal) {
        Long currentUser = userId(principal);
        Long playerUser = getPlayer(id).getUser().getId();
        if (currentUser != playerUser) {
            return "403";
        }

        model.addAttribute("player", playerStringToHtml(getPlayer(id)));
        return "player/player-view";
    }

    public Player getPlayer(Long id) {
        return playerService.findPlayerById(id);
    }

    public Long userId(Principal principal) {
        return userService.findByUserName(principal.getName()).getId();
    }

    public Player playerStringToHtml(Player player) {
        player.setHistory(player.getHistory().replaceAll("(\r\n|\n)", "<br>"));
        player.setSkills(player.getSkills().replaceAll("(\r\n|\n)", "<br />"));
        player.setEquipment(player.getEquipment().replaceAll("(\r\n|\n)", "<br />"));
        player.setBond(player.getBond().replaceAll("(\r\n|\n)", "<br />"));
        player.setFlaw(player.getFlaw().replaceAll("(\r\n|\n)", "<br />"));
        player.setIdeal(player.getIdeal().replaceAll("(\r\n|\n)", "<br />"));
        player.setProficienciesAndLanguages(player.getProficienciesAndLanguages().replaceAll("(\r\n|\n)", "<br />"));
        player.setPersonalityTraits(player.getPersonalityTraits().replaceAll("(\r\n|\n)", "<br />"));
        player.setFeaturesAndTraits(player.getFeaturesAndTraits().replaceAll("(\r\n|\n)", "<br />"));

        return player;
    }


}
