package com.mycompany.poke_center;

import java.util.ArrayList;
import java.util.List;

//Armazenamento básicamente
//São 12 boxes no total com capacidade de 30 pkmns cada um
//Tem as frases comentadas pois eu criei esse primeiro antes de pensar nos serviços
public class PcPokemon{
    static final int NUM_BOXES = 12;
    static final int BOX_CAP = 30;
    
    private List<List<Pokemon>> boxes;
    
    public PcPokemon(){
        this.boxes = new ArrayList<>();
        //Criando os boxes já com a cap de 30
        for(int i = 0; i < NUM_BOXES; i++){
            boxes.add(new ArrayList<>());
        }
    }
    
    public List<List<Pokemon>> getBoxes(){
        return boxes;
    }
    
    public List<Pokemon> getBoxIndex(int boxIndex){
        if(boxIndex >= 0 && boxIndex < NUM_BOXES){
            return boxes.get(boxIndex);
        }else{
            throw new IllegalArgumentException("Esse Box nao existe!");
        }
    }
    
    public void addPokemon(Pokemon pokemon, int boxIndex){
        if(boxIndex >= 0 && boxIndex < NUM_BOXES){
            List<Pokemon> box = boxes.get(boxIndex);
            if(box.size() < BOX_CAP){
                box.add(pokemon);
                //System.out.println("Bem vindo, " + pokemon.getNome() +" !" + pokemon.getNome() + " foi adicionado do PC com sucesso!");
            }else{
                //System.out.println("A Box " + boxIndex + " esta cheia! Nao é possivel adicionar mais Pokemon nesta Box.");
            }   
        }else{
            //System.out.println("Oops! Parece que esta Box nao existe.");
        }
    }
    
    public void removePokemon(Pokemon pokemon, int boxIndex){
        if(boxIndex >= 0 && boxIndex < NUM_BOXES){
            List<Pokemon> box = boxes.get(boxIndex);
            if(box.remove(pokemon)){
            //System.out.println("Ate mais, " + pokemon.getNome() +" !" + pokemon.getNome() + " foi removido do PC com sucesso!");
            }else{
                //System.out.println("Oops! Parece que " + pokemon.getNome() + " nao foi encontrado na Box " + boxIndex + ".");
            }
        }else{
            //System.out.println("Oops! Parece que esta Box nao existe.");
        }   
    }
    
    public void listPokemons(){
        for(int i = 0; i < NUM_BOXES; i++){
            List<Pokemon> box = boxes.get(i);
            if(box.isEmpty()){
                //System.out.println("A Box " + i + " esta vazia!");
            }else{
                //System.out.println("Pokemons na Box " + i + ":");
                for(Pokemon pokemon : box){
                    System.out.println(pokemon + "\n");
                }
            }
        }
    }
    
}
