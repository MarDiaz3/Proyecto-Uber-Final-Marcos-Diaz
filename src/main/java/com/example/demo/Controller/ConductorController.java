package com.example.demo.Controller;

import com.example.demo.Models.Conductor;
import com.example.demo.Service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*; 

import java.time.LocalDate;

public class ConductorController {
     @Autowired
    private ConductorService conductorService;
    
    //mostramos la pag inicio primer url
    @GetMapping("/inicio")
    public String verInicio(){
        return "index"; //index primer HTML
    }
    
}
