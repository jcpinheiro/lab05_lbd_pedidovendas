package edu.ifma.lbd.estoque.modelo;

import edu.ifma.lbd.estoque.modelo.enums.SituacaoPagamento;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento {

    @Id
    private Integer id;

    @Getter @Setter @EqualsAndHashCode.Include
    @OneToOne @JoinColumn(name = "pedido_id")
    @MapsId
    private Pedido pedido;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "situacao")
    private SituacaoPagamento situacaoPagamento;

}
