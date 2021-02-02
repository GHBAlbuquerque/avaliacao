package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.ResultData;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;


    public ResponseEntity gravar(AlunoDTO alunoDTO){
        AlunoEntity entity = new AlunoEntity();

        String cpf = alunoDTO.getCpf();
        List<AlunoEntity> entitiesCPF =  alunoRepository.findByCpf(cpf);

        if(entitiesCPF.size() > 0) {
            ResultData resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "CPF já cadastrado!", cpf);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }

        entity.setNomeAluno(alunoDTO.getNome());
        entity.setCpf(cpf);
        entity = alunoRepository.save(entity);

        ResultData resultData = new ResultData(HttpStatus.CREATED.value(), "Aluno cadastrado com sucesso", entity.getIdAluno());
        return ResponseEntity.status(HttpStatus.CREATED).body(resultData);
    }

    public List<AlunoDTO> converterAlunosDTO(List<AlunoEntity> alunosEntities) {
        List<AlunoDTO> alunosDTO = new ArrayList<>();

        for(AlunoEntity alunoEntity : alunosEntities) {
            AlunoDTO alunoDTO = new AlunoDTO();

            alunoDTO.setNome(alunoEntity.getNomeAluno());
            alunoDTO.setCpf(alunoEntity.getCpf());

            alunosDTO.add(alunoDTO);
        }

        return alunosDTO;
    }
}
