package versao_inicial.service;

import java.time.LocalDateTime;

import versao_inicial.model.Agendamento;

//God Service
public class AgendamentoService {
    private final PacienteService pacienteService;
    private final ProfissionalService profissionalService;
    private int contadorIdAgendamento = 0;

    public AgendamentoService() {
        this.pacienteService = new PacienteService();
        this.profissionalService = new ProfissionalService();
    }

    public Agendamento agendarConsulta(String idPaciente, String idProfissional, LocalDateTime dataAgendamento) {
        var paciente = pacienteService.buscarPorId(idPaciente);
        if (paciente == null) {
            System.out.println("Paciente com ID " + idPaciente + " não encontrado!");
        }

        var profissional = profissionalService.buscarPorId(idProfissional);
        if (profissional == null) {
            System.out.println("Profissional com ID " + idProfissional + " não encontrado!");
        }

        boolean disponivel = profissionalService.verificarDisponibilidade(idProfissional, dataAgendamento);

        if (disponivel) {
            contadorIdAgendamento++;
            String novoId = "AGD_" + contadorIdAgendamento;
            Agendamento novoAgendamento = new Agendamento(novoId, paciente, profissional, dataAgendamento);

            System.out.println("LOG: [AgendamentoService] - Agendamento criado com sucesso: " + novoId);

            this.enviarNotificacaoLOG(novoAgendamento);
            this.enviarNotificacaoVisor(novoAgendamento);

            return novoAgendamento;
        }

        return null;
    }

    private void enviarNotificacaoLOG(Agendamento agendamento) {
        System.out.println("LOG: [AgendamentoService] - NOTIFICAÇÃO: Agendamento "+agendamento.getId()+" confirmado para "+agendamento.getPaciente().getNome());
    }

    private void enviarNotificacaoVisor(Agendamento agendamento) {
        System.out.println("Consulta agendada com sucesso! Detalhes:");
        System.out.println("ID Agendamento: " + agendamento.getId());
        System.out.println("Paciente: " + agendamento.getPaciente().getNome());
        System.out.println("Profissional: " + agendamento.getProfissional().getNome() + " (" + agendamento.getProfissional().getEspecialidade() + ")");
        System.out.println("Data/Agendamento: " + agendamento.getDataAgendamento());    
    }

}
