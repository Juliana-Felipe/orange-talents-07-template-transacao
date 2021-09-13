package br.com.zupacademy.transacoes.transacoes;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface TransacaoRepository extends CrudRepository<Transacao, Long> {
   Page<Transacao> findAllByCartao_IdExterno(String idExterno, Pageable pageable);
}
