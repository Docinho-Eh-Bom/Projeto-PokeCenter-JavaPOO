package com.mycompany.poke_center;

//Deixei abstrata porque tecnicamente seria abstrata, mesmo não existindo nenhuma classe para herdar
//Poderia fazer algumas tipagens e talvez algumas linhas evolutivas? Sim, mas ficaria bem mais complexo
public abstract class Pokemon implements PkmnCuravel{
    private String nome; //Nome do pokemon
    private String specie; //Nome da especié na linha evolutiva
    private String tipo;//Tipagem 
    private int hp;//HP, sendo o máximo 100;
    private String status;//Status (saúdavel, envenenado, adormecido, etc...)
    
    //Status do pokémon, tem mais, mas por simplicidade listei só esses
    private static final String DESMAIADO = "Desmaiado";
    private static final String ATIVO = "Ativo";
    
    //Construtor
    public Pokemon(String nome, String specie, String tipo, int hp, String status){
        this.nome = nome;
        this.specie = specie;
        this.tipo = tipo;
        this.hp = hp;
        this.status = status;
    }

    //Getters e setters
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getSpecie(){
        return specie;
    }

    public void setSpecie(String specie){
        this.specie = specie;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public int getHp(){
        return hp;
    }

    public void setHp(int hp){
        if(hp > 100){//Pokemons podem ter número máximo de HP além desse valor,
                        //mas para facilitar a vida vou estimar que o máximo é 100
            throw new IllegalArgumentException("O valor maximo de vida nao pode ser maior que 100.");
        }
        if(hp < 0){
            throw new IllegalArgumentException("O valor maximo de vida nao pode ser menor que 0.");
        }
        this.hp = hp;
        
        if(hp == 0){
            setStatus(DESMAIADO);
        }else{
            setStatus(ATIVO);
        }
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }
    
    //Interface para curar
   @Override
    public void curarPkmn(){
        this.hp = 100; 
        this.status = "Ativo"; 
    }
    
    @Override 
    public String toString(){
        return "Pokemon: \n" + 
                "Nome: " + nome + "\n" +
                "Especie: " + specie + "\n" +
                "Tipo: " + tipo + "\n" +
                "HP: " + hp + "\n" +
                "Status: " + status + "\n";
    }
    
}
