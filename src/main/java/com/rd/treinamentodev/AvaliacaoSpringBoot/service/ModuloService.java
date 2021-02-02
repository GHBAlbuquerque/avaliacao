package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.ModuloEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuloService {

    @Autowired
    private ModuloRepository moduloRepository;

    public List<ModuloEntity> getModulos(){
        List<ModuloEntity> modulos = moduloRepository.findAll();
        return modulos;
    }
}
