package br.dev.fabricio.financeiro.repositories;

import br.dev.fabricio.financeiro.entities.BancoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BancoRepository extends JpaRepository<BancoEntity, Long> {
}
