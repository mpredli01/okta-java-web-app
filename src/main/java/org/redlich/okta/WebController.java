package org.redlich.okta;

import org.springframework.ui.Model;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.time.Instant;

@Controller
public class WebController {

    @RequestMapping("/")
    public String index(Model model,Principal principal) {
        return "index";
    }

    @RequestMapping("/welcome")
    public String welcome(Model model,Principal principal) {
        return "welcome";
        }

    @RequestMapping("/userinfo")
    public String userinfo(Model model,Principal principal) {
        return "userinfo";
    }

    @RequestMapping("/logout")
    public String logout(Model model,Principal principal) {
        return "logout";
        }

    @RequestMapping("/attributes")
    @ResponseBody
    public String attributes(@AuthenticationPrincipal OidcUser oidcUser) {
        return oidcUser.getAttributes().toString();
        }

    @RequestMapping("/authorities")
    @ResponseBody
    public String authorities(@AuthenticationPrincipal OidcUser oidcUser) {
        return oidcUser.getAuthorities().toString();
        }

    @RequestMapping("/authenticated")
    @ResponseBody
    public Instant authenticated(@AuthenticationPrincipal OidcUser oidcUser) {
        return oidcUser.getAuthenticatedAt();
        }

    @RequestMapping("/token")
    @ResponseBody
    public String token(@AuthenticationPrincipal OidcUser oidcUser) {
        return oidcUser.getIdToken().getTokenValue();
        }
    }
