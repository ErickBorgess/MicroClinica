package versao_inicial.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import versao_inicial.model.Profissional;

public class ProfissionalService {
    private final List<Profissional> profissionaisDB;
    private int contadorRequisicao = 0;

    public ProfissionalService(){
        this.profissionaisDB = new ArrayList<>();
        profissionaisDB.add(new Profissional("PROF_CARD01", "Dr. Carlos Andrade", "Cardiologia"));
        profissionaisDB.add(new Profissional("PROF_DERM01", "Dra. Ana Beatriz", "Dermatologia"));
        profissionaisDB.add(new Profissional("PROF_ORTO01", "Dr. João Miguel", "Ortopedia"));
    }

    public Profissional buscarPorId(String id) {
       for(Profissional p : profissionaisDB) {
              if(p.getId().equals(id)) {
                return p;
              }
       }
       return null;
    }

    public boolean verificarDisponibilidade(String idProfissional, LocalDateTime data) {
        // SIMULAÇÃO DE FALHA: Incrementa o contador a cada chamada
        contadorRequisicao++;
        // SIMULAÇÃO DE FALHA: Lança uma exceção a cada 3 chamadas
        if (contadorRequisicao == 3) { 
            System.out.println("[LOG: ProfissionalService] - FALHA SIMULADA! O serviço está indisponível.");
            throw new RuntimeException("Erro de comunicação: Serviço de Profissionais indisponível!");
        }

        System.out.println("[LOG: ProfissionalService] - Verificando disponibilidade para o profissional "+idProfissional+" na data: "+data);
        return true;
        
    }
    
}
