package org.emanuelphillipe.entities;

public class AtividadeSpinning extends Atividade implements ControladorPresenca{

    private int quantBikes;

    public AtividadeSpinning(String nome, int duracaoAula, int quantidadeMaximaParticipantes, double valorMensal, StatusAtividade status, int quantBikes) {
        super(nome, duracaoAula, quantidadeMaximaParticipantes, valorMensal, status);
        this.quantBikes = quantBikes;
    }

    @Override
    public void exibirDetalhes() {
        System.out.printf("%s | Duração Aula: %d | Quant Máx Participantes: %d | Vlr Mensal: %f | Status: %s | Quant. Bikes: %d",
                this.getNome(), this.getDuracaoAula(), this.getQuantidadeMaximaParticipantes(), this.getValorMensal(), this.getStatus(), this.getQuantBikes());
    }

    @Override
    public boolean atividadeColetiva() {
        return true;
    }

    @Override
    public void registrarPresenca(String nomeParticipante) {

    }

    public int getQuantBikes() {
        return quantBikes;
    }

    public void setQuantBikes(int quantBikes) {
        this.quantBikes = quantBikes;
    }
}
