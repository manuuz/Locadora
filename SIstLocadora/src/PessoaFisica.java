public class PessoaFisica extends Cliente{
    private String CPF, RG;

    public PessoaFisica(int codigo, String nome, String logradouro, int numeroCasa,
                        String bairro, String municipio, String estado, int cep,
                        int telefone, int midiasMax, String CPF, String RG) {
        super(codigo, nome, logradouro, numeroCasa, bairro, municipio, estado, cep,
                telefone, midiasMax);
        this.CPF = CPF;
        this.RG = RG;
    }
}
