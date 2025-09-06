package versao_inicial;

import java.time.LocalDateTime;
import versao_inicial.model.Paciente;
import versao_inicial.service.AgendamentoService;
import versao_inicial.service.PacienteService;
import versao_inicial.service.ProfissionalService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Micro Clínica - Versão Inicial");
        ProfissionalService profissionalService = new ProfissionalService();
        AgendamentoService agendamentoService = new AgendamentoService();
        Paciente paciente = new Paciente("João Silva");
        PacienteService pacienteService = new PacienteService(paciente);
        agendamentoService.agendarConsulta(0, "PROF_CARD01", LocalDateTime.of(2025, 9, 14, 14, 30));
    }
}
