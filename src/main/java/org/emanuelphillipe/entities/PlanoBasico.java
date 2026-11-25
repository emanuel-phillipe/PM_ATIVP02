package org.emanuelphillipe.entities;

import java.util.ArrayList;
import java.util.List;

public class PlanoBasico extends Plano implements ControladorPresenca{

    private List<Atividade> atividades = new ArrayList<Atividade>();
    private String presenca;

    public PlanoBasico(String nome, double valorMensal, int quantidadeMaximaAtividades, StatusPlano status) {
        super(nome, valorMensal, quantidadeMaximaAtividades, status);
    }

    @Override
    public void exibirDetalhes(boolean exibAtividades) {
        System.out.printf("%s | Vlr. Mensal: %f | Quant. Máx. Atividades: %d | Status: %s | 1 uso / dia",
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
        return false;
    }

    @Override
    public void registrarPresenca(String nomeParticipante) {

        if(this.getPresencas().isEmpty() || this.getPresencas().isBlank()){
            throw new IllegalArgumentException("Número máximo de presenças diárias atingido.");
        }

        this.setPresencas(nomeParticipante);
        System.out.println("\n\nPresença registrada com sucesso para o " + nomeParticipante + ".");
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public String getPresencas() {
        return presenca;
    }

    public void setPresencas(String presenca) {
        this.presenca = presenca;
    }

    @Override
    public void addAtividade(Atividade atividade){
        if(atividade.atividadeColetiva()){
            throw new IllegalArgumentException("Plano não permite atividades coletivas.");
        }

        if(this.getAtividades().size()+1 > this.getQuantidadeMaximaAtividades()){
            throw new IllegalArgumentException("Plano com máximo de atividades cadastradas atingido.");
        }

        this.atividades.add(atividade);
    }
}
