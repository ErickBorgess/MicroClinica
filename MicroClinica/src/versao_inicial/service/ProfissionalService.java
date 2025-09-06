package versao_inicial.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import versao_inicial.model.Profissional;

public class ProfissionalService {
    private List<Profissional> profissionaisDB;
    private int contadorRequisicao;

    public ProfissionalService(){
        this.profissionaisDB = new ArrayList<>();
    }

    /*public boolean verificarDisponibilidade() {
        //add logica
    }*/
}
