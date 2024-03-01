package br.dev.fabricio.financeiro.entities;

import br.dev.fabricio.financeiro.requests.ContaRequest;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_conta")
public class ContaEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;

  @Column(name = "entrada_saida_saldo")
  private String entradaSaidaSaldo;

  @Column(name = "receita_despesa")
  private String receitaDespesa;

  public ContaEntity(){}
  public ContaEntity(ContaRequest contaRequest) {
    this.nome = contaRequest.getNome();
    this.entradaSaidaSaldo = contaRequest.getEntradaSaidaSaldo().name();
    this.receitaDespesa = contaRequest.getReceitaDespesa().name();
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

  public String getEntradaSaidaSaldo() {
    return entradaSaidaSaldo;
  }

  public void setEntradaSaidaSaldo(String entradaSaidaSaldo) {
    this.entradaSaidaSaldo = entradaSaidaSaldo;
  }

  public String getReceitaDespesa() {
    return receitaDespesa;
  }

  public void setReceitaDespesa(String receitaDespesa) {
    this.receitaDespesa = receitaDespesa;
  }
}
