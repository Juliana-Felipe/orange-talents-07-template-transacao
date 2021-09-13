package br.com.zupacademy.transacoes.transacoes;

import javax.persistence.Embeddable;

@Embeddable
public class Estabelecimento {
    private String nome;
    private String cidade;
    private String endereco;

    public Estabelecimento(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    @Deprecated
    public Estabelecimento() {
    }

    @Override
    public String toString() {
        return "Estabelecimento{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
