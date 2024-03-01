package br.dev.fabricio.financeiro.entities;

import br.dev.fabricio.financeiro.requests.BancoRequest;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_banco")
public class BancoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String agencia;
  private String numeroConta;
  private String chavePix;

  public BancoEntity() {
  }

  public BancoEntity(BancoRequest bancoRequest) {
    this.nome = bancoRequest.getNome();
    this.agencia = bancoRequest.getAgencia();
    this.numeroConta = bancoRequest.getNumeroConta();
    this.chavePix = bancoRequest.getChavePix();
  }

  public BancoEntity(Long id) {
    this.id = id;
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


  public String getAgencia() {
    return agencia;
  }


  public String getNumeroConta() {
    return numeroConta;
  }


  public String getChavePix() {
    return chavePix;
  }


}
