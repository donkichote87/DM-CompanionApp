package pl.basicstuff.dmcompanionapp.user.service;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.basicstuff.dmcompanionapp.npc.Npc;
import pl.basicstuff.dmcompanionapp.npc.NpcService;
import pl.basicstuff.dmcompanionapp.player.Player;
import pl.basicstuff.dmcompanionapp.player.PlayerService;
import pl.basicstuff.dmcompanionapp.role.Role;
import pl.basicstuff.dmcompanionapp.role.RoleRepository;
import pl.basicstuff.dmcompanionapp.user.User;
import pl.basicstuff.dmcompanionapp.user.UserRepository;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JavaMailSender mailSender;
    private final NpcService npcService;
    private final PlayerService playerService;


    public void saveUser(User user, String siteURL) throws MessagingException, UnsupportedEncodingException {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(false);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRole(userRole);
        String randomCode = RandomString.make(64);
        user.setVerificationCode(randomCode);
        userRepository.save(user);
        sendVerificationEmail(user, siteURL);
    }
    private void sendVerificationEmail(User user, String siteURL)
            throws MessagingException, UnsupportedEncodingException {
        String toAddress = user.getEmail();
        String fromAddress = "dungeonmaster.companion.app@gmail.com";
        String senderName = "DM-Companion App";
        String subject = "Potwierdź swoją rejestrację";
        String content = "Hej [[name]],<br>"
                + "Kliknij w poniższy link aby potwierdzić swoją rejestrację:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Pozdrawiamy!<br>"
                + "DM-Companion App.";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", user.getUsername());
        String verifyURL = siteURL + "/verify/" + user.getVerificationCode();

        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        mailSender.send(message);

    }

    public boolean verify(String verificationCode) {
        User user = userRepository.findByVerificationCode(verificationCode);

        if (user == null || user.isEnabled()) {
            return false;
        } else {
            user.setVerificationCode(null);
            user.setEnabled(true);
            userRepository.save(user);

            return true;
        }

    }

    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findById(Long id) {
        return userRepository.findUserById(id);
    }

    public void updatePassword(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void updateEmail(User user) {

        userRepository.save(user);
    }

    public void deleteUser(User user) {
        List<Npc> userNpcs = npcService.findNpcsByUserId(user.getId());
        for (Npc npc : userNpcs) {
            npcService.deleteNpc(npc);
        }
        List<Player> userPlayers = playerService.findAllByUserIdOrderByIdDesc(user.getId());
        for (Player player : userPlayers) {
            playerService.deletePlayer(player);
        }

        userRepository.delete(user);
    }

    public List<User> findAllByEnabledTrue() {
        return userRepository.findAllByEnabledTrueOrderByIdDesc();
    }

    public List<User> findAllByRoleId(int id) {
        return userRepository.findAllByRoleId(id);
    }

    public void changeRoleToAdmin(User user) {
        Role userRole = roleRepository.findByName("ROLE_ADMIN");
        user.setRole(userRole);
        userRepository.save(user);
    }
    public void changeRoleToUser(User user) {
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRole(userRole);
        userRepository.save(user);
    }

    public void blockUser(User user, String siteUrl)
            throws MessagingException, UnsupportedEncodingException {
        user.setEnabled(false);
        sendBanNotification(user, siteUrl);
        userRepository.save(user);
    }


    private void sendBanNotification(User user, String siteURL)
            throws MessagingException, UnsupportedEncodingException {
        String toAddress = user.getEmail();
        String fromAddress = "dungeonmaster.companion.app@gmail.com";
        String senderName = "DM-Companion App";
        String subject = "Twoje konto zostało zablokowane";
        String content = "Hej [[name]],<br>"
                + "Informujemy że Twoje konto zostało zablokowane przez Administratora.<br>"
                + "Jeśli chcesz je odblokować, proszę skontaktuj się z nami w celu wyjaśnienia sytuacji.<br>"
                + "Pozdrawiamy!<br>"
                + "DM-Companion App.";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", user.getUsername());

        helper.setText(content, true);

        mailSender.send(message);

    }
}