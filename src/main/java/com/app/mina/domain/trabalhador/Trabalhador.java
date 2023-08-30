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
    private String nome_emp_fk;
    private String rfid;
    private String tipo;
    private Boolean habilitar;

    public Trabalhador(DadosCadastroTrabalhador dados) {
        this.matricula = dados.matricula();
        this.nome = dados.nome();
        this.nome_emp_fk = dados.nome_emp_fk();
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
                ", nome_emp_fk='" + nome_emp_fk + '\'' +
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

    public String getNome_emp_fk() {
        return nome_emp_fk;
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
        this.nome_emp_fk = dados.nome_emp_fk();
        this.rfid = dados.rfid();
        this.tipo = dados.tipo();
        this.habilitar = dados.habilitar();
    }
}

