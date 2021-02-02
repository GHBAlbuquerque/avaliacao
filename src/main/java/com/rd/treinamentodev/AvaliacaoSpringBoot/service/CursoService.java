package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.ResultData;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired private CursoRepository cursoRepository;

    public ResponseEntity gravar(CursoDTO cursoDTO) {
        CursoEntity cursoEntity = new CursoEntity();

        cursoEntity.setNomeCurso(cursoDTO.getNome());
        cursoEntity.setNrCargaHoraria(cursoDTO.getCargaHoraria());

        cursoRepository.save(cursoEntity);

        ResultData resultData = new ResultData(HttpStatus.CREATED.value(), "Curso cadastrado com sucesso", cursoEntity.getNomeCurso());
        return ResponseEntity.status(HttpStatus.CREATED).body(resultData);
    }

    public CursoDTO converterCursoDTO(CursoEntity cursoEntity) {
        CursoDTO cursoDTO = new CursoDTO();

        cursoDTO.setNome(cursoEntity.getNomeCurso());
        cursoDTO.setCargaHoraria(cursoEntity.getNrCargaHoraria());

        return cursoDTO;
    }

    public ResponseEntity getCursoByNome(String nomeCurso) {
        List<CursoEntity> cursosEntities = cursoRepository.findByNomeCurso(nomeCurso);

        ResultData resultData = new ResultData(HttpStatus.OK.value(), "Cursos recuperados com sucesso", cursosEntities);
        return ResponseEntity.status(HttpStatus.OK).body(resultData);
    }

}
