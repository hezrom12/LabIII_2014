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
        if (x > (posX + 150)) return false;
        if (y < posY) return false;
        if (y > (posY + 50)) return false;
        return true;

    }

    public void desenha(Graphics g) {
      
        g.drawOval(posX, posY, 150, 50);
        if (this.estaSelecionado()) {
            g.drawOval(posX-2,posY-2,4,4);
            g.drawOval(posX-2,posY+50-2,4,4);
            g.drawOval(posX+150-2,posY-2,4,4);
            g.drawOval(posX+150-2,posY+50-2,4,4);

        }
    }
    
}
