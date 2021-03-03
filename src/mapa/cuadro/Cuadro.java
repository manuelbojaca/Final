package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprites;

public class Cuadro {

    public int x;
    public int y;

    public Sprites sprite;
    private boolean solido;

    public static final int LADO = 32;

    //Coleccion de cuadros
    public static final Cuadro VACIO = new Cuadro(Sprites.VACIO, true);
    
    public static final Cuadro PAST00 = new Cuadro(Sprites.PAST00);
    public static final Cuadro PAST01 = new Cuadro(Sprites.PAST01);
    public static final Cuadro PAST02 = new Cuadro(Sprites.PAST02);
    public static final Cuadro PAST03 = new Cuadro(Sprites.PAST03);
    public static final Cuadro PAST04 = new Cuadro(Sprites.PAST04);
    
    public static final Cuadro PASTO = new Cuadro(Sprites.PASTO);
    public static final Cuadro FLOR = new Cuadro(Sprites.FLOR);
    public static final Cuadro ARBOL = new Cuadro(Sprites.ARBOL, true);
    public static final Cuadro MATA = new Cuadro(Sprites.MATA);
    public static final Cuadro TRONCO = new Cuadro(Sprites.TRONCO, true);
    public static final Cuadro ARENA = new Cuadro(Sprites.ARENA);
    public static final Cuadro ARE_PAS0 = new Cuadro(Sprites.ARE_PAS0);
    public static final Cuadro ARE_PAS1 = new Cuadro(Sprites.ARE_PAS1);
    public static final Cuadro ARE_PAS2 = new Cuadro(Sprites.ARE_PAS2);
    public static final Cuadro ARE_PAS3 = new Cuadro(Sprites.ARE_PAS3);
    public static final Cuadro ARE_PAS4 = new Cuadro(Sprites.ARE_PAS4);
    public static final Cuadro ARE_PAS5 = new Cuadro(Sprites.ARE_PAS5);
    public static final Cuadro ARE_PAS6 = new Cuadro(Sprites.ARE_PAS6);
    public static final Cuadro ARE_PAS7 = new Cuadro(Sprites.ARE_PAS7);
    public static final Cuadro ARE_PAS8 = new Cuadro(Sprites.ARE_PAS8);
    public static final Cuadro RIO = new Cuadro(Sprites.RIO, true);
    public static final Cuadro PAS_RIO0 = new Cuadro(Sprites.PAS_RIO0);
    public static final Cuadro PAS_RIO1 = new Cuadro(Sprites.PAS_RIO1);
    public static final Cuadro PAS_RIO2 = new Cuadro(Sprites.PAS_RIO2);
    public static final Cuadro PAS_RIO3 = new Cuadro(Sprites.PAS_RIO3);
    
    //Fin Coleccion cuadros

    public Cuadro(Sprites sprite) {
        this.sprite = sprite;
        solido = false;
    }

    public Cuadro(Sprites sprite, boolean solido) {
        this.sprite = sprite;
        this.solido = solido;
    }

    public void mostrar(int x, int y, Pantalla pantalla) {
        pantalla.mostrarCuadro(x << 5, y << 5, this);
    }

    public boolean esSolido() {
        return solido;
    }
}
