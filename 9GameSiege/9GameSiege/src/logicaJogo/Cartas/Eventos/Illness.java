/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Cartas.Eventos;

/**
 *
 * @author Andre
 */
public class Illness extends Evento{
    
    public Illness(){
        super("Illness", 2, new String[]{"tower"}, new String[]{"reduce-morale", "reduce-supplies"}, new String[]{"1", "1"}, 
                "O grupo das torres avanca uma casa.\nUma doença espalhou-se pelos habitantes. Este acontecimento a afetou a morale e os suplementos por 1.");
    }
}