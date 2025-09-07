package versao_refatorada.model;

public class Paciente {
    private String id;
    private String nome;
    
    public Paciente(String id, String nome) {
        this.nome = nome;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
}
