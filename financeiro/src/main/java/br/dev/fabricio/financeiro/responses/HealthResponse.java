package br.dev.fabricio.financeiro.responses;

public class HealthResponse {

  private String status;
  private String mensagem;

  public HealthResponse(String status, String mensagem) {
    this.status = status;
    this.mensagem = mensagem;
  }

  public String getStatus() {
    return status;
  }

  public String getMensagem() {
    return mensagem;
  }
}
