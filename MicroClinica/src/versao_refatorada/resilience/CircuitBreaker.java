package versao_refatorada.resilience;

public class CircuitBreaker {
    private enum State {
        FECHADO,
        ABERTO,
        SEMI_ABERTO
    }

    private State estado = State.FECHADO;
    private int contadorFalhas = 0;
    private final int LIMITE_FALHAS = 2;
    private long tempoUltimaFalha = 0;
    private final long TEMPO_ESPERA = 5000;

    public boolean executar(Acao acao) throws Exception {
        switch (estado) {
            case FECHADO:
                try {
                    boolean resultado = acao.executar();
                    resetar();
                    return resultado;
                } catch (Exception e) {
                    registrarFalha();
                    throw e;
                }

            case ABERTO:
                if (System.currentTimeMillis() - tempoUltimaFalha > TEMPO_ESPERA) {
                    estado = State.SEMI_ABERTO;
                    System.out.println("LOG: [Circuit Breaker] - Estado mudou para SEMI-ABERTO.");
                    return executar(acao);
                } else {
                    throw new RuntimeException("CIRCUITO ABERTO! A chamada está bloqueada.");
                }

            case SEMI_ABERTO:
                try {
                    boolean resultado = acao.executar();
                    resetar();
                    return resultado;
                } catch (Exception e) {
                    abrirCircuito();
                    throw e;
                }
        }
        throw new IllegalStateException("Estado inválido do Circuit Breaker.");
    }

    private void registrarFalha() {
        contadorFalhas++;
        System.out.printf("LOG: [Circuit Breaker] - Falha registrada. Contagem: %d/%d%n", contadorFalhas, LIMITE_FALHAS);
        if (contadorFalhas >= LIMITE_FALHAS) {
            abrirCircuito();
        }
    }

    private void abrirCircuito() {
        estado = State.ABERTO;
        tempoUltimaFalha = System.currentTimeMillis();
        System.out.println("LOG: [Circuit Breaker] - Limite de falhas atingido. Estado mudou para ABERTO.");
    }

    private void resetar() {
        if (estado != State.FECHADO) {
            System.out.println("LOG: [Circuit Breaker] - Chamada bem-sucedida. Circuito FECHADO.");
            estado = State.FECHADO;
        }
        contadorFalhas = 0;
    }
}
