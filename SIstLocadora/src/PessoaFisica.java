public class PessoaFisica extends Cliente{
    private String CPF, RG;

    public PessoaFisica(int codigo, String nome, String logradouro, int numeroCasa,
                        String bairro, String municipio, String estado, String cep,
                        int telefone, int midiasMax, String CPF, String RG) {
        super(codigo, nome, logradouro, numeroCasa, bairro, municipio, estado, cep,
                telefone, midiasMax);
        this.CPF = CPF;
        this.RG = RG;
    }

    public PessoaFisica(){}


    /*Imprimir*/
    public void imprimirDadosPF(){
        super.imprimirDadosCliente();
        System.out.println("CPF: " + this.CPF);
        System.out.println("RG: " + this.RG);
    }

    /*GET E SET*/

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }
}
