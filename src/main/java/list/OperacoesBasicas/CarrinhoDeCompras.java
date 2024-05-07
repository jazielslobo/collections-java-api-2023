package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    //atributo
    private List<Item> carrinho;

    public CarrinhoDeCompras() {
        this.carrinho = new ArrayList<>();
    }

    // Adiciona um item ao carrinho com o nome, preço e quantidade especificados.
    public void adicionarItem(String nome, double preco, int quantidade) {
        carrinho.add(new Item(nome, preco, quantidade));
    }

    // Remove um item do carrinho com base no seu nome.
    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        for (Item i : carrinho) {
            if (i.getNome().equalsIgnoreCase(nome)) {
                itensParaRemover.add(i);
            }
        }
        carrinho.removeAll(itensParaRemover);
    }

    //  Calcula e retorna o valor total do carrinho, levando em consideração o preço e a quantidade de cada item.
    public double calcularValorTotal(){
        double total = 0d;
        for (Item item : carrinho) {
            total += (item.getPreco() * item.getQuantidade());
        }
        return total;
    }

    // Exibe todos os itens presentes no carrinho, mostrando seus nomes, preços e quantidades.
    public void exibirItens(){
        for (Item item : carrinho) {
            System.out.println(item.toString());
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        System.out.println("O valor atual do carrinho é: " + carrinho.calcularValorTotal());

        carrinho.adicionarItem("Item 1", 10.00, 2);
        carrinho.adicionarItem("Item 2", 20.00, 1);
        carrinho.adicionarItem("Item 2", 10.00, 1);

        carrinho.exibirItens();
        System.out.println("O valor atual do carrinho é: " + carrinho.calcularValorTotal());

        carrinho.removerItem("Item 2");
        carrinho.exibirItens();
        System.out.println("O valor atual do carrinho é: " + carrinho.calcularValorTotal());

    }

}
