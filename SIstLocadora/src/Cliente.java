public class Cliente {
    private int codigo;
    private int numeroCasa;
    private int telefone;
    private int midiasMax;
    private String nome, estado, bairro, municipio, logradouro, cep;

    public Cliente(int codigo, String nome, String logradouro, int numeroCasa, String estado,
                   String bairro, String municipio, String cep, int telefone, int midiasMax) {

        this.codigo = codigo;
        this.nome = nome;
        this.logradouro = logradouro;
        this.numeroCasa = numeroCasa;
        this.estado = estado;
        this.bairro = bairro;
        this.municipio = municipio;
        this.cep = cep;
        this.telefone = telefone;
        this.midiasMax = midiasMax;
    }

    public Cliente(){}

    /*Imprimir*/
    public void imprimirDadosCliente(){
        System.out.println("\n++++++++++++++++ DADOS CLIENTE ++++++++++++++++\n");
        System.out.println("Código: " + this.codigo);
        System.out.println("Nome: " + this.nome);
        System.out.println("Logradouro: " + this.logradouro);
        System.out.println("Numero do Logradouro: " + this.numeroCasa);
        System.out.println("Estado: " + this.estado);
        System.out.println("Bairro: " + this.bairro);
        System.out.println("Municipio: " + this.municipio);
        System.out.println("CEP: " + this.cep);
        System.out.println("Telefone: " + this.telefone);
        System.out.println("Mídias máximas por empréstimo: " + this.midiasMax);
    }

    /* GET e SET */
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }


    public int getMidiasMax() {
        return midiasMax;
    }
    public void setMidiasMax(int midiasMax) {
        this.midiasMax = midiasMax;
    }
}
