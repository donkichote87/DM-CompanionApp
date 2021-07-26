package pl.basicstuff.dmcompanionapp.diceroll;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("dice")
public class DiceRollController {

    @GetMapping
    public String diceForm(Model model) {
        model.addAttribute("diceRoll", new DiceRoll());
        return "dice/throw";
    }

    @PostMapping
    public String diceThrow(@Valid DiceRoll diceRoll, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "dice/throw";
        }
        Random random = new Random();
        if (diceRoll.getK4() != 0) {
            List<Integer> k4 = new ArrayList<>();
            for (int i = 0; i < diceRoll.getK4(); i++) {
                k4.add(random.nextInt((4 - 1) + 1) + 1);
            }
            model.addAttribute("k4", k4);
            System.out.println(k4);
        }

        if (diceRoll.getK6() != 0) {
            List<Integer> k6 = new ArrayList<>();
            for (int i = 0; i < diceRoll.getK6(); i++) {
                k6.add(random.nextInt((6 - 1) + 1) + 1);
            }
            model.addAttribute("k6", k6);
        }

        if (diceRoll.getK8() != 0) {
            List<Integer> k8 = new ArrayList<>();
            for (int i = 0; i < diceRoll.getK8(); i++) {
                k8.add(random.nextInt((8 - 1) + 1) + 1);
            }
            model.addAttribute("k8", k8);
        }

        if (diceRoll.getK10() != 0) {
            List<Integer> k10 = new ArrayList<>();
            for (int i = 0; i < diceRoll.getK10(); i++) {
                k10.add(random.nextInt((10 - 1) + 1) + 1);
            }
            model.addAttribute("k10", k10);
        }

        if (diceRoll.getK12() != 0) {
            List<Integer> k12 = new ArrayList<>();
            for (int i = 0; i < diceRoll.getK12(); i++) {
                k12.add(random.nextInt((12 - 1) + 1) + 1);
            }
            model.addAttribute("k12", k12);
        }

        if (diceRoll.getK20() != 0) {
            List<Integer> k20 = new ArrayList<>();
            for (int i = 0; i < diceRoll.getK20(); i++) {
                k20.add(random.nextInt((20 - 1) + 1) + 1);
            }
            model.addAttribute("k20", k20);
        }
        return "dice/throw";
    }

    @ModelAttribute("range")

    public List<Integer> range() {

        return Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    }
}
