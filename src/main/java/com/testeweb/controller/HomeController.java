package com.testeweb.controller;

import com.testeweb.model.Corrida;
import com.testeweb.model.Motorista;
import com.testeweb.model.Passageiro;
import com.testeweb.repository.MotoristaRepository;
import com.testeweb.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private PassageiroRepository passageiroRepository;

    @RequestMapping("/motorista")
    public String motorista(Model model) {
        model.addAttribute("motorista", new Motorista());
        return "motorista";
    }

    @RequestMapping("/passageiro")
    public String passageiro(Model model) {
        model.addAttribute("passageiro", new Passageiro());
        return "passageiro";
    }

    @RequestMapping("/corrida")
    public String corrida(Model model) {
        Iterable<Motorista> motoristas = motoristaRepository.findAll();
        Iterable<Passageiro> passageiros = passageiroRepository.findAll();

        model.addAttribute("motoristas", motoristas);
        model.addAttribute("passageiros", passageiros);
        model.addAttribute("corrida", new Corrida());
        return "corrida";
    }
}
