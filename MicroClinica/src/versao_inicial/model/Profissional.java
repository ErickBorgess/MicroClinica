package versao_inicial.model;

public class Profissional {
    private String id;
    private String nome;
    private String especialidade;
    
    public Profissional(String id, String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }
}
