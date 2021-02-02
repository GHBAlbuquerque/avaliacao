package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.InstrutorDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.TurmaDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.InstrutorEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.TurmaEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.InstrutorRepository;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class TurmaService {

    @Autowired private TurmaRepository turmaRepository;
    @Autowired private InstrutorRepository instrutorRepository;

    @Autowired private CursoService cursoService;
    @Autowired private AlunoService alunoService;

    SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    public List<TurmaDTO> listar(){
        List<TurmaEntity> listEntity = turmaRepository.findAll();
        List<TurmaDTO> listDTO = new ArrayList<>();

        //TODO implementar a conversão da lista de objetos de TurmaEntity para TurmaDTO e retornar a listDTO preenchida
        for(TurmaEntity turmaEntity : listEntity) {
            TurmaDTO turmaDTO = new TurmaDTO();

            turmaDTO.setDtInicio(turmaEntity.getDtInicio().toString());
            turmaDTO.setDtFim(turmaEntity.getDtFinal().toString());

            //conversão Curso
            CursoDTO cursoDTO = cursoService.converterCursoDTO(turmaEntity.getCurso());
            turmaDTO.setCurso(cursoDTO);

            //conversão Alunos
            List<AlunoDTO> alunosDTO = alunoService.converterAlunosDTO(turmaEntity.getAlunos());
            turmaDTO.setAlunos(alunosDTO);

            //conversão Instrutores
            List<InstrutorDTO> instrutoresDTO = new ArrayList<>();

            for(InstrutorEntity instrutorEntity : turmaEntity.getInstrutores()) {
                InstrutorDTO instrutorDTO = new InstrutorDTO();

                instrutorDTO.setNome(instrutorEntity.getNomeInstrutor());
                instrutorDTO.setValorHora(instrutorEntity.getValorHora());

                instrutoresDTO.add(instrutorDTO);
            }
            turmaDTO.setInstrutores(instrutoresDTO);

            listDTO.add(turmaDTO);
            }

        return listDTO;
    }
}
