package edu.ifma.lbd.estoque.modelo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public @Data class EnderecoEntrega {

    @Column(name = "endereco_logradouro")
    private String logradouro;

    @Column(name = "endereco_numero")
    private String numero;

    @Column(name = "endereco_cep")
    private String cep;


}