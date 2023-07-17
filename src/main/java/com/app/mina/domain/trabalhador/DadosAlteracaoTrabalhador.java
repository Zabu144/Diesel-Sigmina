package com.app.mina.domain.trabalhador;

public record DadosAlteracaoTrabalhador(Long id, String matricula, String nome, String empresa, String rfid, String tipo, Boolean habilitar) {
}