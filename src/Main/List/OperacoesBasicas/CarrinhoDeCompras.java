package Main.List.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    /** Adiciona um item ao carrinho com o nome, preço e quantidade especificados. */
    public void adicionarItem(String nome, double preco, int quantidade){
        itemList.add(new Item(nome, preco, quantidade));
    }

    /**  Remove um item do carrinho com base no seu nome. */
    public void removerItem(String nome){
        List<Item> itemListRemover = new ArrayList<>();
        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itemListRemover.add(i);
                }
            }
            itemList.removeAll(itemListRemover);
        }else {
            System.out.println("A lista está vazia!");
        }

    }

    /** Calcula e retorna o valor total do carrinho, levando em consideração o preço e a quantidade de cada item. */
    public double calcularValorTotal(){
        double valorTotal = 0d;
        if (!itemList.isEmpty()) {
            for (Item item : itemList){
                double valorItem = item.getPreco() * item.getQuantidade();
                valorTotal += valorItem;
            }
            return valorTotal;
        }
        throw new RuntimeException("A lista está vazia!");

    }

    /** Exibe todos os itens presentes no carrinho, mostrando seus nomes, preços e quantidades. */
    public void exibirItens(){
        if (!itemList.isEmpty()) {
            System.out.println(this.itemList);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public static void main(String[] args) {
        // Criando uma instância do carrinho de compras
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        // Adicionando itens ao carrinho
        carrinhoDeCompras.adicionarItem("pao",10.5,10);
        carrinhoDeCompras.adicionarItem("manteiga",5.50,1);
        carrinhoDeCompras.adicionarItem("leite",5.50,5);

        // Exibindo os itens no carrinho
        carrinhoDeCompras.exibirItens();


        // Removendo um item do carrinho
        carrinhoDeCompras.removerItem("pao");

        // Exibindo os itens atualizados no carrinho
        carrinhoDeCompras.exibirItens();

        // Calculando e exibindo o valor total da compra
        System.out.println("O valor total da compra é = " + carrinhoDeCompras.calcularValorTotal());
    }
}
