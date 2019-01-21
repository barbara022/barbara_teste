package com.testeweb.controller;

import com.testeweb.model.Motorista;
import com.testeweb.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/motorista")
public class MotoristaController {

    @Autowired
    private MotoristaRepository motoristaRepository;

    @RequestMapping("/add")
    public String addMotorista(@ModelAttribute Motorista motorista, Model model) {
        Iterable<Motorista> motoristas = motoristaRepository.findAll();
        for(Motorista motoristaBanco : motoristas) {
            if(motorista.getCpf().equals(motoristaBanco.getCpf())) {
                model.addAttribute("errorMessage", "CPF ja cadastrado !");
                return "motorista";
            }
        }
        motoristaRepository.save(motorista);
        return "motoristaResult";
    }

    @RequestMapping("/listar")
    public String listarMotoristas(Model model) {
        Iterable<Motorista> motoristas = motoristaRepository.findAll();
        model.addAttribute("motoristas", motoristas);
        return "motoristaList";
    }
}
