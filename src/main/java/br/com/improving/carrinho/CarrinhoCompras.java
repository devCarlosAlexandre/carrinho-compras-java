package br.com.improving.carrinho;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import br.com.improving.utils.ItemInvalidoException;

/**
 * Classe que representa o carrinho de compras de um cliente.
 */
public class CarrinhoCompras {

	ArrayList<Item> carrinho = new ArrayList<>();

	/**
	 * Permite a adição de um novo item no carrinho de compras.
	 * <p>
	 * Caso o item já exista no carrinho para este mesmo produto, as seguintes regras deverão ser seguidas:
	 * - A quantidade do item deverá ser a soma da quantidade atual com a quantidade passada como parâmetro.
	 * - Se o valor unitário informado for diferente do valor unitário atual do item, o novo valor unitário do item deverá ser
	 * o passado como parâmetro.
	 * <p>
	 * Devem ser lançadas subclasses de RuntimeException caso não seja possível adicionar o item ao carrinho de compras.
	 *
	 * @param produto
	 * @param valorUnitario
	 * @param quantidade
	 */
	public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade) {
		Item itemEncontrado = null;

		if (produto == null || valorUnitario == null || quantidade <= 0) {
			throw new ItemInvalidoException("Item inválido: produto, valor unitário ou quantidade inválidos.");
		}

		for (Item item : carrinho) {
			if (item.getProduto().getCodigo() == produto.getCodigo()) {
				itemEncontrado = item;
				break;
			}
		}
		if (itemEncontrado != null) {
			itemEncontrado.setQuantidade(itemEncontrado.getQuantidade() + quantidade);
			if (!itemEncontrado.getValorUnitario().equals(valorUnitario)) {
				itemEncontrado.setValorUnitario(valorUnitario);
			}
		} else {
			Item novoItem = new Item(produto, valorUnitario, quantidade);
			carrinho.add(novoItem);
		}
	}

	/**
	 * Permite a remoção do item que representa este produto do carrinho de compras.
	 *
	 * @param produto
	 * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e false
	 * caso o produto não exista no carrinho.
	 */
	public boolean removerItem(Produto produto) {
		boolean itemEncontrado = false;
		for (Item item : carrinho) {
			if (item.getProduto().getCodigo() == produto.getCodigo()) {
				carrinho.remove(item);
				itemEncontrado = true;
				break;
			}
		}
		return itemEncontrado;
	}

	/**
	 * Permite a remoção do item de acordo com a posição.
	 * Essa posição deve ser determinada pela ordem de inclusão do produto na
	 * coleção, em que zero representa o primeiro item.
	 *
	 * @param posicaoItem
	 * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e false
	 * caso o produto não exista no carrinho.
	 */
	public boolean removerItem(int posicaoItem) {
		boolean itemEncontrado = false;
		if(carrinho.get(posicaoItem) != null){
			itemEncontrado = true;
			carrinho.remove(posicaoItem);
			return itemEncontrado;
		}else{
			return itemEncontrado;
		}

	}

	/**
	 * Retorna o valor total do carrinho de compras, que deve ser a soma dos valores totais
	 * de todos os itens que compõem o carrinho.
	 *
	 * @return BigDecimal
	 */
	public BigDecimal getValorTotal() {
		BigDecimal valorTotalCarrinho =BigDecimal.ZERO;;
		for (Item item : carrinho) {
			valorTotalCarrinho = valorTotalCarrinho.add(item.getValorTotal());
		}
		return valorTotalCarrinho;
	}

	/**
	 * Retorna a lista de itens do carrinho de compras.
	 *
	 * @return itens
	 */
	public Collection<Item> getItens() {
		return carrinho;
	}
}