package principal;

import animacion.Movimiento;
import ente.criaturas.Jugador;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import graficos.Pantalla;
import graficos.Sprites;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.DataBufferInt;
import mapa.Mapa;
import mapa.MapaGenerado;

public class Ventana extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;

    private static JFrame ventana;
    private static Thread thread;
    private static Movimiento movimiento;
    private static Pantalla pantalla;
    
    private static Mapa mapa;
    
    private static Jugador jugador;

    private static volatile boolean enFuncionamiento = false;

    private static final int ANCHO = 800;
    private static final int ALTO = 600;
    private static final String NOMBRE = "Juego";
    
    private static String CONTADOR_FPS = "";
    private static String CONTADOR_APS = "";

    private static int aps = 0;
    private static int fps = 0;


    //Imagen en Buffer en blanco
    private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO,
            BufferedImage.TYPE_INT_RGB);
    //Devuelve arr[] de ints
    private static int[] pixeles = ((DataBufferInt) imagen.getRaster().
            getDataBuffer()).getData();
    //((casting) devuelve raster, vuelve datos arr[]) devuelve datos

    public Ventana() {

        setPreferredSize(new Dimension(ANCHO, ALTO));

        pantalla = new Pantalla(ANCHO, ALTO);
        
        mapa = new MapaGenerado(128, 128);

        movimiento = new Movimiento();
        addKeyListener(movimiento);
        
    //CARGAR MAPA
        jugador = new Jugador(mapa, movimiento, Sprites.JUG_FRO0, 384, 286);

        ventana = new JFrame(NOMBRE);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLayout(new BorderLayout());
        ventana.add(this, BorderLayout.CENTER);
        ventana.setUndecorated(true);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        iniciar();

    }

    private synchronized void iniciar() {

        enFuncionamiento = true;
        thread = new Thread(this, "Graficos");
        thread.start();
    }

    private synchronized void detener() {

        enFuncionamiento = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void actualizar() {

        movimiento.actualizar();
        
        jugador.actualizar();

        if (movimiento.exit){
            System.exit(0);
        }
        aps++;
    }

    private void mostrar() {

        BufferStrategy estrategia = getBufferStrategy();

        if (estrategia == null) {
            createBufferStrategy(3);
            return;
        }

        //pantalla.Limpiar();
        //pantalla.mostrar(x, y);
        mapa.mostrar(jugador.getX() - pantalla.getAncho()/2 + jugador.getSprite().getLado()/2, 
                jugador.getY() - pantalla.getAlto()/2 + jugador.getSprite().getLado()/2 , pantalla);
        jugador.mostrar(pantalla);

        System.arraycopy(pantalla.pixeles, 0, pixeles, 0, pixeles.length);
        //(de que arr[] cp, ini[], a que arr[] cp, ini[], tamaño arr[]) 
        /*for (int i = 0; i < pixeles.length; i++){
            pixeles[i] = pantalla.pixeles[i];
        }*/

        //Obj Dibuja lo que este en la estrategia o Buffer
        Graphics g = estrategia.getDrawGraphics();

        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
        //(BufferImage, desde donde dibujar, alto ,ancho)
        //Vacea g o destruye memoria usada por g
        g.setColor(Color.white);
        //g.fillRect(ANCHO/2-16, ALTO/2-16, 32, 32);
        g.drawString(CONTADOR_APS, 10, 20);
        g.drawString(CONTADOR_FPS, 10, 40);
        g.drawString("X: " + jugador.getX(), 10, 60);
        g.drawString("Y: " + jugador.getY(), 10, 80);
        g.dispose();

        estrategia.show();

        fps++;
    }

    @Override
    public void run() {

        final int NS_POR_SEGUNDO = 1000000000;
        final byte APS_OBJETIVO = 60;
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;
        /*Prueba imprimir = new Prueba();
        imprimir.bucle2();*/

        //imprimir = new Prueba(NS_POR_ACTUALIZACION, "NS");
        long referenciaActualizacion = System.nanoTime();
        long referenciaContador = System.nanoTime();

        //imprimir = new Prueba(referenciaActualizacion, "referenciaActualizacion");
        //imprimir = new Prueba(referenciaContador, "referenciaContador");
        double tiempoTranscurrido;
        double delta = 0;

        requestFocus();

        while (enFuncionamiento) {

            final long inicioBucle = System.nanoTime();

            tiempoTranscurrido = inicioBucle - referenciaActualizacion;
            referenciaActualizacion = inicioBucle;

            //imprimir = new Prueba(tiempoTranscurrido, "tiempoTranscurrido");
            //imprimir = new Prueba(referenciaActualizacion, "referenciaActualizacion");
            delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;

            //imprimir = new Prueba(delta, "delta");
            while (delta >= 1) {
                //imprimir = new Prueba(delta, "delta");
                actualizar();
                delta--;
            }

            mostrar();

            if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
                //DATOS EN BORDE DE VENTANA
                //ventana.setTitle(NOMBRE + " || APS: " + aps + " || FPS: " + fps);
                
                CONTADOR_APS = "APS: " + aps;
                CONTADOR_FPS = "FPS: " + fps;
                
                aps = 0;
                fps = 0;
                referenciaContador = System.nanoTime();
            }
        }
    }
}
