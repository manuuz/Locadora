import java.util.ArrayList;

public class Emprestimo {
    private Cliente cliente;
    private ArrayList<Midia> midias;
    private int codigo, ano, mes, dia;
    private double valor, multa;
    private boolean devolvido;

    public Emprestimo(int codigo, Cliente cliente, ArrayList<Midia> midias, int ano, int mes,
                      int dia, double valor, double multa, boolean devolvido) {
        this.codigo = codigo;
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
        System.out.println("Código do empréstimo: " + this.codigo);
        System.out.println("Data: " + this.dia + "/" + this.mes + "/" + this.ano);
        System.out.println("Código do cliente: " + cliente.getCodigo());
        System.out.println("Nome do cliente: " + cliente.getNome());
        System.out.println("Todas mídias alugadas: " + cliente.getCodigo());
        for(Midia midia : midias){
            System.out.println("    Título: " + midia.getTitulo());
        }
        System.out.println("+++++++++++++++++++++++++++++++");
    }

    /* Mudança de disponibilidade da mídia */
    public void midiaIndisp(){
        for(Midia midia : midias){
            midia.setDisponibilidade(false);
        }
    }

    /* Mudança de disponibilidade dda mídia*/
    public void midiaDisp(){
        for(Midia midia : midias){
            midia.setDisponibilidade(true);
        }
    }

    /* Cálculo de possível multa -- WIP */
    public void calculoMulta(){
        if(!devolvido){
            multa = 0;
            /* TO DO */
        }
    }

    public int getCodCliente(){
        return cliente.getCodigo();
    }

    //GET e SET

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setMidias(ArrayList<Midia> midias) {
        this.midias = midias;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    public boolean isDevolvido() {
        return devolvido;
    }
}
