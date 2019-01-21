package com.testeweb.controller;

import com.testeweb.model.Corrida;
import com.testeweb.repository.CorridaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/corrida")
public class CorridaController {

    @Autowired
    private CorridaRepository corridaRepository;

    @RequestMapping("/add")
    public String addCorrida(@ModelAttribute Corrida corrida, Model model) {
        corridaRepository.save(corrida);
        return "corridaResult";
    }

    @RequestMapping("/listar")
    public String listarMotoristas(Model model) {
        Iterable<Corrida> corridas = corridaRepository.findAll();
        model.addAttribute("corridas", corridas);
        return "corridaList";
    }
}