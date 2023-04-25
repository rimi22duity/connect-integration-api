package net.therap.Connect.integration.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

/**
 * @author duity
 * @since 4/19/23
 */

@Controller
public class ConnectIntegrationApiController {

    @GetMapping("/activate")
    public String getActivated(@RequestParam String redirect_uri,
                               @RequestParam String state,
                               @RequestParam(required = false) String userId,
                               RedirectAttributes redirectAttributes,
                               ModelMap model) {
        if (Objects.isNull(userId)) {
            redirectAttributes.addFlashAttribute("redirect_uri", redirect_uri);
            redirectAttributes.addFlashAttribute("state", state);

            return "redirect:/login";
        }

        model.put("redirect_uri", redirect_uri);
        model.put("state", state);
        return "activate";
    }

    @PostMapping("/activate")
    public String activate(@RequestParam String redirect_uri,
                           @RequestParam String state,
                           @RequestParam String userId) {
        
        return "activate";
    }
}
