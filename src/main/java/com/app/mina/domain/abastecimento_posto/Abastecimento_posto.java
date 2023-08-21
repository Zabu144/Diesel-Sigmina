package com.app.mina.domain.abastecimento_posto;

import jakarta.persistence.*;

import java.util.Date;

// Link para a tabela no banco de dados
@Entity
@Table(name = "abastecimento_posto")
public class Abastecimento_posto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data_abastecimento;
    private Double litros;

    // CHAVES ESTRANGEIRAS
    private String equipamento; // tag_equipamento_fk
    private String trabalhador; // mat_tra_fk
    private String cc_ref; // cod_cc_fk


    // Construtor que aceita dados de cadastro de abastecimento_posto
    public Abastecimento_posto(DadosCadastroAbastecimento_posto dados){
        this.data_abastecimento = dados.data_abastecimento();
        this.litros = dados.litros();
        this.equipamento = dados.equipamento();
        this.trabalhador = dados.trabalhador();
        this.cc_ref = dados.cc_ref();
    }

    // Construtor vazio padrão para o JPA
    public Abastecimento_posto() {}

    // Método que converte SQL -> String
    @Override
    public String toString() {
        return "Abastecimento_posto{" +
                "id=" + id +
                ", data_abastecimento=" + data_abastecimento +
                ", litros=" + litros +
                ", equipamento='" + equipamento + '\'' +
                ", trabalhador='" + trabalhador + '\'' +
                ", cc_ref='" + cc_ref + '\'' +
                '}';
    }


    // Getters
    public Long getId() {
        return id;
    }

    public Date getData_abastecimento() {
        return data_abastecimento;
    }

    public Double getLitros() {
        return litros;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public String getTrabalhador() {
        return trabalhador;
    }

    public String getCc_ref() {
        return cc_ref;
    }

    // Construtor para alteração de dados
    public void atualizaDados(DadosAlteracaoAbastecimento_posto dados) {
        this.data_abastecimento = dados.data_abastecimento();
        this.litros = dados.litros();
        this.equipamento = dados.equipamento();
        this.trabalhador = dados.trabalhador();
        this.cc_ref = dados.cc_ref();
    }
}
