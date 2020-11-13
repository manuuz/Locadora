import java.util.ArrayList;
import java.util.Scanner;

public class Locadora {
    private ArrayList<Cliente> clientes;
    private ArrayList<Midia> midias;
    private ArrayList<Emprestimo> emprestimos;

    public Locadora(ArrayList<Cliente> clientes, ArrayList<Midia> midias, ArrayList<Emprestimo> emprestimos) {
        this.clientes = new ArrayList<>();
        this.midias = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public Locadora(){}

    /*Métodos de Impressão*/
    public void imprimirMenu(){
        System.out.println("\n++++++++++++++++ LOCADORA ++++++++++++++++\n");
        System.out.println("1 - Cliente");
        System.out.println("2 - Mídia");
        System.out.println("3 - Empréstimo");
        System.out.println("0 - Sair");

        System.out.println("Escreva uma opção: ");
    }

    public void imprimirSubMenu(String submenu){
        System.out.println("++++++++++++++++" + submenu + "++++++++++++++++");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Excluir");
        System.out.println("3 - Consultar");
        System.out.println("4 - Imprimir Relatório");
        System.out.println("0 - Voltar ao menu principal");

        System.out.println("Escreva uma opção: ");
    }

    /*CLASSE CLIENTE*/
    /*submenu*/
    public void imprimirSubMenuCliente(){
        System.out.println("++++++++++++++++++++++++++++++++");
        System.out.println("1 - Pessoa Física");
        System.out.println("2 - Pessoa Jurídica");
        System.out.println("0 - Voltar ao menu principal");

        System.out.println("Escreva uma opção: ");
    }

    /*solicitar dados*/
    public void solicitacaoCliente(Cliente cliente){
        Scanner in = new Scanner(System.in);

        int codigo = clientes.get(this.clientes.size() - 1).getCodigo()+1;
        cliente.setCodigo(codigo);

        System.out.println("Seu codigo é: " + codigo);
        System.out.println("Digite seu nome: ");
        cliente.setNome(in.nextLine());

        System.out.println("Digite seu logradouro: ");
        cliente.setLogradouro(in.nextLine());

        System.out.println("Digite o número de seu logradouro: ");
        cliente.setNumeroCasa(in.nextInt());

        System.out.println("Digite seu Estado: ");
        cliente.setEstado(in.nextLine());

        System.out.println("Digite seu bairro: ");
        cliente.setBairro(in.nextLine());

        System.out.println("Digite seu município: ");
        cliente.setMunicipio(in.nextLine());

        System.out.println("Digite seu CEP: ");
        cliente.setCep(in.nextLine());

        System.out.println("Digite seu telefone: ");
        cliente.setTelefone(in.nextInt());

        System.out.println("Digite o numero máximo de mídias por empréstimo: ");
        cliente.setMidiasMax(in.nextInt());
    }

    /*adicionar ao ArrayList*/
    public boolean adicionarCliente(Cliente c){
        return clientes.add(c);
    }

    /*excluir do ArrayList*/
    public boolean removerCliente(Cliente c){
        return clientes.remove(c);
    }


    /*CLASSE PESSOA FÍSICA*/
    /*separei as pessoas fisicas das juridicas para consulta*/
    public ArrayList<PessoaFisica> getPessoaFisica(){
        ArrayList<PessoaFisica> pessoasFisicas = new ArrayList();
        for(Cliente cliente : clientes){
            if(cliente instanceof PessoaFisica){
                pessoasFisicas.add((PessoaFisica) cliente);
            }
        }
        return pessoasFisicas;
    }

    /*solicitação de dados*/
    public PessoaFisica solicitacaoPF(){
        Scanner in = new Scanner(System.in);
        PessoaFisica pf = new PessoaFisica();
        this.solicitacaoCliente(pf);

        /*Infos especificas PF*/
        System.out.println("Digite seu CPF: ");
        pf.setCPF(in.next());
        System.out.println("Digite seu RG: ");
        pf.setRG(in.next());

        return pf;
    }

    /*consulta*/
    public PessoaFisica consultarPF(int codigo, ArrayList<PessoaFisica> PFs){
        for(PessoaFisica pf : PFs){
            if(codigo == pf.getCodigo()){
                return pf;
            }
        }
        return null;
    }

    /*CLASSE PESSOA JURÍDICA*/
    /*separei as pessoas juridicas das fisicas para consulta*/
    public ArrayList<PessoaJuridica> getPessoaJuridica(){
        ArrayList<PessoaJuridica> pessoasJuridicas = new ArrayList();
        for(Cliente cliente : clientes){
            if(cliente instanceof PessoaJuridica){
                pessoasJuridicas.add((PessoaJuridica) cliente);
            }
        }
        return pessoasJuridicas;
    }

    /*solicitação de dados*/
    public PessoaJuridica solicitacaoPJ(){
        Scanner in = new Scanner(System.in);
        PessoaJuridica pj = new PessoaJuridica();
        this.solicitacaoCliente(pj);

        /*Infos especificas PJ*/
        System.out.println("Digite seu CNPJ: ");
        pj.setCNPJ(in.next());
        System.out.println("Digite seu IE: ");
        pj.setIE(in.nextInt());

        return pj;
    }

    /*consulta*/
    public PessoaJuridica consultarPJ(int codigo, ArrayList<PessoaJuridica> PJs){
        for(PessoaJuridica pj : PJs){
            if(codigo == pj.getCodigo()){
                return pj;
            }
        }
        return null;
    }

    /*CLASSE MÍDIA*/
    /*verifica possivel existencia*/
    public boolean midiaExistente(String Titulo){
        for(Midia midia : midias){
            if(midia.getTitulo().equalsIgnoreCase(Titulo)){
                return true;
            }
        }
        return false;
    }

    /*adicionar ao Arraylist*/
    public boolean adicionarMidia(Midia m){
        return midias.add(m);
    }

    /*excluir do Arraylist*/
    public boolean excluirMidia(Midia m){
        return midias.remove(m);
    }

    /*solicitação de dados*/
    public Midia solicitacaoMidia(){
        Scanner in = new Scanner(System.in);
        Midia m = new Midia();
        boolean tituloValido = false;

//        int codigo = midias.get(this.midias.size() - 1).getCodigo()+1;
        m.setCodigo(00);

    //    System.out.println("O código dessa mídia é: " + codigo);

        do {
            System.out.println("Digite o título: ");
            String titulo = in.nextLine();
            if (!midiaExistente(titulo)) {
                m.setTitulo(titulo);
                tituloValido = true;
            } else {
                System.out.println("Opa! Já existe uma mídia com esse nome" +
                        "\nDeseja recomeçar? (s/n)");
                if (!in.nextLine().equalsIgnoreCase("s")) {
                    return null;
                }
            }
        } while(!tituloValido);

        System.out.println("Digite a sinopse: ");
        m.setSinopse(in.nextLine());

        System.out.println("Digite a gênero: ");
        m.setGenero(in.nextLine());

        System.out.println("Digite o preço: ");
        m.setPreco(in.nextDouble());

        System.out.println("Mídia com dublagem? (s/n) ");
        if(in.nextLine().equalsIgnoreCase("s")){
            m.setDublado(true);
        } else{
            m.setDublado(false);
        }

        //limpar buffer
        in.nextLine();

        return m;
    }

    /*consulta por titulo*/
    public Midia consultaTituloMidia(String titulo){
        for(Midia m : midias){
            if(m.getTitulo().equals(titulo)){
                return m;
            }
        }
        return null;
    }


    /*GET e SET*/
    public ArrayList<Midia> getMidias() {
        return midias;
    }
}

