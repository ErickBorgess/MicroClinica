package versao_inicial;

import java.time.LocalDateTime;
import versao_inicial.service.AgendamentoService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Micro Clínica - Versão Inicial");
        AgendamentoService agendamentoService = new AgendamentoService();
        for (int i = 1; i <= 5; i++) { //Loop será executado 5 vezes e terá simulação de erro na 3 tentativa
            System.out.printf("%n>>> TENTATIVA DE AGENDAMENTO Nº %d <<< %n", i);
            try {
                String pacienteId = "PAC01"; 
                String profissionalId = "PROF_CARD01";
                LocalDateTime data = LocalDateTime.of(2025, 10, 20, 10, 0);

                agendamentoService.agendarConsulta(pacienteId, profissionalId, data);
                System.out.println(">>> RESULTADO: Agendamento realizado com SUCESSO.");

            } catch (Exception e) {
                System.err.println("!!! ERRO CRÍTICO NA APLICAÇÃO: A operação falhou completamente.");
                System.err.println("!!! Causa: " + e.getMessage());
            }
        }
    }
    
}
