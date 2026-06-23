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
    public String processarCadastro(@ModelAttribute UsuarioForm form, Model model) {
        if (!form.getSenha().equals(form.getConfirmaSenha())){
            model.addAttribute("erro", "Erro, as senhas não conferem !");
            return "cadastro";
        }
        IO.println("Usuário criado com sucesso");
        IO.println(form.getNome()+ " "+form.getSenha());
        return "redirect:/";
    }

    @GetMapping("/")
    public String exibirLogin(Model model) {
        model.addAttribute("usuarioForm", new UsuarioForm());
        model.addAttribute("tituloPagina", "Login");


        return "login";
    }

    @PostMapping("/login")
    public String processarLogin(@ModelAttribute UsuarioForm form, Model model) {
        if (!form.getEmail().endsWith("@df.senac.br")) {
            model.addAttribute("erro", "Erro, E-mail ou senha invalidas!");
            return "login";
        }
        model.addAttribute("erro","E-mail ou senha inválidos!" );
        return "redirect:/home";
    }


    @GetMapping("/alterarSenha")
    public String exibirAlterarSenha(Model model) {
        model.addAttribute("usuarioForm", new UsuarioForm());
        model.addAttribute("tituloPagina", "Aterar senha");


        return "alterarSenha";
    }

    @PostMapping("/alterarSenha")
    public String processarAlterarSenha(@ModelAttribute UsuarioForm form, Model model) {
        if (!form.getSenha().equals(form.getConfirmaSenha())){
            model.addAttribute("erro", "Erro, as senhas não conferem !");
            return "alterarSenha";
        }
        IO.println("Senha alterada com sucesso");
        model.addAttribute("erro", "Senha alterada com sucesso!");
        return "redirect:/";
    }

    @GetMapping("/home")
    public String exibirHome(Model model) {
        model.addAttribute("usuarioForm", new UsuarioForm());
        model.addAttribute("tituloPagina", "SIGEC");
        model.addAttribute("subTituloPagina", "Sistema de Gerenciamneto de Estoque da Cozinha");

        return "Home";
    }
}
