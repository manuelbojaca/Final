package ente.criaturas;

import ente.Ente;
import graficos.Sprites;

public abstract class Criatura extends Ente {

    protected Sprites sprite;
    protected char direccion = 'n';
    protected boolean enMovimiento = false;

    public Sprites getSprite() {
        return sprite;
    }

    @Override
    public void actualizar() {

    }

    @Override
    public void mostrar() {

    }

    public void mover(int desplazamientoX, int desplazamientoY) {
        if (desplazamientoX > 0) {
            direccion = 'e';
        }
        if (desplazamientoX < 0) {
            direccion = 'o';
        }
        if (desplazamientoY > 0) {
            direccion = 's';
        }
        if (desplazamientoY < 0) {
            direccion = 'n';
        }
        if (!getEliminado()) {
            if (!colision(desplazamientoX, 0)) {
                setPosX(desplazamientoX);
            }
            if (!colision(0, desplazamientoY)) {
                setPosY(desplazamientoY);
            }
        }
    }

    private boolean colision(int desplazamientoX, int desplazamientoY) {
        boolean colision = false;
        
        int posicionX = x + desplazamientoX;
        int posicionY = y + desplazamientoY;
        
        int margenIzq = -4;
        int margenDer = 26;
        int margenSup = -6;
        int margenInf = 29;
        
        int bordeIzq = (posicionX + margenDer) / sprite.getLado();
        int bordeDer = (posicionX + margenDer + margenIzq) / sprite.getLado();
        int bordeSup = (posicionY + margenInf) / sprite.getLado();
        int bordeInf = (posicionY + margenInf + margenSup) / sprite.getLado();
        
        if (mapa.getCuadrosCat(bordeIzq + bordeSup * mapa.getAncho()).esSolido()) {
            colision = true;
        }
        if (mapa.getCuadrosCat(bordeIzq + bordeInf * mapa.getAncho()).esSolido()) {
            colision = true;
        }
        if (mapa.getCuadrosCat(bordeDer + bordeSup * mapa.getAncho()).esSolido()) {
            colision = true;
        }
        if (mapa.getCuadrosCat(bordeDer + bordeInf * mapa.getAncho()).esSolido()) {
            colision = true;
        }
        
        return colision;
    }
}
