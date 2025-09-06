package versao_inicial.model;

public class Paciente {
    private int id = 0;
    private String nome;
    
    public Paciente(String nome) {
        this.nome = nome;
        this.id = id++;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
}
