
package UCDiagram;

import java.awt.Graphics;

/**
 *
 * @author hezrom
 */
public class Associacao extends Figura{

    private int tam;

    public Associacao(int x, int y, int tam) {
        super(x, y);
        this.tam = tam;
    }
    
     public boolean intersecta(int x, int y) {
        if (x < posX) return false;
        if (x > (posX + 250)) return false;
        if (y < posY) return false;
        if (y > (posY + tam)) return false;
        return true;
    }
    public void desenha(Graphics g) {
        g.drawLine(posX, posY, posX+250, posY);
        if (this.estaSelecionado()) {
        g.drawOval(posX-2,posY-2,4,4);
        g.drawOval(posX+250-2,posY-2,4,4);
        }
    }
}
