package principal;

import graficos.Sprites;

public class Prueba {

    public Prueba() {
    }
    /*public static int inTdat;
    public static long lonGdat;
    public static double doublEdat;
    public static byte bytEdat;
    */
    public Prueba (int dato, String name){
        System.out.println(name + ": "+ dato);
    }
    public Prueba (long dato, String name){
        System.out.println(name + ": "+ dato);
    }
    public Prueba (double dato, String name){
        System.out.println(name + ": "+ dato);
    }
    public Prueba (byte dato, String name){
        System.out.println(name + ": "+ dato);
    }
    public void bucle(int arr, int lado){
        for(int i = 0;i < lado;i++){
            for(int k = 0;k < lado;k++){
                int res = k + i * lado;
                System.out.println(k +"+"+i+"*"+lado+"="+res);
            }
        }
    }
    public void bucle2(){
        int[] asf = new int[1024];
        for (int i = 0; i<1024; i++){
            asf[i] = 69;
        }
        int[] pixeles = new int[800 * 600];
        for(int y = 0; y < 600; y++) {
            
            int posicionY = y + 10;
            if(posicionY < 0 || posicionY >= 600) {
                continue;
            }
            for(int x = 0; x < 800; x++){
                
                int posicionX = x + 10;
                if(posicionX < 0 || posicionX >= 800) {
                    continue;
                }
                
                //temporal
                pixeles[posicionX + posicionY * 600] = Sprites.ASFALTO.pixeles[
                        (x & 31) + (y & 31) * 32];
                int a = x & 31;
                int b = y & 31;
                int c = a + b * 32;
                int d = posicionX + posicionY * 600;
                System.out.println(a + " + " + b + " * 32 = " + c);
                //System.out.println("pix[" + d + "] = " + pixeles[posicionX + posicionY * 600]);
                
                
            }
        }
    }
}
