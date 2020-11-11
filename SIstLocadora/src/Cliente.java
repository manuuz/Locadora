public class Cliente {
    private int codigo;
    private int numeroCasa;
    private int telefone;
    private int midiasMax;
    private String nome;
    private String logradouro;
    private String bairro;
    private String estado;

    public Cliente(int codigo, String nome, String logradouro, int numeroCasa, String bairro,
                   String municipio, String estado, int cep, int telefone, int midiasMax) {

        this.codigo = codigo;
        this.nome = nome;
        this.logradouro = logradouro;
        this.numeroCasa = numeroCasa;
        this.bairro = bairro;
        this.estado = estado;
        this.telefone = telefone;
        this.midiasMax = midiasMax;
    }


    /* GET e SET */
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getMidiasMax() {
        return midiasMax;
    }
}
