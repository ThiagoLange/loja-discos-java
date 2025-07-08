import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LojaDeDiscos {

    private static final List<Genero> generos = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // --- Exibindo as informações com o novo método getInfo() ---
        System.out.println("--- Relatório Completo do Artista e Obra ---");

        // 1. Criação da instância de Genero
        Genero generoMpb = new Genero(
                "MPB",
                "Música Popular Brasileira, conhecida por sua riqueza melódica e poética."
        );

        // 2. Criação da instância de Disco
        Disco discoClubeDaEsquina = new Disco(
                "Clube da Esquina",
                1972,
                generoMpb
        );

        // 3. Criação da instância de Autor
        Autor autorMilton = new Autor(
                "Milton Nascimento & Lô Borges",
                discoClubeDaEsquina
        );
        // Chamada única que gera o relatório completo em cascata
        System.out.println(autorMilton.getInfo());


        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    menuGeneros();
                    break;
                case 2:
                    System.out.println("Opção [Discos] ainda não implementada.");
                    break;
                case 3:
                    System.out.println("Opção [Autores] ainda não implementada.");
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n--- MENU DE CONTROLE ---");
        System.out.println("[1] Gêneros");
        System.out.println("[2] Discos");
        System.out.println("[3] Autores");
        System.out.println("[4] Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void menuGeneros() {
        int opcao;
        do {
            exibirMenuGeneros();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    novoGenero();
                    break;
                case 2:
                    excluirGenero();
                    break;
                case 3:
                    listarGeneros();
                    break;
                case 4:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }

    private static void exibirMenuGeneros() {
        System.out.println("\n--- GÊNEROS ---");
        System.out.println("[1] Novo Gênero");
        System.out.println("[2] Excluir Gênero");
        System.out.println("[3] Listar Gêneros");
        System.out.println("[4] Voltar");
        System.out.print("Escolha uma opção: ");
    }

    private static void novoGenero() {
        System.out.print("Digite o nome do novo gênero: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a descrição do novo gênero: ");
        String descricao = scanner.nextLine();

        try {
            generos.add(new Genero(nome, descricao));
            System.out.println("Gênero adicionado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar gênero: " + e.getMessage());
        }
    }

    private static void excluirGenero() {
        listarGeneros();
        if (generos.isEmpty()) {
            return;
        }
        System.out.print("Digite o número do gênero a ser excluído: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir nova linha

        if (indice >= 0 && indice < generos.size()) {
            generos.remove(indice);
            System.out.println("Gênero excluído com sucesso!");
        } else {
            System.out.println("Número inválido.");
        }
    }

    private static void listarGeneros() {
        System.out.println("\n--- LISTA DE GÊNEROS ---");
        if (generos.isEmpty()) {
            System.out.println("Nenhum gênero cadastrado.");
        } else {
            for (int i = 0; i < generos.size(); i++) {
                System.out.println((i + 1) + ". " + generos.get(i).getInfo());
            }
        }
    }
}