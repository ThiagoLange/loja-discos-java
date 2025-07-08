public class Autor {

    private String nome;
    private Disco disco;

    public Autor(String nome, Disco disco) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do autor é obrigatório.");
        }
        if (disco == null) {
            throw new IllegalArgumentException("O disco do autor é obrigatório.");
        }
        this.nome = nome;
        this.disco = disco;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public Disco getDisco() {
        return disco;
    }

    /**
     * Retorna uma string formatada com as informações completas do Autor.
     * Inclui os detalhes do Disco, obtidos através do método getInfo() da classe Disco.
     * @return String com os detalhes do autor e sua obra.
     */
    public String getInfo() {
        return String.format(
                "Autor: %s\nObra Principal:\n\t%s",
                this.nome, this.disco.getInfo()
        );
    }

    @Override
    public String toString() {
        return "Autor: " + this.nome; // Mantido para representações simples
    }
}
