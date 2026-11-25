package org.emanuelphillipe.entities;

public class AtividadeMusculacao extends Atividade{

    private int quantAparelhos;

    public AtividadeMusculacao(String nome, int duracaoAula, int quantidadeMaximaParticipantes, double valorMensal, StatusAtividade status, int quantAparelhos) {
        super(nome, duracaoAula, quantidadeMaximaParticipantes, valorMensal, status);
        this.quantAparelhos = quantAparelhos;
    }

    @Override
    public void exibirDetalhes() {
        System.out.printf("%s | Duração Aula: %d | Quant Máx Participantes: %d | Vlr Mensal: %f | Status: %s | Quant. Aparelhos: %d",
                this.getNome(), this.getDuracaoAula(), this.getQuantidadeMaximaParticipantes(), this.getValorMensal(), this.getStatus(), this.getQuantAparelhos());
    }

    @Override
    public boolean atividadeColetiva() {
        return false;
    }

    public int getQuantAparelhos() {
        return quantAparelhos;
    }
    public void setQuantAparelhos(int quantAparelhos) {
        this.quantAparelhos = quantAparelhos;
    }
}
