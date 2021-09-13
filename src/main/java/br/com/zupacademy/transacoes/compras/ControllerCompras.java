package br.com.zupacademy.transacoes.compras;

import br.com.zupacademy.transacoes.transacoes.Transacao;
import br.com.zupacademy.transacoes.transacoes.TransacaoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{id}/compras")
public class ControllerCompras {

    TransacaoRepository transacaoRepository;

    public ControllerCompras(TransacaoRepository transacaoRepository) {

        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping
    ResponseEntity<Page<TransacaoRespose>> buscaCompraPorCartao(@PathVariable String id, @PageableDefault(sort = "efetivadaEm", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable pageable) {
        Page<Transacao> transacoes = transacaoRepository.findAllByCartao_IdExterno(id, pageable);
        if (transacoes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Page<TransacaoRespose> transacoesResponse = TransacaoRespose.converte(transacoes);

        return ResponseEntity.ok(transacoesResponse);

    }
}
