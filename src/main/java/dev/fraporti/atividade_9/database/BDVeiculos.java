package dev.fraporti.atividade_9.database;

import dev.fraporti.atividade_9.model.Carga;
import dev.fraporti.atividade_9.model.Passeio;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vitor.rosmann on 30/04/2025
 */
public class BDVeiculos {
    private List<Passeio> listaPasseio;
    private List<Carga> listaCarga;

    public BDVeiculos() {
        this.listaPasseio = new ArrayList<>();
        this.listaCarga = new ArrayList<>();
    }

    public List<Passeio> getListaPasseio() {
        return listaPasseio;
    }

    public void setListaPasseio(List<Passeio> listaPasseio) {
        this.listaPasseio = listaPasseio;
    }

    public List<Carga> getListaCarga() {
        return listaCarga;
    }

    public void setListaCarga(List<Carga> listaCarga) {
        this.listaCarga = listaCarga;
    }
}
