package br.dev.fabricio.financeiro.repositories;

import br.dev.fabricio.financeiro.entities.BancoEntity;
import br.dev.fabricio.financeiro.entities.LancamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LancamentoRepository extends JpaRepository<LancamentoEntity, Long> {


  @Query(value = "SELECT L " +
          "FROM LancamentoEntity L " +
          "WHERE L.ano = :ano AND L.mes = :mes ")
  List<LancamentoEntity> findByAnoAndMes(@Param("ano") Integer ano, @Param("mes") Integer mes);

  @Query(value = "SELECT * " +
          "FROM tb_lancamento L " +
          "WHERE L.ano = ?1 AND L.mes = ?2 AND banco_id = ?3 ",
          nativeQuery = true)
  List<LancamentoEntity> findByAnoAndMesAndBancoNative(Integer ano, Integer mes, Long banco_id);

  @Query(value = "SELECT L " +
          "FROM LancamentoEntity L " +
          "WHERE L.ano = :ano AND L.mes = :mes AND banco = :banco ")
  List<LancamentoEntity> findByAnoAndMesAndBanco(@Param("ano") Integer ano, @Param("mes") Integer mes, @Param("banco") BancoEntity banco);

}
