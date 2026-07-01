package com.example.primeiroAppSpring.controller;

import com.example.primeiroAppSpring.model.Usuario;
import com.example.primeiroAppSpring.model.UsuarioForm;
import com.example.primeiroAppSpring.service.UsuarioService;
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
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/cadastro")
    public String exibirCadastro(Model model) {
        model.addAttribute("usuarioForm", new UsuarioForm());
        model.addAttribute("tituloPagina", "Cadastro");
        model.addAttribute("subTituloPagina", "Sistema de Gerenciamneto de Estoque da Cozinha");

        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String processarCadastro(@ModelAttribute UsuarioForm form, Model model) {
        String erro = usuarioService.cadastrar(form);
        if (erro != null) {
            model.addAttribute("erro", erro);
            model.addAttribute("usuarioForm", form);//mantem os dados do formulario
            model.addAttribute("tituloPagina", "Cadastro");
            model.addAttribute("subTituloPagina", "Sistema de Gerenciamento de Estoque da Cozinha");
            return "cadastro";
        }
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
        Usuario usuario = usuarioService.autenticar(form.getEmail(), form.getSenha());
        if (usuario == null) {
            model.addAttribute("erro","Email ou senha incorreto!");
            return "login";
        }

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
