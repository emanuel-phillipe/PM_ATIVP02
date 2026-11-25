package org.emanuelphillipe.entities;

import java.util.ArrayList;
import java.util.List;

public class PlanoPremium extends Plano{

    private List<Atividade> atividades = new ArrayList<Atividade>();

    public PlanoPremium(String nome, double valorMensal, int quantidadeMaximaAtividades, StatusPlano status) {
        super(nome, valorMensal, quantidadeMaximaAtividades, status);
    }

    @Override
    public void exibirDetalhes(boolean exibAtividades) {
        System.out.printf("%s | Vlr. Mensal: %f | Quant. Máx. Atividades: %d | Status: %s | Usos Ilimitados",
                this.getNome(), this.getValorMensal(), this.getQuantidadeMaximaAtividades(), this.getStatus());

        if(exibAtividades && !this.getAtividades().isEmpty()){
            System.out.println("\n>>> Atividade do Plano: ");
            for (Atividade atividade : this.getAtividades()){
                atividade.exibirDetalhes();
                System.out.println(" ");
            }
        }
    }

    @Override
    public boolean permiteAtividadeColetiva() {
        return true;
    }

    @Override
    public void addAtividade(Atividade atividade){
        this.atividades.add(atividade);
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }
}
