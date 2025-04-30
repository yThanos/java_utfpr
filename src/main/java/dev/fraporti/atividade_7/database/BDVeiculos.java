package dev.fraporti.atividade_7.database;

import dev.fraporti.atividade_7.model.Carga;
import dev.fraporti.atividade_7.model.Passeio;

/**
 * @author vitor.rosmann on 30/04/2025
 */
public class BDVeiculos {
    private Passeio[] listaPasseio = new Passeio[5];
    private Carga[] listaCarga = new Carga[5];

    public Passeio[] getListaPasseio() {
        return listaPasseio;
    }

    public Carga[] getListaCarga() {
        return listaCarga;
    }

    public void setListaPasseio(Passeio[] listaPasseio) {
        this.listaPasseio = listaPasseio;
    }

    public void setListaCarga(Carga[] listaCarga) {
        this.listaCarga = listaCarga;
    }
}
