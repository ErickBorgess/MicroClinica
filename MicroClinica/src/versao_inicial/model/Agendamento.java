package versao_inicial.model;

public class Agendamento {
    private int id;
    private Paciente paciente;
    private Profissional profissional;
    private String dataAgendamento;

    public Agendamento(Paciente paciente, Profissional profissional, String data) {
        this.paciente = paciente;
        this.profissional = profissional;
        this.dataAgendamento = data;
    }

    public int getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }
    
    public Profissional getProfissional() {
        return profissional;
    }

    public String getDataAgendamento() {
        return dataAgendamento;
    }

}
