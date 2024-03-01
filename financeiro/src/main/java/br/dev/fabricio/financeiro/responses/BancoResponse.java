package br.dev.fabricio.financeiro.responses;

import br.dev.fabricio.financeiro.entities.BancoEntity;

public class BancoResponse {
  private Long id;
  private String nome;
  private String agencia;
  private String numeroConta;
  private String chavePix;

  public BancoResponse(BancoEntity bancoEntity) {
    this.id = bancoEntity.getId();
    this.nome = bancoEntity.getNome();
    this.agencia = bancoEntity.getAgencia();
    this.numeroConta = bancoEntity.getNumeroConta();
    this.chavePix = bancoEntity.getChavePix();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getAgencia() {
    return agencia;
  }

  public void setAgencia(String agencia) {
    this.agencia = agencia;
  }

  public String getNumeroConta() {
    return numeroConta;
  }

  public void setNumeroConta(String numeroConta) {
    this.numeroConta = numeroConta;
  }

  public String getChavePix() {
    return chavePix;
  }

  public void setChavePix(String chavePix) {
    this.chavePix = chavePix;
  }
}
