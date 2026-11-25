package org.emanuelphillipe;

import org.emanuelphillipe.entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner input = new Scanner(System.in);
    private static List<Atividade> atividadesList = new ArrayList<Atividade>();
    private static List<Plano> planoList = new ArrayList<Plano>();

    static void main() {

        atividadesList.add(new AtividadeMusculacao("Supino Reto", 10, 1
        , 12.45, StatusAtividade.ATIVA, 4));
        atividadesList.add(new AtividadeNatacao("Natação Manhã", 60, 8
                , 119.90, StatusAtividade.ATIVA, 2.80));
        atividadesList.add(new AtividadeSpinning("Spinning Noite", 60, 15
                , 129.90, StatusAtividade.ATIVA, 15));

        planoList.add(new PlanoBasico("Plano BÁSICO 01", 120.00, 4, StatusPlano.ATIVO));
        planoList.add(new PlanoPremium("Plano PREMIUM 01", 210.00, 10, StatusPlano.ATIVO));

        boolean menuAtivo = true;

        while(menuAtivo){
            showMenu();


            switch (selectOption(">> Selecione uma das opções: ")){
                case 1:
                    associarAtivPlano();
                    break;
                case 2:

                    System.out.println("\n LISTA DE ATIVIDADES \n\n");

                    for (Atividade atividade : atividadesList){
                        atividade.exibirDetalhes();
                        System.out.println(" ");
                    }

                    selectOption("Pressione qualquer número para voltar...");

                    break;
                case 3:

                    System.out.println("\n PLANOS CADASTRADOS \n\n");

                    for (Plano plano : planoList){
                        plano.exibirDetalhes(true);
                        System.out.println(" ");
                    }

                    selectOption("Pressione qualquer número para voltar...");

                    break;
                case 4:

                    System.out.println("\n PLANOS ATIVOS \n\n");

                    for (Plano plano : planoList){
                        if(plano.getStatus() == StatusPlano.ATIVO){
                            plano.exibirDetalhes(true);
                            System.out.println(" ");
                        }
                    }

                    selectOption("Pressione qualquer número para voltar...");

                    break;
                case 5:

                    System.out.println("\n EMITIR CERTIFICADO \n\n");
                    break;
                case 6:
                    System.out.println("\n REGISTRAR PRESENÇA \n\n");

                    List<PlanoBasico> planosBasicosDisponiveis = new ArrayList<PlanoBasico>();

                    for (Plano plano : planoList){
                        if(!plano.permiteAtividadeColetiva()){
                            PlanoBasico planoBasico = (PlanoBasico) plano;

                            if(planoBasico.getPresencas().isEmpty()){
                                planoBasico.exibirDetalhes(false);
                                planosBasicosDisponiveis.add(planoBasico);
                            }

                            System.out.println(" ");
                        }
                    }

                    if(planosBasicosDisponiveis.isEmpty()){
                        System.out.println("\n AVISO: Não há planos disponíveis para registrar presenças. \n\n");
                        break;
                    }

                    int planoNum = selectOption("\n>>> Selecione o plano de acordo com a sua posição: ");

                    if (planoNum > planosBasicosDisponiveis.size()) {
                        break;
                    }

                    break;

                default:
                    menuAtivo = false;
                    break;
            }
        }
    }

    static void associarAtivPlano(){
        System.out.println("ASSOCIAÇÃO DE ATIVIDADES AO PLANO\n\n");

        int numPlano = 1;
        for(Plano plano : planoList){
            System.out.print(numPlano + " - ");
            plano.exibirDetalhes(false);
            System.out.println(" ");
            numPlano++;
        }

        int planoNum = selectOption("\n>>> Selecione o plano de acordo com a sua posição: ");
        if (planoNum > planoList.toArray().length) {
            throw new IllegalArgumentException("Numeração acima da quantidade de planos disponíveis.");
        }

        int numAtividade = 1;
        for(Atividade atividade : atividadesList){
            System.out.print(numAtividade + " - ");
            atividade.exibirDetalhes();
            System.out.println(" ");
            numAtividade++;
        }

        int atividadeNum = selectOption("\n>>> Selecione a atividade de acordo com a sua posição: ");
        if (planoNum > atividadesList.toArray().length) {
            throw new IllegalArgumentException("Numeração acima da quantidade de atividades disponíveis.");
        }

        try {
            planoList.get(planoNum-1).addAtividade(atividadesList.get(atividadeNum-1));
            System.out.println("\nAtividade adicionada com sucesso!\n\n");
        } catch (IllegalArgumentException e) {
            System.out.println("\nAVISO: " + e.getMessage());
        }
    }

    static int selectOption(String msg){
        System.out.print(msg);
        return input.nextInt();
    }

    static void showMenu(){
        System.out.println("""
                
                ======
                ACADEMIA PUC-ALL-HAPPY
                ======
                
                1. Associar atividades a um plano
                2. Exibir todas as atividades cadastradas
                3. Exibir todos os planos cadastrados
                4. Exibir apenas planos ativos
                5. Emitir certificado
                6. Registrar presença
                7. Remover atividades inativas do sistema
                
                """);
    }
}
