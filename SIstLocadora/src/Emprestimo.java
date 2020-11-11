import java.util.ArrayList;

public class Emprestimo {
    private Cliente cliente;
    private ArrayList<Midia> midias;
    private int ano, mes, dia;
    private double valor, multa;
    private boolean devolvido;

    public Emprestimo(Cliente cliente, ArrayList<Midia> midias, int ano, int mes,
                      int dia, double valor, double multa, boolean devolvido) {
        this.cliente = cliente;
        this.midias = midias;
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.valor = valor;
        this.multa = multa;
        this.devolvido = devolvido;

        midiaIndisp();
    }

    /* iniciador de valores facultativos */
    public Emprestimo(){
        this.valor = 0.0;
        this.multa = 0.0;
    }

    /* Método de impressão de dados para relatório */
    public void imprimirEmprestimo(){
        System.out.println("++++++++++++++++++++++++++++++++");
        System.out.println("Data: " + this.dia + "/" + this.mes + "/" + this.ano);
        System.out.println("Código do cliente: " + cliente.getCodigo());
        System.out.println("Nome do cliente: " + cliente.getNome());
        System.out.println("Todas mídias alugadas: " + cliente.getCodigo());
        for(Midia midia : midias){
            System.out.println("    Título: " + midia.getTitulo());
        }
        System.out.println("+++++++++++++++++++++++++++++++");
    }

    /* Mudança de disponibilidade mídia */
    public void midiaIndisp(){
        for(Midia midia : midias){
            midia.setDisponibilidade(false);
        }
    }

    /* Cálculo de possível multa -- WIP */
    public void calculoMulta(){
        if(!devolvido){
            multa = 0;
            /* TO DO */
        }
    }
}
