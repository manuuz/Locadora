import java.util.ArrayList;

public class Locadora {
    private ArrayList<Cliente> clientes;
    private ArrayList<Midia> midias;
    private ArrayList<Emprestimo> emprestimos;

    /*public Locadora(ArrayList<Cliente> clientes, ArrayList<Midia> midias, ArrayList<Emprestimo> emprestimos) {
        this.clientes = new ArrayList<>();
        this.midias = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }*/

    public void imprimirMenu(){
        System.out.println("\n++++++++++++++++ LOCADORA ++++++++++++++++\n");
        System.out.println("1 - Cliente");
        System.out.println("2 - Mídia");
        System.out.println("3 - Empréstimo");
        System.out.println("0 - Sair");

        System.out.println("Escreva uma opção: ");
    }

    public void imprimirSubMenu(){
        System.out.println("++++++++++++++++++++++++++++++++");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Excluir");
        System.out.println("3 - Consultar");
        System.out.println("4 - Imprimir Relatório");
        System.out.println("0 - Voltar ao menu principal");

        System.out.println("Escreva uma opção: ");
    }

    public void imprimirSubMenuCliente(){
        System.out.println("++++++++++++++++++++++++++++++++");
        System.out.println("1 - Pessoa Física");
        System.out.println("2 - Pessoa Jurídica");
        System.out.println("0 - Voltar ao menu principal");

        System.out.println("Escreva uma opção: ");
    }
}

