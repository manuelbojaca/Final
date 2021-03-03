package ente.criaturas;

import animacion.Movimiento;
import graficos.Pantalla;
import graficos.Sprites;
import mapa.Mapa;

public class Jugador extends Criatura {

    private Movimiento movimiento;

    private int animacion;

    public Jugador(Mapa mapa, Movimiento movimiento, Sprites sprite) {
        this.mapa = mapa;
        this.movimiento = movimiento;
        this.sprite = sprite;
    }

    public Jugador(Mapa mapa, Movimiento movimiento, Sprites sprite, int posX, int posY) {
        this(mapa, movimiento, sprite);
        
    // Posible error
        this.movimiento = movimiento;
        this.sprite = sprite;
    //fin

        this.x = posX;
        this.y = posY;
    }

    @Override
    public void actualizar() {
        int desplazamientoX = 0;
        int desplazamientoY = 0;
        
        int velocidad = 1;
        if (animacion < 32767) {
            animacion++;
        } else {
            animacion = 0;
        }
        
        if (movimiento.correr) {
            velocidad = 2;
        }
        
        if (movimiento.arriba) {
            desplazamientoY -= velocidad;
        }
        if (movimiento.abajo) {
            desplazamientoY += velocidad;
        }
        if (movimiento.izquierda) {
            desplazamientoX -= velocidad;
        }
        if (movimiento.derecha) {
            desplazamientoX += velocidad;
        }
        if (desplazamientoX != 0 || desplazamientoY != 0) {
            mover(desplazamientoX, desplazamientoY);
            enMovimiento = true;
        } else {
            enMovimiento = false;
        }

        int resto = animacion % 40;

        if (direccion == 'n') {
            sprite = Sprites.JUG_BCK0;
            if (enMovimiento) {
                if (resto > 10 && resto <= 20) {
                    sprite = Sprites.JUG_BCK1;
                } else if (resto > 20 && resto <= 20) {
                    sprite = Sprites.JUG_BCK0;
                } else if (resto > 30) {
                    sprite = Sprites.JUG_BCK2;
                } else {
                    sprite = Sprites.JUG_BCK0;
                }
            }
        }
        if (direccion == 's') {
            sprite = Sprites.JUG_FRO0;
            if (enMovimiento) {
                if (resto > 10 && resto <= 20) {
                    sprite = Sprites.JUG_FRO1;
                } else if (resto > 20 && resto <= 20) {
                    sprite = Sprites.JUG_FRO0;
                } else if (resto > 30) {
                    sprite = Sprites.JUG_FRO2;
                } else {
                    sprite = Sprites.JUG_FRO0;
                }
            }
        }
        if (direccion == 'o') {
            sprite = Sprites.JUG_LFT0;
            if (enMovimiento) {
                if (resto > 10 && resto <= 20) {
                    sprite = Sprites.JUG_LFT1;
                } else if (resto > 20 && resto <= 20) {
                    sprite = Sprites.JUG_LFT0;
                } else if (resto > 30) {
                    sprite = Sprites.JUG_LFT2;
                } else {
                    sprite = Sprites.JUG_LFT0;
                }
            }
        }

        if (direccion == 'e') {
            sprite = Sprites.JUG_RGT0;
            if (enMovimiento) {
                if (resto > 10 && resto <= 20) {
                    sprite = Sprites.JUG_RGT1;
                } else if (resto > 20 && resto <= 20) {
                    sprite = Sprites.JUG_RGT0;
                } else if (resto > 30) {
                    sprite = Sprites.JUG_RGT2;
                } else {
                    sprite = Sprites.JUG_RGT0;
                }
            }
        }
    }

    public void mostrar(Pantalla pantalla) {
        pantalla.mostrarJugador(x, y, this);
    }
}
