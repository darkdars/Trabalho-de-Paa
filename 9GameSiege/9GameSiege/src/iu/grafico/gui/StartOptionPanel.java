/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico.gui;

import iu.grafico.ObservableGame;
import java.awt.Component;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import logicaJogo.estados.AwaitBeginning;

/**
 *
 * @author jhssi
 */
public class StartOptionPanel extends JPanel implements Observer{

    ObservableGame game;
    
    //Opcoes
     JButton start=new JButton("Start Game");
     JButton sair = new JButton("Sair");
     
     //Imagem
     String imageFiles ="images/homepage.PNG";
     Image home;
     
     
     StartOptionPanel(ObservableGame g)
    {
        game=g;
        game.addObserver(this);

        setupComponentes();
        setupLayout();
        
        setVisible(game.getEstado() instanceof AwaitBeginning);
    }
     
     private void setupLayout()
    {
      
         validate();
        
    }
     
     private void setupComponentes(){
      
     }
     
     
     
    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}