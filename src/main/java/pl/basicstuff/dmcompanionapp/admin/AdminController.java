package pl.basicstuff.dmcompanionapp.admin;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.basicstuff.dmcompanionapp.npc.NpcService;
import pl.basicstuff.dmcompanionapp.user.User;
import pl.basicstuff.dmcompanionapp.user.service.UserService;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    private final NpcService npcService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<User> users = userService.findAllByEnabledTrue();
        model.addAttribute("users", users);
        model.addAttribute("npcService", npcService);
        return "admin/dashboard";
    }

    @GetMapping("/role/{id}")
    public String changeRoles(@PathVariable Long id, RedirectAttributes attributes) {
        User user = userService.findById(id);
        if (user.getRole().getId() == 2) {
            if (ifLastAdmin()) {
                return "admin/no-change";
            } else {
                userService.changeRoleToUser(user);
                attributes.addFlashAttribute("Success", "Rola użytkownika " + user.getUsername() + " została pomyślnie zmieniona");
                return "redirect:/admin/dashboard";
            }

        } else {
            userService.changeRoleToAdmin(user);
            attributes.addFlashAttribute("Success", "Rola użytkownika " + user.getUsername() + " została pomyślnie zmieniona");
            return "redirect:/admin/dashboard";

        }
    }

    @GetMapping("/confirm/{id}")
    public String blockUserConfirmation(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        if (user.getRole().getId() == 2) {
            if (ifLastAdmin()) {
                return "admin/no-change";
            }
        }
        model.addAttribute("user", user);

        return "admin/block-confirm";
    }

    @GetMapping("/block/{id}")
    public String blockUser(@PathVariable Long id, RedirectAttributes attributes, HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
        User user = userService.findById(id);
        if (user.getRole().getId() == 2) {
            if (ifLastAdmin()) {
                return "admin/no-change";
            }
        }

        userService.blockUser(user, getSiteURL(request));
        attributes.addFlashAttribute("Success", "Użytkownik " + user.getUsername() + " został pomyślnie zablokowany");
        return "redirect:/admin/dashboard";

    }


    public boolean ifLastAdmin() {
        List<User> admins = userService.findAllByRoleId(2);
        if (admins.size() > 1) {
            return false;
        }
        return true;
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

}

