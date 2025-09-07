package versao_refatorada.model;

import java.time.LocalDateTime;

public class Agendamento {
    private String id;
    private Paciente paciente;
    private Profissional profissional;
    private LocalDateTime dataAgendamento;

    public Agendamento(String id, Paciente paciente, Profissional profissional, LocalDateTime data) {
        this.id = id;
        this.paciente = paciente;
        this.profissional = profissional;
        this.dataAgendamento = data;
    }

    public String getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }
    
    public Profissional getProfissional() {
        return profissional;
    }

    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

}
