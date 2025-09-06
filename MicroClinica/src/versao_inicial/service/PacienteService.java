package versao_inicial.service;

import java.util.ArrayList;
import java.util.List;
import versao_inicial.model.Paciente;

public class PacienteService {
    private final List<Paciente> pacientesDB;

    public PacienteService() {
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

}
