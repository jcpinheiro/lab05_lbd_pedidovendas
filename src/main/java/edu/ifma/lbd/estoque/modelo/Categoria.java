package edu.ifma.lbd.estoque.modelo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Categoria implements EntidadeBase {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "categoria_pai", nullable = false)
    private Categoria categoriaPai;

    @OneToMany(mappedBy = "categoriaPai")
    private Set<Categoria> subCategorias = new LinkedHashSet<>();


}
