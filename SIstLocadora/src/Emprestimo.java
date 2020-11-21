import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
        calculoMulta();
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
        System.out.println("Todas mídias alugadas: ");
        for(Midia midia : midias){
            System.out.println("    Título: " + midia.getTitulo());
        }
        System.out.println("Multa: " + this.multa);
        System.out.println("Valor total: " + (this.valor + this.multa));
        String devolvido;

        if(isDevolvido()){
            devolvido = "Sim";
        } else{
            devolvido = "Não";
        }

        System.out.println("Devolução feita: " + devolvido);
    }

    /* Mudança de disponibilidade da mídia */
    public void midiaIndisp(){
        for(Midia midia : midias){
            midia.setDisponibilidade(false);
        }
    }

    /* Mudança de disponibilidade da mídia*/
    public void midiaDisp(){
        for(Midia midia : midias){
            midia.setDisponibilidade(true);
        }
    }

    /* Cálculo de possível multa */
    public void calculoMulta(){
        if(!isDevolvido()){
            LocalDate dataEmprestimo = LocalDate.of(ano, mes, dia);
            LocalDate dataHoje = LocalDate.now();

            long diferencaSemanas = dataEmprestimo.until(dataHoje, ChronoUnit.WEEKS);
            this.multa = 0.1*diferencaSemanas*valor;
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
