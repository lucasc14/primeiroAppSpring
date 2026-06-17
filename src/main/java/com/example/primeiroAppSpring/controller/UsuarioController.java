package com.example.primeiroAppSpring.controller;

import com.example.primeiroAppSpring.model.UsuarioForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UsuarioController {
    @GetMapping("/cadastro")
    public String exibirCadastro(Model model) {
        model.addAttribute("usuarioForm", new UsuarioForm());
        model.addAttribute("tituloPagina", "Cadastro");
        model.addAttribute("subTituloPagina", "Sistema de Gerenciamneto de Estoque da Cozinha");

        return "cadastro";
    }
    @GetMapping("/login")
    public String exibirLogin(Model model) {
        model.addAttribute("usuarioForm", new UsuarioForm());
        model.addAttribute("tituloPagina", "Login");


        return "login";
    }

    @GetMapping("/alterarSenha")
    public String exibirAlterarSenha(Model model) {
        model.addAttribute("usuarioForm", new UsuarioForm());
        model.addAttribute("tituloPagina", "Aterar senha");


        return "alterarSenha";
    }
}
