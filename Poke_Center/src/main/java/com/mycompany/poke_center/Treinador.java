package com.mycompany.poke_center;

import java.util.ArrayList;
import java.util.List;

public class Treinador{
     //Equipe máxima é SEMPRE 6
    static final int MAX_EQUIPE = 6;
    
    private final String nome; //Nome do treinador
    private List<Pokemon> equipe;//Equipe do treinador
    
    public Treinador(String nome){
        this.nome = nome;
        this.equipe = new ArrayList<>();
    }
    
    public String getNome(){
        return nome;
    }
    
    public List<Pokemon> getEquipe(){
        return equipe;
    }
    
    public boolean addPokemon(Pokemon pokemon){
        if(equipe.size() < MAX_EQUIPE){
            equipe.add(pokemon);
            System.out.println(pokemon.getNome() + " foi adicionado a equipe do treinador " + nome + ".\n");
            return true;
        }else{
            System.out.println("Sua equipe esta cheia!\n");
            return false;
        }
    }
    
    public boolean removePokemon(Pokemon pokemon){
        if(equipe.size() > 1 &&  equipe.remove(pokemon)){
            System.out.println(pokemon.getNome() + " foi removido da equipe do treinador " + nome + ".");
            return true;
        }else if(equipe.size() <= 1){//Nos jogos pelo menos é constado que o mínimo é 1
                                    //para não ser atacado em áreas selvagens, por isso a restrição
            System.out.println(nome + " deve manter pelo menos 1 Pokemon para protecao!");
            return false;
        }else{
            System.out.println(pokemon.getNome() + " nao foi encontrado na equipe do treinador " + nome + ".");
            return false;
        }
    }
    
    public void listEquipe(){
        if(equipe.isEmpty()){
             System.out.println("A equipe do treinador " + nome + " esta vazia. Visite o Centro Pokémon mais proximo para ajuda!");
        }else{
            System.out.println("Equipe do treinador Pokemon " + nome + ":");
            for(Pokemon pokemon : equipe){
                System.out.println(pokemon);
            }
        }
    }
    
}
