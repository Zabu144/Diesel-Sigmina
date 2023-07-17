package com.app.mina.domain.equipamento;

public record DadosAlteracaoEquipamento(Long id, String tag, String categoria, String rfid, Boolean habilitar, String empresa, String cod_centro_custo, String des_centro_custo) {
}
