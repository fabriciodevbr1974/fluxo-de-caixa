package br.dev.fabricio.financeiro.repositories;

import br.dev.fabricio.financeiro.entities.ContaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<ContaEntity, Long> {
}
