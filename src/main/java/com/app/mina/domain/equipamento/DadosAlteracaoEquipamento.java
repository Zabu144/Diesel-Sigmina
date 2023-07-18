package com.app.mina.domain.equipamento;

public record DadosAlteracaoEquipamento(Long id, String tag, String categoria, String rfid, Boolean habilitar, String empresa, String custos) {
}
