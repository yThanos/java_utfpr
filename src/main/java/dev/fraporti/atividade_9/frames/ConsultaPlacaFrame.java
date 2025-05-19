package dev.fraporti.atividade_9.frames;

import dev.fraporti.atividade_9.VeiculosDrive;
import dev.fraporti.atividade_9.model.Carga;
import dev.fraporti.atividade_9.model.Passeio;
import dev.fraporti.atividade_9.model.Veiculo;

import javax.swing.*;
import java.awt.*;

public class ConsultaPlacaFrame extends JFrame {
    private final VeiculosFrame parentComponent;
    private final VeiculosFrame.Context context;

    private final JTextField placaInput = new JTextField(20);
    private final JTextField marcaInput = new JTextField(20);
    private final JTextField modeloInput = new JTextField(20);
    private final JTextField corInput = new JTextField(20);
    private final JTextField qtdRodasInput = new JTextField(20);
    private final JTextField velocMaxInput = new JTextField(20);
    private final JTextField qtdPistInput = new JTextField(20);
    private final JTextField potenInput = new JTextField(20);

    private final JTextField taraInput = new JTextField(20);
    private final JTextField cargaMaxInput = new JTextField(20);

    private final JTextField qtdPassInput = new JTextField(20);

    public ConsultaPlacaFrame(VeiculosFrame parentComponent, VeiculosFrame.Context context) {
        this.parentComponent = parentComponent;
        this.context = context;

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        setSize(500, 500);

        setTitle("Consulta de "+ context + "por placa");

        //vehicle fields
        JPanel placa = new JPanel(new FlowLayout(FlowLayout.LEFT));
        placa.setSize(500, 30);
        JLabel placaLabel = new JLabel("Informe a placa: ");
        placa.add(placaLabel);
        placa.add(placaInput);
        add(placa);

        if(context == VeiculosFrame.Context.carga) {
            //carga fields
            JPanel tara = new JPanel(new FlowLayout(FlowLayout.LEFT));
            tara.setSize(500, 30);
            JLabel taraLabel = new JLabel("Tara: ");
            tara.add(taraLabel);
            taraInput.setEditable(false);
            tara.add(taraInput);
            add(tara);

            JPanel cargaMax = new JPanel(new FlowLayout(FlowLayout.LEFT));
            cargaMax.setSize(500, 30);
            JLabel cargaMaxLabel = new JLabel("Carga Max.: ");
            cargaMax.add(cargaMaxLabel);
            cargaMaxInput.setEditable(false);
            cargaMax.add(cargaMaxInput);
            add(cargaMax);
        } else {
            //passeio fields
            JPanel qtdPass = new JPanel(new FlowLayout(FlowLayout.LEFT));
            qtdPass.setSize(500, 30);
            JLabel qtdPassLabel = new JLabel("Qtd. Passageiros: ");
            qtdPass.add(qtdPassLabel);
            qtdPassInput.setEditable(false);
            qtdPass.add(qtdPassInput);
            add(qtdPass);
        }

        JPanel marca = new JPanel(new FlowLayout(FlowLayout.LEFT));
        marca.setSize(500, 30);
        JLabel marcaLabel = new JLabel("Marca: ");
        marca.add(marcaLabel);
        marcaInput.setEditable(false);
        marca.add(marcaInput);
        add(marca);

        JPanel modelo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        modelo.setSize(500, 30);
        JLabel modeloLabel = new JLabel("Modelo: ");
        modelo.add(modeloLabel);
        modeloInput.setEditable(false);
        modelo.add(modeloInput);
        add(modelo);

        JPanel cor = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cor.setSize(500, 30);
        JLabel corLabel = new JLabel("Cor: ");
        cor.add(corLabel);
        corInput.setEditable(false);
        cor.add(corInput);
        add(cor);

        JPanel qtdRodas = new JPanel(new FlowLayout(FlowLayout.LEFT));
        qtdRodas.setSize(500, 30);
        JLabel qtdRodaLabel = new JLabel("Qtd. Rodas: ");
        qtdRodas.add(qtdRodaLabel);
        qtdRodasInput.setEditable(false);
        qtdRodas.add(qtdRodasInput);
        add(qtdRodas);

        JPanel velocMax = new JPanel(new FlowLayout(FlowLayout.LEFT));
        velocMax.setSize(500, 30);
        JLabel velocMaxLabel = new JLabel("Velocidade Max.: ");
        velocMax.add(velocMaxLabel);
        velocMaxInput.setEditable(false);
        velocMax.add(velocMaxInput);
        add(velocMax);

        JPanel qtdPist = new JPanel(new FlowLayout(FlowLayout.LEFT));
        qtdPist.setSize(500, 30);
        JLabel qtdPistLabel = new JLabel("Qtd. Pistões: ");
        qtdPist.add(qtdPistLabel);
        qtdPistInput.setEditable(false);
        qtdPist.add(qtdPistInput);
        add(qtdPist);

        JPanel poten = new JPanel(new FlowLayout(FlowLayout.LEFT));
        poten.setSize(500, 30);
        JLabel potenLabel = new JLabel("Potência: ");
        poten.add(potenLabel);
        potenInput.setEditable(false);
        poten.add(potenInput);
        add(poten);

        //buttons
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton cadastrar = new JButton("Consultar");
        cadastrar.addActionListener(this::consultar);
        buttons.add(cadastrar);

        JButton novo = new JButton("Excluir");
        novo.addActionListener(this::excluir);
        buttons.add(novo);

        JButton sair = new JButton("Sair");
        sair.addActionListener(this::close);
        buttons.add(sair);

        add(buttons);

        setVisible(true);
    }

    private void consultar(Object o) {
        String placa = placaInput.getText();
        Veiculo veiculo;
        if(context == VeiculosFrame.Context.carga){
            veiculo = VeiculosDrive.imprimeCargaPelaPlaca(placa, true);
            if(veiculo != null){
                taraInput.setText(Integer.toString(((Carga) veiculo).getTara()));
                cargaMaxInput.setText(Integer.toString(((Carga) veiculo).getCargaMax()));
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum veiculo de carga com está placa!");
                return;
            }
        } else {
            veiculo = VeiculosDrive.imprimePasseioPelaPlaca(placa, true);
            if(veiculo != null){
                qtdPassInput.setText(Integer.toString(((Passeio) veiculo).getQtdPassageiros()));
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum veiculo de passeio com está placa!");
                return;
            }
        }
        marcaInput.setText(veiculo.getMarca());
        modeloInput.setText(veiculo.getModelo());
        corInput.setText(veiculo.getCor());
        qtdRodasInput.setText(Integer.toString(veiculo.getQtdRodas()));
        velocMaxInput.setText(Float.toString(veiculo.getVelocMax()));
        qtdPistInput.setText(Integer.toString(veiculo.getMotor().getQtdPist()));
        potenInput.setText(Integer.toString(veiculo.getMotor().getPotencia()));
    }

    private void excluir(Object o) {
        String placa = placaInput.getText();
        if(context == VeiculosFrame.Context.carga){
            Carga carga = VeiculosDrive.imprimeCargaPelaPlaca(placa, true);
            if(carga == null){
                JOptionPane.showMessageDialog(this, "Nenhum veiculo de passeio com essa placa!");
            } else {
                VeiculosDrive.repository.getListaCarga().remove(carga);
                JOptionPane.showMessageDialog(this, "Veiculo de carga com placa " + placa + " excluído!");
            }
        } else {
            Passeio passeio = VeiculosDrive.imprimePasseioPelaPlaca(placa, true);
            if(passeio == null){
                JOptionPane.showMessageDialog(this, "Nenhum veiculo de passeio com essa placa!");
            } else {
                VeiculosDrive.repository.getListaPasseio().remove(passeio);
                JOptionPane.showMessageDialog(this, "Veiculo de passeio com placa " + placa + " excluído!");
            }
        }

        limpar();
    }

    private void limpar(){
        placaInput.setText("");
        marcaInput.setText("");
        modeloInput.setText("");
        corInput.setText("");
        qtdRodasInput.setText("");
        velocMaxInput.setText("");
        qtdPistInput.setText("");
        potenInput.setText("");
    }

    private void close(Object o) {
        this.parentComponent.consultaPlacaFrame = null;
        this.dispose();
    }
}
