package com.app.mina.domain.equipamento;

import jakarta.persistence.*;

@Entity
@Table(name = "equipamento")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tag;
    private String categoria;
    private String rfid;
    private Boolean habilitar;
    private String empresa;
    private String custos;

    public Equipamento(DadosCadastroEquipamento dados) {
        this.tag = dados.tag();
        this.categoria = dados.categoria();
        this.rfid = dados.rfid();
        this.habilitar = dados.habilitar();
        this.empresa = dados.empresa();
        this.custos = dados.custos();
    }

    public Equipamento(){}

    @Override
    public String toString() {
        return "Equipamento{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                ", categoria='" + categoria + '\'' +
                ", rfid='" + rfid + '\'' +
                ", habilitar=" + habilitar +
                ", empresa='" + empresa + '\'' +
                ", custos='" + custos + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getRfid() {
        return rfid;
    }

    public Boolean getHabilitar() {
        return habilitar;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getCustos() {
        return custos;
    }

    public void atualizaDados(DadosAlteracaoEquipamento dados) {
        this.tag = dados.tag();
        this.categoria = dados.categoria();
        this.rfid = dados.rfid();
        this.habilitar = dados.habilitar();
        this.empresa = dados.empresa();
        this.custos = dados.custos();
    }
}
