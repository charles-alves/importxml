package br.com.charlesalves.importxml.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.charlesalves.importxml.model.Liquidacao;

@Repository
public interface LiquidacaoDao extends JpaRepository<Liquidacao, Long> {

}
