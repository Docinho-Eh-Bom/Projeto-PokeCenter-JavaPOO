package com.mycompany.poke_center;

import com.mycompany.poke_center.CentroPokemon;
import com.mycompany.poke_center.Pokemon;
import com.mycompany.poke_center.Servico;
import com.mycompany.poke_center.Treinador;
import java.util.Scanner;

public class ServicoCura extends Servico{

    public ServicoCura(CentroPokemon centroPokemon){
        super(centroPokemon);
    }

    @Override
    public void executar(Treinador treinador){
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while(!sair){
            System.out.println("Servico de Cura");
            System.out.println("Escolha uma opcao: \n1. Curar todos os Pokemons \n2. Curar apenas um Pokemon \n3. Sair \n4");

            int escolha = scanner.nextInt();

            switch(escolha){
                case 1:
                    curarTodos(treinador);
                    break;
                case 2:
                    curarPokemon(treinador);
                    break;
                case 3:
                    sair = true;
                    System.out.println("Saindo do servico de cura.\n");
                    break;
                default:
                    System.out.println("Oops! Opcao invalida. Por favor, tente novamente!\n");
            }
        }
    }

    //Normal é curar todos de uma vez só
    public void curarTodos(Treinador treinador) {
        for (Pokemon pokemon : treinador.getEquipe()) {
            pokemon.curarPkmn();
            System.out.println(pokemon.getNome() + " foi curado com sucesso!\n");
        }
    }

    //Mas implementei a opção de selecionar apenas um
    public void curarPokemon(Treinador treinador) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha um Pokemon para curar:");

        for (int i = 0; i < treinador.getEquipe().size(); i++) {
            System.out.println((i + 1) + ". " + treinador.getEquipe().get(i).getNome());
        }

        int escolha = scanner.nextInt();

        if (escolha > 0 && escolha <= treinador.getEquipe().size()) {
            Pokemon pokemon = treinador.getEquipe().get(escolha - 1);
            pokemon.curarPkmn();
            System.out.println(pokemon.getNome() + " foi curado com sucesso!\n");
        } else {
            System.out.println("Parece que essa escolha nao esta disponivel. Por favor, tente novamente.");
        }
    }
}
