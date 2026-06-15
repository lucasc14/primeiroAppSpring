package com.example.primeiroAppSpring.controller;

import com.example.primeiroAppSpring.model.Aluno;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoController {


    @GetMapping("/api/aluno")
    public Aluno buscarAluno() {
        return new Aluno("Lucas", "Desenvolvimento de sistemas");
    }

}
