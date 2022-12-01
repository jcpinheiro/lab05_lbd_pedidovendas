package edu.ifma.lbd.estoque.modelo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    @EqualsAndHashCode.Include
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();

    @Getter
    private BigDecimal valor;
    @Getter @Setter
    private BigDecimal desconto = BigDecimal.ZERO;

    @Getter @Setter
    private Integer quantidade = 1;

    @PrePersist
    private void prePersit() {
        this.valor = id.getProduto().getPrecoAtual();
    }

    @Transient
    public BigDecimal getSubTotal() {
        return valor
               .multiply(new BigDecimal(quantidade))
               .subtract(desconto );
    }

    public void setPedido(Pedido pedido) {
        id.setPedido(pedido);
    }

    public void setProduto(Produto produto) {
        id.setProduto(produto);
    }

    public Produto getProduto() {
        return id.getProduto();
    }

    public void aumentaQuantidade(Integer qtd) {
        this.quantidade = this.quantidade + qtd;
    }

    public void baixarEstoque(Integer quantidade) {
        this.getProduto().baixaNoEstoque(quantidade );
    }

    public void adicionarEstoque(Integer quantidade) {
        this.getProduto().adicionaNoEstoque(quantidade );
    }
}
