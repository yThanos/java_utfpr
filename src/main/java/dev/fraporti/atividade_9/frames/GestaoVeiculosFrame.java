package dev.fraporti.atividade_9.frames;

import javax.swing.*;
import java.awt.*;

public class GestaoVeiculosFrame extends JFrame {
    private static final JButton passeio = new JButton();
    private static final JButton carga = new JButton();

    private VeiculosFrame passeiosFrame = null;
    private VeiculosFrame cargasFrame = null;

    public GestaoVeiculosFrame() {
        setSize(500, 300);
        setTitle("Gestão de veiculos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        passeio.setSize(100, 50);
        passeio.setText("Passeio");
        passeio.addActionListener(this::passeioButtonEvent);

        carga.setSize(100, 50);
        carga.setText("Carga");
        carga.addActionListener(this::cargaButtonEvent);

        add(passeio);
        add(carga);

        setVisible(true);
    }

    private void passeioButtonEvent(Object o){
        if(passeiosFrame == null) {
            passeiosFrame = new VeiculosFrame(VeiculosFrame.Context.passeio, this);
        } else {
            JOptionPane.showMessageDialog(this, "A janela de gerenciamento de veiculos de passeio já está aberta");
        }
    }

    private void cargaButtonEvent(Object o){
        if(cargasFrame == null) {
            cargasFrame = new VeiculosFrame(VeiculosFrame.Context.carga, this);
        } else {
            JOptionPane.showMessageDialog(this, "A janela de gerenciamento de veiculos de carga já está aberta");
        }
    }

    public void close(VeiculosFrame.Context context){
        if(context == VeiculosFrame.Context.carga){
            this.cargasFrame = null;
        } else {
            this.passeiosFrame = null;
        }
    }
}
