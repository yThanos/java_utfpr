package dev.fraporti.atividade_1;

import java.util.Random;
import java.util.UUID;

/**
 * @author vitor.rosmann on 13/03/2025
 */
public class Teste {
    private static final Veiculo[] veiculos = new Veiculo[5];
    private static final String[] marcas = new String[]{"volkswagen", "Fiat", "Chevrolet", "Honda", "Mazda"};
    private static final String[] modelos = new String[]{"Gol", "Uno", "Prisma", "HR-V", "MX-5"};

    //complete arbitrary choose of numbers, cars arent my area of interest
    private static final int[] pistoes = new int[]{3, 4, 6};

    //thought it would be cool to don't have everything static
    private static final Random rng = new Random();

    public static void main(String[] args) {
        for(int i = 0; i < 5; i++){
            Veiculo veiculo = new Veiculo();
            veiculo.setMarca(marcas[i]);
            veiculo.setModelo(modelos[i]);
            veiculo.setCor("Vermelho");
            veiculo.setQtdRodas(4);

            UUID uuid = UUID.randomUUID();
            veiculo.setPlaca(uuid.toString().substring(0, 8));

            float velocMax = rng.nextFloat(1, 3);
            veiculo.setVelocMax(velocMax * 100);

            int potencia = rng.nextInt(20, 36);
            int qntPist = rng.nextInt(0, 3);

            //apparently Uno has 18 cv per cylinder, and Hr-v 35
            veiculo.getMotor().setPotencia(potencia * pistoes[qntPist]);
            veiculo.getMotor().setQtdPist(pistoes[qntPist]);

            veiculos[i] = veiculo;
        }

        for(Veiculo v: veiculos){
            System.out.println(v);
        }
    }
}
