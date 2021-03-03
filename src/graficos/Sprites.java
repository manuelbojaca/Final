package graficos;

public final class Sprites {
    
    private final int lado;
    
    private int x;
    private int y;
    
    public int[] pixeles;
    private HojaSprites hoja;
    
    //coleccion hojas de sprites
    public static Sprites VACIO = new Sprites(32, 0x000000);
    public static Sprites ASFALTO = new Sprites(32, 0, 0, HojaSprites.desierto);
    public static Sprites ARBOLITO = new Sprites(32, 1, 0, HojaSprites.desierto);
    public static Sprites PASTO1 = new Sprites(32, 2, 0, HojaSprites.desierto);
    public static Sprites PASTO2 = new Sprites(32, 3, 0, HojaSprites.desierto);
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
    
    public int getLado () {
        return lado;
    }
}