import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LojaDeDiscos {

    private static final List<Genero> generos = new ArrayList<>();
    private static final List<Disco> discos = new ArrayList<>();
    private static final List<Autor> autores = new ArrayList<>(); // Lista para armazenar os autores
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Populando dados iniciais para teste
        Genero generoMpb = new Genero(
                "MPB",
                "Música Popular Brasileira, conhecida por sua riqueza melódica e poética."
        );
        generos.add(generoMpb);

        Disco discoClubeDaEsquina = new Disco(
                "Clube da Esquina",
                1972,
                generoMpb
        );
        discos.add(discoClubeDaEsquina);

        Autor autorMilton = new Autor(
                "Milton Nascimento & Lô Borges",
                discoClubeDaEsquina
        );
        autores.add(autorMilton);


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
                    menuDiscos();
                    break;
                case 3:
                    menuAutores(); // Chamada para o novo menu de autores
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

    // --- Lógica de Gêneros (implementada anteriormente) ---
    private static void menuGeneros() {
        int opcao;
        do {
            exibirMenuGeneros();
            opcao = scanner.nextInt();
            scanner.nextLine();

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
        if (generos.isEmpty()) return;
        System.out.print("Digite o número do gênero a ser excluído: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();

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
                System.out.println((i + 1) + ". " + generos.get(i).getNome());
            }
        }
    }


    // --- Lógica de Discos (implementada anteriormente) ---
    private static void menuDiscos() {
        int opcao;
        do {
            exibirMenuDiscos();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    novoDisco();
                    break;
                case 2:
                    ativarInativarDisco();
                    break;
                case 3:
                    listarDiscos();
                    break;
                case 4:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }

    private static void exibirMenuDiscos() {
        System.out.println("\n--- DISCOS ---");
        System.out.println("[1] Novo Disco");
        System.out.println("[2] Ativar/Inativar Disco");
        System.out.println("[3] Listar Discos");
        System.out.println("[4] Voltar");
        System.out.print("Escolha uma opção: ");
    }

    private static void novoDisco() {
        if (generos.isEmpty()) {
            System.out.println("É necessário ter ao menos um gênero cadastrado para criar um disco.");
            return;
        }

        System.out.print("Digite o título do novo disco: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o ano de lançamento do disco: ");
        int ano = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        listarGeneros();
        System.out.print("Escolha o número do gênero para este disco: ");
        int indiceGenero = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir nova linha

        if (indiceGenero >= 0 && indiceGenero < generos.size()) {
            Genero generoSelecionado = generos.get(indiceGenero);
            try {
                discos.add(new Disco(titulo, ano, generoSelecionado));
                System.out.println("Disco adicionado com sucesso!");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao criar disco: " + e.getMessage());
            }
        } else {
            System.out.println("Número de gênero inválido.");
        }
    }

    private static void ativarInativarDisco() {
        listarDiscos();
        if (discos.isEmpty()) {
            return;
        }
        System.out.print("Digite o número do disco para alterar o status (Ativar/Inativar): ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir nova linha

        if (indice >= 0 && indice < discos.size()) {
            Disco disco = discos.get(indice);
            disco.setAtivo(!disco.isAtivo()); // Inverte o status atual
            System.out.printf("Status do disco \"%s\" alterado para %s.\n", disco.getTitulo(), (disco.isAtivo() ? "Ativo" : "Inativo"));
        } else {
            System.out.println("Número inválido.");
        }
    }

    private static void listarDiscos() {
        System.out.println("\n--- LISTA DE DISCOS ---");
        if (discos.isEmpty()) {
            System.out.println("Nenhum disco cadastrado.");
        } else {
            for (int i = 0; i < discos.size(); i++) {
                System.out.println((i + 1) + ". " + discos.get(i).getInfo());
            }
        }
    }


    // --- Nova Lógica de Autores ---
    private static void menuAutores() {
        int opcao;
        do {
            exibirMenuAutores();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    novoAutor();
                    break;
                case 2:
                    listarAutores();
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);
    }

    private static void exibirMenuAutores() {
        System.out.println("\n--- AUTORES ---");
        System.out.println("[1] Novo Autor");
        System.out.println("[2] Listar Autores");
        System.out.println("[3] Voltar");
        System.out.print("Escolha uma opção: ");
    }

    private static void novoAutor() {
        if (discos.isEmpty()) {
            System.out.println("É necessário ter ao menos um disco cadastrado para criar um autor.");
            return;
        }

        System.out.print("Digite o nome do novo autor: ");
        String nome = scanner.nextLine();

        listarDiscos();
        System.out.print("Escolha o número do disco principal para este autor: ");
        int indiceDisco = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir nova linha

        if (indiceDisco >= 0 && indiceDisco < discos.size()) {
            Disco discoSelecionado = discos.get(indiceDisco);
            try {
                autores.add(new Autor(nome, discoSelecionado));
                System.out.println("Autor adicionado com sucesso!");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao criar autor: " + e.getMessage());
            }
        } else {
            System.out.println("Número de disco inválido.");
        }
    }

    private static void listarAutores() {
        System.out.println("\n--- LISTA DE AUTORES ---");
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor cadastrado.");
        } else {
            for (int i = 0; i < autores.size(); i++) {
                System.out.println("\n--- Autor " + (i + 1) + " ---");
                System.out.println(autores.get(i).getInfo());
            }
        }
    }
}