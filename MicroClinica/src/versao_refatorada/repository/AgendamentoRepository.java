package versao_refatorada.repository;

import java.util.ArrayList;
import java.util.List;
import versao_refatorada.model.Agendamento;

public class AgendamentoRepository {
    private final List<Agendamento> agendamentosDB;

    public AgendamentoRepository() {
        this.agendamentosDB = new ArrayList<>();
    }

    public void salvar(Agendamento agendamento) {
        System.out.println("LOG: [Repository] - Salvando agendamento: " + agendamento.getId());
        agendamentosDB.add(agendamento);
    }
}
