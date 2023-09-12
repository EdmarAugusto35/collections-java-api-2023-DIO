package Main.java.Map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    Map<String, Integer> palavrasMap;

    public ContagemPalavras() {
        this.palavrasMap = new HashMap<>();
    }

    /** Adiciona uma palavra à contagem. */
    public void adicionarPalavra(String palavra, Integer contagem){
        palavrasMap.put(palavra,contagem);
    }

    /** Remove uma palavra da contagem, se estiver presente. */
    public void removerPalavra(String palavra){
        if (!palavrasMap.isEmpty()){
            palavrasMap.remove(palavra);
        } else {
            System.out.println("A agenda de contatos está vazia.");
        }
    }

    /**  Exibe todas as palavras e suas respectivas contagens */
    public void exibirContagemPalavras(){
        if (!palavrasMap.isEmpty()){
            System.out.println(palavrasMap);
        } else {
            System.out.println("A agenda de contatos está vazia.");
        }
    }

    /** Encontra a palavra mais frequente no texto e retorna a palavra e sua contagem. */
    public String encontrarPalavraMaisFrequente(){
      String palavraMaisFrequente = null;
      int maiorContagem = 0;
      for (Map.Entry<String,Integer> entry : palavrasMap.entrySet()){
          if (entry.getValue() > maiorContagem){
              maiorContagem = entry.getValue();
              palavraMaisFrequente = entry.getKey();
          }
      }
      return  palavraMaisFrequente;
    }
    public static void main(String[] args) {
        ContagemPalavras contagemLinguagens = new ContagemPalavras();

        // Adiciona linguagens e suas contagens
        contagemLinguagens.adicionarPalavra("Java", 2);
        contagemLinguagens.adicionarPalavra("Python", 8);
        contagemLinguagens.adicionarPalavra("JavaScript", 1);
        contagemLinguagens.adicionarPalavra("C#", 6);

        // Exibe a contagem total de linguagens
        System.out.println("Existem " + contagemLinguagens.encontrarPalavraMaisFrequente() + " palavras.");

        // Encontra e exibe a linguagem mais frequente
        String linguagemMaisFrequente = contagemLinguagens.encontrarPalavraMaisFrequente();
        System.out.println("A linguagem mais frequente é: " + linguagemMaisFrequente);
    }
}
