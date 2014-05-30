
package UCDiagram;

import java.awt.Graphics;


public class Ator extends Figura{

  private int tam;
  public String ator = "Ator";

    public Ator(int x, int y, int tam) {
        super(x, y);
        this.tam = tam;
    }

    public boolean intersecta(int x, int y) {
        if (x < posX) return false;
        if (x > (posX + tam)) return false;
        if (y < posY) return false;
        if (y > (posY + 110)) return false;
        return true;

    }

    public void desenha(Graphics g) {
        g.drawOval(posX, posY, tam, tam);                   //cabeça
        g.drawLine(posX+15, posY+30, posX+15, posY+70);     //corpo
        g.drawLine(posX-5, posY+45, posX+35, posY+45);     //braços
        g.drawLine(posX+0, posY+95, posX+15, posY+70);     //perna esq
        g.drawLine(posX+15, posY+70, posX+30, posY+95);    //perna dir
        g.drawString(ator, posX+3, posY+110);
        if (this.estaSelecionado()) {
            g.drawOval(posX-10,posY-2,4,4);
            g.drawOval(posX-10,posY+110-2,4,4);
            g.drawOval(posX+tam+5,posY-2,4,4);
            g.drawOval(posX+tam+5,posY+110-2,4,4);

        }
    }
}
