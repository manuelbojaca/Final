package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprites;

public abstract class Cuadro {
    public int x;
    public int y;
    
    public Sprites sprite;
    
    //Coleccion de cuadros
    public static final Cuadro VACIO = new CuadroVacio(Sprites.VACIO);
    public static final Cuadro ASFALTO = new CuadroAsfalto(Sprites.ASFALTO);
    public static final Cuadro ARBOLITO = new CuadroAsfalto(Sprites.ARBOLITO);
    public static final Cuadro PASTO1 = new CuadroAsfalto(Sprites.PASTO1);
    public static final Cuadro PASTO2 = new CuadroAsfalto(Sprites.PASTO2);
    //Fin Coleccion cuadros
    
    public Cuadro(Sprites sprite) {
        this.sprite = sprite;
    }
    
    public void mostrar(int x, int y, Pantalla pantalla) {
        pantalla.mostrarCuadro(x << 5, y << 5, this);
    }
    
    public boolean solido(){
        return false;
    }
}
