package LimpBiscuit.Demo.Controller;

import LimpBiscuit.Demo.Entities.Routine;
import LimpBiscuit.Demo.Repositories.RoutineRepository;
import LimpBiscuit.Demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
public class RoutineController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoutineRepository routineRepository;

    @GetMapping("/home")
    public ModelAndView home(OAuth2Authentication authentication) {
        LinkedHashMap<String, Object> properties = (LinkedHashMap<String, Object>) authentication.getUserAuthentication().getDetails();
        System.out.println(properties.get("email"));
        System.out.println("aaaaaa");

        String email = String.valueOf(properties.get("email"));

//        List<Routine> routines = routineRepository.findAll();
        List<Routine> routines = routineRepository.findByEmail(email);

        ModelAndView modelAndView = new ModelAndView("Home");

        modelAndView.addObject("routines", routines);

//        System.out.println(userRepository.findUsersNotDoneRoutines());

        return modelAndView;


    }

}