package com.controller;

//import com.batis.AuthDao;
//import com.model.Greeting;
import com.model.LoginForm;
import com.model.RegistrationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Lord on 22.09.2017.
 */
@Controller
//@RestController("/asd")
public class MainController {

//    @Autowired
//    private AuthDao authDao;
//
//    @RequestMapping("/asd")
//    @ResponseBody
//    public String person() {
//        return authDao.getAllPerson().toString();
//    }

    @RequestMapping("/d")
    @ResponseBody
    public String index2() {
        return "Добро пожжаловать на мою страничку, делать тут пока нечего";
    }


    String message = "Welcome to Spring MVC!";

//    @RequestMapping(value = {"/", "/helloworld**"}, method = {RequestMethod.GET,RequestMethod.POST})
//    public ModelAndView showMessage()
    //@RequestParam(value = "name", required = false, defaultValue = "World") String name)
//    {
//        System.out.println("in controller");
//        ModelAndView mv = new ModelAndView("static/index");
//        mv.setViewName("/рhiindex.html");
//        mv.addObject("message", message);
        //mv.addObject("name", name);
//        return mv;
//    }


//    @RequestMapping(value = "/testform",consumes = "application/json",
//        method = {RequestMethod.POST,RequestMethod.GET},
//        produces = "application/json")
//    @ResponseBody
//    public String greeting3(
//        String s
//
//    ) throws Exception {
//        System.out.println("inside greeting");
//        return " Привет";
//    }


    @RequestMapping(value="/testformlog", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute LoginForm loginForm, Model model) {
        model.addAttribute("greeting", loginForm);
        return "result";
    }
    @RequestMapping(value="/testformpass", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute RegistrationForm registrationForm, Model model) {
        model.addAttribute("registrationForm", registrationForm);
        return "result";
    }




    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/hellos")
//    @ResponseBody
    public String showMessages()
    //@RequestParam(value = "name", required = false, defaultValue = "World") String name)
    {
//        System.out.println("in controller");
//        ModelAndView mv = new ModelAndView("index");
        //mv.addObject("message", message);
        //mv.addObject("name", name);
        return "sdsd";
    }
}
