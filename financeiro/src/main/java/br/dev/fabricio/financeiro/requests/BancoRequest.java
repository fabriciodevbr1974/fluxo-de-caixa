package br.dev.fabricio.financeiro.requests;

public class BancoRequest {
  private String nome;
  private String agencia;
  private String numeroConta;
  private String chavePix;

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
