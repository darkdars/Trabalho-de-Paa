/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.grafico.gui;

import iu.grafico.ObservableGame;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import logicaJogo.estados.AwaitEndDayPhase;
import logicaJogo.estados.AwaitPlayerAction;
import logicaJogo.estados.AwaitTopCard;

/**
 *
 * @author jhssi
 */
public class StatusCardPanel extends JPanel implements Observer {

    ObservableGame game;
    String imageFiles[] ={"imagens/statusCard.PNG","imagens/piaoVerde.png","imagens/piaoPreto.png"};
    Image imagem[]= new Image[imageFiles.length];
    boolean loaded = false;
    
    StatusCardPanel(ObservableGame g) {
        game = g;
        game.addObserver(this);
        
        setupLayout();
        
        setVisible(game.getEstado() instanceof AwaitTopCard);
    }
    
    
      Image getImagem(ObservableGame game,int i)
    {

       if(!loaded){
           int j=0;
           loaded=true;
           for(String fileName:imageFiles){
               try {
            imagem[j++] = ImageIO.read(Resources.getResourceFile(fileName));
            } catch (IOException ex) {
            }
           }
       }
       
       return imagem[i];
    }
    
    
     @Override
    public void paintComponent(Graphics g)
    {

        int width_image =241;
        int height_image = 336;
       
        super.paintComponent(g);
            
        g.drawImage(getImagem(game,0),200,250,width_image,height_image,null);
        g.drawRect(200,250,width_image,height_image);
        
        //resto das opcoes
        
        
    }

     private void setupLayout() {
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    }
    
    @Override
    public void update(Observable o, Object arg) {
       setVisible(game.getEstado() instanceof AwaitTopCard || game.getEstado() instanceof AwaitPlayerAction || game.getEstado() instanceof AwaitEndDayPhase);
       revalidate();
       repaint();
    }

  
}
