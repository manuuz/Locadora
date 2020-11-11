public class PessoaJuridica extends Cliente {
    private String CNPJ;
    private int IE;

    public PessoaJuridica(int codigo, String nome, String logradouro, int numeroCasa,
                          String bairro, String municipio, String estado, int cep,
                          int telefone, int midiasMax, String CNPJ, int IE) {
        super(codigo, nome, logradouro, numeroCasa, bairro, municipio, estado, cep,
                telefone, midiasMax);
        this.CNPJ = CNPJ;
        this.IE = IE;
    }
}
