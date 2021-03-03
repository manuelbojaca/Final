package mapa;

import graficos.Pantalla;
import mapa.cuadro.Cuadro;

public abstract class Mapa {

    protected int ancho;
    protected int alto;
    
    protected int[] cuadros;
    
    public Mapa(int ancho, int alto){
        this.ancho = ancho;
        this.alto = alto;
        
        cuadros = new int[ancho * alto];
        generarMapa();
    }

    protected void generarMapa() {
    
    }

    private void cargarMapa(String ruta) {
    
    }
    
    public void actualizar() {

    }
    
    public void mostrar(int compensacionX, int compensacionY, Pantalla pantalla) {
        pantalla.establecerDiferencia(compensacionY, compensacionX);
        
        int o = compensacionX >> 5;
        int e = compensacionX + pantalla.getAncho() >> 5;
        int n = compensacionY >> 5;
        int s = compensacionY + pantalla.getAlto() >> 5;
        
        for(int y = n; y < s; y++){
            for(int x = o; x < e; x++){
                getCuadro(x, y).mostrar(x, y, pantalla);
            }
        }
    }
    
    
    
    
    public Cuadro getCuadro(final int x, final int y) {
        switch (cuadros[x + y * ancho]){
            case 0:
                return Cuadro.ASFALTO;
            case 1:
            case 2:
            case 3:
            default:
                return Cuadro.VACIO;
        }
    }
}
