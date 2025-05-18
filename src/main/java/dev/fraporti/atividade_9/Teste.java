package dev.fraporti.atividade_9;

import dev.fraporti.atividade_9.database.BDVeiculos;
import dev.fraporti.atividade_9.frames.GestaoVeiculosFrame;
import dev.fraporti.atividade_9.model.Carga;
import dev.fraporti.atividade_9.model.Leitura;
import dev.fraporti.atividade_9.model.Passeio;
import dev.fraporti.atividade_9.model.Veiculo;
import dev.fraporti.atividade_9.exception.VeicExistException;
import dev.fraporti.atividade_9.exception.VelocException;

/**
 * @author vitor.rosmann on 13/03/2025
 */
public class Teste {
    private static final BDVeiculos repository = new BDVeiculos();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
       new GestaoVeiculosFrame();
    }

    public static void cadastrarVeiculoPasseio() {
        Passeio passeio = new Passeio();
        try{
            System.out.println("Informe os dados do veiculo de passeio!");
            fillVehicleFields(passeio);
        } catch (VeicExistException e){
            System.out.println("Já existe um veículo com esta placa");
            return;
        }

        boolean done = false;
        do{
            try{
                passeio.setQtdPassageiros(Integer.parseInt(Leitura.entDados("Quantidade de passageiros:")));
                done = true;
            } catch (NumberFormatException e){
                System.out.println("Informe um valor numérico!");
            }
        } while(!done);

        repository.getListaPasseio().add(passeio);


        if(Leitura.entDados("Deseja cadastrar outros veiculo de passeio? (S/N)").contains("S")){
            cadastrarVeiculoPasseio();
        }
    }

    public static void cadastrarVeiculoCarga() {
        Carga carga = new Carga();
        try{
            System.out.println("Informe os dados do veiculo de carga!");
            fillVehicleFields(carga);
        } catch (VeicExistException e){
            System.out.println("Já existe um veículo com esta placa");
            return;
        }

        boolean done = false;
        do{
            try{
                 carga.setCargaMax(Integer.parseInt(Leitura.entDados("Carga maxíma:")));
                done = true;
            } catch (NumberFormatException e){
                System.out.println("Informe um valor numérico!");
            }
        } while(!done);
        do{
            try{
                carga.setTara(Integer.parseInt(Leitura.entDados("Tara:")));
                done = true;
            } catch (NumberFormatException e){
                done = false;
                System.out.println("Informe um valor numérico!");
            }
        } while(!done);

        repository.getListaCarga().add(carga);

        if(Leitura.entDados("Deseja cadastrar outros veiculo de carga? (S/N)").equalsIgnoreCase("S")){
            cadastrarVeiculoCarga();
        }
    }

    public static <T extends Veiculo> void fillVehicleFields(T veiculo) throws VeicExistException {
        veiculo.setMarca(Leitura.entDados("Marca:"));
        veiculo.setModelo(Leitura.entDados("Modelo:"));
        veiculo.setCor(Leitura.entDados("Cor:"));

        String placa = Leitura.entDados("Placa:");
        if(imprimeCargaPelaPlaca(placa, true) != null || imprimePasseioPelaPlaca(placa, true) != null){
            //System.out.println("Já existe um veiculo com esta placa cadastrado!");
            throw new VeicExistException("Já existe um veiculo com esta placa cadastrado!");
        }
        veiculo.setPlaca(placa);

        boolean done = false;
        do{
            try{
                veiculo.setQtdRodas(Integer.parseInt(Leitura.entDados("Quantidade de rodas:")));
                done = true;
            } catch (NumberFormatException e){
                System.out.println("Informe um valor numérico!");
            }
        } while(!done);
        do{
            try{
                veiculo.setVelocMax(Float.parseFloat(Leitura.entDados("Velocidade maxíma:")));
                done = true;
            } catch (NumberFormatException e){
                done = false;
                System.out.println("Informe um valor numérico!");
            } catch (VelocException e){
                if(veiculo instanceof Passeio){
                    try {
                        veiculo.setVelocMax(100);
                    } catch (VelocException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    try {
                        veiculo.setVelocMax(90);
                    } catch (VelocException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        } while(!done);
        do{
            try{
                veiculo.getMotor().setPotencia(Integer.parseInt(Leitura.entDados("Potencia do motor:")));
                done = true;
            } catch (NumberFormatException e){
                done = false;
                System.out.println("Informe um valor numérico!");
            }
        } while(!done);
        do{
            try{
                veiculo.getMotor().setQtdPist(Integer.parseInt(Leitura.entDados("Quantidade de pistões:")));
                done = true;
            } catch (NumberFormatException e){
                done = false;
                System.out.println("Informe um valor numérico!");
            }
        } while(!done);
    }

    public static void imprimeTodosPasseio() {
        if(repository.getListaPasseio().isEmpty()){
            System.out.println("Nenhum veiculo de passeio cadastrado!");
            return;
        }
        for(Passeio passeio: repository.getListaPasseio()){
            System.out.println(passeio);
        }
    }

    public static void imprimeTodosCarga() {
        if(repository.getListaCarga().isEmpty()){
            System.out.println("Nenhum veiculo de carga cadastrado!");
            return;
        }
        for(Carga carga: repository.getListaCarga()){
            System.out.println(carga);
        }
    }

    public static Passeio imprimePasseioPelaPlaca(String placa, boolean search) {
        if(repository.getListaPasseio().isEmpty() && !search){
            System.out.println("Nenhum veiculo de passeio cadastrado!");
            return null;
        }
        for(Passeio passeio: repository.getListaPasseio()){
            if(passeio.getPlaca().equals(placa)){
                if(search) return passeio;
                System.out.println(passeio);
                return passeio;
            }
        }
        if(search) return null;
        System.out.println("Placa não encontrada!");
        return null;
    }

    public static Carga imprimeCargaPelaPlaca(String placa, boolean search) {
        if(repository.getListaCarga().isEmpty() && !search){
            System.out.println("Nenhum veiculo de carga cadastrado!");
            return null;
        }
        for(Carga carga: repository.getListaCarga()){
            if(carga.getPlaca().equals(placa)){
                if(search) return carga;
                System.out.println(carga);
                return carga;
            }
        }
        if(search) return null;
        System.out.println("Placa não encontrada!");
        return null;
    }

    public static void deletePasseioByPlate(String plate) {
        Passeio passeio = imprimePasseioPelaPlaca(plate, true);
        if(passeio == null){
            System.out.println("Nenhum veiculo de passeio com essa placa!");
        } else {
            repository.getListaPasseio().remove(passeio);
            System.out.println("Veiculo de passeio com placa " + plate + " excluído!");
        }
    }

    public static void deleteCargaByPlate(String plate) {
        Carga carga = imprimeCargaPelaPlaca(plate, true);
        if(carga == null){
            System.out.println("Nenhum veiculo de passeio com essa placa!");
        } else {
            repository.getListaCarga().remove(carga);
            System.out.println("Veiculo de carga com placa " + plate + " excluído!");
        }
    }
}
