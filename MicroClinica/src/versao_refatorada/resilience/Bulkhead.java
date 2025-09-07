package versao_refatorada.resilience;

import java.util.concurrent.Semaphore;

public class Bulkhead {
    private final Semaphore semaforo = new Semaphore(2);

    public boolean executar(Acao acao) throws Exception {
        if (!semaforo.tryAcquire()) {
            throw new RuntimeException("BULKHEAD REJEITOU! Limite de chamadas concorrentes excedido.");
        }

        try {
            System.out.println("LOG: [Bulkhead] - Permissão adquirida. Executando a ação.");
            return acao.executar();
        } finally {
            System.out.println("LOG: [Bulkhead] - Permissão liberada.");
            semaforo.release();
        }
    }
}
