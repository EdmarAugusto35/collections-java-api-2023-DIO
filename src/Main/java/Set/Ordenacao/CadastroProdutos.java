package Main.java.Set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    //Atributos
    private Set<Produto> produtoSet;

    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
    }

    /** Adiciona um produto ao cadastro. */
    public void adicionarProduto(long cod, String nome, double preco, int quantidade){
        produtoSet.add(new Produto(cod, nome, preco, quantidade));
    }

    /** Exibe todos os produtos do cadastro em ordem alfabética pelo nome. */
    public Set<Produto> exibirProdutosPorNome(){
        Set<Produto> produtoPorNome = new TreeSet<>(produtoSet);
        if (!produtoSet.isEmpty()){
           return produtoPorNome;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    /** Exibe todos os produtos do cadastro em ordem crescente de preço. */
    public Set<Produto> exibirProdutosPorPreco(){
        Set<Produto> produtoPorPreco = new TreeSet<>(new ComparatorPorPreco());
        if (!produtoSet.isEmpty()){
            produtoPorPreco.addAll(produtoSet);
            return produtoPorPreco;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public static void main(String[] args) {
        // Criando uma instância do CadastroProdutos
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        // Adicionando produtos ao cadastro
        cadastroProdutos.adicionarProduto(1L, "Smartphone", 1000d, 10);
        cadastroProdutos.adicionarProduto(2L, "Notebook", 1500d, 5);
        cadastroProdutos.adicionarProduto(1L, "Set", 30d, 20);
        cadastroProdutos.adicionarProduto(4L, "Teclado", 50d, 15);

        // Exibindo todos os produtos no cadastro
        System.out.println(cadastroProdutos.exibirProdutosPorNome());

        // Exibindo produtos ordenados por nome
        System.out.println(cadastroProdutos.exibirProdutosPorNome());

        // Exibindo produtos ordenados por preço
        System.out.println(cadastroProdutos.exibirProdutosPorPreco());
    }
}
