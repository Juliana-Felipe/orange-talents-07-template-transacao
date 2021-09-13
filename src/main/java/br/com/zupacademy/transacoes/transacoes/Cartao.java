package br.com.zupacademy.transacoes.transacoes;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idExterno;
    @Email
    private String email;
    @OneToMany(mappedBy = "cartao")
    private List<Transacao> transacoes;

    public Cartao(String idExterno, String email) {
        this.idExterno = idExterno;
        this.email = email;
    }

    @Deprecated
    public Cartao() {
    }

    public String getIdExterno() {
        return idExterno;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                ", idExterno='" + idExterno + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
