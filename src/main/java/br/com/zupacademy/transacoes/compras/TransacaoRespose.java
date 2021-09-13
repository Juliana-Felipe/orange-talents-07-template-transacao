package br.com.zupacademy.transacoes.compras;

import br.com.zupacademy.transacoes.transacoes.Cartao;
import br.com.zupacademy.transacoes.transacoes.Estabelecimento;
import br.com.zupacademy.transacoes.transacoes.Transacao;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoRespose {

    private Long id;
    private String idExterno;
    private String valor;
    private String estabelecimento;
    private String cartao;
    private String efetivadaEm;

    public TransacaoRespose(Long id, String idExterno, String valor, String estabelecimento, String cartao, String efetivadaEm) {
        this.id = id;
        this.idExterno = idExterno;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public static Page<TransacaoRespose> converte(Page<Transacao> transacoes) {
        return transacoes.map(transacao -> transacao.converteResposta());
    }

    public Long getId() {
        return id;
    }

    public String getIdExterno() {
        return idExterno;
    }

    public String getValor() {
        return valor;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public String getCartao() {
        return cartao;
    }

    public String getEfetivadaEm() {
        return efetivadaEm;
    }
}
