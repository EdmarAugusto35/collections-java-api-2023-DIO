package Main.List.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {

    //Atributo
    private List<Tarefa> listaTarefa;

    public ListaTarefas() {
        this.listaTarefa = new ArrayList<>();
    }

    /**
     * Adiciona uma nova tarefa à lista com a descrição fornecida*/
    public void adicionarTarefa(String descricao){
        listaTarefa.add(new Tarefa(descricao));
    }

    /**
     * Remove uma tarefa da lista com base em sua descrição*/
    public void removerTarefa(String descricao){
        List<Tarefa> tarefasParaRemover = new ArrayList<>();
        for (Tarefa t : listaTarefa){
            if (t.getDescricao().equalsIgnoreCase(descricao)){
                tarefasParaRemover.add(t);
            }
        }
        listaTarefa.removeAll(tarefasParaRemover);
    }

    /**
     * Retorna o número total de tarefas na lista*/
    public int obterNumeroTotalTarefas(){
        return listaTarefa.size();
    }

    /**
     * Retorna uma lista contendo a descrição de todas as tarefas na lista*/
    public void obterDescricoesTarefas(){
        System.out.println(listaTarefa);
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();
        System.out.println("O numero total de elementos na lista é: " + listaTarefas.obterNumeroTotalTarefas());

        listaTarefas.adicionarTarefa("tarefa01");
        listaTarefas.adicionarTarefa("tarefa02");
        System.out.println("O numero total de elementos na lista é: " + listaTarefas.obterNumeroTotalTarefas());

        listaTarefas.obterDescricoesTarefas();

        listaTarefas.removerTarefa("tarefa01");
        System.out.println("O numero total de elementos na lista é: " + listaTarefas.obterNumeroTotalTarefas());
    }
}
