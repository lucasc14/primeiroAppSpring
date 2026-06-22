package com.example.primeiroAppSpring.controller;

import com.example.primeiroAppSpring.model.UsuarioForm;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.Normalizer;

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

    @PostMapping("/cadastro")
    public String processarUsuario(@ModelAttribute UsuarioForm form, Model model) {
        if (!form.getSenha().equals(form.getConfirmaSenha())){
            model.addAttribute("erro", "Erro, as senhas não conferem !");
            return "cadastro";
        }
        IO.println("Usuário criado com sucesso");
        IO.println(form.getNome()+ " "+form.getSenha());
        return "redirect:/login";
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
