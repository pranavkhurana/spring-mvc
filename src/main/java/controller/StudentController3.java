package controller;

import co.StudentCO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


@Controller
public class StudentController3 {
    @RequestMapping("/index")
    public ModelAndView display(){
        return new ModelAndView("index3","details","Annotation Controller example");
    }

    @ResponseBody
    @RequestMapping("/view")
    public String view() {
        return "Hello world using @ResponseBody";
    }

    @RequestMapping("/view2")
    public String view2(ModelMap model){
        model.addAttribute("greet","hello world");
        return "view2";
    }
    @RequestMapping("/view3/{firstname}/{lastname}")
    public ModelAndView view3(@PathVariable String firstname,@PathVariable String lastname){
        ModelAndView model=new ModelAndView("view3");
        model.addObject("firstname",firstname);
        model.addObject("lastname",lastname);
        return model;
    }
    @RequestMapping("/view4/{firstname}/{lastname}")
    public ModelAndView view4(@PathVariable Map<String,String> requestMap){
        ModelAndView model=new ModelAndView("view3");
        model.addObject("firstname",requestMap.get("firstname"));
        model.addObject("lastname",requestMap.get("lastname"));
        return model;
    }
    @RequestMapping(value = "/formData",method= RequestMethod.POST)
    public ModelAndView view5(@RequestParam("firstname") String firstname,
                              @RequestParam("lastname") String lastname){
        ModelAndView model=new ModelAndView("view3");
        model.addObject("firstname",firstname);
        model.addObject("lastname",lastname);
        return model;
    }
    @RequestMapping(value = "/formData2",method= RequestMethod.POST)
    public ModelAndView view6(@ModelAttribute StudentCO student){
        return new ModelAndView("view4","student",student);
    }
    @ModelAttribute
    void addHeading(Model model){
        model.addAttribute("heading","Spring MVC demo");
    }
}
