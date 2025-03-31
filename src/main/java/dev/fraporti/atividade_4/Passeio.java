package dev.fraporti.atividade_4;

/**
 * @author vitor.rosmann on 31/03/2025
 */
public final class Passeio extends Veiculo {
    private int qtdPassageiros;

    public Passeio() {
        super();
        this.qtdPassageiros = 0;
    }

    @Override
    public float calcVel(float velocMax) {
        return 0;
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
                "Quantidade de passageiros: "+ this.getQtdPassageiros();
    }
}
