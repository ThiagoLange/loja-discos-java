public class Disco {

    private String titulo;
    private int anoLancamento;
    private Genero genero;
    private boolean ativo; // Novo atributo para controlar o status

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
        this.ativo = true; // O disco começa como "Ativo"
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

    public boolean isAtivo() {
        return ativo;
    }

    // Setter para modificar o status do disco
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * Retorna uma string formatada com as informações do Disco.
     * Inclui as informações do Gênero e o status (Ativo/Inativo).
     * @return String com os detalhes do disco.
     */
    public String getInfo() {
        String status = this.ativo ? "Ativo" : "Inativo";
        return String.format(
                "Disco: \"%s\" (%d) - Status: %s\n\t%s",
                this.titulo, this.anoLancamento, status, this.genero.getInfo()
        );
    }

    @Override
    public String toString() {
        return String.format("'%s' (%d)", this.titulo, this.anoLancamento);
    }
}