package pl.basicstuff.dmcompanionapp.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.basicstuff.dmcompanionapp.user.dto.UserDtoMail;
import pl.basicstuff.dmcompanionapp.user.dto.UserDtoPass;
import pl.basicstuff.dmcompanionapp.user.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/dashboard")
    public String dashboard() {
        return "user/dashboard";
    }


    @GetMapping("/edit")
    public String userForm(Model model) {
        model.addAttribute("userDtoPass", new UserDtoPass());
        model.addAttribute("userDtoMail", new UserDtoMail());
        return "user/edit";
    }
    @GetMapping("/edit/pass")
    public String userPassForm(Model model) {
        model.addAttribute("userDtoPass", new UserDtoPass());
        model.addAttribute("userDtoMail", new UserDtoMail());
        return "user/edit";
    }
    @GetMapping("/edit/email")
    public String userMailForm(Model model) {
        model.addAttribute("userDtoPass", new UserDtoPass());
        model.addAttribute("userDtoMail", new UserDtoMail());
        return "user/edit";
    }

    @PostMapping("/edit/pass")
    public String passwordSave(@Valid UserDtoPass userDtoPass, BindingResult result, RedirectAttributes attributes, Model model, HttpServletRequest request, @AuthenticationPrincipal CurrentUser customUser) {
        String password = request.getParameter("passwordConfirm");
        User entityUser = customUser.getUser();
        if (result.hasErrors() && !password.equals(userDtoPass.getPassword())) {
            request.setAttribute("errorPassword", "Podane hasła nie są identyczne");
            model.addAttribute("userDtoMail", new UserDtoMail());
            return "user/edit";
        } else if (result.hasErrors()) {
            model.addAttribute("userDtoMail", new UserDtoMail());
            return "user/edit";
        } else if (!password.equals(userDtoPass.getPassword())) {
            request.setAttribute("errorPassword", "Podane hasła nie są identyczne");
            model.addAttribute("userDtoMail", new UserDtoMail());
            return "user/edit";
        }

        entityUser.setPassword(userDtoPass.getPassword());
        userService.updatePassword(entityUser);
        attributes.addFlashAttribute("editSuccess", "Hasło zostało pomyślnie zmienione");
        return "redirect:pass";
    }
    @PostMapping("/edit/email")
    public String emailSave(@Valid UserDtoMail userDtoMail, BindingResult result, RedirectAttributes attributes, Model model, HttpServletRequest request, @AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        User validateEmail = userService.findByEmail(userDtoMail.getEmail());
        if (validateEmail != null) {
            request.setAttribute("alreadyExist", "Użytkownik o podanym adresie email już istnieje");
            model.addAttribute("userDtoPass", new UserDtoPass());
            return "user/edit";
        }

        if (result.hasErrors()) {
            model.addAttribute("userDtoPass", new UserDtoPass());
            return "user/edit";
        }

        entityUser.setEmail(userDtoMail.getEmail());
        userService.updateEmail(entityUser);
        attributes.addFlashAttribute("editSuccess", "Email został pomyślnie zmieniony");
        return "redirect:email";
    }
}