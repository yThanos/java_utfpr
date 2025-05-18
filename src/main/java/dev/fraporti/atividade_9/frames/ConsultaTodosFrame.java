package dev.fraporti.atividade_9.frames;

import javax.swing.*;

public class ConsultaTodosFrame extends JFrame {
    private final VeiculosFrame parentComponent;
    private final VeiculosFrame.Context context;

    public ConsultaTodosFrame(VeiculosFrame parentComponent, VeiculosFrame.Context context) {
        this.parentComponent = parentComponent;
        this.context = context;
    }

    private void close(Object o) {
        this.parentComponent.consultaTodosFrame = null;
        this.dispose();
    }
}
