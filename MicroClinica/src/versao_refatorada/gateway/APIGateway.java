package versao_refatorada.gateway;

import java.time.LocalDateTime;
import versao_refatorada.model.Agendamento;
import versao_refatorada.service.AgendamentoService;

public class APIGateway {
    private final AgendamentoService agendamentoService;

    public APIGateway(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
        System.out.println("LOG: [API Gateway] - Gateway inicializado e pronto para receber requisições.");
    }

    public Agendamento agendarConsulta(String idPaciente, String idProfissional, LocalDateTime data) throws Exception {
        System.out.println("LOG: [API Gateway] - Recebida requisição para agendar consulta.");
        return agendamentoService.agendarConsulta(idPaciente, idProfissional, data);
    }
}
