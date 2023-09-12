package Main.java.Map.Ordenacao;

import java.util.*;

public class LivrariaOnline {
    private Map<String, Livro> livroMap;

    public LivrariaOnline() {
        this.livroMap = new HashMap<>();
    }

    /** Adiciona um livro à livraria, utilizando o ISBN como chave no Map. */
    public void adicionarLivro(String link, Livro livro){
        livroMap.put(link,livro);
    }

    /** Remove um livro da livraria, dado o titulo do livro */
    public void removerLivro(String titulo){
        List<String> chavesRemover = new ArrayList<>();
       for (Map.Entry<String,Livro> entry : livroMap.entrySet()){
           if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)){
               chavesRemover.remove(entry.getKey());
           }
       }
       for (String chave : chavesRemover){
           livroMap.remove(chave);
       }
    }

    /**  Exibe os livros da livraria em ordem crescente de preço. */
    public Map<String, Livro> exibirLivrosOrdenadosPorPreco(){
        List<Map.Entry<String,Livro>> livrosOrdenadosPorPrecos = new ArrayList<>(livroMap.entrySet());
        Collections.sort(livrosOrdenadosPorPrecos, new ComparatorPorPreço());

        Map<String, Livro> livrosOrdenadosPorPreco  = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrosOrdenadosPorPrecos) {
            livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
        }
        return livrosOrdenadosPorPreco;
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorAutor() {
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorAutor = new ArrayList<>(livroMap.entrySet());

        Collections.sort(livrosParaOrdenarPorAutor, new ComparatorPorAutor());

        Map<String, Livro> livrosOrdenadosPorAutor = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorAutor) {
            livrosOrdenadosPorAutor.put(entry.getKey(), entry.getValue());
        }

        return livrosOrdenadosPorAutor;
    }

    /** Retorna uma lista de todos os livros escritos por um determinado autor. */
    public Map<String,Livro> pesquisarLivrosPorAutor(String autor){
        Map<String,Livro> livroPorAutor = new LinkedHashMap<>();
        for (Map.Entry<String,Livro> entry : livroMap.entrySet()){
            Livro livro = entry.getValue();
            if (livro.getAutor().equals(autor)){
                livroPorAutor.put(entry.getKey(), livro);
            }
        }
        return livroPorAutor;
    }

    /** Retorna o livro mais caro disponível na livraria. */
    public List<Livro> obterLivroMaisCaro(){
        List<Livro> livroMaisCaro = new ArrayList<>();
        double precoMaisAlto = Double.MIN_VALUE;
        if (!livroMap.isEmpty()){
            for (Livro livro : livroMap.values()){
                if (livro.getPreco() > precoMaisAlto){
                    precoMaisAlto = livro.getPreco();
                }
            }
        }else{
            throw new NoSuchElementException("A livraria está vazia!");
        }
        for (Map.Entry<String, Livro> entry: livroMap.entrySet()){
            if (entry.getValue().getPreco() == precoMaisAlto){
                Livro livroComPrecoMaisAlto = livroMap.get(entry.getKey());
                livroMaisCaro.add(livroComPrecoMaisAlto);
            }
        }
        return livroMaisCaro;
    }

    /** Retorna o livro mais barato disponível na livraria.*/
    public List<Livro> exibirLivroMaisBarato(){
        List<Livro> livrosMaisBaratos = new ArrayList<>();
        double precoMaisBaixo = Double.MAX_VALUE;
        if (!livroMap.isEmpty()){
            for (Livro livro : livroMap.values()){
                if (livro.getPreco() < precoMaisBaixo){
                    precoMaisBaixo = livro.getPreco();
                }
            }
        }else{
            throw new NoSuchElementException("A livraria está vazia!");
        }
        for (Map.Entry<String, Livro> entry: livroMap.entrySet()){
            if (entry.getValue().getPreco() == precoMaisBaixo){
                Livro livroComPrecoMaisAlto = livroMap.get(entry.getKey());
                livrosMaisBaratos.add(livroComPrecoMaisAlto);
            }
        }
        return livrosMaisBaratos;
    }
    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();
        // Adiciona os livros à livraria online
        livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z", new Livro("1984", "George Orwell", 50d));
        livrariaOnline.adicionarLivro("https://amzn.to/47Umiun", new Livro("A Revolução dos Bichos", "George Orwell", 7.05d));
        livrariaOnline.adicionarLivro("https://amzn.to/3L1FFI6", new Livro("Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d));
        livrariaOnline.adicionarLivro("https://amzn.to/3OYb9jk", new Livro("Malorie", "Josh Malerman", 5d));
        livrariaOnline.adicionarLivro("https://amzn.to/45HQE1L", new Livro("E Não Sobrou Nenhum", "Agatha Christie", 50d));
        livrariaOnline.adicionarLivro("https://amzn.to/45u86q4", new Livro("Assassinato no Expresso do Oriente", "Agatha Christie", 5d));

        // Exibe todos os livros ordenados por preço
        System.out.println("Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());

        //Exibe todos os livros ordenados por autor
        System.out.println("Livros ordenados por autor: \n" + livrariaOnline.exibirLivrosOrdenadosPorAutor());

        // Pesquisa livros por autor
        String autorPesquisa = "Josh Malerman";
        livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa);

        // Obtém e exibe o livro mais caro
        System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

        // Obtém e exibe o livro mais barato
        System.out.println("Livro mais barato: " + livrariaOnline.exibirLivroMaisBarato());

        // Remover um livro pelo título
        livrariaOnline.removerLivro("1984");
        System.out.println(livrariaOnline.livroMap);

    }
}
