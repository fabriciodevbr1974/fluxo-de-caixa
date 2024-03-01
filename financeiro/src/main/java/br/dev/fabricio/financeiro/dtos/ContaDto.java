package br.dev.fabricio.financeiro.dtos;

public class ContaDto {
  private Long id;
  private String nome;

  public ContaDto(Long id, String nome){
    this.id = id;
    this.nome = nome;
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
}
