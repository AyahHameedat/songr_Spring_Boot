package com.example.songr.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class helloController {


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/hello")
    //RequestParam  for query
    // Pathvariable
    String hello(@RequestParam(name = "name", required = false, defaultValue = "Hello World") String name, Model model){
        System.out.println("Hello folks => " + name);

        model.addAttribute("name", name);
        model.addAttribute("age",99);

        return "hello";
    }

//    /capitalize/

    @GetMapping("/capitalize/{name}")
    String capitalize(@PathVariable(name = "name", required = false) String name, Model model){
        if(name == null)
        {
            //you need an Exception;
        }
        else
        {
            name = name.toUpperCase();
        }
        System.out.println("Hello folks => " + name);
        model.addAttribute("name", name.toUpperCase());

        return "capitalize";
    }

}
