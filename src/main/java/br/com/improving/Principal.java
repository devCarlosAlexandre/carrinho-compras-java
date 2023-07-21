package br.com.improving;

import java.math.BigDecimal;

import br.com.improving.carrinho.CarrinhoCompras;
import br.com.improving.carrinho.CarrinhoComprasFactory;
import br.com.improving.carrinho.Item;
import br.com.improving.carrinho.Produto;

public class Principal {
	public static void main(String[] args) {
		//Criando produtos
		System.out.println("Criando produto");
		Long codigoPaodeAlho = Long.valueOf(358);
		Long codigoCuscuz = Long.valueOf(357);
		Produto paodeAlho = new Produto(codigoPaodeAlho, "Pão de alho");
		Produto cuscuz = new Produto(codigoCuscuz, "Cuscuz");
		System.out.println("Criado os produtos: " + paodeAlho.getDescricao() + ", " + cuscuz.getDescricao());

		//criando carrinho
		CarrinhoComprasFactory carrinhoFactory = new CarrinhoComprasFactory();
		CarrinhoCompras carrinho = carrinhoFactory.criar("1");

		//Adicionando itens no carrinho de compra
		carrinho.adicionarItem(paodeAlho, BigDecimal.valueOf(2.50), 2);
		carrinho.adicionarItem(cuscuz, BigDecimal.valueOf(2), 3);
		System.out.println("Quantidade e itens "+carrinho.getItens().size());
		System.out.println("Valor total do carrinho "+carrinho.getValorTotal());
		System.out.println("Carrinho: "+carrinho.getItens().toString());

	}
}
