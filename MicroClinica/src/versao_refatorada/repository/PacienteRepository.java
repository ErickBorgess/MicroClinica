package versao_refatorada.repository;

import java.util.ArrayList;
import java.util.List;
import versao_refatorada.model.Paciente;

public class PacienteRepository {
    private final List<Paciente> pacientesDB;

    public PacienteRepository() {
        this.pacientesDB = new ArrayList<>();
        pacientesDB.add(new Paciente("PAC01", "Ana Silva"));
        pacientesDB.add(new Paciente("PAC02", "Bruno Costa"));
    }
    
    public Paciente buscarPorId(String id) {
       for(Paciente p : pacientesDB) {
              if(p.getId().equals(id)) {
                return p;
              }
       }
       return null;
    }

    public void salvar(Paciente paciente) {
        System.out.println("LOG: [Repository] - Salvando paciente: "+paciente.getNome());
        pacientesDB.add(paciente);
    }
}
