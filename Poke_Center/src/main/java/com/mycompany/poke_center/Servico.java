package com.mycompany.poke_center;

public abstract class Servico{
    protected CentroPokemon centroPokemon;
    
    public Servico(CentroPokemon centroPokemon){
        this.centroPokemon = centroPokemon;
    }
    
     public CentroPokemon getCentroPokemon(){
        return centroPokemon;
    }
    
    public abstract void executar(Treinador treinador);
}