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
    public String passwordForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "user/edit";
    }

    @PostMapping("/edit")
    public String passwordSave(@Valid UserDto userDto, BindingResult result, RedirectAttributes attributes, HttpServletRequest request, @AuthenticationPrincipal CurrentUser customUser) {
        String password = request.getParameter("passwordConfirm");
        User entityUser = customUser.getUser();
        if (result.hasErrors() && !password.equals(userDto.getPassword())) {
            request.setAttribute("errorPassword", "Podane hasła nie są identyczne");
            return "user/edit";
        } else if (result.hasErrors()) {
            return "user/edit";
        } else if (!password.equals(userDto.getPassword())) {
            request.setAttribute("errorPassword", "Podane hasła nie są identyczne");
            return "user/edit";
        }

        entityUser.setPassword(userDto.getPassword());
        userService.updatePassword(entityUser);
        attributes.addFlashAttribute("editSuccess", "Hasło zostało pomyślnie zmienione");
        return "redirect:/user/edit";
    }
}