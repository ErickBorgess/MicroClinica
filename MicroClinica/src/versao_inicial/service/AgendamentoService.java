package versao_inicial.service;

import java.time.LocalDateTime;

//God Service
public class AgendamentoService {
    private final PacienteService pacienteService;
    private final ProfissionalService profissionalService;
    private int contadorIdAgendamento = 0;

    public AgendamentoService() {
        this.pacienteService = new PacienteService();
        this.profissionalService = new ProfissionalService();
    }

    public void agendarConsulta(int idPaciente, String idProfissional, LocalDateTime dataAgendamento) {
        var paciente = pacienteService.buscarPorId(idPaciente);
        if (paciente == null) {
            System.out.println("Paciente com ID " + idPaciente + " não encontrado!");
            return;
        }

        var profissional = profissionalService.buscarPorId(idProfissional);
        if (profissional == null) {
            System.out.println("Profissional com ID " + idProfissional + " não encontrado!");
            return;
        }

        try {
            boolean disponivel = profissionalService.verificarDisponibilidade(idProfissional, dataAgendamento);
            if (!disponivel) {
                System.out.println("Profissional " + profissional.getNome() + " não está disponível na data " + dataAgendamento);
                return;
            }
        } catch (Exception e) {
            System.out.println("Erro ao verificar disponibilidade do profissional: " + e.getMessage());
            return;
        }

        contadorIdAgendamento++;
        System.out.println("Consulta agendada com sucesso! Detalhes:");
        System.out.println("ID Agendamento: " + contadorIdAgendamento);
        System.out.println("Paciente: " + paciente.getNome());
        System.out.println("Profissional: " + profissional.getNome() + " (" + profissional.getEspecialidade() + ")");
        System.out.println("Data/Agendamento: " + dataAgendamento);
    }

}
