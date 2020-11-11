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
                    /**/
                    break;
                case 2:
                    /**/
            }
        }while(opcao != 0);

    }

    public static void submenuCliente(Locadora locadora){
        Scanner in = new Scanner(System.in);
        int opcao;

        do{
            locadora.imprimirSubMenu();
            opcao = in.nextInt();
        }while(opcao != 0);
    }
}
