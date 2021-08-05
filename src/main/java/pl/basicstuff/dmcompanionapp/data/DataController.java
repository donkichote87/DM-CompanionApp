package pl.basicstuff.dmcompanionapp.data;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.basicstuff.dmcompanionapp.data.background.Background;
import pl.basicstuff.dmcompanionapp.data.background.BackgroundService;
import pl.basicstuff.dmcompanionapp.data.characterclass.CharacterClass;
import pl.basicstuff.dmcompanionapp.data.characterclass.CharacterClassService;
import pl.basicstuff.dmcompanionapp.data.firstname.FirstName;
import pl.basicstuff.dmcompanionapp.data.firstname.FirstNameService;
import pl.basicstuff.dmcompanionapp.data.lastname.LastName;
import pl.basicstuff.dmcompanionapp.data.lastname.LastNameService;
import pl.basicstuff.dmcompanionapp.data.race.Race;
import pl.basicstuff.dmcompanionapp.data.race.RaceService;

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


    @GetMapping("")
    public String data(Model model) {
        model.addAttribute("firstNamesCount", firstNameService.listOfNames().size());
        model.addAttribute("lastNamesCount", lastNameService.listOfNames().size());
        model.addAttribute("racesCount", raceService.racesList().size());
        model.addAttribute("classesCount", characterClassService.classesList().size());
        model.addAttribute("backgroundsCount", backgroundService.backgroundsList().size());
        return "data/data";
    }

    @GetMapping("/first-name")
    public String firstNameDashboard(Model model) {
        model.addAttribute("newName", new FirstName());
        model.addAttribute("names", firstNameService.listOfNames());
        return "data/first-name";
    }

    @PostMapping("/first-name")
    public String saveFirstName(@ModelAttribute FirstName newName, RedirectAttributes attributes) {
        firstNameService.saveName(newName);
        attributes.addFlashAttribute("Success", "Imię zostało dodane do bazy danych");
        return "redirect:/admin/data/first-name";
    }

    @GetMapping("/first-name/{id}")
    public String firstNameEdit(Model model, @PathVariable Long id) {
        model.addAttribute("newName", firstNameService.findNameById(id));
        model.addAttribute("names", firstNameService.listOfNames());
        return "data/first-name";
    }

    @PostMapping("/first-name/{id}")
    public String saveFirstNameEdit(@ModelAttribute FirstName newName, RedirectAttributes attributes) {
        System.out.println(newName);
        firstNameService.updateName(newName);
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
        model.addAttribute("newName", new LastName());
        model.addAttribute("names", lastNameService.listOfNames());
        return "data/last-name";
    }

    @PostMapping("/last-name")
    public String saveLastName(@ModelAttribute LastName newName, RedirectAttributes attributes) {
        lastNameService.saveName(newName);
        attributes.addFlashAttribute("Success", "Nazwisko zostało dodane do bazy danych");
        return "redirect:/admin/data/last-name";
    }

    @GetMapping("/last-name/{id}")
    public String lastNameEdit(Model model, @PathVariable Long id) {
        model.addAttribute("newName", lastNameService.findNameById(id));
        model.addAttribute("names", lastNameService.listOfNames());
        return "data/last-name";
    }

    @PostMapping("/last-name/{id}")
    public String saveLastNameEdit(@ModelAttribute LastName newName, RedirectAttributes attributes) {
        System.out.println(newName);
        lastNameService.updateName(newName);
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
        model.addAttribute("newRace", new Race());
        model.addAttribute("races", raceService.racesList());
        return "data/race";
    }

    @PostMapping("/race")
    public String saveRace(@ModelAttribute Race newRace, RedirectAttributes attributes) {
        raceService.saveRace(newRace);
        attributes.addFlashAttribute("Success", "Rasa została dodana do bazy danych");
        return "redirect:/admin/data/race";
    }

    @GetMapping("/race/{id}")
    public String raceEdit(Model model, @PathVariable Long id) {
        model.addAttribute("newRace", raceService.findRaceById(id));
        model.addAttribute("races", raceService.racesList());
        return "data/race";
    }

    @PostMapping("/race/{id}")
    public String saveRaceEdit(@ModelAttribute Race newRace, RedirectAttributes attributes) {
        raceService.updateRace(newRace);
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
        model.addAttribute("newClass", new CharacterClass());
        model.addAttribute("classes", characterClassService.classesList());
        return "data/class";
    }

    @PostMapping("/class")
    public String saveClass(@ModelAttribute CharacterClass newClass, RedirectAttributes attributes) {
        characterClassService.saveClass(newClass);
        attributes.addFlashAttribute("Success", "Klasa została dodana do bazy danych");
        return "redirect:/admin/data/class";
    }

    @GetMapping("/class/{id}")
    public String classEdit(Model model, @PathVariable Long id) {
        model.addAttribute("newClass", characterClassService.findCharacterClassById(id));
        model.addAttribute("classes", characterClassService.classesList());
        return "data/class";
    }

    @PostMapping("/class/{id}")
    public String saveClassEdit(@ModelAttribute CharacterClass newClass, RedirectAttributes attributes) {
        characterClassService.updateClass(newClass);
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
        model.addAttribute("newBackground", new Background());
        model.addAttribute("backgrounds", backgroundService.backgroundsList());
        return "data/background";
    }

    @PostMapping("/background")
    public String saveBackground(@ModelAttribute Background newBackground, RedirectAttributes attributes) {
        backgroundService.saveBackground(newBackground);
        attributes.addFlashAttribute("Success", "Pochodzenie zostało dodane do bazy danych");
        return "redirect:/admin/data/background";
    }

    @GetMapping("/background/{id}")
    public String classBackground(Model model, @PathVariable Long id) {
        model.addAttribute("newBackground", backgroundService.findBackgroundById(id));
        model.addAttribute("backgrounds", backgroundService.backgroundsList());
        return "data/background";
    }

    @PostMapping("/background/{id}")
    public String saveBackgroundEdit(@ModelAttribute Background newBackground, RedirectAttributes attributes) {
        backgroundService.updateBackground(newBackground);
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
