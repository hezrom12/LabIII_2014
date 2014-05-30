package UCDiagram;

import java.awt.Graphics;

/**
 *
 * @author hezrom
 */
public class UseCase extends Figura{
private int tam;

    public UseCase(int x, int y, int tam) {
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
        g.fillOval(posX, posY, 75, 25);
        if (this.estaSelecionado()) {
            g.drawOval(posX-2,posY-2,4,4);
            g.drawOval(posX-2,posY+25-2,4,4);
            g.drawOval(posX+75-2,posY-2,4,4);
            g.drawOval(posX+75-2,posY+25-2,4,4);

        }
    }
    
}
