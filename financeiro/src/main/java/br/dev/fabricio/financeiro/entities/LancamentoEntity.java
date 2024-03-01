package br.dev.fabricio.financeiro.entities;

import br.dev.fabricio.financeiro.requests.LancamentoRequest;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_lancamento")
public class LancamentoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "conta_id")
  private ContaEntity conta;

  @ManyToOne
  @JoinColumn(name = "banco_id")
  private BancoEntity banco;

  private Integer ano;
  private Integer mes;


  private Integer diaVencimento;
  private Integer diaPagamento;
  private Integer diaLancamento;
  private BigDecimal valorPrevisto;
  private BigDecimal valorRealizado;


  public LancamentoEntity() {
  }

  public LancamentoEntity(LancamentoRequest lancamentoRequest, ContaEntity contaEntity, BancoEntity bancoEntity) {
    this.conta = contaEntity;
    this.banco = bancoEntity;
    this.ano = lancamentoRequest.getAno();
    this.mes = lancamentoRequest.getMes();
    this.diaLancamento = lancamentoRequest.getDiaLancamento();
    this.diaPagamento = lancamentoRequest.getDiaPagamento();
    this.diaVencimento = lancamentoRequest.getDiaVencimento();
    this.valorPrevisto = lancamentoRequest.getValorPrevisto();
    this.valorRealizado = lancamentoRequest.getValorRealizado();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ContaEntity getConta() {
    return conta;
  }

  public void setConta(ContaEntity conta) {
    this.conta = conta;
  }

  public BancoEntity getBanco() {
    return banco;
  }

  public void setBanco(BancoEntity banco) {
    this.banco = banco;
  }

  public Integer getAno() {
    return ano;
  }

  public void setAno(Integer ano) {
    this.ano = ano;
  }

  public Integer getMes() {
    return mes;
  }

  public void setMes(Integer mes) {
    this.mes = mes;
  }

  public Integer getDiaVencimento() {
    return diaVencimento;
  }

  public void setDiaVencimento(Integer diaVencimento) {
    this.diaVencimento = diaVencimento;
  }

  public Integer getDiaPagamento() {
    return diaPagamento;
  }

  public void setDiaPagamento(Integer diaPagamento) {
    this.diaPagamento = diaPagamento;
  }

  public Integer getDiaLancamento() {
    return diaLancamento;
  }

  public void setDiaLancamento(Integer diaLancamento) {
    this.diaLancamento = diaLancamento;
  }

  public BigDecimal getValorPrevisto() {
    return valorPrevisto;
  }

  public void setValorPrevisto(BigDecimal valorPrevisto) {
    this.valorPrevisto = valorPrevisto;
  }

  public BigDecimal getValorRealizado() {
    return valorRealizado;
  }

  public void setValorRealizado(BigDecimal valorRealizado) {
    this.valorRealizado = valorRealizado;
  }
}
