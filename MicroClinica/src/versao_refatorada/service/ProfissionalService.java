package versao_refatorada.service;

import java.time.LocalDateTime;
import versao_refatorada.model.Profissional;
import versao_refatorada.repository.ProfissionalRepository;

public class ProfissionalService {
    private final ProfissionalRepository profissionalRepository;
    private int contadorRequisicao = 0;

    public ProfissionalService(ProfissionalRepository repository) {
        this.profissionalRepository = repository;
    }

    public Profissional buscarProfissionalPorId(String id) {
        return profissionalRepository.buscarPorId(id);
    }

    public boolean verificarDisponibilidade(String idProfissional, LocalDateTime data) {
        contadorRequisicao++;
        if (contadorRequisicao == 3 || contadorRequisicao == 4) {
            System.out.println("LOG: [ProfissionalService] - FALHA SIMULADA! O serviço está indisponível.");
            throw new RuntimeException("Erro de comunicação: Serviço de Profissionais indisponível!");
        }

        System.out.println("LOG: [ProfissionalService] - Verificando disponibilidade para o profissional "+idProfissional+" na data: "+data);
        return true;
    }
}
