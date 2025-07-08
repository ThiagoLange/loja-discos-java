public class Disco {

    private String titulo;
    private int anoLancamento;
    private Genero genero;

    public Disco(String titulo, int anoLancamento, Genero genero) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O título do disco é obrigatório.");
        }
        if (genero == null) {
            throw new IllegalArgumentException("O gênero do disco é obrigatório.");
        }
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public Genero getGenero() {
        return genero;
    }

    /**
     * Retorna uma string formatada com as informações do Disco.
     * Inclui as informações do Gênero, obtidas através do método getInfo() da classe Genero.
     * @return String com os detalhes do disco.
     */
    public String getInfo() {
        return String.format(
                "Disco: \"%s\" (%d)\n\t%s",
                this.titulo, this.anoLancamento, this.genero.getInfo()
        );
    }

    @Override
    public String toString() {
        return String.format("'%s' (%d)", this.titulo, this.anoLancamento); // Mantido para representações simples
    }
}