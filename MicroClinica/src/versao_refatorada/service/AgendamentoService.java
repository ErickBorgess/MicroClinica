package versao_refatorada.service;

import java.time.LocalDateTime;
import versao_refatorada.model.Agendamento;
import versao_refatorada.model.Paciente;
import versao_refatorada.model.Profissional;
import versao_refatorada.repository.AgendamentoRepository;

public class AgendamentoService {
    private final PacienteService pacienteService;
    private final ProfissionalService profissionalService;
    private final AgendamentoRepository agendamentoRepository;
    private int contadorIdAgendamento = 0;

    public AgendamentoService(PacienteService pacService, ProfissionalService profService, AgendamentoRepository agendRepository) {
        this.pacienteService = pacService;
        this.profissionalService = profService;
        this.agendamentoRepository = agendRepository;
    }

    public Agendamento agendarConsulta(String idPaciente, String idProfissional, LocalDateTime data) {
        Paciente paciente = pacienteService.buscarPorId(idPaciente);
        if (paciente == null) {
            throw new IllegalArgumentException("Paciente não encontrado: " + idPaciente);
        }

        Profissional profissional = profissionalService.buscarProfissionalPorId(idProfissional);
        if (profissional == null) {
            throw new IllegalArgumentException("Profissional não encontrado: " + idProfissional);
        }

        boolean disponivel = profissionalService.verificarDisponibilidade(idProfissional, data);

        if (disponivel) {
            contadorIdAgendamento++;
            String novoId = "AGD_REF_" + contadorIdAgendamento;
            Agendamento novoAgendamento = new Agendamento(novoId, paciente, profissional, data);

            agendamentoRepository.salvar(novoAgendamento);

            return novoAgendamento;
        }

        return null;
    }
}
