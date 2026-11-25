package org.emanuelphillipe.entities;

public class AtividadeNatacao extends Atividade implements Certificavel, ControladorPresenca{

    private double profundidadePiscina;

    public AtividadeNatacao(String nome, int duracaoAula, int quantidadeMaximaParticipantes, double valorMensal, StatusAtividade status, double profundidadePiscina) {
        super(nome, duracaoAula, quantidadeMaximaParticipantes, valorMensal, status);
        this.profundidadePiscina = profundidadePiscina;
    }

    @Override
    public void exibirDetalhes() {
        System.out.printf("%s | Duração Aula: %d | Quant Máx Participantes: %d | Vlr Mensal: %f | Status: %s | Profundidade Piscina: %f",
                this.getNome(), this.getDuracaoAula(), this.getQuantidadeMaximaParticipantes(), this.getValorMensal(), this.getStatus(), this.getProfundidadePiscina());
    }

    @Override
    public boolean atividadeColetiva() {
        return true;
    }

    @Override
    public void emitirCertificado(String nomeParticipante) {

    }

    @Override
    public void registrarPresenca(String nomeParticipante) {

    }

    public double getProfundidadePiscina() {
        return profundidadePiscina;
    }
    public void setProfundidadePiscina(double profundidadePiscina) {
        this.profundidadePiscina = profundidadePiscina;
    }
}
