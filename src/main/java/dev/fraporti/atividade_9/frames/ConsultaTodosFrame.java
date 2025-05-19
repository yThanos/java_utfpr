package dev.fraporti.atividade_9.frames;

import dev.fraporti.atividade_9.VeiculosDrive;
import dev.fraporti.atividade_9.model.Carga;
import dev.fraporti.atividade_9.model.Passeio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultaTodosFrame extends JFrame {
    private final VeiculosFrame parentComponent;
    private final VeiculosFrame.Context context;
    private final DefaultTableModel tableModel;

    public ConsultaTodosFrame(VeiculosFrame parentComponent, VeiculosFrame.Context context) {
        this.parentComponent = parentComponent;
        this.context = context;

        setTitle("Ver todos veiculos de "+ context);

        setSize(800, 400);

        setLayout(new BorderLayout());

        List<String> columns = new ArrayList<>();
        if(context == VeiculosFrame.Context.carga){
            columns.add("Tara");
            columns.add("Carga Max.");
        } else {
            columns.add("Qtd. Passageiros");
        }

        columns.addAll(List.of("Placa", "Marca", "Modelo", "Cor", "Qtd. Rodas", "Velocidade Max.", "Qtd. Pistões", "Potência"));

        tableModel = new DefaultTableModel(columns.toArray(), 0);

        JTable table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton imprime = new JButton("Imprimir todos");
        JButton exclui = new JButton("Excluir todos");
        JButton sair = new JButton("Sair");

        imprime.addActionListener(this::imprimeTudo);
        exclui.addActionListener(this::deletaTudo);
        sair.addActionListener(this::close);

        buttons.add(imprime);
        buttons.add(exclui);
        buttons.add(sair);

        add(buttons, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void imprimeTudo(Object o) {
        tableModel.setRowCount(0);
        if(context == VeiculosFrame.Context.carga){
            for(Carga carga: VeiculosDrive.repository.getListaCarga()) {
                Object[] rowData = {carga.getTara(), carga.getCargaMax(), carga.getPlaca(), carga.getMarca(), carga.getModelo(), carga.getCor(),
                        carga.getQtdRodas(), carga.getVelocMax(), carga.getMotor().getQtdPist(), carga.getMotor().getPotencia()};
                tableModel.addRow(rowData);
            }
        } else {
            for(Passeio passeio: VeiculosDrive.repository.getListaPasseio()) {
                Object[] rowData = {passeio.getQtdPassageiros(), passeio.getPlaca(), passeio.getMarca(), passeio.getModelo(), passeio.getCor(),
                        passeio.getQtdRodas(), passeio.getVelocMax(), passeio.getMotor().getQtdPist(), passeio.getMotor().getPotencia()};
                tableModel.addRow(rowData);
            }
        }
    }

    private void deletaTudo(Object o) {
        if(context == VeiculosFrame.Context.carga){
            VeiculosDrive.repository.setListaCarga(new ArrayList<>());
        } else {
            VeiculosDrive.repository.setListaPasseio(new ArrayList<>());
        }
        JOptionPane.showMessageDialog(this, "Todos veiculos de "+ context + " foram excluidos");
    }

    private void close(Object o) {
        this.parentComponent.consultaTodosFrame = null;
        this.dispose();
    }
}
