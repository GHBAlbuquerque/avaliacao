package com.rd.treinamentodev.AvaliacaoSpringBoot.controller;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CursoController {

    @Autowired private CursoService cursoService;

    @PostMapping("/curso")
    public ResponseEntity gravar(@RequestBody CursoDTO cursoDTO){
        return cursoService.gravar(cursoDTO);
    }

    @GetMapping("/curso/{nome}")
    public ResponseEntity getCursoByNome(@PathVariable("nome") String nomeCurso){
        return cursoService.getCursoByNome(nomeCurso);
    }

}
