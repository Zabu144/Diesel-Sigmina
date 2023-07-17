package com.app.mina.domain.trabalhador;

import jakarta.persistence.*;

@Entity
@Table(name = "trabalhador")
public class Trabalhador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matricula;
    private String nome;
    private String empresa;
    private String rfid;
    private String tipo;
    private Boolean habilitar;

    public Trabalhador(DadosCadastroTrabalhador dados) {
        this.matricula = dados.matricula();
        this.nome = dados.nome();
        this.empresa = dados.empresa();
        this.rfid = dados.rfid();
        this.tipo = dados.tipo();
        this.habilitar = dados.habilitar();
    }

    public Trabalhador(){}

    @Override
    public String toString() {
        return "Trabalhador{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", empresa='" + empresa + '\'' +
                ", rfid='" + rfid + '\'' +
                ", tipo='" + tipo + '\'' +
                ", habilitar='" + habilitar + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }
    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getRfid() {
        return rfid;
    }

    public String getTipo() {
        return tipo;
    }

    public Boolean getHabilitar() {
        return habilitar;
    }

    public void atualizaDados(DadosAlteracaoTrabalhador dados) {
        this.matricula = dados.matricula();
        this.nome = dados.nome();
        this.empresa = dados.empresa();
        this.rfid = dados.rfid();
        this.tipo = dados.tipo();
        this.habilitar = dados.habilitar();
    }
}

