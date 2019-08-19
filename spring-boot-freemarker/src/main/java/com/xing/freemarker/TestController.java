package com.xing.freemarker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.controller
 * @email 397600342@qq.com
 * @date 2018/3/14
 */
@Controller
public class TestController {

    @RequestMapping("/index")
    public String index(ModelMap modelMap){
        return "index";
    }

    @RequestMapping("/test")
    public String testFreemarker(ModelMap modelMap){
        Person single = new Person("chen",21);
        modelMap.addAttribute("msg", "Hello 小明 , this is freemarker");
        modelMap.addAttribute("msg", single);
        return "test";
    }

    @RequestMapping("/test-event")
    public String testeventFreemarker(ModelMap model){
        Person single = new Person("chen",21);
        List<Person> people = new ArrayList<Person>();
        Person p1 = new Person("小明",17);
        Person p2 = new Person("小红",18);
        Person p3 = new Person("小智",19);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("singlePerson",single);
        model.addAttribute("people", people);
        return "test-event";
    }
}
