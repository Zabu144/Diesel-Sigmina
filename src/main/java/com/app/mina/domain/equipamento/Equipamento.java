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
    private String cod_centro_custo;
    private String des_centro_custo;

    public Equipamento(DadosCadastroEquipamento dados) {
        this.tag = dados.tag();
        this.categoria = dados.categoria();
        this.rfid = dados.rfid();
        this.habilitar = dados.habilitar();
        this.empresa = dados.empresa();
        this.cod_centro_custo = dados.cod_centro_custo();
        this.des_centro_custo = dados.des_centro_custo();
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
                ", cod_centro_custo='" + cod_centro_custo + '\'' +
                ", des_centro_custo='" + des_centro_custo + '\'' +
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

    public String getCod_centro_custo() {
        return cod_centro_custo;
    }

    public String getDes_centro_custo() {
        return des_centro_custo;
    }

    public void atualizaDados(DadosAlteracaoEquipamento dados) {
        this.tag = dados.tag();
        this.categoria = dados.categoria();
        this.rfid = dados.rfid();
        this.habilitar = dados.habilitar();
        this.empresa = dados.empresa();
        this.cod_centro_custo = dados.cod_centro_custo();
        this.des_centro_custo = dados.des_centro_custo();
    }
}
