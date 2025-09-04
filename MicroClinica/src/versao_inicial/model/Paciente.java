package versao_inicial.model;

public class Paciente {
    private int id;
    private String nome;
    
    public Paciente(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
}
