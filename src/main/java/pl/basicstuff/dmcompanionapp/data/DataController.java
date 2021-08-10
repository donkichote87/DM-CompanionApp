package pl.basicstuff.dmcompanionapp.data;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.basicstuff.dmcompanionapp.data.appearance.Appearance;
import pl.basicstuff.dmcompanionapp.data.appearance.AppearanceService;
import pl.basicstuff.dmcompanionapp.data.background.Background;
import pl.basicstuff.dmcompanionapp.data.background.BackgroundService;
import pl.basicstuff.dmcompanionapp.data.characterclass.CharacterClass;
import pl.basicstuff.dmcompanionapp.data.characterclass.CharacterClassService;
import pl.basicstuff.dmcompanionapp.data.firstname.FirstName;
import pl.basicstuff.dmcompanionapp.data.firstname.FirstNameService;
import pl.basicstuff.dmcompanionapp.data.interaction.Interaction;
import pl.basicstuff.dmcompanionapp.data.interaction.InteractionService;
import pl.basicstuff.dmcompanionapp.data.lastname.LastName;
import pl.basicstuff.dmcompanionapp.data.lastname.LastNameService;
import pl.basicstuff.dmcompanionapp.data.mannerism.Mannerism;
import pl.basicstuff.dmcompanionapp.data.mannerism.MannerismService;
import pl.basicstuff.dmcompanionapp.data.occupation.Occupation;
import pl.basicstuff.dmcompanionapp.data.occupation.OccupationService;
import pl.basicstuff.dmcompanionapp.data.race.Race;
import pl.basicstuff.dmcompanionapp.data.race.RaceService;
import pl.basicstuff.dmcompanionapp.data.talent.Talent;
import pl.basicstuff.dmcompanionapp.data.talent.TalentService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/data")
public class DataController {
    private final FirstNameService firstNameService;
    private final LastNameService lastNameService;
    private final RaceService raceService;
    private final CharacterClassService characterClassService;
    private final BackgroundService backgroundService;
    private final OccupationService occupationService;
    private final AppearanceService appearanceService;
    private final TalentService talentService;
    private final MannerismService mannerismService;
    private final InteractionService interactionService;


    @GetMapping("")
    public String data(Model model) {
        model.addAttribute("firstNamesCount", firstNameService.listOfNames().size());
        model.addAttribute("lastNamesCount", lastNameService.listOfNames().size());
        model.addAttribute("racesCount", raceService.racesList().size());
        model.addAttribute("classesCount", characterClassService.classesList().size());
        model.addAttribute("backgroundsCount", backgroundService.backgroundsList().size());
        model.addAttribute("occupationsCount", occupationService.occupationsList().size());
        model.addAttribute("appearancesCount", appearanceService.appearancesList().size());
        model.addAttribute("talentsCount", talentService.talentsList().size());
        model.addAttribute("mannerismsCount", mannerismService.mannerismsList().size());
        model.addAttribute("interactionsCount", interactionService.interactionsList().size());
        return "data/data";
    }

    @GetMapping("/first-name")
    public String firstNameDashboard(Model model) {
        model.addAttribute("firstName", new FirstName());
        model.addAttribute("names", firstNameService.listOfNames());
        return "data/first-name";
    }

    @PostMapping("/first-name")
    public String saveFirstName(@Valid FirstName firstName, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("names", firstNameService.listOfNames());
            return "data/first-name";
        }
        firstNameService.saveName(firstName);
        attributes.addFlashAttribute("Success", "Imię zostało dodane do bazy danych");
        return "redirect:/admin/data/first-name";
    }

    @GetMapping("/first-name/{id}")
    public String firstNameEdit(Model model, @PathVariable Long id) {
        model.addAttribute("firstName", firstNameService.findNameById(id));
        model.addAttribute("names", firstNameService.listOfNames());
        return "data/first-name";
    }

    @PostMapping("/first-name/{id}")
    public String saveFirstNameEdit(@Valid FirstName firstName, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("names", firstNameService.listOfNames());
            return "data/first-name";
        }
        firstNameService.updateName(firstName);
        attributes.addFlashAttribute("Success", "Imię zostało pomyślnie nadpisane");
        return "redirect:/admin/data/first-name";
    }

    @GetMapping("/first-name/delete/{id}")
    public String firstNameDelete(@PathVariable Long id, RedirectAttributes attributes) {
        FirstName name = firstNameService.findNameById(id);
        firstNameService.deleteName(name);
        attributes.addFlashAttribute("Success", "Imię zostało pomyślnie usunięte");
        return "redirect:/admin/data/first-name";
    }

    @GetMapping("/last-name")
    public String lastNameDashboard(Model model) {
        model.addAttribute("lastName", new LastName());
        model.addAttribute("names", lastNameService.listOfNames());
        return "data/last-name";
    }

    @PostMapping("/last-name")
    public String saveLastName(@Valid LastName lastName, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("names", lastNameService.listOfNames());
            return "data/last-name";
        }
        lastNameService.saveName(lastName);
        attributes.addFlashAttribute("Success", "Nazwisko zostało dodane do bazy danych");
        return "redirect:/admin/data/last-name";
    }

    @GetMapping("/last-name/{id}")
    public String lastNameEdit(Model model, @PathVariable Long id) {
        model.addAttribute("lastName", lastNameService.findNameById(id));
        model.addAttribute("names", lastNameService.listOfNames());
        return "data/last-name";
    }

    @PostMapping("/last-name/{id}")
    public String saveLastNameEdit(@Valid LastName lastName, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("names", lastNameService.listOfNames());
            return "data/last-name";
        }
        lastNameService.updateName(lastName);
        attributes.addFlashAttribute("Success", "Nazwisko zostało pomyślnie nadpisane");
        return "redirect:/admin/data/last-name";
    }

    @GetMapping("/last-name/delete/{id}")
    public String lastNameDelete(@PathVariable Long id, RedirectAttributes attributes) {
        LastName name = lastNameService.findNameById(id);
        lastNameService.deleteName(name);
        attributes.addFlashAttribute("Success", "Nazwisko zostało pomyślnie usunięte");
        return "redirect:/admin/data/last-name";
    }

    @GetMapping("/race")
    public String raceDashboard(Model model) {
        model.addAttribute("race", new Race());
        model.addAttribute("races", raceService.racesList());
        return "data/race";
    }

    @PostMapping("/race")
    public String saveRace(@Valid Race race, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("races", raceService.racesList());
            return "data/race";
        }
        raceService.saveRace(race);
        attributes.addFlashAttribute("Success", "Rasa została dodana do bazy danych");
        return "redirect:/admin/data/race";
    }

    @GetMapping("/race/{id}")
    public String raceEdit(Model model, @PathVariable Long id) {
        model.addAttribute("race", raceService.findRaceById(id));
        model.addAttribute("races", raceService.racesList());
        return "data/race";
    }

    @PostMapping("/race/{id}")
    public String saveRaceEdit(@Valid Race race, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("races", raceService.racesList());
            return "data/race";
        }
        raceService.updateRace(race);
        attributes.addFlashAttribute("Success", "Rasa została pomyślnie nadpisana");
        return "redirect:/admin/data/race";
    }

    @GetMapping("/race/delete/{id}")
    public String raceDelete(@PathVariable Long id, RedirectAttributes attributes) {
        Race race = raceService.findRaceById(id);
        raceService.deleteRace(race);
        attributes.addFlashAttribute("Success", "Rasa została pomyślnie usunięta");
        return "redirect:/admin/data/race";
    }

    @GetMapping("/class")
    public String classDashboard(Model model) {
        model.addAttribute("characterClass", new CharacterClass());
        model.addAttribute("classes", characterClassService.classesList());
        return "data/class";
    }

    @PostMapping("/class")
    public String saveClass(@Valid CharacterClass characterClass, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("classes", characterClassService.classesList());
            return "data/class";
        }
        characterClassService.saveClass(characterClass);
        attributes.addFlashAttribute("Success", "Klasa została dodana do bazy danych");
        return "redirect:/admin/data/class";
    }

    @GetMapping("/class/{id}")
    public String classEdit(Model model, @PathVariable Long id) {
        model.addAttribute("characterClass", characterClassService.findCharacterClassById(id));
        model.addAttribute("classes", characterClassService.classesList());
        return "data/class";
    }

    @PostMapping("/class/{id}")
    public String saveClassEdit(@Valid CharacterClass characterClass, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("classes", characterClassService.classesList());
            return "data/class";
        }
        characterClassService.updateClass(characterClass);
        attributes.addFlashAttribute("Success", "Klasa została pomyślnie nadpisana");
        return "redirect:/admin/data/class";
    }

    @GetMapping("/class/delete/{id}")
    public String classDelete(@PathVariable Long id, RedirectAttributes attributes) {
        CharacterClass characterClass = characterClassService.findCharacterClassById(id);
        characterClassService.deleteClass(characterClass);
        attributes.addFlashAttribute("Success", "Klasa została pomyślnie usunięta");
        return "redirect:/admin/data/class";
    }


    @GetMapping("/background")
    public String backgroundDashboard(Model model) {
        model.addAttribute("background", new Background());
        model.addAttribute("backgrounds", backgroundService.backgroundsList());
        return "data/background";
    }

    @PostMapping("/background")
    public String saveBackground(@Valid Background background, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("backgrounds", backgroundService.backgroundsList());
            return "data/background";
        }
        backgroundService.saveBackground(background);
        attributes.addFlashAttribute("Success", "Pochodzenie zostało dodane do bazy danych");
        return "redirect:/admin/data/background";
    }

    @GetMapping("/background/{id}")
    public String backgroundEdit(Model model, @PathVariable Long id) {
        model.addAttribute("background", backgroundService.findBackgroundById(id));
        model.addAttribute("backgrounds", backgroundService.backgroundsList());
        return "data/background";
    }

    @PostMapping("/background/{id}")
    public String saveBackgroundEdit(@Valid Background background, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("backgrounds", backgroundService.backgroundsList());
            return "data/background";
        }
        backgroundService.updateBackground(background);
        attributes.addFlashAttribute("Success", "Pochodzenie zostało pomyślnie nadpisane");
        return "redirect:/admin/data/background";
    }

    @GetMapping("/background/delete/{id}")
    public String backgroundDelete(@PathVariable Long id, RedirectAttributes attributes) {
        Background background = backgroundService.findBackgroundById(id);
        backgroundService.deleteBackground(background);
        attributes.addFlashAttribute("Success", "Pochodzenie zostało pomyślnie usunięte");
        return "redirect:/admin/data/background";
    }

    @GetMapping("/occupation")
    public String occupationDashboard(Model model) {
        model.addAttribute("occupation", new Occupation());
        model.addAttribute("occupations", occupationService.occupationsList());
        return "data/occupation";
    }

    @PostMapping("/occupation")
    public String saveOccupation(@Valid Occupation occupation, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("occupations", occupationService.occupationsList());
            return "data/occupation";
        }

        occupationService.saveOccupation(occupation);
        attributes.addFlashAttribute("Success", "Zawód został dodany do bazy danych");
        return "redirect:/admin/data/occupation";
    }

    @GetMapping("/occupation/{id}")
    public String occupationEdit(Model model, @PathVariable Long id) {
        model.addAttribute("occupation", occupationService.findOccupationById(id));
        model.addAttribute("occupations", occupationService.occupationsList());
        return "data/occupation";
    }

    @PostMapping("/occupation/{id}")
    public String saveOccupationEdit(@Valid Occupation occupation, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("occupations", occupationService.occupationsList());
            return "data/occupation";
        }

        occupationService.updateOccupation(occupation);
        attributes.addFlashAttribute("Success", "Zawód został pomyślnie nadpisany");
        return "redirect:/admin/data/occupation";
    }

    @GetMapping("/occupation/delete/{id}")
    public String occupationDelete(@PathVariable Long id, RedirectAttributes attributes) {
        Occupation occupation = occupationService.findOccupationById(id);
        occupationService.deleteOccupation(occupation);
        attributes.addFlashAttribute("Success", "Zawód został pomyślnie usunięty");
        return "redirect:/admin/data/occupation";
    }

    @GetMapping("/appearance")
    public String appearanceDashboard(Model model) {
        model.addAttribute("appearance", new Appearance());
        model.addAttribute("appearances", appearanceService.appearancesList());
        return "data/appearance";
    }

    @PostMapping("/appearance")
    public String saveAppearance(@Valid Appearance appearance, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("appearances", appearanceService.appearancesList());
            return "data/appearance";
        }

        appearanceService.saveAppearance(appearance);
        attributes.addFlashAttribute("Success", "Wygląd został dodany do bazy danych");
        return "redirect:/admin/data/appearance";
    }

    @GetMapping("/appearance/{id}")
    public String appearanceEdit(Model model, @PathVariable Long id) {
        model.addAttribute("appearance", appearanceService.findAppearanceById(id));
        model.addAttribute("appearances", appearanceService.appearancesList());
        return "data/appearance";
    }

    @PostMapping("/appearance/{id}")
    public String saveAppearanceEdit(@Valid Appearance appearance, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("appearances", appearanceService.appearancesList());
            return "data/appearance";
        }

        appearanceService.updateAppearance(appearance);
        attributes.addFlashAttribute("Success", "Wygląd został pomyślnie nadpisany");
        return "redirect:/admin/data/appearance";
    }

    @GetMapping("/appearance/delete/{id}")
    public String appearanceDelete(@PathVariable Long id, RedirectAttributes attributes) {
        Appearance appearance = appearanceService.findAppearanceById(id);
        appearanceService.deleteAppearance(appearance);
        attributes.addFlashAttribute("Success", "Wygląd został pomyślnie usunięty");
        return "redirect:/admin/data/appearance";
    }

    @GetMapping("/talent")
    public String talentDashboard(Model model) {
        model.addAttribute("talent", new Talent());
        model.addAttribute("talents", talentService.talentsList());
        return "data/talent";
    }

    @PostMapping("/talent")
    public String saveTalent(@Valid Talent talent, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("talents", talentService.talentsList());
            return "data/talent";
        }

        talentService.saveTalent(talent);
        attributes.addFlashAttribute("Success", "Talent został dodany do bazy danych");
        return "redirect:/admin/data/talent";
    }

    @GetMapping("/talent/{id}")
    public String talentEdit(Model model, @PathVariable Long id) {
        model.addAttribute("talent", talentService.findTalentById(id));
        model.addAttribute("talents", talentService.talentsList());
        return "data/talent";
    }

    @PostMapping("/talent/{id}")
    public String saveTalentEdit(@Valid Talent talent, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("talents", talentService.talentsList());
            return "data/talent";
        }

        talentService.updateTalent(talent);
        attributes.addFlashAttribute("Success", "Talent został pomyślnie nadpisany");
        return "redirect:/admin/data/talent";
    }

    @GetMapping("/talent/delete/{id}")
    public String talentDelete(@PathVariable Long id, RedirectAttributes attributes) {
        Talent talent = talentService.findTalentById(id);
        talentService.deleteTalent(talent);
        attributes.addFlashAttribute("Success", "Talent został pomyślnie usunięty");
        return "redirect:/admin/data/talent";
    }

    @GetMapping("/mannerism")
    public String mannerismDashboard(Model model) {
        model.addAttribute("mannerism", new Mannerism());
        model.addAttribute("mannerisms", mannerismService.mannerismsList());
        return "data/mannerism";
    }

    @PostMapping("/mannerism")
    public String saveMannerism(@Valid Mannerism mannerism, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("mannerisms", mannerismService.mannerismsList());
            return "data/mannerism";
        }

        mannerismService.saveMannerism(mannerism);
        attributes.addFlashAttribute("Success", "Zachowanie zostało dodane do bazy danych");
        return "redirect:/admin/data/mannerism";
    }

    @GetMapping("/mannerism/{id}")
    public String mannerismEdit(Model model, @PathVariable Long id) {
        model.addAttribute("mannerism", mannerismService.findMannerismById(id));
        model.addAttribute("mannerisms", mannerismService.mannerismsList());
        return "data/mannerism";
    }

    @PostMapping("/mannerism/{id}")
    public String saveMannerismEdit(@Valid Mannerism mannerism, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("mannerisms", mannerismService.mannerismsList());
            return "data/mannerism";
        }

        mannerismService.updateMannerism(mannerism);
        attributes.addFlashAttribute("Success", "Zachowanie zostało pomyślnie nadpisane");
        return "redirect:/admin/data/mannerism";
    }

    @GetMapping("/mannerism/delete/{id}")
    public String mannerismDelete(@PathVariable Long id, RedirectAttributes attributes) {
        Mannerism mannerism = mannerismService.findMannerismById(id);
        mannerismService.deleteMannerism(mannerism);
        attributes.addFlashAttribute("Success", "Zachowanie zostało pomyślnie usunięte");
        return "redirect:/admin/data/mannerism";
    }

    @GetMapping("/interaction")
    public String interactionDashboard(Model model) {
        model.addAttribute("interaction", new Interaction());
        model.addAttribute("interactions", interactionService.interactionsList());
        return "data/interaction";
    }

    @PostMapping("/interaction")
    public String saveInteraction(@Valid Interaction interaction, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("interactions", interactionService.interactionsList());
            return "data/interaction";
        }

        interactionService.saveInteraction(interaction);
        attributes.addFlashAttribute("Success", "Nastawienie zostało dodane do bazy danych");
        return "redirect:/admin/data/interaction";
    }

    @GetMapping("/interaction/{id}")
    public String interactionEdit(Model model, @PathVariable Long id) {
        model.addAttribute("interaction", interactionService.findInteractionById(id));
        model.addAttribute("interactions", interactionService.interactionsList());
        return "data/interaction";
    }

    @PostMapping("/interaction/{id}")
    public String saveInteractionEdit(@Valid Interaction interaction, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("interactions", interactionService.interactionsList());
            return "data/interaction";
        }

        interactionService.updateInteraction(interaction);
        attributes.addFlashAttribute("Success", "Nastawienie zostało pomyślnie nadpisane");
        return "redirect:/admin/data/interaction";
    }

    @GetMapping("/interaction/delete/{id}")
    public String interactionDelete(@PathVariable Long id, RedirectAttributes attributes) {
        Interaction interaction = interactionService.findInteractionById(id);
        interactionService.deleteInteraction(interaction);
        attributes.addFlashAttribute("Success", "Nastawienie zostało pomyślnie usunięte");
        return "redirect:/admin/data/interaction";
    }

    @ModelAttribute("generalRacesList")
    public List<String> getGeneralRaces() {
        List<Race> races = raceService.racesList();
        List<String> generalNames = new ArrayList<>();

        for (Race race : races) {
            generalNames.add(race.getGeneralRace());
        }
        return generalNames.stream()
                .distinct()
                .collect(Collectors.toList());

    }


}
