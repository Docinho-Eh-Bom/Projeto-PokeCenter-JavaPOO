package com.mycompany.poke_center;

import java.util.ArrayList;
import java.util.List;

public class CentroPokemon {
    private Treinador treinador;
    private List<Servico> servicos;

    public CentroPokemon() {
        this.servicos = new ArrayList<>();
    }
    
    public Treinador getTreinador() {
        return treinador;
    }

    public void addServico(Servico servico) {
        servicos.add(servico);
    }

    public void executarServico(String nomeServico, Treinador treinador) {
        for (Servico servico : servicos) {
            if (servico.getClass().getSimpleName().equals(nomeServico)) {
                servico.executar(treinador);
                return;
            }
        }
        System.out.println("Oops! Parece que esse servico nao existe neste Centro Pokemon.");
    }
}

