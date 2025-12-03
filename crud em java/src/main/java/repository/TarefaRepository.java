package repository;

import model.Tarefa;
import java.util.ArrayList;
import java.util.List;

public class TarefaRepository {

    private List<Tarefa> tarefas = new ArrayList<>();
    private int autoIncrementId = 1;

    public Tarefa salvar(String titulo, String descricao, java.time.LocalDate dataConclusao) {
        Tarefa tarefa = new Tarefa(autoIncrementId++, titulo, descricao, dataConclusao);
        tarefas.add(tarefa);
        return tarefa;
    }

    public List<Tarefa> listar() {
        return tarefas;
    }

    public Tarefa buscarPorId(int id) {
        return tarefas.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean remover(int id) {
        return tarefas.removeIf(t -> t.getId() == id);
    }
}
