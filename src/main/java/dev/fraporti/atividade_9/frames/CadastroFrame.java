package dev.fraporti.atividade_9.frames;

import dev.fraporti.atividade_9.VeiculosDrive;
import dev.fraporti.atividade_9.exception.VeicExistException;
import dev.fraporti.atividade_9.exception.VelocException;
import dev.fraporti.atividade_9.model.Carga;
import dev.fraporti.atividade_9.model.Passeio;
import dev.fraporti.atividade_9.model.Veiculo;

import javax.swing.*;
import java.awt.*;

public class CadastroFrame extends JFrame {
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

    public CadastroFrame(VeiculosFrame parentComponent, VeiculosFrame.Context context) {
        this.parentComponent = parentComponent;
        this.context = context;

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        setSize(500, 500);

        setTitle("Cadastro de "+ context);

        if(context == VeiculosFrame.Context.carga) {
            //carga fields
            JPanel tara = new JPanel(new FlowLayout(FlowLayout.LEFT));
            tara.setSize(500, 30);
            JLabel taraLabel = new JLabel("Tara: ");
            tara.add(taraLabel);
            tara.add(taraInput);
            add(tara);

            JPanel cargaMax = new JPanel(new FlowLayout(FlowLayout.LEFT));
            cargaMax.setSize(500, 30);
            JLabel cargaMaxLabel = new JLabel("Carga Max.: ");
            cargaMax.add(cargaMaxLabel);
            cargaMax.add(cargaMaxInput);
            add(cargaMax);
        } else {
            //passeio fields
            JPanel qtdPass = new JPanel(new FlowLayout(FlowLayout.LEFT));
            qtdPass.setSize(500, 30);
            JLabel qtdPassLabel = new JLabel("Qtd. Passageiros: ");
            qtdPass.add(qtdPassLabel);
            qtdPass.add(qtdPassInput);
            add(qtdPass);
        }

        //vehicle fields
        JPanel placa = new JPanel(new FlowLayout(FlowLayout.LEFT));
        placa.setSize(500, 30);
        JLabel placaLabel = new JLabel("Placa: ");
        placa.add(placaLabel);
        placa.add(placaInput);
        add(placa);

        JPanel marca = new JPanel(new FlowLayout(FlowLayout.LEFT));
        marca.setSize(500, 30);
        JLabel marcaLabel = new JLabel("Marca: ");
        marca.add(marcaLabel);
        marca.add(marcaInput);
        add(marca);

        JPanel modelo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        modelo.setSize(500, 30);
        JLabel modeloLabel = new JLabel("Modelo: ");
        modelo.add(modeloLabel);
        modelo.add(modeloInput);
        add(modelo);

        JPanel cor = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cor.setSize(500, 30);
        JLabel corLabel = new JLabel("Cor: ");
        cor.add(corLabel);
        cor.add(corInput);
        add(cor);

        JPanel qtdRodas = new JPanel(new FlowLayout(FlowLayout.LEFT));
        qtdRodas.setSize(500, 30);
        JLabel qtdRodaLabel = new JLabel("Qtd. Rodas: ");
        qtdRodas.add(qtdRodaLabel);
        qtdRodas.add(qtdRodasInput);
        add(qtdRodas);

        JPanel velocMax = new JPanel(new FlowLayout(FlowLayout.LEFT));
        velocMax.setSize(500, 30);
        JLabel velocMaxLabel = new JLabel("Velocidade Max.: ");
        velocMax.add(velocMaxLabel);
        velocMax.add(velocMaxInput);
        add(velocMax);

        JPanel qtdPist = new JPanel(new FlowLayout(FlowLayout.LEFT));
        qtdPist.setSize(500, 30);
        JLabel qtdPistLabel = new JLabel("Qtd. Pistões: ");
        qtdPist.add(qtdPistLabel);
        qtdPist.add(qtdPistInput);
        add(qtdPist);

        JPanel poten = new JPanel(new FlowLayout(FlowLayout.LEFT));
        poten.setSize(500, 30);
        JLabel potenLabel = new JLabel("Potência: ");
        poten.add(potenLabel);
        poten.add(potenInput);
        add(poten);

        //buttons
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton cadastrar = new JButton("Cadastrar");
        cadastrar.addActionListener(this::cadastrar);
        buttons.add(cadastrar);

        JButton novo = new JButton("Novo");
        novo.addActionListener(this::novo);
        buttons.add(novo);

        JButton limpar = new JButton("Limpar");
        limpar.addActionListener(this::limpar);
        buttons.add(limpar);

        JButton sair = new JButton("Sair");
        sair.addActionListener(this::close);
        buttons.add(sair);

        add(buttons);

        setVisible(true);
    }

    private void cadastrar(Object o) {
        Veiculo veiculo = context == VeiculosFrame.Context.carga ? new Carga() : new Passeio();
        try {
            veiculo.setPlaca(placaInput.getText());
        } catch (VeicExistException e) {
            JOptionPane.showMessageDialog(this, "Já existe um veiculo com está placa cadastrado!");
        }
        veiculo.setMarca(marcaInput.getText());
        veiculo.setModelo(modeloInput.getText());
        veiculo.setCor(corInput.getText());
        try{
            int qtdRodas = Integer.parseInt(qtdRodasInput.getText());
            veiculo.setQtdRodas(qtdRodas);
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "A quantidade de rodas deve ser um valor numérico!");
            return;
        }
        try{
            int velocMax = Integer.parseInt(velocMaxInput.getText());
            veiculo.setVelocMax(velocMax);
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "A quantidade de rodas deve ser um valor numérico!");
            return;
        } catch (VelocException e) {
            if(veiculo instanceof Passeio){
                try {
                    velocMaxInput.setText("100");
                    veiculo.setVelocMax(100);
                    JOptionPane.showMessageDialog(this, "Velocidade maxima excede o permitido, valor redefinido para 100!");
                } catch (VelocException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                try {
                    velocMaxInput.setText("90");
                    veiculo.setVelocMax(90);
                    JOptionPane.showMessageDialog(this, "Velocidade maxima excede o permitido, valor redefinido para 90!");
                } catch (VelocException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        try{
            int qtdPist = Integer.parseInt(qtdPistInput.getText());
            veiculo.getMotor().setQtdPist(qtdPist);
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "A quantidade de pistões deve ser um valor numérico!");
            return;
        }
        try{
            int potencia = Integer.parseInt(potenInput.getText());
            veiculo.getMotor().setPotencia(potencia);
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "A potência deve ser um valor numérico!");
            return;
        }

        if(veiculo instanceof  Carga) {
            try{
                int tara = Integer.parseInt(taraInput.getText());
                ((Carga) veiculo).setTara(tara);
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(this, "A tara deve ser um valor numérico!");
                return;
            }
            try{
                int cargaMax = Integer.parseInt(cargaMaxInput.getText());
                ((Carga) veiculo).setCargaMax(cargaMax);
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(this, "A carga maxíma deve ser um valor numérico!");
                return;
            }
            VeiculosDrive.repository.getListaCarga().add((Carga) veiculo);
        } else {
            try{
                int qtdPass = Integer.parseInt(qtdPassInput.getText());
                ((Passeio) veiculo).setQtdPassageiros(qtdPass);
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(this, "A quantidade de passageiros deve ser um valor numérico!");
                return;
            }
            VeiculosDrive.repository.getListaPasseio().add((Passeio) veiculo);
        }

        JOptionPane.showMessageDialog(this, "Veiculo de "+ context +" cadastrado com  sucesso!");
    }

    private void novo(Object o) {
        limpar(o);
    }

    private void limpar(Object o){
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
        this.parentComponent.cadastroFrame = null;
        this.dispose();
    }
}
