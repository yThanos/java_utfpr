package dev.fraporti.atividade_9.frames;

import javax.swing.*;
import java.awt.*;

public class CadastroFrame extends JFrame {
    private final VeiculosFrame parentComponent;
    private final VeiculosFrame.Context context;

    //vehicle fields
    private final JLabel placaLabel = new JLabel("Placa: ");
    private final JTextField placaInput = new JTextField(10);
    private final JLabel marcaLabel = new JLabel("Marca: ");
    private final JTextField marcaInput = new JTextField(10);
    private final JLabel modeloLabel = new JLabel("Modelo: ");
    private final JTextField modeloInput = new JTextField(10);
    private final JLabel corLabel = new JLabel("Cor: ");
    private final JTextField corInput = new JTextField(10);
    private final JLabel qtdRodaLabel = new JLabel("Qtd. Rodas: ");
    private final JTextField qtdRodasInput = new JTextField(10);
    private final JLabel velocMaxLabel = new JLabel("Velocidade Max.: ");
    private final JTextField velocMaxInput = new JTextField(10);
    private final JLabel qtdPistLabel = new JLabel("Qtd. Pistões: ");
    private final JTextField qtdPistInput = new JTextField(10);
    private final JLabel potenLabel = new JLabel("Potência: ");
    private final JTextField potenInput = new JTextField(10);

    //carga fields
    private final JLabel taraLabel = new JLabel("Tara: ");
    private final JTextField taraInput = new JTextField(10);
    private final JLabel cargaMaxLabel = new JLabel("Carga Max.: ");
    private final JTextField cargaMaxInput = new JTextField(10);

    //passeio fields
    private final JLabel qtdPassLabel = new JLabel("Qtd. Passageiros: ");
    private final JTextField qtdPassInput = new JTextField(10);

    public CadastroFrame(VeiculosFrame parentComponent, VeiculosFrame.Context context) {
        this.parentComponent = parentComponent;
        this.context = context;

        setLayout(new FlowLayout());

        setSize(500, 300);

        setTitle("Cadastro de "+ context);

        if(context == VeiculosFrame.Context.carga) {
            add(taraLabel);
            add(taraInput);
            //line break
            add(cargaMaxLabel);
            add(cargaMaxInput);
        } else {
            add(qtdPassLabel);
            add(qtdPassInput);
        }

        //line break
        add(placaLabel);
        add(placaInput);
        //line break
        add(marcaLabel);
        add(marcaInput);
        //line break
        add(modeloLabel);
        add(modeloInput);
        //line break
        add(corLabel);
        add(corInput);
        //line break
        add(qtdRodaLabel);
        add(qtdRodasInput);
        //line break
        add(velocMaxLabel);
        add(velocMaxInput);
        //line break
        add(qtdPistLabel);
        add(qtdPistInput);
        //line break
        add(potenLabel);
        add(potenInput);


        setVisible(true);
    }

    private void close(Object o) {
        this.parentComponent.cadastroFrame = null;
        this.dispose();
    }
}
