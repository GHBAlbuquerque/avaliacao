package com.rd.treinamentodev.AvaliacaoSpringBoot.controller;

import com.rd.treinamentodev.AvaliacaoSpringBoot.service.ModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModuloController {

    @Autowired private ModuloService moduloService;

    @GetMapping("/modulos")
    public ResponseEntity getModulos() {
        return ResponseEntity.ok().body(moduloService.getModulos());
    }

}
