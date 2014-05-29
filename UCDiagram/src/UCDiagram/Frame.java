package UCDiagram;



import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class Frame extends JFrame{
    
   //TelaDesenho desenho;
    JToggleButton botaoSelecionar, botaoCirculo, botaoQuadrado, botaoTexto;
    JButton botaoLimpar;
    JToolBar barraFerramentas;
    
   
    public Frame() {
        super("UCDiagram");

        iniciaComponentes();
        iniciaMenu();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(200,100);
        setSize(640, 480);
        setVisible(true);
    }
    
    private void iniciaComponentes() {

        ButtonGroup botaoGrupo = new ButtonGroup();
        
    }
    
        private void iniciaMenu(){
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArquivo = new JMenu("Arquivo");
        menuArquivo.setMnemonic(KeyEvent.VK_A);
        
        JMenu menuAjuda = new JMenu("Ajuda");
        menuAjuda.setMnemonic(KeyEvent.VK_J);
        
        JMenuItem menuItemNovo = new JMenuItem(TrataMenu.NOVO);
        menuItemNovo.setMnemonic(KeyEvent.VK_N);
        menuItemNovo.setName(TrataMenu.NOVO);
        menuItemNovo.addActionListener(new TrataMenu());
        menuArquivo.add(menuItemNovo);
        
        JMenuItem menuItemAbrir = new JMenuItem(TrataMenu.ABRIR);
        menuItemAbrir.setMnemonic(KeyEvent.VK_B);
        menuItemAbrir.setName(TrataMenu.ABRIR);
        menuItemAbrir.addActionListener(new TrataMenu());
        menuArquivo.add(menuItemAbrir);
        
        JMenuItem menuItemSalvar = new JMenuItem(TrataMenu.SALVAR);
        menuItemSalvar.setMnemonic(KeyEvent.VK_S);
        menuItemSalvar.setName(TrataMenu.SALVAR);
        menuItemSalvar.addActionListener(new TrataMenu());
        menuArquivo.add(menuItemSalvar);
        
        JMenuItem menuItemSair = new JMenuItem(TrataMenu.SAIR);
        menuItemSair.setMnemonic(KeyEvent.VK_R);
        menuItemSair.setName(TrataMenu.SAIR);
        menuItemSair.addActionListener(new TrataMenu());
        menuArquivo.add(menuItemSair);
        
        JMenuItem menuItemSobre = new JMenuItem(TrataMenu.SOBRE);
        menuItemSobre.setName(TrataMenu.SOBRE);
        menuAjuda.add(menuItemSobre);
        
        menuBar.add(menuArquivo);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(menuAjuda);
        setJMenuBar(menuBar);
        
    }
        
    private class TrataMenu implements ActionListener{
    public static final String NOVO="Novo";
    public static final String ABRIR="Abrir";
    public static final String SALVAR="Salvar";
    public static final String SAIR="Sair";
    public static final String SOBRE="Sobre";
    
        @Override
        public void actionPerformed(ActionEvent e) {
            JComponent componente = (JComponent) e.getSource();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            switch(componente.getName()){
                case NOVO:
                    desenho.limpar();
                    break;
                case ABRIR:
                    
                    int returnVa = fileChooser.showOpenDialog(Frame.this);

                    if (returnVa == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();
                        try {
                            desenho.carregaDados(file);
                            desenho.repaint();
                            JOptionPane.showMessageDialog(Frame.this, "Arquivo carregado com sucesso!");
                        } catch (Exception exc) {
                            JOptionPane.showMessageDialog(Frame.this, "Erro ao ler do arquivo");
                        }
                    }
                    break;
                case SALVAR:
                    int returnVal = fileChooser.showSaveDialog(Frame.this);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();
                        try {
                            desenho.salvarDados(file);
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(Frame.this, "Erro ao salvar no arquivo");
                        }
                    }
                    break;
                case SAIR:
                    System.exit(0);
                    break;
            }
        }
        
    }

    
    
    
}
