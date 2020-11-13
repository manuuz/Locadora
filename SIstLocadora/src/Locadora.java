import java.util.ArrayList;
import java.util.Scanner;

public class Locadora {
    private ArrayList<Cliente> clientes;
    private ArrayList<Midia> midias;
    private ArrayList<Emprestimo> emprestimos;

    public Locadora(){
        this.clientes = new ArrayList<>();
        this.midias = new ArrayList<>();
        this.emprestimos = new ArrayList<>();

    }

    //TESTES
    public void cadastroAutomatico(){
        /*Clientes*/
        /*Pessoa Física*/
        PessoaFisica pf1 = new PessoaFisica(0, "Emanuelle Maria", "Rua Capela",
                407, "Jd Riacho", "Contagem", "MG", "32241290",
                998349599, 6, "150512526-05", "MG-160610");
        adicionarCliente(pf1);

        /*Pessoa Juridica*/


        /*Midias*/
        Midia m1 = new Midia(0, "Clube da Luta", "Filmes com críticas",
                "Drama", true, 20.00);
        adicionarMidia(m1);
        Midia m2 = new Midia(1, "Parasite", "Filmes ganhadores de Oscar",
                "Thriller", false, 17.00);
        adicionarMidia(m2);
    }

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

    //CLASSE CLIENTE
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

        int codigo = clientes.size()-1;
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

    public Cliente consultarCliente(int codigo){
        for(Cliente cliente : clientes){
            if(codigo == cliente.getCodigo()){
                return cliente;
            }
        }
        return null;
    }

    /*adicionar ao ArrayList*/
    public boolean adicionarCliente(Cliente c){
        return clientes.add(c);
    }

    /*excluir do ArrayList*/
    public boolean removerCliente(Cliente c){
        return clientes.remove(c);
    }


    //CLASSE PESSOA FÍSICA
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

    //CLASSE MÍDIA
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

        int codigo = midias.size() - 1;
        m.setCodigo(codigo);

        System.out.println("O código dessa mídia é: " + codigo);

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
        m.setDublado(in.nextLine().equalsIgnoreCase("s"));

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

    //CLASE EMPRESTIMO
    /*imprime submenu*/
    public void imprimirSubmenuEmprestimo(){
        System.out.println("++++++++++++++++ Emprestimo ++++++++++++++++");
            System.out.println("1 - Empréstimo");
            System.out.println("2 - Devolução");
            System.out.println("3 - Imprimir Relatório");
            System.out.println("0 - Voltar ao menu principal");

            System.out.println("Escreva uma opção: ");
    }

    /*solicitação de dados*/
    public Emprestimo solicitacaoEmprestimo(){
        Scanner in = new Scanner(System.in);
        boolean clienteValido = false;
        Cliente cliente;
        String tituloMidia;

        Emprestimo emprestimo = new Emprestimo();
        do{
            System.out.println("Digite código do cliente: ");
            int codCliente = in.nextInt();

            //limpar buffer
            in.nextLine();

            cliente = consultarCliente(codCliente);

            if(cliente != null){
                System.out.println("Confirmar cliente " + cliente.getNome() + " ? (s/n)");
                if(in.nextLine().equalsIgnoreCase("s")){
                    emprestimo.setCliente(cliente);
                    clienteValido = true;
                }
            } else {
                System.out.println("Cliente não encontrado. \nDeseja recomeçar? (s/n");
                if(!in.nextLine().equalsIgnoreCase("s")){
                    return null;
                }
            }

        }while(!clienteValido);

        /*guia para midias alugadas desse cliente*/
        ArrayList<Midia> midiasAlugadas = new ArrayList<>();
        System.out.println("O máximo de mídias que o cliente tem direito de alugar são " +
                cliente.getMidiasMax());

        Midia midia;
        int contador = 0;
        boolean adicionarMidias = true;
        System.out.println("\n++++++++++++++++ EMPRESTIMO DE MIDIAS ++++++++++++++++\n");

        do {
            do {
                System.out.println("Escreva o título da mídia: ");
                tituloMidia = in.nextLine();

                midia = consultaTituloMidia(tituloMidia);

                if (midia != null) {
                    if (midia.isDisponibilidade()) {
                        System.out.println(midia.getTitulo() + " adicionada com sucesso" +
                                "\nPreço: R$" + midia.getPreco());
                        midiasAlugadas.add(midia);
                        emprestimo.setValor(emprestimo.getValor() + midia.getPreco());
                        contador++;
                    } else {
                        System.out.println("Mídia indisponível no momento");
                    }
                } else {
                    System.out.println("Mídia não encontrada");
                }
            } while (contador == 0);

            if(contador == cliente.getMidiasMax()){
                System.out.println("Número máximo de mídias atingido");
                adicionarMidias = false;

            } else{
                System.out.println("Deseja cadastrar mais mídias? (s/n)");
                if(in.nextLine().equalsIgnoreCase("n")) {
                    adicionarMidias = false;
                }
            }

        } while(adicionarMidias);

        /*define mídias do empréstimo e muda disponibilidade delas*/
        emprestimo.setMidias(midiasAlugadas);
        emprestimo.midiaIndisp();
        emprestimo.setDevolvido(false);

        System.out.println("Digite a data atual:");
        System.out.println("Dia: ");
        emprestimo.setDia(in.nextInt());
        System.out.println("Mês: ");
        emprestimo.setMes(in.nextInt());
        System.out.println("Ano: ");
        emprestimo.setAno(in.nextInt());

        //limpar buffer
        in.nextLine();

        return emprestimo;
    }

    public Emprestimo consultaEmprestimos(int codigo){
        for(Emprestimo e : emprestimos){
            if(e.getCodCliente() == codigo){
                return e;
            }
        }
        return null;
    }

    /*Verifica se há multas*/
    public boolean verificaMulta(Emprestimo e){
        return e.getMulta() != 0.0;
    }

    /*adicionar ao ArrayList*/
    public boolean adicionarEmprestimo(Emprestimo e){
        return emprestimos.add(e);
    }



    //GET e SET
    public ArrayList<Midia> getMidias() {
        return midias;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}

