public class LojaDeDiscos {

    public static void main(String[] args) {
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

        // --- Exibindo as informações com o novo método getInfo() ---
        System.out.println("--- Relatório Completo do Artista e Obra ---");

        // Chamada única que gera o relatório completo em cascata
        System.out.println(autorMilton.getInfo());
    }
}
