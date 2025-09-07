package versao_refatorada.resilience;

public interface Acao {
    boolean executar() throws Exception;
}
