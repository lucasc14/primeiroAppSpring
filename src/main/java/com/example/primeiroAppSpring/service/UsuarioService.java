package com.example.primeiroAppSpring.service;

import com.example.primeiroAppSpring.model.Usuario;
import com.example.primeiroAppSpring.model.UsuarioForm;
import com.example.primeiroAppSpring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private  BCryptPasswordEncoder  encoder = new BCryptPasswordEncoder();

    // METODO: CADASTRAR

    public String cadastrar(UsuarioForm form){
        if(!form.getSenha().equals(form.getConfirmaSenha())){
            return "As senhas não conferem!";
        }

        if (usuarioRepository.existsByEmail(form.getEmail())){
            return "Email já cadastrado no sistema!";
        }
        if(!form.getEmail().endsWith("@df.senac.br")){
            return "E-mail não valido. Insira um e-mail @df.senac.br ";
        }

        String senhaCriptografada = encoder.encode(form.getSenha());

        Usuario novoUsuario = new Usuario(form.getNome(),  form.getEmail(), senhaCriptografada );

        usuarioRepository.save(novoUsuario);

        return null;
    }


    // METODO: LOGIN

    public Usuario autenticar( String email, String senha) {
        Optional<Usuario> resultado = usuarioRepository.findByEmail(email);
        if (resultado.isEmpty()){
            return null;
        }
        Usuario usuario = resultado.get();
        if (!encoder.matches(senha, usuario.getSenha())){
            return null;
        }
        return usuario;
    }

    // METODO : ALTERAR SENHA

   /* public String alterarSenha(UsuarioForm form) {
        if (!form.getSenha().equals(form.getConfirmaSenha())){
            return "As senhas não conferem!";
        }
    }*/

}