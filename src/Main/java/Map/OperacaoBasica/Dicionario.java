package Main.java.Map.OperacaoBasica;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String,String> dicionario;

    public Dicionario(){
        this.dicionario = new HashMap<>();
    }

    /** : Adiciona uma palavra e sua definição ao dicionário, associando a palavra à sua definição correspondente */
    public void adicionarPalavra(String palavra, String definicao){
        dicionario.put(palavra,definicao);
    }

    /**  Remove uma palavra do dicionário, dado o termo a ser removido. */
    public void removerPalavra(String palavra){
        if (!dicionario.isEmpty()){
            dicionario.remove(palavra);
        }else {
            System.out.println("O dicionário está vazio.");
        }
    }

    /** Exibe todas as palavras e suas definições do dicionário, mostrando cada palavra seguida de sua respectiva definição. */
    public void exibirPalavras(){
        if (!dicionario.isEmpty()){
            System.out.println(dicionario);
        }else {
            System.out.println("O dicionário está vazio.");
        }
    }

    /** Pesquisa uma palavra no dicionário e retorna sua definição correspondente. */
    public String pesquisarPorPalavra(String palavra){
        String definicao = dicionario.get(palavra);
        if (definicao != null){
            return definicao;
        }
        return "Linguagem não encontrada no dicionário.";
    }
    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        // Adicionar palavras (linguagens de programação)
        dicionario.adicionarPalavra("java", "Linguagem de programação orientada a objetos.");
        dicionario.adicionarPalavra("typescript", "Superset da linguagem JavaScript que adiciona tipagem estática.");
        dicionario.adicionarPalavra("kotlin", "Linguagem moderna de programação para a JVM.");

        // Exibir todas as palavras
        dicionario.exibirPalavras();

        // Pesquisar palavras
        String definicaoJava = dicionario.pesquisarPorPalavra("java");
        System.out.println("Definição da linguagem 'java': " + definicaoJava);

        String definicaoCSharp = dicionario.pesquisarPorPalavra("csharp");
        System.out.println(definicaoCSharp);

        // Remover uma palavra
        dicionario.removerPalavra("typescript");
        dicionario.exibirPalavras();
    }
}
