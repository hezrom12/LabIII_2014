package UCDiagram;

import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class Desenho extends JPanel{
    List<Figura> figuras;
    public Desenho(){
        figuras = new ArrayList<>();
    }
    
    public void addFigura(Figura f)
    {
        figuras.add(f);
    }
    
    public void limpar(){
        figuras.clear();
        repaint();
    }
    
    public void verificaSelecao(int x, int y){
        for(Figura f:figuras)
            if(f.intersecta(x, y))
            {
                deselecionarFiguras();
                f.selecionar();
            }
        
    }
    
    public Figura getSelecionado()
    {
        for(Figura f:figuras)
        {
            if(f.estaSelecionado())
                return f;
        }
        return null;
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        for(Figura f:figuras)
            f.desenha(g);
    }

    public void deselecionarFiguras() {
        for(Figura f:figuras)
            f.deselecionar();
        repaint();
    }
    
    public void carregaDados(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        figuras = (List<Figura>) ois.readObject();
        ois.close();
        fis.close();
    }

    public void salvarDados(File file) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.reset();
        oos.writeObject(figuras);
        oos.close();
        fos.close();

    }        

    
}
