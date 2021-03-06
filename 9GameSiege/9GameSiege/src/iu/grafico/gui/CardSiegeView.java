/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico.gui;

import com.sun.glass.events.KeyEvent;
import iu.grafico.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import logicaJogo.Ficheiros;
import logicaJogo.Jogo;

/**
 *
 * @author jhssi
 */
public class CardSiegeView extends JFrame implements Observer{

     ObservableGame game;
     CardSiegeGamePanel panel;
    
    public CardSiegeView(ObservableGame observableGame)
    {
        super(" 9 Card Siege");
        
        game = observableGame;
        game.addObserver(this);
        
        
       // startInterface();
        
       panel = new CardSiegeGamePanel(game);
       
       addComponents();
       menu();
       
       setVisible(true);
       this.setSize(1024,860);
       this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
       this.setMinimumSize(new Dimension(700,600));
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       validate();
    }
    
    public void startInterface(){
       game.addObserver(this);
       setVisible(true);
       this.setSize(700,500);
       this.setMinimumSize(new Dimension(700, 500));
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       validate();
        
    }
    
    
    private void addComponents()
    {
        Container cp = getContentPane();
        
        cp.setLayout(new BorderLayout());
        cp.add(panel,BorderLayout.CENTER);
    }
      
    private void menu(){

      JMenuBar menuBar = new JMenuBar();
      setJMenuBar(menuBar);

      JMenu gameMenu = new JMenu("Jogo");

      JMenuItem newObjJMI = new JMenuItem("Parar");
      newObjJMI.setAccelerator(
          KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

      JMenuItem readObjJMI = new JMenuItem("Carregar");
      newObjJMI.setAccelerator(
          KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));

      JMenuItem saveObjJMI = new JMenuItem("Gravar");
      newObjJMI.setAccelerator(
          KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

      JMenuItem exitObjJMI = new JMenuItem("Sair");
      newObjJMI.setAccelerator(
          KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

      gameMenu.add(newObjJMI);
      gameMenu.add(readObjJMI);
      gameMenu.add(saveObjJMI);
      gameMenu.addSeparator();

      gameMenu.add(exitObjJMI);
      menuBar.add(gameMenu);
/*
      newObjJMI.addActionListener(new ObjMenuBarListener());
      readObjJMI.addActionListener(new CarregarObjMenuBarListener());
      saveObjJMI.addActionListener(new GravarObjMenuBarListener());
      exitObjJMI.addActionListener(new SairListener());
*/
      newObjJMI.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(CardSiegeView.this, "Fechou o Jogo","Sair",JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
            }
        });
      readObjJMI.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser("./data");
                int returnVal = fc.showOpenDialog(CardSiegeView.this);

                if(returnVal == JFileChooser.APPROVE_OPTION)
                {
                    File file = fc.getSelectedFile();

                    try{
                        game.setGame((Jogo)Ficheiros.CarregarJogo(file));
                    }catch(IOException | ClassNotFoundException ex){
                        JOptionPane.showMessageDialog(CardSiegeView.this,"Operacao Falhou \r\n\r\n" + e);
                    }
                } else{
                    System.out.println("Operacao cancelada");
                }
            }
        });
      saveObjJMI.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser("./data");
                int returnVal = fc.showOpenDialog(CardSiegeView.this);

                if(returnVal == JFileChooser.APPROVE_OPTION)
                {
                    File file = fc.getSelectedFile();

                    try{
                        game.setGame((Jogo)Ficheiros.CarregarJogo(file));
                    }catch(IOException | ClassNotFoundException ex){
                        JOptionPane.showMessageDialog(CardSiegeView.this,"Operação falhou \r\n\r\n" + e);
                    }
                } else{
                    System.out.println("Operação Falhou");
                }
            }
        });
      exitObjJMI.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 JOptionPane.showMessageDialog(CardSiegeView.this, "Fechou o Jogo","Sair",JOptionPane.PLAIN_MESSAGE);
                 System.exit(0);
            }
        });
      
      JMenu helpMenu = new JMenu("Opções");

      JMenuItem helpContentJMI = new JMenuItem("Ajuda");
      helpContentJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));

      JMenuItem aboutJMI = new JMenuItem("Acerca");
      aboutJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));

      helpMenu.add(helpContentJMI);
      helpMenu.add(aboutJMI);
      menuBar.add(helpMenu);
      
      //helpContentJMI.addActionListener(new AjudaListener());
      //aboutJMI.addActionListener(new AcercaListener());

      helpContentJMI.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 JOptionPane.showMessageDialog(CardSiegeView.this,"Carregue nas Opções disponiveis! Tente defender o castelo durante 3 dias e ganhe!","Ajuda",JOptionPane.PLAIN_MESSAGE);
            }
        });
      aboutJMI.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 JOptionPane.showMessageDialog(CardSiegeView.this,"9 Card Siege GameBoard","Acerca",JOptionPane.PLAIN_MESSAGE);
            }
        });
    }
/*
    class ObjMenuBarListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(CardSiegeView.this, "Fechou o Jogo","Sair",JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }

    }
        
     class CarregarObjMenuBarListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser("./data");
                int returnVal = fc.showOpenDialog(CardSiegeView.this);

                if(returnVal == JFileChooser.APPROVE_OPTION)
                {
                    File file = fc.getSelectedFile();

                    try{
                        game.setGame((Jogo)Ficheiros.CarregarJogo(file));
                    }catch(IOException | ClassNotFoundException ex){
                        JOptionPane.showMessageDialog(CardSiegeView.this,"Operacao Falhou \r\n\r\n" + e);
                    }
                } else{
                    System.out.println("Operacao cancelada");
                }
            }
    
        }
      
      class GravarObjMenuBarListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser("./data");
                int returnVal = fc.showOpenDialog(CardSiegeView.this);

                if(returnVal == JFileChooser.APPROVE_OPTION)
                {
                    File file = fc.getSelectedFile();

                    try{
                        game.setGame((Jogo)Ficheiros.CarregarJogo(file));
                    }catch(IOException | ClassNotFoundException ex){
                        JOptionPane.showMessageDialog(CardSiegeView.this,"Operação falhou \r\n\r\n" + e);
                    }
                } else{
                    System.out.println("Operação Falhou");
                }
            }
    
        }
      
       class SairListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                 JOptionPane.showMessageDialog(CardSiegeView.this, "Fechou o Jogo","Sair",JOptionPane.PLAIN_MESSAGE);
                 System.exit(0);
            }
    
        }
       
       class AjudaListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                 JOptionPane.showMessageDialog(CardSiegeView.this,"Carregue nas Opções disponiveis! Tente defender o castelo durante 3 dias e ganhe!","Ajuda",JOptionPane.PLAIN_MESSAGE);
            }
    
        }
       
       class AcercaListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                 JOptionPane.showMessageDialog(CardSiegeView.this,"9 Card Siege GameBoard","Acerca",JOptionPane.PLAIN_MESSAGE);
            }
    
        }
       */
       
    @Override
    public void update(Observable o, Object arg) {
        revalidate();
        repaint();
    }
    
}
