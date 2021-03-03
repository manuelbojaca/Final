package graficos;

import mapa.cuadro.Cuadro;

public class Pantalla {
    
    private final int ancho;
    private final int alto;
    
    private int diferenciaX;
    private int diferenciaY;
    
    public final int[] pixeles;
    
    // temporal
//    private final static int LADO_SPRITE = 32;
//    private final static int MASCARA_SPRITE = LADO_SPRITE - 1;
    // fin temporal
    
    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public Pantalla(int ancho, int alto) {
        
        this.ancho = ancho;
        this.alto = alto;
        
        pixeles = new int[ancho * alto];
    }
    
    public void Limpiar() {
        
        for(int i = 0; i < pixeles.length; i++) {
            pixeles[i] = 0;
        }
    }
    
    /*public void mostrar(final int compensacionX, final int compensacionY){
        
        for(int y = 0; y < alto; y++) {
            
            int posicionY = y + compensacionY;
            if(posicionY < 0 || posicionY >= alto) {
                continue;
            }
            for(int x = 0; x < ancho; x++){
                
                int posicionX = x + compensacionX;
                if(posicionX < 0 || posicionX >= ancho) {
                    continue;
                }
                
                //temporal
                pixeles[posicionX + posicionY * ancho] = Sprites.ASFALTO.pixeles[
                        (x & MASCARA_SPRITE) + (y & MASCARA_SPRITE) * 
                        LADO_SPRITE];
            }
        }    
    }*/
    //fin temporal
    public void mostrarCuadro(int compensacionX, int compensacionY, Cuadro cuadro){
        compensacionX -= diferenciaX;
        compensacionY -= diferenciaY;
        
        for(int y = 0; y < cuadro.sprite.getLado(); y++){
            int posicionY = y + compensacionY;
            for(int x = 0; x < cuadro.sprite.getLado(); x++){
                int posicionX = x + compensacionX;
                if (posicionX < 0 || posicionX > ancho|| posicionY < 0 ||
                        posicionY > alto) {
                    break;
                }
                pixeles[posicionX + posicionY * ancho] = cuadro.sprite.
                        pixeles[x + y * cuadro.sprite.getLado()];
            }
        }        
    }
    
    public void establecerDiferencia (final int diferenciaY, final int diferenciaX){
        this.diferenciaY = diferenciaY;
        this.diferenciaX = diferenciaX;
    }
}