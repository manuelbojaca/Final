package animacion;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class Movimiento implements KeyListener {
    
    private final static int numeroTeclas = 120;
    private final boolean[] teclas = new boolean[numeroTeclas];

    public boolean arriba;
    public boolean abajo;
    public boolean izquierda;
    public boolean derecha;
    
    public void actualizar() {
        
        arriba = teclas[KeyEvent.VK_W];
        izquierda = teclas[KeyEvent.VK_A];
        abajo = teclas[KeyEvent.VK_S];
        derecha = teclas[KeyEvent.VK_D];
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
            //teclas[e.getKeyCode()] = true;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        teclas[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        teclas[e.getKeyCode()] = false;
    }
    
}