package dev.fraporti.atividade_9.frames;

import javax.swing.*;
import java.awt.*;

public class VeiculosFrame extends JFrame {
    public enum Context {
        passeio,
        carga
    }

    private final Context context;
    private final GestaoVeiculosFrame parentComponent;

    private final JButton cadastrarButton = new JButton();
    private final JButton consultaPlaca = new JButton();
    private final JButton consultaTodos = new JButton();
    private final JButton sair = new JButton();

    public CadastroFrame cadastroFrame = null;
    public ConsultaPlacaFrame consultaPlacaFrame = null;
    public ConsultaTodosFrame consultaTodosFrame = null;

    public VeiculosFrame(Context context, GestaoVeiculosFrame parentComponent) {
        this.context = context;
        this.parentComponent = parentComponent;

        if(context == Context.passeio){
            setTitle("Veiculos de passeio");
        } else {
            setTitle("Veiculos de carga");
        }

        setSize(500, 300);

        setDefaultCloseOperation(HIDE_ON_CLOSE);

        setLayout(new FlowLayout());

        cadastrarButton.setText("Cadastrar");
        cadastrarButton.setSize(100, 50);
        cadastrarButton.addActionListener(this::cadastrar);
        add(cadastrarButton);

        consultaPlaca.setText("Consultar/Excluir pela placa");
        consultaPlaca.setSize(100, 50);
        consultaPlaca.addActionListener(this::consultaPlaca);
        add(consultaPlaca);

        consultaTodos.setText("Consultar/Excluir todos");
        consultaTodos.setSize(100, 50);
        consultaTodos.addActionListener(this::consultaTodos);
        add(consultaTodos);

        sair.setText("Sair");
        sair.setSize(100, 50);
        sair.addActionListener(this::sair);
        add(sair);
        setVisible(true);
    }

    private void cadastrar(Object o){
        if(this.cadastroFrame == null){
            this.cadastroFrame = new CadastroFrame(this, context);
        } else {
            JOptionPane.showMessageDialog(this, "A janela de cadastro de veiculos de "+ context +" já está aberta");
        }
    }

    private void consultaPlaca(Object o) {
        if(this.consultaPlacaFrame == null){
            this.consultaPlacaFrame = new ConsultaPlacaFrame(this, context);
        } else {
            JOptionPane.showMessageDialog(this, "A janela de consulta e exclusão de veiculos de "+ context +" por placa já está aberta");
        }
    }

    private void consultaTodos(Object o) {
        if(this.consultaTodosFrame == null){
            this.consultaTodosFrame = new ConsultaTodosFrame(this, context);
        } else {
            JOptionPane.showMessageDialog(this, "A janela de consulta e exclusão de todos veiculos de "+ context +" já está aberta");
        }
    }

    private void sair(Object o) {
        this.parentComponent.close(this.context);
        this.dispose();
    }
}
