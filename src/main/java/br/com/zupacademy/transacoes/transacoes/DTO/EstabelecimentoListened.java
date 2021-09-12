package br.com.zupacademy.transacoes.transacoes.DTO;

import br.com.zupacademy.transacoes.transacoes.Cartao;
import br.com.zupacademy.transacoes.transacoes.Estabelecimento;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

public class EstabelecimentoListened {
    private String nome;
    private String cidade;
    private String endereco;

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public Estabelecimento converteParaEstabelecimento() {
        return new Estabelecimento(nome, cidade, endereco);
    }
}
