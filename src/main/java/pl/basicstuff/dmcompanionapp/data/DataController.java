package pl.basicstuff.dmcompanionapp.data;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.basicstuff.dmcompanionapp.data.ability.Ability;
import pl.basicstuff.dmcompanionapp.data.ability.AbilityService;
import pl.basicstuff.dmcompanionapp.data.alignment.Alignment;
import pl.basicstuff.dmcompanionapp.data.alignment.AlignmentService;
import pl.basicstuff.dmcompanionapp.data.appearance.Appearance;
import pl.basicstuff.dmcompanionapp.data.appearance.AppearanceService;
import pl.basicstuff.dmcompanionapp.data.background.Background;
import pl.basicstuff.dmcompanionapp.data.background.BackgroundService;
import pl.basicstuff.dmcompanionapp.data.bond.Bond;
import pl.basicstuff.dmcompanionapp.data.bond.BondService;
import pl.basicstuff.dmcompanionapp.data.characterclass.CharacterClass;
import pl.basicstuff.dmcompanionapp.data.characterclass.CharacterClassService;
import pl.basicstuff.dmcompanionapp.data.firstname.FirstName;
import pl.basicstuff.dmcompanionapp.data.firstname.FirstNameService;
import pl.basicstuff.dmcompanionapp.data.flaworsecret.FlawOrSecret;
import pl.basicstuff.dmcompanionapp.data.flaworsecret.FlawOrSecretService;
import pl.basicstuff.dmcompanionapp.data.ideal.Ideal;
import pl.basicstuff.dmcompanionapp.data.ideal.IdealService;
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
import pl.basicstuff.dmcompanionapp.data.usefulknowledge.UsefulKnowledge;
import pl.basicstuff.dmcompanionapp.data.usefulknowledge.UsefulKnowledgeService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
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
    private final BondService bondService;
    private final FlawOrSecretService flawOrSecretService;
    private final AbilityService abilityService;
    private final AlignmentService alignmentService;
    private final IdealService idealService;
    private final UsefulKnowledgeService usefulKnowledgeService;


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
        model.addAttribute("bondsCount", bondService.bondsList().size());
        model.addAttribute("flawsOrSecretsCount", flawOrSecretService.flawsOrSecretsList().size());
        model.addAttribute("abilitiesCount", abilityService.abilitiesList().size());
        model.addAttribute("alignmentsCount", alignmentService.alignmentsList().size());
        model.addAttribute("idealsCount", idealService.idealsList().size());
        model.addAttribute("usefulKnowledgeCount", usefulKnowledgeService.usefulKnowledgeList().size());
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

    @GetMapping("/bond")
    public String bondDashboard(Model model) {
        model.addAttribute("bond", new Bond());
        model.addAttribute("bonds", bondService.bondsList());
        return "data/bond";
    }

    @PostMapping("/bond")
    public String saveBond(@Valid Bond bond, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("bonds", bondService.bondsList());
            return "data/bond";
        }

        bondService.saveBond(bond);
        attributes.addFlashAttribute("Success", "Więź została dodana do bazy danych");
        return "redirect:/admin/data/bond";
    }

    @GetMapping("/bond/{id}")
    public String bondEdit(Model model, @PathVariable Long id) {
        model.addAttribute("bond", bondService.findBondById(id));
        model.addAttribute("bonds", bondService.bondsList());
        return "data/bond";
    }

    @PostMapping("/bond/{id}")
    public String saveBondEdit(@Valid Bond bond, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("bonds", bondService.bondsList());
            return "data/bond";
        }

        bondService.updateBond(bond);
        attributes.addFlashAttribute("Success", "Więź została pomyślnie nadpisana");
        return "redirect:/admin/data/bond";
    }

    @GetMapping("/bond/delete/{id}")
    public String bondDelete(@PathVariable Long id, RedirectAttributes attributes) {
        Bond bond = bondService.findBondById(id);
        bondService.deleteBond(bond);
        attributes.addFlashAttribute("Success", "Więź została pomyślnie usunięta");
        return "redirect:/admin/data/bond";
    }

    @GetMapping("/flaw-or-secret")
    public String flawOrSecretDashboard(Model model) {
        model.addAttribute("flawOrSecret", new FlawOrSecret());
        model.addAttribute("flawsOrSecrets", flawOrSecretService.flawsOrSecretsList());
        return "data/flaw-or-secret";
    }

    @PostMapping("/flaw-or-secret")
    public String saveFlawOrSecret(@Valid FlawOrSecret flawOrSecret, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("flawsOrSecrets", flawOrSecretService.flawsOrSecretsList());
            return "data/flaw-or-secret";
        }

        flawOrSecretService.saveFlawOrSecret(flawOrSecret);
        attributes.addFlashAttribute("Success", "Pomyślnie dodano słabość/tajemnicę");
        return "redirect:/admin/data/flaw-or-secret";
    }

    @GetMapping("/flaw-or-secret/{id}")
    public String flawOrSecretEdit(Model model, @PathVariable Long id) {
        model.addAttribute("flawOrSecret", flawOrSecretService.findFlawOrSecretById(id));
        model.addAttribute("flawsOrSecrets", flawOrSecretService.flawsOrSecretsList());
        return "data/flaw-or-secret";
    }

    @PostMapping("/flaw-or-secret/{id}")
    public String saveFlawOrSecretEdit(@Valid FlawOrSecret flawOrSecret, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("flawsOrSecrets", flawOrSecretService.flawsOrSecretsList());
            return "data/flaw-or-secret";
        }

        flawOrSecretService.updateFlawOrSecret(flawOrSecret);
        attributes.addFlashAttribute("Success", "Pomyślnie nadpisano słabość/tajemnicę");
        return "redirect:/admin/data/flaw-or-secret";
    }

    @GetMapping("/flaw-or-secret/delete/{id}")
    public String flawOrSecretDelete(@PathVariable Long id, RedirectAttributes attributes) {
        FlawOrSecret flawOrSecret = flawOrSecretService.findFlawOrSecretById(id);
        flawOrSecretService.deleteFlawOrSecret(flawOrSecret);
        attributes.addFlashAttribute("Success", "Pomyślnie usunięto słabość/tajemnicę");
        return "redirect:/admin/data/flaw-or-secret";
    }

    @GetMapping("/ability")
    public String abilityDashboard(Model model) {
        model.addAttribute("ability", new Ability());
        model.addAttribute("abilities", abilityService.abilitiesList());
        return "data/ability";
    }

    @PostMapping("/ability")
    public String saveAbility(@Valid Ability ability, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("abilities", abilityService.abilitiesList());
            return "data/ability";
        }

        abilityService.saveAbility(ability);
        attributes.addFlashAttribute("Success", "Umiejętność została dodana do bazy danych");
        return "redirect:/admin/data/ability";
    }

    @GetMapping("/ability/{id}")
    public String abilityEdit(Model model, @PathVariable Long id) {
        model.addAttribute("ability", abilityService.findAbilityById(id));
        model.addAttribute("abilities", abilityService.abilitiesList());
        return "data/ability";
    }

    @PostMapping("/ability/{id}")
    public String saveAbilityEdit(@Valid Ability ability, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("abilities", abilityService.abilitiesList());
            return "data/ability";
        }

        abilityService.updateAbility(ability);
        attributes.addFlashAttribute("Success", "Umiejętność została pomyślnie nadpisana");
        return "redirect:/admin/data/ability";
    }

    @GetMapping("/ability/delete/{id}")
    public String abilityDelete(@PathVariable Long id, RedirectAttributes attributes) {
        Ability ability = abilityService.findAbilityById(id);
        abilityService.deleteAbility(ability);
        attributes.addFlashAttribute("Success", "Umiejętność została pomyślnie usunięta");
        return "redirect:/admin/data/ability";
    }

    @GetMapping("/alignment")
    public String alignmentDashboard(Model model) {
        model.addAttribute("alignment", new Alignment());
        model.addAttribute("alignments", alignmentService.alignmentsList());
        return "data/alignment";
    }

    @PostMapping("/alignment")
    public String saveAlignment(@Valid Alignment alignment, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("alignments", alignmentService.alignmentsList());
            return "data/alignment";
        }

        alignmentService.saveAlignment(alignment);
        attributes.addFlashAttribute("Success", "Charakter został dodany do bazy danych");
        return "redirect:/admin/data/alignment";
    }

    @GetMapping("/alignment/{id}")
    public String alignmentEdit(Model model, @PathVariable Long id) {
        model.addAttribute("alignment", alignmentService.findAlignmentById(id));
        model.addAttribute("alignments", alignmentService.alignmentsList());
        return "data/alignment";
    }

    @PostMapping("/alignment/{id}")
    public String saveAlignmentEdit(@Valid Alignment alignment, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("alignments", alignmentService.alignmentsList());
            return "data/alignment";
        }

        alignmentService.updateAlignment(alignment);
        attributes.addFlashAttribute("Success", "Charakter został pomyślnie nadpisany");
        return "redirect:/admin/data/alignment";
    }

    @GetMapping("/alignment/delete/{id}")
    public String alignmentDelete(@PathVariable Long id, RedirectAttributes attributes) {
        Alignment alignment = alignmentService.findAlignmentById(id);
        alignmentService.deleteAlignment(alignment);
        attributes.addFlashAttribute("Success", "Charakter został pomyślnie usunięta");
        return "redirect:/admin/data/alignment";
    }

    @GetMapping("/ideal")
    public String idealDashboard(Model model) {
        model.addAttribute("ideal", new Ideal());
        model.addAttribute("ideals", idealService.idealsList());
        return "data/ideal";
    }

    @PostMapping("/ideal")
    public String saveIdeal(@Valid Ideal ideal, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("ideals", idealService.idealsList());
            return "data/ideal";
        }

        idealService.saveIdeal(ideal);
        attributes.addFlashAttribute("Success", "Ideał został dodany do bazy danych");
        return "redirect:/admin/data/ideal";
    }

    @GetMapping("/ideal/{id}")
    public String idealEdit(Model model, @PathVariable Long id) {
        model.addAttribute("ideal", idealService.findIdealById(id));
        model.addAttribute("ideals", idealService.idealsList());
        return "data/ideal";
    }

    @PostMapping("/ideal/{id}")
    public String saveIdealEdit(@Valid Ideal ideal, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("ideals", idealService.idealsList());
            return "data/ideal";
        }

        idealService.updateIdeal(ideal);
        attributes.addFlashAttribute("Success", "Ideał został pomyślnie nadpisany");
        return "redirect:/admin/data/ideal";
    }

    @GetMapping("/ideal/delete/{id}")
    public String idealDelete(@PathVariable Long id, RedirectAttributes attributes) {
        Ideal ideal = idealService.findIdealById(id);
        idealService.deleteIdeal(ideal);
        attributes.addFlashAttribute("Success", "Ideał został pomyślnie usunięty");
        return "redirect:/admin/data/ideal";
    }

    @GetMapping("/useful-knowledge")
    public String usefulKnowledgeDashboard(Model model) {
        model.addAttribute("usefulKnowledge", new UsefulKnowledge());
        model.addAttribute("usefulKnowledgeList", usefulKnowledgeService.usefulKnowledgeList());
        return "data/useful-knowledge";
    }

    @PostMapping("/useful-knowledge")
    public String saveUsefulKnowledge(@Valid UsefulKnowledge usefulKnowledge, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("usefulKnowledgeList", usefulKnowledgeService.usefulKnowledgeList());
            return "data/useful-knowledge";
        }

        usefulKnowledgeService.saveUsefulKnowledge(usefulKnowledge);
        attributes.addFlashAttribute("Success", "Wiedza została dodany do bazy danych");
        return "redirect:/admin/data/useful-knowledge";
    }

    @GetMapping("/useful-knowledge/{id}")
    public String usefulKnowledgeEdit(Model model, @PathVariable Long id) {
        model.addAttribute("usefulKnowledge", usefulKnowledgeService.findUsefulKnowledgeById(id));
        model.addAttribute("usefulKnowledgeList", usefulKnowledgeService.usefulKnowledgeList());
        return "data/useful-knowledge";
    }

    @PostMapping("/useful-knowledge/{id}")
    public String saveUsefulKnowledgeEdit(@Valid UsefulKnowledge usefulKnowledge, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("usefulKnowledgeList", usefulKnowledgeService.usefulKnowledgeList());
            return "data/useful-knowledge";
        }

        usefulKnowledgeService.updateUsefulKnowledge(usefulKnowledge);
        attributes.addFlashAttribute("Success", "Wiedza została pomyślnie nadpisana");
        return "redirect:/admin/data/useful-knowledge";
    }

    @GetMapping("/useful-knowledge/delete/{id}")
    public String usefulKnowledgeDelete(@PathVariable Long id, RedirectAttributes attributes) {
        UsefulKnowledge usefulKnowledge = usefulKnowledgeService.findUsefulKnowledgeById(id);
        usefulKnowledgeService.deleteUsefulKnowledge(usefulKnowledge);
        attributes.addFlashAttribute("Success", "Wiedza została pomyślnie usunięta");
        return "redirect:/admin/data/useful-knowledge";
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

    @ModelAttribute("attributes")
    public List<String> getAttributesList() {
        return Arrays.asList("Siła", "Zręczność", "Kondycja", "Inteligencja", "Mądrość", "Charyzma");
    }

    @ModelAttribute("qualities")
    public List<String> getQualitiesList() {
        return Arrays.asList("Wysoka", "Niska");
    }

    @ModelAttribute("alignments")
    public List<String> getAlignmentsList() {
        return Arrays.asList("dobry", "zły", "neutralny", "praworządny", "chaotyczny", "inny");
    }



}
