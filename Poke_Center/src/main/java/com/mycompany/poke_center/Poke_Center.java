package com.mycompany.poke_center;

import java.util.Scanner;
public class Poke_Center {

    public static void main(String[] args){ 

        //Inicializando o centro + serviços
        CentroPokemon centroPokemon = new CentroPokemon();
        PcPokemon pcPokemon = new PcPokemon();

        ServicoArmazenamento servicoArmazenamento = new ServicoArmazenamento(centroPokemon, pcPokemon);
        Servico servicoCura = new ServicoCura(centroPokemon); 

        //Add os serviços ao centro
        centroPokemon.addServico(servicoArmazenamento);
        centroPokemon.addServico(servicoCura);

        // Criando treinador e equipe1
        
        //Criando um box com um pokemon extra
        Treinador treinador = new Treinador("Ash");

        Pokemon pikachu = new PkmnCriar("Pikachu", "Pikachu", "Eletrico", 50, "Ativo");
        Pokemon charmander = new PkmnCriar("Charmander", "Charmander", "Fogo", 40, "Ativo");
        Pokemon bulbassauro = new PkmnCriar("Bulbassauro", "Bulbassauro", "Grama", 45, "Ativo");
        Pokemon squirtle = new PkmnCriar("Squirtle", "Squirtle", "Agua", 60, "Ativo");
        Pokemon pidgey = new PkmnCriar("Pidgey", "Pidgey", "Voador/Normal", 45, "Ativo");
        Pokemon butterfree = new PkmnCriar("Butterfree", "Butterfree", "Inseto/Voador", 50, "Ativo");
        
        Pokemon mew = new PkmnCriar("Miado", "Mew", "Psiquico", 100,"Ativo");
      
        treinador.addPokemon(pikachu);
        treinador.addPokemon(charmander);
        treinador.addPokemon(bulbassauro);
        treinador.addPokemon(squirtle);
        treinador.addPokemon(pidgey);
        treinador.addPokemon(butterfree);
        
        pcPokemon.addPokemon(mew,0);
        
        //Scanner para o menu
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        
         while(!sair){
            System.out.println("Bem vindo ao PokeCenter!");
            System.out.println("Escolha uma opcao: \n1. Curar Pokemon \n2. Armazenar Pokemon \n3. Sair \n4");
            
            int escolha = scanner.nextInt();
            
             switch(escolha){
                case 1:
                    //Cura direta
                    centroPokemon.executarServico("ServicoCura",treinador);
                    break;
                case 2:
                    //Armazenando direto
                    centroPokemon.executarServico("ServicoArmazenamento",treinador);
                    break;
                case 3:
                    //Saída
                    sair = true;
                    System.out.println("Saindo do Pokecenter, cuide-se e volte sempre!\n");
                    break;
                default:
                    System.out.println("Oops! Parece que esse servio nao existe ainda. Por favor, tente novamente!\n");
                    break;
            }
        }
        
        //Listando a equipe e as box
        treinador.listEquipe();
        
         System.out.println("Listando o Armazenamento  do treinador " + treinador.getNome() + ":");
        pcPokemon.listPokemons();
    }
}
