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

    //thought it would be cool to not have everything static
    private static final Random RNG = new Random();

    public static void main(String[] args) {
        //fill the array with trucks
        for(int i = 0; i < 10; i = i+2){
            Carga carga = new Carga();

            carga.setMarca(BRANDS[i]);
            carga.setModelo(MODELS[i]);
            carga.setCor("Vermelho");
            carga.setQtdRodas(4);

            UUID uuid = UUID.randomUUID();
            carga.setPlaca(uuid.toString().substring(0, 8));

            float velocMax = RNG.nextFloat(1, 3);
            carga.setVelocMax(velocMax * 100);

            int potencia = RNG.nextInt(20, 36);
            int qntPist = RNG.nextInt(0, 3);

            //apparently Uno has 18 cv per cylinder, and Hr-v 35
            carga.getMotor().setPotencia(potencia * CYLINDERS[qntPist]);
            carga.getMotor().setQtdPist(CYLINDERS[qntPist]);

            VEHICLES[i] = carga;

            //I have no idea at all about this values
            //just to have the values with 00 on the end
            int cargaMax = RNG.nextInt(5000, 40000) / 100;
            int tara = RNG.nextInt(1000, 4000) / 100;
            carga.setCargaMax(cargaMax * 100);
            carga.setTara(tara * 100);
        }

        //fill the array with cars
        for(int i = 1; i < 10; i = i+2){
            Passeio passeio = new Passeio();

            passeio.setMarca(BRANDS[i]);
            passeio.setModelo(MODELS[i]);
            passeio.setCor("Vermelho");
            passeio.setQtdRodas(4);

            UUID uuid = UUID.randomUUID();
            passeio.setPlaca(uuid.toString().substring(0, 8));

            float velocMax = RNG.nextFloat(1, 3);
            passeio.setVelocMax(velocMax * 100);

            int potencia = RNG.nextInt(20, 36);
            int qntPist = RNG.nextInt(0, 3);

            //apparently Uno has 18 cv per cylinder, and Hr-v 35
            passeio.getMotor().setPotencia(potencia * CYLINDERS[qntPist]);
            passeio.getMotor().setQtdPist(CYLINDERS[qntPist]);

            VEHICLES[i] = passeio;

            //I think there are some cars with 7 seats
            passeio.setQtdPassageiros(RNG.nextInt(2, 8));
        }

        for(Veiculo v: VEHICLES){
            System.out.println(v);
        }
    }

    /**
     * Idea to not have all that duplicated code, but no Teste-Vehicle relation allowed, I guess it includes this
     * @deprecated Do not use
     * @param veiculo the vehicle, either Carga or Passeio
     * @param i the current index position
     * @param <T> One of the subclasses of vehicle
     */
    private static <T extends Veiculo> void fillVehicleProperties(T veiculo, int i){
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
}
