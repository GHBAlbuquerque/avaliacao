package com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "TB_MODULO")
@Data
public class ModuloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MODULO")
    private BigInteger idModulo;

    @Column(name = "DS_Nome")
    private String dsNome;

//    As tabelas não estão relacionadas no DBeaver, não sei se é um problema.
    @ManyToOne
    @JoinColumn(name = "ID_INSTRUTOR")
    private InstrutorEntity instrutor;
}
