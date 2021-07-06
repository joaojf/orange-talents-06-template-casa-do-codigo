package br.com.zupacademy.joao.casadocodigo.estado;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.zupacademy.joao.casadocodigo.pais.Pais;

@Entity
public class Estado {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    private Pais pais;

    public Estado() {}

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

}
