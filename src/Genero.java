public class Genero {

    private String nome;
    private String descricao;

    public Genero(String nome, String descricao) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do gênero é obrigatório.");
        }
        if (descricao == null) {
            throw new IllegalArgumentException("A descrição do gênero é obrigatória.");
        }
        this.nome = nome;
        this.descricao = descricao;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    /**
     * Retorna uma string formatada com as informações do Gênero.
     * @return String com os detalhes do gênero.
     */
    public String getInfo() {
        return String.format(
                "Gênero: %s\n\tDescrição: %s",
                this.nome, this.descricao
        );
    }

    @Override
    public String toString() {
        return this.nome; // Mantido para representações simples
    }
}