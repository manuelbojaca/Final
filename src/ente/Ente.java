package ente;

import graficos.Pantalla;
import mapa.Mapa;

public abstract class Ente {

    protected int x;
    protected int y;

    private boolean eliminado = false;

    protected Mapa mapa;

    public void actualizar() {

    }

    public void mostrar() {

    }

    public void eliminar() {
        eliminado = true;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setPosX(int x) {
        this.x += x;
    }

    public void setPosY(int y) {
        this.y += y;
    }

    public boolean getEliminado() {
        return eliminado;
    }
}
