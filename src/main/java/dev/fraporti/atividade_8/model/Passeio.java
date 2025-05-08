package dev.fraporti.atividade_8.model;

import dev.fraporti.atividade_8.interfaces.Calcular;

/**
 * @author vitor.rosmann on 31/03/2025
 */
public final class Passeio extends Veiculo implements Calcular {
    private int qtdPassageiros;

    public Passeio() {
        super();
        this.qtdPassageiros = 0;
    }

    @Override
    public float calcVel(float velocMax) {
        return velocMax * 1000;
    }

    public int getQtdPassageiros(){
        return this.qtdPassageiros;
    }

    public final void setQtdPassageiros(int qtdPassageiros){
        this.qtdPassageiros = qtdPassageiros;
    }

    @Override
    public String toString() {
        return "\nVeiculo de passeio" + super.toString() + "\n" +
                "Quantidade de passageiros: " + this.getQtdPassageiros() + "\n" +
                "Calculo velocidade: "+ this.calcVel(this.getVelocMax()) + "M/h\n" +
                "Calculo: " + this.calcular() + " caracteres";
    }

    /**
     *
     * @return a soma das quantidades de letras existentes em todos os atributos do tipo String;
     */
    @Override
    public int calcular() {
        return getCor().length() + getMarca().length() + getModelo().length() + getPlaca().length();
    }
}
