package LimpBiscuit.Demo.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@Controller
public class ChatController {

    @RequestMapping("/chat")
    public String index(HttpServletRequest request, Model model, OAuth2Authentication authentication) {
        LinkedHashMap<String, Object> properties = (LinkedHashMap<String, Object>) authentication.getUserAuthentication().getDetails();
        String email = String.valueOf(properties.get("email"));
        String username = email.substring(0, 6) + "*****";

        model.addAttribute("username", username);

        return "Chat";
    }
}