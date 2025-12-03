package service;

import model.Tarefa;
import repository.TarefaRepository;

import java.time.LocalDate;
import java.util.List;

public class TarefaService {

    private TarefaRepository repository;

    public TarefaService() {
        this.repository = new TarefaRepository();
    }

    public void cadastrar(String titulo, String descricao, LocalDate dataConclusao) {
        repository.salvar(titulo, descricao, dataConclusao);
        System.out.println("Tarefa cadastrada com sucesso!");
    }

    public List<Tarefa> listar() {
        return repository.listar();
    }

    public boolean atualizar(int id, String novoTitulo, String novaDescricao, LocalDate novaData) {
        Tarefa tarefa = repository.buscarPorId(id);

        if (tarefa == null) return false;

        tarefa.setTitulo(novoTitulo);
        tarefa.setDescricao(novaDescricao);
        tarefa.setDataConclusao(novaData);
        return true;
    }

    public boolean remover(int id) {
        return repository.remover(id);
    }
}
