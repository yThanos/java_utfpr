package dev.fraporti.atividade_7.model;

/**
 * @author vitor.rosmann on 13/03/2025
 */
public abstract class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private float velocMax;
    private int qtdRodas;
    private Motor motor;

    public Veiculo() {
        this.placa = " ";
        this.marca = " ";
        this.modelo = " ";
        this.cor = " ";
        this.velocMax = 0f;
        this.qtdRodas = 0;
        this.motor = new Motor();
    }

    public abstract float calcVel(float velocMax);

    public String getPlaca() {
        return placa;
    }

    public final void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public final void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public final void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public final void setCor(String cor) {
        this.cor = cor;
    }

    public float getVelocMax() {
        return velocMax;
    }

    public final void setVelocMax(float velocMax) {
        this.velocMax = velocMax;
    }

    public int getQtdRodas() {
        return qtdRodas;
    }

    public final void setQtdRodas(int qtdRodas) {
        this.qtdRodas = qtdRodas;
    }

    public Motor getMotor() {
        return motor;
    }

    public final void setMotor(Motor motor) {
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "\nMarca: "+ this.getMarca() + "\n" +
                "Modelo: "+ this.getModelo() + "\n" +
                "Placa: "+ this.getPlaca().toUpperCase() + "\n" +
                "Cor: "+ this.getCor() + "\n" +
                "Velocidade maxima: "+ this.getVelocMax() + "\n" +
                "Quantidade de rodas: "+ this.getQtdRodas() + "\n" +
                "Motor -> { potencia: "+ this.getMotor().getPotencia() + ", " +
                "Quantidade de pistões: "+ this.getMotor().getQtdPist() + " }";
    }
}
