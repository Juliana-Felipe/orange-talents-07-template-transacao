package br.com.zupacademy.transacoes.transacoes.DTO;

import br.com.zupacademy.transacoes.transacoes.Cartao;

import javax.validation.constraints.Email;

public class CartaoListened {
    private String id;
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao converteParaCartao(){
        return new Cartao(id, email);
    }
}
