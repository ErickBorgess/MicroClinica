package versao_inicial.service;

import java.util.ArrayList;
import java.util.List;
import versao_inicial.model.Paciente;

public class PacienteService {
    private List<Paciente> pacientes = new ArrayList<>();
    
    public Paciente buscarPorId(int id) {
       for(Paciente p : pacientes) {
              if(p.getId() == id) {
                return p;
              }
       }
       return null;
    }
}

