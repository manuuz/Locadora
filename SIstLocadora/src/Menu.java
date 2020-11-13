import java.util.ArrayList;
import java.util.Scanner;

/* Classe Principal com menu e submenus */
public class Menu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Locadora locadora = new Locadora();

        int opcao;

        do{
            locadora.imprimirMenu();
            opcao = in.nextInt();

            switch (opcao){
                case 1:
                    submenuCliente(locadora);
                    break;

                case 2:
                    submenuMidia(locadora);
                    break;

                case 3:
                    /*submenuEmprestimo(locadora)*/
            }
        }while(opcao != 0);

    }

    /* Códigos dos submenus */
    /* CLASSE CLIENTE*/
    public static void submenuCliente(Locadora locadora){
        Scanner in = new Scanner(System.in);
        int opcao;

        do{
            locadora.imprimirSubMenuCliente();
            opcao = in.nextInt();

            switch(opcao){
                case 1:
                    submenuPessoaFisica(locadora);

                case 2:
                    submenuPessoaJuridica(locadora);
            }

        }while(opcao != 0);
    }

    /*CLASSE PESSOA FÍSICA*/
    public static void submenuPessoaFisica(Locadora locadora){
        Scanner in = new Scanner(System.in);
        int opcao;
        ArrayList<PessoaFisica> pessoasFisicas;
        PessoaFisica pf;

        do {
            locadora.imprimirSubMenu("Pessoa Física");
            opcao = in.nextInt();
            pessoasFisicas = locadora.getPessoaFisica();

            switch (opcao){
                case 1:
                    //cadastro
                    System.out.println("\n++++++++++++++++ CADASTRO PESSOA FÍSICA ++++++++++++++++\n");
                    pf = locadora.solicitacaoPF();

                    //limpar buffer
                    in.nextLine();

                    if(pf != null){
                        if(!locadora.adicionarCliente(pf)){
                            System.out.println("Erro no cadastro");
                        } else{
                            System.out.println("Sucesso no cadastro");
                        }
                    } else{
                        System.out.println("Erro no cadastro");
                    }
                    break;

                case 2:
                    //exclusao
                    System.out.println("Digite o código da pessoa física que deseja excluir:");
                    pf = locadora.consultarPF(in.nextInt(), pessoasFisicas);

                    //limpar buffer
                    in.nextLine();

                    if(pf != null){
                        System.out.println("Deseja excluir o cliente " + pf.getNome() + " ? (s/n");
                        if(in.nextLine().equalsIgnoreCase("s")){
                            if(locadora.removerCliente(pf)){
                                System.out.println("Exclusão com sucesso");
                            } else {
                                System.out.println("Erro na exclusão");
                            }
                        } else{
                            System.out.println("Exclusão cancelada.");
                        }
                    } else{
                        System.out.println("Pessoa física não encontrada");
                    }
                    break;

                case 3:
                    //consulta
                    if(pessoasFisicas.isEmpty()){
                        System.out.println("Não há pessoas físicas cadastradas!");
                    } else {
                        System.out.println("Digite o código da pessoa física que deseja consultar:");
                        pf = locadora.consultarPF(in.nextInt(), pessoasFisicas);

                        //limpar buffer
                        in.nextLine();

                        if(pf != null){
                            pf.imprimirDadosPF();
                        } else{
                            System.out.println("Erro na consultar pessoa física");
                        }

                    }
                    break;

                case 4:
                    //relatório
                    if(pessoasFisicas.isEmpty()){
                        System.out.println("Não há pessoas físicas cadastradas!");
                    }else {
                        for(PessoaFisica pessoaFisica : pessoasFisicas){
                            System.out.println(" ");
                            pessoaFisica.imprimirDadosPF();
                        }
                    }
                    break;
            }

        }while(opcao != 0);
    }

    /*CLASSE PESSOA JURÍDICA*/
    public static void submenuPessoaJuridica(Locadora locadora){
        Scanner in = new Scanner(System.in);
        int opcao;
        ArrayList<PessoaJuridica> pessoasJuridicas;
        PessoaJuridica pj;

        do{
            locadora.imprimirSubMenu("Pessoa Jurídica");
            opcao = in.nextInt();
            pessoasJuridicas = locadora.getPessoaJuridica();

            switch (opcao){
                case 1:
                    //cadastro
                    System.out.println("\n++++++++++++++++ CADASTRO PESSOA JURÍDICA ++++++++++++++++\n");
                    pj = locadora.solicitacaoPJ();

                    //limpar buffer
                    in.nextLine();

                    if(pj != null){
                        if(!locadora.adicionarCliente(pj)){
                            System.out.println("Erro no cadastro");
                        } else{
                            System.out.println("Sucesso no cadastro");
                        }
                    } else{
                        System.out.println("Erro no cadastro");
                    }
                    break;

                case 2:
                    //exclusao
                    System.out.println("Qual o código da pessoa jurídica que deseja excluir? ");
                    pj = locadora.consultarPJ(in.nextInt(), pessoasJuridicas);

                    //limpar buffer
                    in.nextLine();

                    if(pj != null){
                        System.out.println("Deseja excluir a pessoa jurídica " + pj.getNome() + " ? (s/n)");
                        if(in.nextLine().equalsIgnoreCase("s")){
                            if(locadora.removerCliente(pj)){
                                System.out.println("Sucesso na exclusão");
                            } else{
                                System.out.println("Erro na exclusão");
                            }
                        } else{
                            System.out.println("Exclusão cancelada");
                        }
                    }else{
                        System.out.println("Pessoa jurídica não encontrada");
                    }
                    break;

                case 3:
                    //consulta
                    if(pessoasJuridicas.isEmpty()){
                        System.out.println("Não há pessoas jurídicas cadastradas");
                    } else {
                        System.out.println("Qual o código da pessoa jurídica que deseja consultar? ");
                        pj = locadora.consultarPJ(in.nextInt(), pessoasJuridicas);

                        //limpa buffer
                        in.nextLine();

                        if(pj != null){
                            pj.imprimirDadosPJ();
                        } else{
                            System.out.println("Erro ao consultar pessoa jurídica");
                        }
                    }
                    break;

                case 4:
                    if(pessoasJuridicas.isEmpty()){
                        System.out.println("Não há pessoas jurídicas cadastradas");
                    } else {
                        for(PessoaJuridica pessoaJuridica : pessoasJuridicas){
                            System.out.println(" ");
                            pessoaJuridica.imprimirDadosPJ();
                        }
                    }
                    break;
            }

        } while(opcao != 0);
    }

    /*CLASSE MÍDIA*/
    public static void submenuMidia(Locadora locadora){
        Scanner in = new Scanner(System.in);
        int opcao;
        String titulo;
        Midia midia;

        do{
            locadora.imprimirSubMenu("Mídias");
            opcao = in.nextInt();

            //limpar buffer
            in.nextLine();

            switch (opcao){
                case 1:
                    //cadastro
                    System.out.println("\n++++++++++++++++ CADASTRO MIDIA ++++++++++++++++\n");
                    midia = locadora.solicitacaoMidia();

                    if(midia != null){
                        if(locadora.adicionarMidia(midia)){
                            System.out.println("Sucesso no cadastro");
                        } else{
                            System.out.println("Erro no cadastro");
                        }
                    } else{
                        System.out.println("Erro no cadastro");
                    }
                    break;

                case 2:
                    //exclusao
                    System.out.println("Digite o título da mídia que deseja excluir: ");
                    midia = locadora.consultaTituloMidia(in.nextLine());

                    //limpar buffer
                    in.nextLine();

                    if(midia != null){
                        System.out.println("Deseja mesmo excluir a mídia " + midia.getTitulo() + " ?(s/n)");
                        if(in.nextLine().equalsIgnoreCase("s")){
                            if(locadora.excluirMidia(midia)){
                                System.out.println("Exclusão com sucesso");
                            } else{
                                System.out.println("Erro na exclusão");
                            }
                        } else{
                            System.out.println("Exclusão cancelada");
                        }
                    } else{
                        System.out.println("Mídia não encontrada");
                    }
                    break;

                case 3:
                    //consulta
                    if(locadora.getMidias().isEmpty()){
                        System.out.println("Não há mídias cadastradas");
                    } else{
                        System.out.println("Digite o título da mídia que deseja consultar: ");
                        midia = locadora.consultaTituloMidia(in.nextLine());

                        if(midia != null){
                            midia.imprimirMidia();
                        } else{
                            System.out.println("Mídia não encontrada");
                        }
                    }
                    break;

                case 4:
                    //relatório
                    if(locadora.getMidias().isEmpty()){
                        System.out.println("Não há mídias cadastradas");
                    } else{
                        for(Midia m : locadora.getMidias()){
                            System.out.println("");
                            m.imprimirMidia();
                        }
                    }
                    break;
            }
        } while(opcao != 0);
    }

    /*CLASSE EMPRÉSTIMO*/
    public static void submenuEmprestimo(Locadora locadora){
        
    }
}

