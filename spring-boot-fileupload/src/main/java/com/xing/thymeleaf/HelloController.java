package com.xing.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/6.
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/index")
    public String index() {
        return "index.html";
    }

    @RequestMapping(value = "/test")
    public String index(Model  model)
    {
        Person single = new Person("chen",21);
        List<Person> people = new ArrayList<Person>();
        Person p1 = new Person("小明",17);
        Person p2 = new Person("小红",18);
        Person p3 = new Person("小智",19);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("singlePerson",single);
        model.addAttribute("people",people);
        return "test.html";
    }

//    @RequestMapping(value = "/hello")
//    @ResponseBody
//    public String hello(Model  model)
//    {
//        return "hello";
//    }
}