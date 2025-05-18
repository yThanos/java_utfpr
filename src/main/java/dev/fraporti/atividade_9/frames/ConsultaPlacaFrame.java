package dev.fraporti.atividade_9.frames;

import javax.swing.*;

public class ConsultaPlacaFrame extends JFrame {
    private final VeiculosFrame parentComponent;
    private final VeiculosFrame.Context context;

    public ConsultaPlacaFrame(VeiculosFrame parentComponent, VeiculosFrame.Context context) {
        this.parentComponent = parentComponent;
        this.context = context;
    }

    private void close(Object o) {
        this.parentComponent.consultaPlacaFrame = null;
        this.dispose();
    }
}
