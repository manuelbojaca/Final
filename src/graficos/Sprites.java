package graficos;

import java.util.Random;
import principal.Prueba;

public final class Sprites {
    
    private final int lado;
    
    private int x;
    private int y;
    
    private int i = 0;
    private int j = 0;
    
    public Prueba prueba;
    
    public static Random r;
    
    public int[] pixeles;
    private HojaSprites hoja;
    
    //coleccion hojas de sprites
    public static Sprites VACIO = new Sprites(32, 0x000000);
    
    public static Sprites PASTO = new Sprites(32, 0, 0, HojaSprites.desierto);
    public static Sprites FLOR = new Sprites(32, 1, 0, HojaSprites.desierto);
    public static Sprites ARBOL = new Sprites(32, 2, 0, HojaSprites.desierto);
    public static Sprites MATA = new Sprites(32, 3, 0, HojaSprites.desierto);
    public static Sprites TRONCO = new Sprites(32, 4, 0, HojaSprites.desierto);
    public static Sprites ARENA = new Sprites(32, 5, 0, HojaSprites.desierto);
    public static Sprites ARE_PAS0 = new Sprites(32, 6, 0, HojaSprites.desierto);
    public static Sprites ARE_PAS1 = new Sprites(32, 7, 0, HojaSprites.desierto);
    public static Sprites ARE_PAS2 = new Sprites(32, 8, 0, HojaSprites.desierto);
    public static Sprites ARE_PAS3 = new Sprites(32, 9, 0, HojaSprites.desierto);
    public static Sprites ARE_PAS4 = new Sprites(32, 0, 1, HojaSprites.desierto);
    public static Sprites ARE_PAS5 = new Sprites(32, 1, 1, HojaSprites.desierto);
    public static Sprites ARE_PAS6 = new Sprites(32, 2, 1, HojaSprites.desierto);
    public static Sprites ARE_PAS7 = new Sprites(32, 3, 1, HojaSprites.desierto);
    public static Sprites ARE_PAS8 = new Sprites(32, 4, 1, HojaSprites.desierto);
    public static Sprites RIO = new Sprites(32, 5, 1, HojaSprites.desierto);
    public static Sprites PAS_RIO0 = new Sprites(32, 6, 1, HojaSprites.desierto);
    public static Sprites PAS_RIO1 = new Sprites(32, 7, 1, HojaSprites.desierto);
    public static Sprites PAS_RIO2 = new Sprites(32, 8, 1, HojaSprites.desierto);
    public static Sprites PAS_RIO3 = new Sprites(32, 9, 1, HojaSprites.desierto);
    
    public static Sprites PAST00 = new Sprites(32, 0, 0, HojaSprites.pasto);
    public static Sprites PAST01 = new Sprites(32, 1, 0, HojaSprites.pasto);
    public static Sprites PAST02 = new Sprites(32, 2, 0, HojaSprites.pasto);
    public static Sprites PAST03 = new Sprites(32, 3, 0, HojaSprites.pasto);
    public static Sprites PAST04 = new Sprites(32, 4, 0, HojaSprites.pasto);
    
    public static Sprites JUG_FRO0 = new Sprites(32, 0, 0, HojaSprites.jugador);
    public static Sprites JUG_FRO1 = new Sprites(32, 0, 1, HojaSprites.jugador);
    public static Sprites JUG_FRO2 = new Sprites(32, 0, 2, HojaSprites.jugador);
    public static Sprites JUG_RGT0 = new Sprites(32, 1, 0, HojaSprites.jugador);
    public static Sprites JUG_RGT1 = new Sprites(32, 1, 1, HojaSprites.jugador);
    public static Sprites JUG_RGT2 = new Sprites(32, 1, 2, HojaSprites.jugador);
    public static Sprites JUG_LFT0 = new Sprites(32, 2, 0, HojaSprites.jugador);
    public static Sprites JUG_LFT1 = new Sprites(32, 2, 1, HojaSprites.jugador);
    public static Sprites JUG_LFT2 = new Sprites(32, 2, 2, HojaSprites.jugador);
    public static Sprites JUG_BCK0 = new Sprites(32, 3, 0, HojaSprites.jugador);
    public static Sprites JUG_BCK1 = new Sprites(32, 3, 1, HojaSprites.jugador);
    public static Sprites JUG_BCK2 = new Sprites(32, 3, 2, HojaSprites.jugador);
    //fin coleccion

    public Sprites(final int lado, final int columna, final int fila, 
            final HojaSprites hoja){
        
        this.lado = lado;
        this.hoja = hoja;
        
        pixeles = new int[lado * lado];
        
        this.x = columna * lado;
        this.y = fila * lado;
        
        for(int y = 0; y < lado; y++){
            for(int x = 0; x < lado; x++){
                pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y)
                        * hoja.getAncho()];
            }
        }
    }   
    
    public Sprites (final int lado, final int color){
        this.lado = lado;
        pixeles = new int[lado * lado];
        for (int i = 0; i < pixeles.length; i++){
            pixeles [i]= color;
        }
    }
    
    public Sprites(final int lado, final HojaSprites hoja){
        
        this.lado = lado;
        this.hoja = hoja;
        
        pixeles = new int[lado * lado];
        
        Random ran0 = new Random();
        Random ran1 = new Random();
        
        this.x = ran0.nextInt(5) * lado;
        this.y = ran1.nextInt(3) * lado;
        
        for(int y = 0; y < lado; y++){
            for(int x = 0; x < lado; x++){
                pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y)
                        * hoja.getAncho()];
            }
        }
    }
    
    public int getLado () {
        return lado;
    }
}