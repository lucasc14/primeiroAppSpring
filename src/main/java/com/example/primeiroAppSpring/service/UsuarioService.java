package com.example.primeiroAppSpring.service;

import com.example.primeiroAppSpring.model.Usuario;
import com.example.primeiroAppSpring.model.UsuarioForm;
import com.example.primeiroAppSpring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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

        String senhaCriptografada = encoder.encode(form.getSenha());

        Usuario novoUsuario = new Usuario(form.getNome(),  form.getEmail(), senhaCriptografada );

        usuarioRepository.save(novoUsuario);

        return null;
    }


}
