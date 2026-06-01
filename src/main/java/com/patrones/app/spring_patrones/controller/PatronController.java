package com.patrones.app.spring_patrones.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.patrones.app.spring_patrones.model.PatronDTO;


@Controller
public class PatronController {
 
    @GetMapping("/")
    public String Index() {
        return "index";
    }
    @GetMapping("/api/patrones")
    @ResponseBody
    
    public List<PatronDTO> getPatrones(){
        return List.of(
          
        );

    }

    
    
    
    
}
