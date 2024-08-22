package com.mycompany.poke_center;

import java.util.Scanner;

public class ServicoArmazenamento extends Servico{
    private PcPokemon pc;

    public ServicoArmazenamento(CentroPokemon centroPokemon, PcPokemon pc){
        super(centroPokemon);
        this.pc = pc;
    }

    @Override
    public void executar(Treinador treinador){
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        
        while(!sair){
            System.out.println("Servico de Armazenamento");
            System.out.println("Escolha uma opcao: \n1. Armazenar Pokemon \n2. Retirar Pokemon do PC \n3. Sair \n4");
            
            int escolha = scanner.nextInt();
            
             switch(escolha){
                case 1:
                    armazenarPokemon(treinador);
                    break;
                case 2:
                    retirarPokemon(treinador);
                    break;
                case 3:
                    sair = true;
                    System.out.println("Saindo do servico de armazenamento.\n");
                    break;
                default:
                    System.out.println("Oops! Opcao invalida. Por favor, tente novamente!\n");
            }
        }
           
    }

    private void armazenarPokemon(Treinador treinador){
        if(treinador.getEquipe().size() > 1){
            System.out.println("Escolha um Pokemon para armazenar:");
            for(int i = 0; i < treinador.getEquipe().size(); i++){
                System.out.println((i + 1) + ". " + treinador.getEquipe().get(i).getNome());
            }
            
            Scanner scanner = new Scanner(System.in);
            int escolha = scanner.nextInt();

            if(escolha > 0 && escolha <= treinador.getEquipe().size()){
                Pokemon pokemon = treinador.getEquipe().get(escolha - 1);

                System.out.println("Escolha uma Box (0-11) para armazenar:");
                int boxNumber = scanner.nextInt();

                if(boxNumber >= 0 && boxNumber < 12){
                    treinador.removePokemon(pokemon);
                    pc.addPokemon(pokemon, boxNumber);
                    System.out.println("Seja bem-vindo! " + pokemon.getNome() + " foi armazenado na Box " + boxNumber + " com sucesso!\n");
                }else{
                    System.out.println("Parece que essa Box nao existe! Por favor, tente novamente.\n");
                }
            }else{
                System.out.println("Parece que esta escolha nao esta disponivel. Por favor, tente novamente.\n");
            }
        }else{
            System.out.println("Voce precisa manter pelo menos um Pokemon na equipe!\n");
        }
    }

    private void retirarPokemon(Treinador treinador){
        if(treinador.getEquipe().size() < Treinador.MAX_EQUIPE){
            Scanner scanner = new Scanner(System.in);

            System.out.println("Escolha uma Box (0-11) para retirar Pokemon:");
            int boxNumber = scanner.nextInt();

            if(boxNumber >= 0 && boxNumber < 12){
                if(!pc.getBoxIndex(boxNumber).isEmpty()){
                    System.out.println("Escolha um Pokemon para retirar do PC:");
                    for(int i = 0; i < pc.getBoxIndex(boxNumber).size(); i++){
                        System.out.println((i + 1) + ". " + pc.getBoxIndex(boxNumber).get(i).getNome());
                    }

                    int escolha = scanner.nextInt();

                    if(escolha > 0 && escolha <= pc.getBoxIndex(boxNumber).size()){
                        Pokemon pokemon = pc.getBoxIndex(boxNumber).get(escolha - 1);
                        pc.removePokemon(pokemon, boxNumber);
                        treinador.addPokemon(pokemon);
                        System.out.println("Ate mais! " + pokemon.getNome() + " foi retirado do PC e adicionado a equipe com sucesso!\n");
                    }else{
                        System.out.println("Parece que esta escolha nao esta disponivel. Por favor, tente novamente.\n");
                    }
                }else{
                    System.out.println("A Box " + boxNumber + " esta vazia!\n");
                }
            }else{
                System.out.println("Parece que essa Box nao existe! Por favor, tente novamente.\n");
            }
        }else{
            System.out.println("Sua equipe ja esta cheia!\n");
        }
    }
}
