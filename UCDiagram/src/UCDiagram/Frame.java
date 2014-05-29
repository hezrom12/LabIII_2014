package UCDiagram;



import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;


public class Frame extends JFrame{
    
   //Frame
    Desenho desenho;
    JToggleButton botaoSelecionar, botaoAtor, botaoUsecase, botaoAssociacao, botaoExtend, botaoInclude, botaoTexto;
    JButton botaoLimpar;
    JToolBar barraFerramentas;
    JPanel painel1, painel2;
   
    public Frame() {
        super("UCDiagram");

        iniciaComponentes();
        iniciaMenu();
        iniciaFerramentas();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(200,100);
        setSize(800,600 );
        setVisible(true);
    }
    
    private void iniciaComponentes() {
        //Separador de Painel
        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,painel1,painel2);
        getContentPane().add(splitPane);
        
        //Arvore
        DefaultMutableTreeNode nodoRaiz = new DefaultMutableTreeNode("Raiz");
        DefaultMutableTreeNode nodoGalho1 = new DefaultMutableTreeNode("Galho1");
        DefaultMutableTreeNode nodoFolha1 = new DefaultMutableTreeNode("Folha1");
        nodoGalho1.add(nodoFolha1);
        DefaultMutableTreeNode nodoFolha2 = new DefaultMutableTreeNode("Folha2");
        nodoGalho1.add(nodoFolha2);
        DefaultMutableTreeNode nodoFolha3 = new DefaultMutableTreeNode("Folha3");
        nodoGalho1.add(nodoFolha3);
        nodoRaiz.add(nodoGalho1);
        DefaultMutableTreeNode nodoGalho2 = new DefaultMutableTreeNode("Galho2");
        DefaultMutableTreeNode nodoFolha4 = new DefaultMutableTreeNode("Folha4");
        nodoGalho2.add(nodoFolha4);
        DefaultMutableTreeNode nodoFolha5 = new DefaultMutableTreeNode("Folha5");
        nodoGalho2.add(nodoFolha5);
        nodoRaiz.add(nodoGalho2);        
        
        final JTree arvore = new JTree(nodoRaiz);
        painel1.add(arvore);
        getContentPane().add(painel1, BorderLayout.WEST);
 
        
    }
   
    private void iniciaFerramentas() {
        //Menu de Ferramentas
        ButtonGroup botaoGrupo = new ButtonGroup();

        barraFerramentas = new JToolBar();
        botaoSelecionar = new JToggleButton("Select", true);        
        botaoGrupo.add(botaoSelecionar);
        barraFerramentas.add(botaoSelecionar);
        
        //Botão Ator
        botaoAtor = new JToggleButton("Ator", true);
        botaoAtor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                desenho.deselecionarFiguras();
                
            }
        });
        botaoGrupo.add(botaoAtor);
        barraFerramentas.add(botaoAtor);

        //Botão Usecase
        botaoUsecase = new JToggleButton("UC");
        botaoUsecase.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                desenho.deselecionarFiguras();
            }
        });
        botaoGrupo.add(botaoUsecase);
        barraFerramentas.add(botaoUsecase);
        
        //Botão Associação
        botaoAssociacao = new JToggleButton("----");
        botaoAssociacao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                desenho.deselecionarFiguras();
            }
        });
        botaoGrupo.add(botaoAssociacao);
        barraFerramentas.add(botaoAssociacao);
        
        //Botão Extend
        botaoExtend = new JToggleButton("E-->");
        botaoExtend.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                desenho.deselecionarFiguras();
            }
        });
        botaoGrupo.add(botaoExtend);
        barraFerramentas.add(botaoExtend);
        
          //Botão Include
        botaoInclude = new JToggleButton("I-->");
        botaoInclude.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                desenho.deselecionarFiguras();
            }
        });
        botaoGrupo.add(botaoInclude);
        barraFerramentas.add(botaoInclude);
        
        
        //Botão Texto
        botaoTexto = new JToggleButton("Text");
        botaoTexto.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                desenho.deselecionarFiguras();
            }
        });
        botaoGrupo.add(botaoTexto);
        barraFerramentas.add(botaoTexto);

        barraFerramentas.add(Box.createHorizontalGlue());
        
        //Botão Limpar
        botaoLimpar = new JButton("Limpar");
        botaoLimpar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                desenho.limpar();
                desenho.repaint();
            }

        });
        barraFerramentas.add(botaoLimpar);

        getContentPane().add(barraFerramentas, BorderLayout.NORTH);

        //desenho = new TelaDesenho();
        //desenho.addMouseListener(new TrataMouse());
        //desenho.addMouseMotionListener(new TrataMouse());
        //getContentPane().add(desenho);
        
    }
    
    private void iniciaMenu(){
            //Menus
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArquivo = new JMenu("Arquivo");
        menuArquivo.setMnemonic(KeyEvent.VK_A);
        
        JMenu menuAjuda = new JMenu("Ajuda");
        menuAjuda.setMnemonic(KeyEvent.VK_J);
        
            //Menus Itens
        JMenuItem menuItemNovo = new JMenuItem(TrataMenu.NOVO);
        menuItemNovo.setMnemonic(KeyEvent.VK_N);
        menuItemNovo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        menuItemNovo.setName(TrataMenu.NOVO);
        menuItemNovo.addActionListener(new TrataMenu());
        menuArquivo.add(menuItemNovo);
        
        JMenuItem menuItemAbrir = new JMenuItem(TrataMenu.ABRIR);
        menuItemAbrir.setMnemonic(KeyEvent.VK_B);
        menuItemAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
        menuItemAbrir.setName(TrataMenu.ABRIR);
        menuItemAbrir.addActionListener(new TrataMenu());
        menuArquivo.add(menuItemAbrir);
        
        JMenuItem menuItemSalvar = new JMenuItem(TrataMenu.SALVAR);
        menuItemSalvar.setMnemonic(KeyEvent.VK_S);
        menuItemSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
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
        
            //Adiciona os "MenusItem" ao Menu
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

    private class TrataMouse extends MouseAdapter {

        public final static int TAMANHO = 30;

        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            int tam = TAMANHO;
            if(botaoSelecionar.isSelected()){
                desenho.verificaSelecao(x, y);
            }
            else if (botaoAtor.isSelected()) {
                Ator a = new Ator(x, y, tam);
                desenho.addFigura(a);
            } else if (botaoUsecase.isSelected()) {
                UseCase u = new UseCase(x, y, tam);
                desenho.addFigura(u);
            } else if (botaoAssociacao.isSelected()) {
                Associacao as = new Associacao(x, y, tam);
                desenho.addFigura(as);
            } else if (botaoExtend.isSelected()) {
                Extend ex = new Extend(x, y, tam);
                desenho.addFigura(ex);
            } else if (botaoInclude.isSelected()) {
                Include i = new Include(x, y, tam);
                desenho.addFigura(i);
            } else if (botaoTexto.isSelected()) {
                String texto = JOptionPane.showInputDialog("Texto:");
                Texto t = new Texto(x, y, texto);
                desenho.addFigura(t);

            }

            desenho.repaint();

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            if(botaoSelecionar.isSelected()){
                
                Figura figura = desenho.getSelecionado();
                if(figura!=null)
                    figura.moveTo(x, y);
            }            
            desenho.repaint();
        }
    }
    
    
    
}
