package br.com.improving.carrinho;

import java.math.BigDecimal;

/**
 * Classe que representa um item no carrinho de compras.
 */
public class Item {

	private Produto produto;
	private BigDecimal valorUnitario;
	private int quantidade;

	/**
	 * Construtor da classe Item.
	 *
	 * @param produto
	 * @param valorUnitario
	 * @param quantidade
	 */
	public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
		this.produto = produto;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
	}

	/**
	 * Retorna o produto.
	 *
	 * @return Produto
	 */
	public Produto getProduto() {
		return this.produto;
	}

	/**
	 * Retorna o valor unitário do item.
	 *
	 * @return BigDecimal
	 */
	public BigDecimal getValorUnitario() {
		return this.valorUnitario;
	}

	/**
	 * Retorna a quantidade dos item.
	 *
	 * @return int
	 */
	public int getQuantidade() {
		return this.quantidade;
	}

	/**
	 * Retorna o valor total do item.
	 *
	 * @return BigDecimal
	 */
	public BigDecimal getValorTotal() {
		BigDecimal valorTotal;
		return this.valorUnitario.multiply(BigDecimal.valueOf(this.quantidade));
	}

	public void setQuantidade(int quantidade) {
		if (quantidade > 0) {
			this.quantidade = quantidade;
		} else {
			Exception exception;
			throw new IllegalArgumentException("A quantidade não pode ser 0.");
		}

	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	@Override
	public String toString() {
		return this.produto.toString() + ", Valor unitario: " + this.valorUnitario + ", Quantidade: " + this.quantidade;
	}
}
