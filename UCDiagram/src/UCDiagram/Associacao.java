
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
        if (x > (posX + tam)) return false;
        if (y < posY) return false;
        if (y > (posY + tam)) return false;
        return true;
     }
    public void desenha(Graphics g) {
        g.drawLine(posX, posY, posY, posX);
    }
}
