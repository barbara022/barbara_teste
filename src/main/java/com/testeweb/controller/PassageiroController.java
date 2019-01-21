package com.testeweb.controller;

import com.testeweb.model.Motorista;
import com.testeweb.model.Passageiro;
import com.testeweb.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/passageiro")
public class PassageiroController {

    @Autowired
    private PassageiroRepository passageiroRepository;

    @RequestMapping("/add")
    public String addPassageiro(@ModelAttribute Passageiro passageiro, Model model) {
        Iterable<Passageiro> passageiros = passageiroRepository.findAll();
        for(Passageiro passageiroBanco : passageiros) {
            if(passageiro.getCpf().equals(passageiroBanco.getCpf())) {
                model.addAttribute("errorMessage", "CPF ja cadastrado !");
                return "passageiro";
            }
        }
        passageiroRepository.save(passageiro);
        return "passageiroResult";
    }

    @RequestMapping("/listar")
    public String listarPassageiros(Model model) {
        Iterable<Passageiro> passageiros = passageiroRepository.findAll();
        model.addAttribute("passageiros", passageiros);
        return "passageiroList";
    }
}
