public class Midia {
    private int codigo;
    private String titulo, sinopse, genero;
    private boolean dublado, disponibilidade;
    private double preco;

    public Midia(int codigo, String titulo, String sinopse, String genero,
                 boolean dublado, double preco) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.genero = genero;
        this.dublado = dublado;
        this.preco = preco;
        this.disponibilidade = true;
    }

    /* Método de impressão de dados para relatório */
    public void imprimirMidia(){
        System.out.println("++++++++++++++++++++++++++++++++");
        System.out.println("Código: " + this.codigo);
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Sinopse: " + this.sinopse);
        System.out.println("Gênero: " + this.genero);

        String temDublagem, taDisp;
        if(dublado)
            temDublagem = "Sim";
        else
            temDublagem = "Não";

        if(disponibilidade)
            taDisp = "Sim";
        else
            taDisp = "Não";

        System.out.println("Dublado: " + temDublagem);
        System.out.println("Disponivel? " + taDisp);
        System.out.println("Preço: R$" + this.preco);
        System.out.println("+++++++++++++++++++++++++++++++");
    }

    /* GET e SET */
    public String getTitulo() {
        return titulo;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
