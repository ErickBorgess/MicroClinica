package versao_inicial.model;

import java.time.LocalDateTime;

public class Agendamento {
    private int id;
    private Paciente paciente;
    private Profissional profissional;
    private LocalDateTime dataAgendamento;

    public Agendamento(Paciente paciente, Profissional profissional, LocalDateTime data) {
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

    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

}
