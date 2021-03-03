package mapa;

import graficos.Pantalla;
import java.util.Random;
import mapa.cuadro.Cuadro;

public abstract class Mapa {

    protected int ancho;
    protected int alto;

    protected int[] cuadros;
    protected Cuadro[] cuadrosCat;

    public Mapa(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;

        cuadros = new int[ancho * alto];
        generarMapa();
    }
    
      public Mapa(String ruta){
        cargarMapa(ruta);
        generarMapa();
    }

    public Cuadro getCuadrosCat(int posicion) {
        return cuadrosCat[posicion];
    }

    public int getAncho() {
        return ancho;
    }
    
    protected void generarMapa() {

    }

    protected void cargarMapa(String ruta) {

    }

    public void actualizar() {

    }

    public void mostrar(int compensacionX, int compensacionY, Pantalla pantalla) {
        pantalla.establecerDiferencia(compensacionY, compensacionX);

        int o = compensacionX >> 5;
        int e = (compensacionX + pantalla.getAncho() + Cuadro.LADO) >> 5;
        int n = compensacionY >> 5;
        int s = (compensacionY + pantalla.getAlto() + Cuadro.LADO) >> 5;

        for (int y = n; y < s; y++) {
            for (int x = o; x < e; x++) {
                getCuadro(x, y).mostrar(x, y, pantalla);
                //prueba = new Prueba(x, "x");
            }
        }
    }

    public Cuadro getCuadro(final int x, final int y) {
        //prueba = new Prueba(x, "x");

        if (x < 0 || y < 0 || x >= ancho || y >= alto) {
            return Cuadro.VACIO;
        }
        Random r = new Random();
        switch (cuadros[x + y * ancho]) {
            case 0:
                return Cuadro.PAST00;
            case 1:
                return Cuadro.PAST01;
            case 2:
                return Cuadro.PAST02;
            case 3:
                return Cuadro.PAST03;
            case 4:
                return Cuadro.PAST04;
            case 5:
                return Cuadro.FLOR;
            case 6:
                return Cuadro.ARBOL;
            case 7:
                return Cuadro.MATA;
            case 8:
                return Cuadro.TRONCO;
            case 9:
                return Cuadro.ARENA;
            case 10:
                return Cuadro.ARE_PAS0;
            case 11:
                return Cuadro.ARE_PAS1;
            case 12:
                return Cuadro.ARE_PAS2;
            case 13:
                return Cuadro.ARE_PAS3;
            case 14:
                return Cuadro.ARE_PAS4; 
            case 15:
                return Cuadro.ARE_PAS5;
            case 16:
                return Cuadro.ARE_PAS6;
            case 17:
                return Cuadro.ARE_PAS7;
            case 18:
                return Cuadro.ARE_PAS8;
            case 19:
                return Cuadro.RIO;
            case 20:
                return Cuadro.PAS_RIO0;
            case 21:
                return Cuadro.PAS_RIO1;
            case 22:
                return Cuadro.PAS_RIO2;
            case 23:
                return Cuadro.PAS_RIO3;
            /*switch(r.nextInt(5)){
                    case 0:
                        return Cuadro.PAST00;
                    case 1:
                        return Cuadro.PAST01;
                    case 2:
                        return Cuadro.PAST02;
                    case 3:
                        return Cuadro.PAST03;
                    case 4:
                        return Cuadro.PAST04;
                } */
            default:
                return Cuadro.VACIO;
        }
    }

}
