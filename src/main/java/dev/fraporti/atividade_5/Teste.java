package dev.fraporti.atividade_5;

import dev.fraporti.atividade_5.model.Carga;
import dev.fraporti.atividade_5.model.Leitura;
import dev.fraporti.atividade_5.model.Passeio;
import dev.fraporti.atividade_5.model.Veiculo;

/**
 * @author vitor.rosmann on 13/03/2025
 */
public class Teste {
    private static final String MENU_OPTIONS = """
                    Sistema de Gestão de Veículos - Menu Inicial
                    1. Cadastrar Veículo de Passeio
                    2. Cadastrar Veículo de Carga
                    3. Imprimir Todos os Veículos de Passeio
                    4. Imprimir Todos os Veículos de Carga
                    5. Imprimir Veículo de Passeio pela Placa
                    6. Imprimir Veículo de Carga pela Placa
                    7. Sair do Sistema
                    """;

    private static final Passeio[] PASSEIOS = new Passeio[5];
    private static final Carga[] CARGAS = new Carga[5];
    private static int noPasseios = 0;
    private static int noCargas = 0;

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        boolean loop = true;
        int option;

        while(loop) {
            try{
                option = Integer.parseInt(Leitura.entDados(MENU_OPTIONS));

                switch (option) {
                    case 1:
                        cadastrarVeiculoPasseio();
                        break;
                    case 2:
                        cadastrarVeiculoCarga();
                        break;
                    case 3:
                        imprimeTodosPasseio();
                        break;
                    case 4:
                        imprimeTodosCarga();
                        break;
                    case 5: {
                        String placa = Leitura.entDados("Placa buscada:");
                        imprimePasseioPelaPlaca(placa, false);
                        break;
                    }
                    case 6 : {
                        String placa = Leitura.entDados("Placa buscada:");
                        imprimeCargaPelaPlaca(placa, false);
                        break;
                    }
                    case 7:
                        System.out.println("Até mais!");
                        loop = false;
                        break;
                    default:
                        System.out.println("Digite um valor");
                        break;
                }

            } catch (NumberFormatException e){
                System.out.println("Informe apenas o Numero da opção desejada!");
            }
        }
    }

    private static void cadastrarVeiculoPasseio() {
        if(noPasseios < 5) {
            Passeio passeio = new Passeio();
            try{
                System.out.println("Informe os dados do veiculo de passeio!");
                fillVehicleFields(passeio);
            } catch (RuntimeException e){
                /// already an existing vehicle with said plate
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

            PASSEIOS[noPasseios] = passeio;
            noPasseios++;


            if(Leitura.entDados("Deseja cadastrar outros veiculo de passeio? (S/N)").equalsIgnoreCase("S")){
                cadastrarVeiculoPasseio();
            }
        } else {
            System.out.println("Quantidade maxima de veículos de passeio cadastrados!");
        }
    }

    private static void cadastrarVeiculoCarga() {
        if(noCargas < 5) {
            Carga carga = new Carga();
            try{
                System.out.println("Informe os dados do veiculo de carga!");
                fillVehicleFields(carga);
            } catch (RuntimeException e){
                /// already an existing vehicle with said plate
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

            CARGAS[noCargas] = carga;
            noCargas++;

            if(Leitura.entDados("Deseja cadastrar outros veiculo de carga? (S/N)").equalsIgnoreCase("S")){
                cadastrarVeiculoCarga();
            }
        } else {
            System.out.println("Quantidade maxima de veículos de carga cadastrados!");
        }
    }

    private static <T extends Veiculo> void fillVehicleFields(T veiculo) {
        veiculo.setMarca(Leitura.entDados("Marca:"));
        veiculo.setModelo(Leitura.entDados("Modelo:"));
        veiculo.setCor(Leitura.entDados("Cor:"));

        String placa = Leitura.entDados("Placa:");
        if(imprimeCargaPelaPlaca(placa, true) || imprimePasseioPelaPlaca(placa, true)){
            System.out.println("Já existe um veiculo com esta placa cadastrado!");
            throw new RuntimeException();
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

    private static void imprimeTodosPasseio() {
        if(noPasseios == 0){
            System.out.println("Nenhum veiculo de passeio cadastrado!");
            return;
        }
        for(int i = 0; i < noPasseios; i++){
            System.out.println(PASSEIOS[i]);
        }
    }

    private static void imprimeTodosCarga() {
        if(noCargas == 0){
            System.out.println("Nenhum veiculo de carga cadastrado!");
            return;
        }
        for(int i = 0; i < noCargas; i++){
            System.out.println(CARGAS[i]);
        }
    }

    private static boolean imprimePasseioPelaPlaca(String placa, boolean search) {
        if(noPasseios == 0 && !search){
            System.out.println("Nenhum veiculo de passeio cadastrado!");
            return false;
        }
        for(int i = 0; i < noPasseios; i++){
            if(PASSEIOS[i].getPlaca().equals(placa)){
                if(search) return true;
                System.out.println(PASSEIOS[i]);
                return true;
            }
        }
        if(search) return false;
        System.out.println("Placa não encontrada!");
        return false;
    }

    private static boolean imprimeCargaPelaPlaca(String placa, boolean search) {
        if(noCargas == 0 && !search){
            System.out.println("Nenhum veiculo de carga cadastrado!");
            return false;
        }
        for(int i = 0; i < noCargas; i++){
            if(CARGAS[i].getPlaca().equals(placa)){
                if(search) return true;
                System.out.println(CARGAS[i]);
                return true;
            }
        }
        if(search) return false;
        System.out.println("Placa não encontrada!");
        return false;
    }
}
