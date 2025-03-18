package dev.fraporti.atividade_1;

import java.util.Random;
import java.util.UUID;

/**
 * @author vitor.rosmann on 13/03/2025
 */
public class Teste {
    private static final Veiculo[] VEHICLES = new Veiculo[5];
    private static final String[] BRANDS = new String[]{"volkswagen", "Fiat", "Chevrolet", "Honda", "Mazda"};
    private static final String[] MODELS = new String[]{"Gol", "Uno", "Prisma", "HR-V", "MX-5"};

    //complete arbitrary choose of numbers, cars arent my area of interest
    private static final int[] CYLINDERS = new int[]{3, 4, 6};

    //thought it would be cool to don't have everything static
    private static final Random RNG = new Random();

    public static void main(String[] args) {
        for(int i = 0; i < 5; i++){
            Veiculo veiculo = new Veiculo();
            veiculo.setMarca(BRANDS[i]);
            veiculo.setModelo(MODELS[i]);
            veiculo.setCor("Vermelho");
            veiculo.setQtdRodas(4);

            UUID uuid = UUID.randomUUID();
            veiculo.setPlaca(uuid.toString().substring(0, 8));

            float velocMax = RNG.nextFloat(1, 3);
            veiculo.setVelocMax(velocMax * 100);

            int potencia = RNG.nextInt(20, 36);
            int qntPist = RNG.nextInt(0, 3);

            //apparently Uno has 18 cv per cylinder, and Hr-v 35
            veiculo.getMotor().setPotencia(potencia * CYLINDERS[qntPist]);
            veiculo.getMotor().setQtdPist(CYLINDERS[qntPist]);

            VEHICLES[i] = veiculo;
        }

        for(Veiculo v: VEHICLES){
            System.out.println(v);
        }
    }
}
