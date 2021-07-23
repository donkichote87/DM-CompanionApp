package pl.basicstuff.dmcompanionapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.basicstuff.dmcompanionapp.user.CurrentUser;
import pl.basicstuff.dmcompanionapp.user.User;
import pl.basicstuff.dmcompanionapp.user.service.UserService;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;


@Controller
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login/login";
    }


    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "login/login";
    }

    @PostMapping("/register")
    public String add(@Valid User user, BindingResult result, RedirectAttributes attributes, HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
        User validateEmail = userService.findByEmail(user.getEmail());
        if (validateEmail != null) {
            request.setAttribute("userEmailExist", "Użytkownik o podanym adresie email już istnieje");
            return "login/login";
        }

        User validateLogin = userService.findByUserName(user.getUsername());

        String password = request.getParameter("passwordConfirm");
        if (validateLogin != null) {
            request.setAttribute("userLoginExist", "Podany login jest już zajęty");
            return "login/login";
        }
        if (result.hasErrors() && !password.equals(user.getPassword())) {
            request.setAttribute("errorPassword", "Podane hasła nie są identyczne");
            return "login/login";
        } else if (result.hasErrors()) {
            return "login/login";
        } else if (!password.equals(user.getPassword())) {
            request.setAttribute("errorPassword", "Podane hasła nie są identyczne");
            return "login/login";
        }

        userService.saveUser(user, getSiteURL(request));
        attributes.addFlashAttribute("verify", "Potwierdź swój adres email klikając w link zawarty w wiadomości");
        return "redirect:/register";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return "Hello " + entityUser.getUsername();
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

    @GetMapping("/verify/{code}")
    public String verifyUser(@PathVariable String code, RedirectAttributes attributes) {
        if (userService.verify(code)) {
            attributes.addFlashAttribute("verifySuccess", "Twoje konto zostało pomyślnie zweryfikowane. Możesz się zalogować");
            return "redirect:/login";
        } else {
            attributes.addFlashAttribute("verifyFail", "Nie mogliśmy zweryfikować Twojego konta. Możliwe że zostało już zweryfikowane lub kod weryfikacyjny jest nieprawidłowy.");
            return "redirect:/register";
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }
}
