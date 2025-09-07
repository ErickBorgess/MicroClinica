package versao_refatorada.service;

import versao_refatorada.model.Paciente;
import versao_refatorada.repository.PacienteRepository;

public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente buscarPorId(String id) {
        System.out.println("LOG: [Service] - Buscando paciente por ID: "+id);
        return pacienteRepository.buscarPorId(id);
    }
}
