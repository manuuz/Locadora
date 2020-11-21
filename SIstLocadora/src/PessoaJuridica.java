public class PessoaJuridica extends Cliente {
    private String CNPJ;
    private int IE;

    public PessoaJuridica(int codigo, String nome, String logradouro, int numeroCasa,
                          String bairro, String municipio, String estado, String cep,
                          int telefone, int midiasMax, String CNPJ, int IE) {
        super(codigo, nome, logradouro, numeroCasa, bairro, municipio, estado, cep,
                telefone, midiasMax);
        this.CNPJ = CNPJ;
        this.IE = IE;
    }

    public PessoaJuridica(){}

    /*Imprimir*/
    public void imprimirDadosPJ(){
        super.imprimirDadosCliente();
        System.out.println("CNPJ: " + this.CNPJ);
        System.out.println("IE: " + this.IE);
    }

    //GET E SET

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public void setIE(int IE) {
        this.IE = IE;
    }
}
