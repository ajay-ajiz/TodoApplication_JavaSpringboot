package com.example.TodoApplication.TodoApplication.Login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("name")
public class loginController {

    private AuthenticationService authenticationService;

    public loginController(AuthenticationService authenticationService) {
        super();
        this.authenticationService = authenticationService;
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
        public String gotoLoginPage(){
            return "login";
        }
    @RequestMapping(value="login",method = RequestMethod.POST)
    //login?name=Ranga RequestParam
    public String gotoWelcomePage(@RequestParam String name,
                                  @RequestParam String password, ModelMap model) {

        if(authenticationService.authenticate(name, password)) {

            model.put("name", name);
            //Authentication
            //name - in28minutes
            //password - dummy

            return "welcome";
        }

        return "login";
    }

    }

