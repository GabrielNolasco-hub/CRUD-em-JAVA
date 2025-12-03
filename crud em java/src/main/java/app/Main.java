package app;

import model.Tarefa;
import service.TarefaService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static TarefaService service = new TarefaService();

    public static void main(String[] args) {

        int opcao;

        do {
            menu();
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1: cadastrar(); break;
                case 2: listar(); break;
                case 3: atualizar(); break;
                case 4: excluir(); break;
                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private static void menu() {
        System.out.println("\n=== MENU TAREFAS ===");
        System.out.println("1 - Cadastrar tarefa");
        System.out.println("2 - Listar tarefas");
        System.out.println("3 - Atualizar tarefa");
        System.out.println("4 - Excluir tarefa");
        System.out.println("0 - Sair");
        System.out.print("Opção: ");
    }

    private static void cadastrar() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Data de conclusão (AAAA-MM-DD): ");
        LocalDate data = LocalDate.parse(scanner.nextLine());

        service.cadastrar(titulo, descricao, data);
    }

    private static void listar() {
        List<Tarefa> tarefas = service.listar();

        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }

        tarefas.forEach(System.out::println);
    }

    private static void atualizar() {
        System.out.print("ID da tarefa: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Novo título: ");
        String titulo = scanner.nextLine();

        System.out.print("Nova descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Nova data (DD-MM-AAAA): ");
        LocalDate data = LocalDate.parse(scanner.nextLine());

        boolean atualizado = service.atualizar(id, titulo, descricao, data);

        if (atualizado) {
            System.out.println("Tarefa atualizada com sucesso!");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    private static void excluir() {
        System.out.print("ID para excluir: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (service.remover(id)) {
            System.out.println("Tarefa excluída.");
        } else {
            System.out.println("ID não encontrado.");
        }
    }
}
