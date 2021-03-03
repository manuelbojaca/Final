package mapa;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import mapa.cuadro.Cuadro;

public class MapaCargado extends Mapa {

    private int[] pixeles;

    public MapaCargado(String ruta) {
        super(ruta);
    }

    protected void CargarMapa(String ruta) {
        try {
            BufferedImage imagen = ImageIO.read(MapaCargado.class
                    .getResource(ruta));

            ancho = imagen.getWidth();
            alto = imagen.getHeight();

            cuadrosCat = new Cuadro[ancho * alto];
            pixeles = new int[ancho * alto];

            imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void generarMapa() {
        for (int i = 0; i < pixeles.length; i++) {
            switch (pixeles[i]) {

                case 0xff52be40:
                    cuadrosCat[i] = Cuadro.PASTO;
                    continue;
                case 0xff5e2c16:
                    cuadrosCat[i] = Cuadro.FLOR;
                    continue;
                case 0xfffbaa73:
                    cuadrosCat[i] = Cuadro.ARBOL;
                    continue;
                case 0xfffff000:
                    cuadrosCat[i] = Cuadro.MATA;
                    continue;
                case 0xffff0000:
                    cuadrosCat[i] = Cuadro.TRONCO;
                    continue;
                case 0xfff1d66c:
                    cuadrosCat[i] = Cuadro.ARENA;
                    continue;
                case 0xffd85660:
                    cuadrosCat[i] = Cuadro.ARE_PAS0;
                    continue;
                case 0xfff31318:
                    cuadrosCat[i] = Cuadro.ARE_PAS1;
                    continue;
                case 0xff8f5e7d:
                    cuadrosCat[i] = Cuadro.ARE_PAS2;
                    continue;
                case 0xff900a5f:
                    cuadrosCat[i] = Cuadro.ARE_PAS3;
                    continue;
                case 0xffff02a3:
                    cuadrosCat[i] = Cuadro.ARE_PAS4;
                    continue;
                case 0xffcabc57:
                    cuadrosCat[i] = Cuadro.ARE_PAS5;
                    continue;
                case 0xfff66f0c:
                    cuadrosCat[i] = Cuadro.ARE_PAS6;
                    continue;
                case 0xffdeff00:
                    cuadrosCat[i] = Cuadro.ARE_PAS7;
                    continue;
                case 0xffd39a1f:
                    cuadrosCat[i] = Cuadro.ARE_PAS8;
                    continue;
                case 0xff540d3a:
                    cuadrosCat[i] = Cuadro.RIO;
                    continue;
                case 0xff602fb0:
                    cuadrosCat[i] = Cuadro.PAS_RIO0;
                    continue;
                case 0xff771c69:
                    cuadrosCat[i] = Cuadro.PAS_RIO1;
                    continue;
                case 0xff3296c4:
                    cuadrosCat[i] = Cuadro.PAS_RIO2;
                    continue;
                case 0xff07fdfa:
                    cuadrosCat[i] = Cuadro.PAS_RIO3;
                    continue;
                default:
                    cuadrosCat[i] = Cuadro.VACIO;

            }
        }
    }
}
