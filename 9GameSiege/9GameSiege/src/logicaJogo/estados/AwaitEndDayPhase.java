/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.estados;

import logicaJogo.DadosJogo;

/**
 *
 * @author jhssi
 */
public class AwaitEndDayPhase extends EstadoAdapter{
    
    public AwaitEndDayPhase(DadosJogo dadosJogo) {
        super(dadosJogo);
    }
    
    @Override
    public IEstado endDayPhase(){
        
        //Check if we win
        if(dadosJogo.getDia() > 3){
            dadosJogo.setTexto("Parabens!!!! Sobreviveu aos ataques do inimigo!");
            return this;
        }
        
        //Suplies reduction
        dadosJogo.getStatusCard().setMantimentos(dadosJogo.getStatusCard().getMantimentos() - 1);
        
        //soldiers back to the tunnel
        if(dadosJogo.getStatusCard().getTunel() == 2 || dadosJogo.getStatusCard().getTunel() == 3){
            dadosJogo.getStatusCard().setTunel(1);
            
            if(dadosJogo.getStatusCard().getMantimentos() != 4){
             
            if(dadosJogo.getStatusCard().getMantimentos() == 3){
                if(dadosJogo.getStatusCard().getMantimentosRoubados() == 2){
                    dadosJogo.getStatusCard().setMantimentos(dadosJogo.getStatusCard().getMantimentos() + 1);
                }else{
                    dadosJogo.getStatusCard().setMantimentos(dadosJogo.getStatusCard().getMantimentos() + dadosJogo.getStatusCard().getMantimentosRoubados());
                }
            }else{
                 dadosJogo.getStatusCard().setMantimentos(dadosJogo.getStatusCard().getMantimentos() + dadosJogo.getStatusCard().getMantimentosRoubados());
            }    
                
            }
            
            dadosJogo.getStatusCard().setMantimentosRoubados(0);
        }
        
        // If are enemys on enemy line space capture
       // if(dadosJogo.getEnemyTracks())
        
        
        return new AwaitLineCheck(dadosJogo);
    }
    
}
