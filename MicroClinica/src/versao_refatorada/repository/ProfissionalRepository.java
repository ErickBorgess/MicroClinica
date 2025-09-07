package versao_refatorada.repository;

import java.util.ArrayList;
import java.util.List;
import versao_refatorada.model.Profissional;

public class ProfissionalRepository {
    private final List<Profissional> profissionaisDB;

    public ProfissionalRepository(){
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
}
