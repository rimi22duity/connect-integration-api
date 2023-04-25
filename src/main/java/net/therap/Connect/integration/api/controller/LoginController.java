package net.therap.Connect.integration.api.controller;

import net.therap.Connect.integration.api.db.User;
import net.therap.Connect.integration.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * @author duity
 * @since 4/19/23
 */

@Controller
public class LoginController {

    private final static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String getLoginPage(HttpServletRequest request,
                               ModelMap model) {
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        if (inputFlashMap != null) {
            String redirect_uri = (String) inputFlashMap.get("redirect_uri");
            String state = (String) inputFlashMap.get("state");

            model.put("redirect_uri", redirect_uri);
            model.put("state", state);
        }

        model.put("username", null);
        model.put("password", null);
        return "login";
    }

    @PostMapping("/login")
    public String submit(@RequestParam String username,
                         @RequestParam String redirect_uri,
                         @RequestParam String state,
                         RedirectAttributes redirectAttributes,
                         ModelMap model) {
        User dbUser = userService.findByUsername(username);

        if (Objects.isNull(dbUser)) {
            log.info("User does not exist in db!");
            model.put("username", username);
            model.put("redirect_uri", redirect_uri);
            model.put("state", state);

            return "login";
        }

        log.info("Redirecting to Activate Page!");

        redirectAttributes.addAttribute("redirect_uri", redirect_uri);
        redirectAttributes.addAttribute("state", state);
        redirectAttributes.addAttribute("userId", dbUser.getUserId());

        return "redirect:/activate";
    }
}