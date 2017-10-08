package com.controller;

import com.batis.AuthDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Lord on 22.09.2017.
 */
@Controller
//@RestController("/asd")
public class MainController {

    @Autowired
    private AuthDao authDao;

    @RequestMapping("/asd")
    @ResponseBody
    public String person() {
        return authDao.getAllPerson().toString();
    }

    @RequestMapping("/d")
    @ResponseBody
    public String index2() {
        return "Добро пожжаловать на мою страничку, делать тут пока нечего";
    }


    String message = "Welcome to Spring MVC!";

//    @RequestMapping(value = {"/", "/helloworld**"}, method = {RequestMethod.GET,RequestMethod.POST})
//    public ModelAndView showMessage()
    //@RequestParam(value = "name", required = false, defaultValue = "World") String name)
    {
//        System.out.println("in controller");
//        ModelAndView mv = new ModelAndView("static/index");
//        mv.setViewName("/рhiindex.html");
//        mv.addObject("message", message);
        //mv.addObject("name", name);
//        return mv;
    }


    @RequestMapping("/")
    String index(){
        return "index.html";
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
