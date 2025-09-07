package versao_refatorada.service;

import java.time.LocalDateTime;
import versao_refatorada.model.Agendamento;
import versao_refatorada.model.Paciente;
import versao_refatorada.model.Profissional;
import versao_refatorada.repository.AgendamentoRepository;
import versao_refatorada.resilience.Bulkhead;
import versao_refatorada.resilience.CircuitBreaker;

public class AgendamentoService {
    private final PacienteService pacienteService;
    private final ProfissionalService profissionalService;
    private final AgendamentoRepository agendamentoRepository;
    private int contadorIdAgendamento = 0;
    private final CircuitBreaker circuitBreaker;
    private final Bulkhead bulkhead;

    public AgendamentoService(PacienteService pacService, ProfissionalService profService, AgendamentoRepository agendRepository, CircuitBreaker cBreaker, Bulkhead bulkhead) {
        this.pacienteService = pacService;
        this.profissionalService = profService;
        this.agendamentoRepository = agendRepository;
        this.circuitBreaker = cBreaker;
        this.bulkhead = bulkhead;
    }

    public Agendamento agendarConsulta(String idPaciente, String idProfissional, LocalDateTime data) throws Exception {
        Paciente paciente = pacienteService.buscarPorId(idPaciente);
        if (paciente == null) {
            throw new IllegalArgumentException("Paciente não encontrado: " + idPaciente);
        }

        Profissional profissional = profissionalService.buscarProfissionalPorId(idProfissional);
        if (profissional == null) {
            throw new IllegalArgumentException("Profissional não encontrado: " + idProfissional);
        }

        boolean disponivel = bulkhead.executar(() ->
            circuitBreaker.executar(() -> // Você também simplificaria o Circuit Breaker
                profissionalService.verificarDisponibilidade(idProfissional, data)
            )
        );
        
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
