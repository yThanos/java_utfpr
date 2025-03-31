package dev.fraporti.atividade_4;

/**
 * @author vitor.rosmann on 31/03/2025
 */
public final class Carga extends Veiculo {
    private int cargaMax;
    private int tara;

    public Carga() {
        super();
        this.cargaMax = 0;
        this.tara = 0;
    }

    @Override
    public float calcVel(float velocMax) {
        return 0;
    }

    public int getCargaMax(){
        return this.cargaMax;
    }

    public final void setCargaMax(int cargaMax){
        this.cargaMax = cargaMax;
    }

    public int getTara(){
        return this.tara;
    }

    public final void setTara(int tara){
        this.tara = tara;
    }

    @Override
    public String toString() {
        return "\nVeiculo de carga" + super.toString() + "\n" +
                "Carga Maxíma: "+ this.getCargaMax() + "\n" +
                "Tara: " + this.getTara();
    }
}
