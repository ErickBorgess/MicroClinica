package versao_refatorada;

import java.time.LocalDateTime;

import versao_refatorada.repository.*;
import versao_refatorada.resilience.*;
import versao_refatorada.service.*;
import versao_refatorada.model.Agendamento;
import versao_refatorada.gateway.APIGateway;

public class MainRefatorado {
    public static void main(String[] args) throws Exception {
        System.out.println("--- SIMULAÇÃO DA VERSÃO REFATORADA (ESTRUTURAL) ---");
        System.out.println("====================================================");

        // --- INICIALIZAÇÃO E INJEÇÃO DE DEPENDÊNCIA ---
        PacienteRepository pacienteRepo = new PacienteRepository();
        ProfissionalRepository profissionalRepo = new ProfissionalRepository();
        AgendamentoRepository agendamentoRepo = new AgendamentoRepository();

        PacienteService pacienteService = new PacienteService(pacienteRepo);
        ProfissionalService profissionalService = new ProfissionalService(profissionalRepo);

        CircuitBreaker circuitBreaker = new CircuitBreaker();
        Bulkhead bulkhead = new Bulkhead();
        AgendamentoService agendamentoService = new AgendamentoService(pacienteService, profissionalService,
                agendamentoRepo, circuitBreaker, bulkhead);

        APIGateway gateway = new APIGateway(agendamentoService);
        
        // --- FASE DE EXECUÇÃO ---
        for (int i = 1; i <= 6; i++) {
            System.out.printf("%n>>> REQUISIÇÃO Nº %d via Gateway <<< %n", i);
            try {
                String pacienteId = "PAC01";
                String profissionalId = "PROF_CARD01";
                LocalDateTime data = LocalDateTime.of(2025, 10, 20, 10, 0);

                Agendamento agendamento = gateway.agendarConsulta(pacienteId, profissionalId, data);

                System.out.println(">>> RESPOSTA DO GATEWAY: Agendamento realizado com SUCESSO.");
                System.out.println(">>> ID do Agendamento: " + agendamento.getId());

            } catch (Exception e) {
                System.err.println("!!! RESPOSTA DO GATEWAY: ERRO NA OPERAÇÃO.");
                System.err.println("!!! Causa: " + e.getMessage());
            }

            if (i == 5) {
                try {
                    System.out.println(
                            "\nEsperando 6 segundos para o Circuit Breaker tentar fechar (entrar em SEMI-ABERTO)...");
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        System.out.println("\n======================================================");
        System.out.println("------------------ FIM DA SIMULAÇÃO ------------------");
    }

}
