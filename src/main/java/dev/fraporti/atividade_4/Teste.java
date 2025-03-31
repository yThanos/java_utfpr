package dev.fraporti.atividade_4;

import java.util.Random;
import java.util.UUID;

/**
 * @author vitor.rosmann on 13/03/2025
 */
public class Teste {
    private static final Veiculo[] VEHICLES = new Veiculo[10];
    private static final String[] BRANDS = new String[]{"Volvo", "volkswagen", "GMC", "Fiat", "Mercedes Benz", "Chevrolet", "MAN", "Honda", "DAF", "Mazda"};
    private static final String[] MODELS = new String[]{"FH", "Gol", "Sierra 1500", "Uno", "Lo 2000", "Prisma", "TGX", "HR-V", "XF", "MX-5"};

    //complete arbitrary choose of numbers, cars arent my area of interest
    private static final int[] CYLINDERS = new int[]{3, 4, 6};

    //thought it would be cool to don't have everything static
    private static final Random RNG = new Random();

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            Veiculo veiculo = i % 2 == 0 ? new Carga() : new Passeio();
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

            if(veiculo instanceof Passeio){
                //I think there are some cars with 7 seats
                ((Passeio) veiculo).setQtdPassageiros(RNG.nextInt(2, 8));
            } else {
                //I have no idea at all about this values
                ((Carga) veiculo).setCargaMax(RNG.nextInt(5000, 40000));
                ((Carga) veiculo).setTara(RNG.nextInt(1000, 4000));
            }
        }

        for(Veiculo v: VEHICLES){
            System.out.println(v);
        }
    }
}
