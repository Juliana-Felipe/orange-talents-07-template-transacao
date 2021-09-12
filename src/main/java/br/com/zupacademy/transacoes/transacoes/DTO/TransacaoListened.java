package br.com.zupacademy.transacoes.transacoes.DTO;

import br.com.zupacademy.transacoes.transacoes.Cartao;
import br.com.zupacademy.transacoes.transacoes.Estabelecimento;
import br.com.zupacademy.transacoes.transacoes.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoListened {
    private String id;
    private String valor;
    private EstabelecimentoListened estabelecimento;
    private CartaoListened cartao;
    private String efetivadaEm;

    public String getValor() {
        return valor;
    }

    public EstabelecimentoListened getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoListened getCartao() {
        return cartao;
    }

    public String getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacao converteParaTransacao() {
        Estabelecimento estabelecimento = this.estabelecimento.converteParaEstabelecimento();
        Cartao cartao = this.cartao.converteParaCartao();
        return new Transacao(id, new BigDecimal(valor), estabelecimento, cartao, LocalDateTime.parse(efetivadaEm));
    }

    public String getId() {
        return id;
    }
}
