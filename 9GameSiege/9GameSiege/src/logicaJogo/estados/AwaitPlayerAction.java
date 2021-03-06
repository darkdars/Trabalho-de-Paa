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
public class AwaitPlayerAction extends EstadoAdapter{
    
    public AwaitPlayerAction(DadosJogo dadosJogo) {
        super(dadosJogo);
    }
    
    @Override
    public IEstado playerAction(int opcao, int target){
        dadosJogo.rollDice();
        switch(opcao){
            case 0:
                return new AwaitEndDayPhase(dadosJogo);
            case 1: // Archers Attack
                switch(target){
                    //Acrescentar um ao dado dependendo do evento
                    case 1: // Ladders
                        if(dadosJogo.getEnemyTracks().getEscada() != 4){
                            if(dadosJogo.getDice() + dadosJogo.getBonusEvent(0) + dadosJogo.getBonusEnemy(3)> dadosJogo.getEnemyTracks().getEscadaStrengh()){
                                dadosJogo.getEnemyTracks().setEscada(dadosJogo.getEnemyTracks().getEscada() + 1);
                                dadosJogo.setTexto("Ataque bem sucedido! Ladders Movida para a posicao: " + dadosJogo.getEnemyTracks().getEscada());
                            }else{
                                dadosJogo.setTexto("O ataque falhou!");
                            }    
 
                        }else{
                            dadosJogo.setTexto("Nao da para mover! A Escada ja esta na posicao inicial!");
                            return this;
                        }

                        break;
                    case 2: // Battering Ram
                         if(dadosJogo.getEnemyTracks().getAriete() != 4){
                            if(dadosJogo.getDice() + dadosJogo.getBonusEvent(0) + dadosJogo.getBonusEnemy(2)> dadosJogo.getEnemyTracks().getArieteStrengh()){
                                dadosJogo.getEnemyTracks().setAriete(dadosJogo.getEnemyTracks().getAriete() + 1);
                                dadosJogo.setTexto("Ataque bem sucedido! Battering Ram Movida para posicao: " + dadosJogo.getEnemyTracks().getAriete());
                            }else{
                                dadosJogo.setTexto("O ataque falhou!");
                            }    
 
                        }else{
                            dadosJogo.setTexto("Nao da para mover! O ariete ja esta na posicao inicial!");
                            return this;
                        }
          
                        break;
                    case 3: // Siege Tower
                        
                        if(dadosJogo.getEnemyTracks().isVidaTorre() == false){
                            dadosJogo.setTexto("Nao existe torre! Escolha outra opcao!");
                            return this;
                        }
                        
                        
                         if(dadosJogo.getEnemyTracks().getTorre() != 4){
                            if(dadosJogo.getDice() + dadosJogo.getBonusEvent(0) + dadosJogo.getBonusEnemy(1)> dadosJogo.getEnemyTracks().getTorreStrengh()){
                                dadosJogo.getEnemyTracks().setTorre(dadosJogo.getEnemyTracks().getTorre() + 1);
                                dadosJogo.setTexto("Ataque bem sucedido! Siege Tower Movida para posicao: " + dadosJogo.getEnemyTracks().getTorre());
                            }else{
                                dadosJogo.setTexto("O ataque falhou!");
                            }    
 
                        }else{
                            dadosJogo.setTexto("Nao da para mover! A Torre ja esta na posicao inicial!");
                            return this;
                        }
                        break;
                }
                break;
            case 2: // Boiling Water Attack
                switch(target){
                    //Acrescentar um ao dado dependendo do evento
                    case 1: // Ladders
                        if(dadosJogo.getEnemyTracks().getEscada() == 1){
                            if(dadosJogo.getDice() + 1 + dadosJogo.getBonusEvent(1) + dadosJogo.getBonusEnemy(3)> dadosJogo.getEnemyTracks().getEscadaStrengh()){
                                dadosJogo.getEnemyTracks().setEscada(dadosJogo.getEnemyTracks().getEscada() + 1);
                                dadosJogo.setTexto("Ataque bem sucedido! Ladders Movida para a posicao: " + dadosJogo.getEnemyTracks().getEscada());
                            }else{
                                dadosJogo.setTexto("O ataque falhou!");
                            }    
 
                        }else{
                            dadosJogo.setTexto("Nao da para atacar! A Escada nao esta dentro do circulo (casa 1)!");
                            return this;
                        }
                        
                        break;
                    case 2: // Battering Ram
                         if(dadosJogo.getEnemyTracks().getAriete() == 1){
                            if(dadosJogo.getDice() + 1 + dadosJogo.getBonusEvent(1) + dadosJogo.getBonusEnemy(2)> dadosJogo.getEnemyTracks().getArieteStrengh()){
                                dadosJogo.getEnemyTracks().setAriete(dadosJogo.getEnemyTracks().getAriete() + 1);
                                dadosJogo.setTexto("Ataque bem sucedido! Battering Ram Movida para posicao: " + dadosJogo.getEnemyTracks().getAriete());
                            }else{
                                dadosJogo.setTexto("O ataque falhou!");
                            }    
 
                        }else{
                            dadosJogo.setTexto("Nao da para atacar! A Ariete nao esta dentro do circulo (casa 1)!");
                            return this;
                        }
          
                        break;
                    case 3: // Siege Tower
                         if(dadosJogo.getEnemyTracks().isVidaTorre() == false){
                            dadosJogo.setTexto("Nao existe torre! Escolha outra opcao!");
                            return this;
                        }
                        
                         if(dadosJogo.getEnemyTracks().getTorre() == 1){
                            if(dadosJogo.getDice() + 1 + dadosJogo.getBonusEvent(1) + dadosJogo.getBonusEnemy(1)> dadosJogo.getEnemyTracks().getTorreStrengh()){
                                dadosJogo.getEnemyTracks().setTorre(dadosJogo.getEnemyTracks().getTorre() + 1);
                                dadosJogo.setTexto("Ataque bem sucedido! Siege Tower Movida para posicao: " + dadosJogo.getEnemyTracks().getTorre());
                            }else{
                                dadosJogo.setTexto("O ataque falhou!");
                            }    
 
                        }else{
                            dadosJogo.setTexto("Nao da para atacar! A Torre nao esta dentro do circulo (casa 1)!");
                            return this;
                        }
                        break;
                }
                dadosJogo.setOpcoesUtilizadasIndice(1);
                break;
            case 3: // Close Combat Attack
                switch(target){
                    //Acrescentar um ao dado dependendo do evento
                    case 1: // Ladders
                        if(dadosJogo.getEnemyTracks().getEscada() == 0){
                            if(dadosJogo.getDice() + dadosJogo.getBonusEvent(2) + dadosJogo.getBonusEnemy(3)> dadosJogo.getEnemyTracks().getEscadaStrengh()){
                                dadosJogo.getEnemyTracks().setEscada(dadosJogo.getEnemyTracks().getEscada() + 1);
                                dadosJogo.setTexto("Ataque bem sucedido! Ladders Movida para a posicao: " + dadosJogo.getEnemyTracks().getEscada());
                            }else{
                                dadosJogo.setTexto("O ataque falhou!");
                            }    
 
                        }else{
                            dadosJogo.setTexto("Nao da para atacar! A Escada nao se encontra dentro da zona de close combat (casa 0)!");
                            return this;
                        }
                        
                        break;
                    case 2: // Battering Ram
                         if(dadosJogo.getEnemyTracks().getAriete() == 0){
                            if(dadosJogo.getDice() + dadosJogo.getBonusEvent(2) + dadosJogo.getBonusEnemy(2)> dadosJogo.getEnemyTracks().getArieteStrengh()){
                                dadosJogo.getEnemyTracks().setAriete(dadosJogo.getEnemyTracks().getAriete() + 1);
                                dadosJogo.setTexto("Ataque bem sucedido! Battering Ram Movida para posicao: " + dadosJogo.getEnemyTracks().getAriete());
                            }else{
                                dadosJogo.setTexto("O ataque falhou!");
                            }    
 
                        }else{
                            dadosJogo.setTexto("Nao da para atacar! A Ariete nao se encontra dentro da zona de close combat (casa 0)!");
                            return this;
                        }
          
                        break;
                    case 3: // Siege Tower
                        if(dadosJogo.getEnemyTracks().isVidaTorre() == false){
                            dadosJogo.setTexto("Nao existe torre! Escolha outra opcao!");
                            return this;
                        }
                        
                         if(dadosJogo.getEnemyTracks().getTorre() == 0){
                            if(dadosJogo.getDice() + dadosJogo.getBonusEvent(2) + dadosJogo.getBonusEnemy(1)> dadosJogo.getEnemyTracks().getTorreStrengh()){
                                dadosJogo.getEnemyTracks().setTorre(dadosJogo.getEnemyTracks().getTorre() + 1);
                                dadosJogo.setTexto("Ataque bem sucedido! Siege Tower Movida para posicao: " + dadosJogo.getEnemyTracks().getTorre());
                            }else{
                                dadosJogo.setTexto("O ataque falhou!");
                            }    
 
                        }else{
                            dadosJogo.setTexto("Nao da para atacar! A Torre nao se encontra dentro da zona de close combat (casa 0)!");
                            return this;
                       }
                        break;
                }
                break;
            case 4: // Coupure
                if(dadosJogo.getStatusCard().getMuralha() < 4){
                    if(dadosJogo.getDice() + dadosJogo.getBonusEvent(3)> 4){
                        dadosJogo.getStatusCard().updateMuralha(1);
                        dadosJogo.setTexto("A muralha foi reparada com sucesso. Ficou com o valor " + dadosJogo.getStatusCard().getMuralha() + ".");
                    }else{
                        dadosJogo.setTexto("Houve um assidente que levou a falha da recuperacao da muralha.");
                    }
                }else{
                        dadosJogo.setTexto("A muralha encontra-se sem dano.");
                        return this;
                } 
                break;
            case 5: // Rally Trops
                if(dadosJogo.getStatusCard().getMoral() < 4){
                    if((dadosJogo.getDice() + target + dadosJogo.getBonusEvent(4)) > 4){
                        dadosJogo.getStatusCard().updateMoral(1);
                        dadosJogo.setTexto("A moral foi levantada com sucesso. Ficou com o valor " + dadosJogo.getStatusCard().getMoral()+ ".");
                    }else{
                        dadosJogo.setTexto("O discurso foi mal intrepertado pelo povo, mantendo a moral no mesmo nivel.");
                    }
                }else{
                        dadosJogo.setTexto("A moral encontra-se ao maximo.");
                        return this;
                }
                break;
            case 6: // Tunnel Movement
                switch(target){
                    //Acrescentar um ao dado dependendo do evento
                    case 1: // Entrar no tunel
                        if(dadosJogo.getStatusCard().getTunel() == 1){
                            dadosJogo.getStatusCard().updateTunel(1);
                            dadosJogo.setTexto("As tropas estao no(a) " + dadosJogo.getStatusCard().getTunelString() + " .");
                        }else{
                                dadosJogo.setTexto("As tropas ja se encontram dentro do tunel.");
                                return this;
                        }
                        break;
                    case 2: // Free Movement
                         if((dadosJogo.getStatusCard().getTunel() > 1 && dadosJogo.getStatusCard().isTunelDir()) || (dadosJogo.getStatusCard().getTunel() < 4 && !dadosJogo.getStatusCard().isTunelDir())){
                            dadosJogo.getStatusCard().updateTunel(1);
                            dadosJogo.setTexto("As tropas estao no(a) " + dadosJogo.getStatusCard().getTunelString() + " .");
                        }else{
                                dadosJogo.setTexto("As tropas nao se encontram dentro do tunel.");
                        }
                        return this;
                    case 3: // Fast Movement
                         if((dadosJogo.getStatusCard().getTunel() > 1 && dadosJogo.getStatusCard().isTunelDir()) || (dadosJogo.getStatusCard().getTunel() < 4 && !dadosJogo.getStatusCard().isTunelDir())){
                            if(dadosJogo.getStatusCard().isTunelDir()){
                                dadosJogo.getStatusCard().setTunel(4);
                                dadosJogo.getStatusCard().setTunelDir(false);
                                dadosJogo.setTexto("As tropas estao no(a) " + dadosJogo.getStatusCard().getTunelString() + " .");
                                break;
                            }
                            if(!dadosJogo.getStatusCard().isTunelDir()){
                                dadosJogo.getStatusCard().setTunel(1);
                                dadosJogo.getStatusCard().setTunelDir(true);
                                dadosJogo.setTexto("As tropas estao no(a) " + dadosJogo.getStatusCard().getTunelString() + " .");
                            } 
                        }else{
                                dadosJogo.setTexto("As tropas encontram fora do tunel.");
                                return this;
                        }
                        break;
                }
                break;
            case 7: // Supply Raid
                if(dadosJogo.getStatusCard().getTunel() == 4){
                    if(dadosJogo.getStatusCard().getMantimentosRoubados() < 2){
                        if(dadosJogo.getDice() + dadosJogo.getBonusEvent(6) + dadosJogo.getBonusEnemy(0)> 2 && dadosJogo.getDice() < 6){
                            dadosJogo.getStatusCard().updateMantimentosRoubados(1);
                            dadosJogo.setTexto("As tropas obtiveram uma caixa de suplementos. No total tem " + dadosJogo.getStatusCard().getMantimentosRoubados() + ".");
                            break;
                        }
                        if(dadosJogo.getDice() >= 6){
                            dadosJogo.getStatusCard().updateMantimentosRoubados(2);
                            dadosJogo.setTexto("As tropas obtiveram duas caixa de suplementos. No total tem " + dadosJogo.getStatusCard().getMantimentosRoubados() + ".");
                            break;
                        }
                        if(dadosJogo.getDice() == 1){
                            dadosJogo.getStatusCard().updateMoral(-1);
                            dadosJogo.getStatusCard().setTunel(1);
                            dadosJogo.getStatusCard().setTunelDir(true);
                            dadosJogo.getStatusCard().setMantimentosRoubados(0);
                            dadosJogo.setTexto("As tropas foram capturadas, perdeu todos os mantimentos roubados e vai ter de enviar novas tropas. Devido a perda dos soldados a moral e reduzida por 1.");
                            break;
                        }
                    }else{
                            dadosJogo.setTexto("As tropas encontram-se sobrecarregadas, nao conseguem roubar mais mantimentos.");
                            return this;
                    }
                }else{
                    dadosJogo.setTexto("Tem de estar nas linhas inimigas para realizar uma raid de mantimentos.");
                    return this;
                }
                
                break;
            case 8: // Sabotage
                if(dadosJogo.getStatusCard().getTunel() == 4){
                    if(dadosJogo.getEnemyTracks().getTrincheiras()> 1){
                        if(dadosJogo.getDice() + dadosJogo.getBonusEvent(7) > 4){
                            dadosJogo.getEnemyTracks().updateTrincheiras(-1);
                            dadosJogo.setTexto("As tropas realizaram dano as Trebuchets, de momento os inimigos tem " + dadosJogo.getEnemyTracks().getAriete() + ".");
                            break;
                        }
                        if(dadosJogo.getDice() == 1){
                            dadosJogo.getStatusCard().updateMoral(-1);
                            dadosJogo.getStatusCard().setTunel(1);
                            dadosJogo.getStatusCard().setTunelDir(true);
                            dadosJogo.getStatusCard().setMantimentosRoubados(0);
                            dadosJogo.setTexto("As tropas foram capturadas, perdeu todos os mantimentos roubados e vai ter de enviar novas tropas. Devido a perda dos soldados a moral e reduzida por 1.");
                            break;
                        }
                    }else{
                            dadosJogo.setTexto("As tropas nao conseguem atacar. Tente mais tarde");
                            return this;
                    }
                }else{
                    dadosJogo.setTexto("Tem de estar nas linhas inimigas para realizar uma sabotagem.");
                    return this;
                }
                break;
        }
        
        dadosJogo.setJogadasDisp(dadosJogo.getJogadasDisp() - 1);
        
            if(dadosJogo.checkEnemyCloseCombat() >= 3 || dadosJogo.check0SpaceStatusTrack() >= 2){
                dadosJogo.setTexto("Perdeu!");
            return new AwaitEnd(dadosJogo); 
        }
        
        return this;
    }
    
    @Override
    public IEstado checkJogadasDisp(){
        if(dadosJogo.getJogadasDisp() == 0){
            dadosJogo.setListaCards(dadosJogo.getListaCards() + 1);
            return new AwaitEndDayPhase(dadosJogo);
        }
        return this;
    }
    
    @Override
    public IEstado skipCard(){
        dadosJogo.setListaCards(dadosJogo.getListaCards() + 1);
        return new AwaitEndDayPhase(dadosJogo);
    }
    
    @Override
    public IEstado archerAttck(){
        return new AwaitArchersAttack(dadosJogo);
    }
    
    @Override
    public IEstado boilingWater(){
        return new AwaitBoilingWatter(dadosJogo);
    }
    
    @Override
    public IEstado closeCombat(){
        return new AwaitCloseCombat(dadosJogo);
    }
    
    @Override
    public IEstado rally(){
        return new AwaitRally(dadosJogo);
    }
    
    @Override
    public IEstado tunnel(){
        return new AwaitTunnel(dadosJogo);
    }
    
    @Override
    public IEstado coupure(){
        dadosJogo.rollDice();
        if(dadosJogo.getStatusCard().getMuralha() < 4){
            if(dadosJogo.getDice() + dadosJogo.getBonusEvent(3)> 4){
                dadosJogo.getStatusCard().updateMuralha(1);
                dadosJogo.setTexto("A muralha foi reparada com sucesso. Ficou com o valor " + dadosJogo.getStatusCard().getMuralha() + ".");
            }else{
                dadosJogo.setTexto("Houve um acidente que levou a falha da recuperacao da muralha.");
            }
            dadosJogo.setJogadasDisp(dadosJogo.getJogadasDisp() - 1);
        }else{
                dadosJogo.setTexto("A muralha encontra-se sem dano.");
        } 
        return this;
    }
    
    @Override
    public IEstado supplyRaid(){
        dadosJogo.rollDice();
        
        if(dadosJogo.getStatusCard().getTunel() == 4){
            if(dadosJogo.getStatusCard().getMantimentosRoubados() < 2){
                if(dadosJogo.getDice() + dadosJogo.getBonusEvent(6) + dadosJogo.getBonusEnemy(0)> 2 && dadosJogo.getDice() < 6){
                    dadosJogo.getStatusCard().updateMantimentosRoubados(1);
                    dadosJogo.setTexto("As tropas obtiveram uma caixa de suplementos. No total tem " + dadosJogo.getStatusCard().getMantimentosRoubados() + ".");
                }
                if(dadosJogo.getDice() >= 6){
                    dadosJogo.getStatusCard().updateMantimentosRoubados(2);
                    dadosJogo.setTexto("As tropas obtiveram duas caixa de suplementos. No total tem " + dadosJogo.getStatusCard().getMantimentosRoubados() + ".");
                }
                if(dadosJogo.getDice() == 1){
                    dadosJogo.getStatusCard().updateMoral(-1);
                    dadosJogo.getStatusCard().setTunel(1);
                    dadosJogo.getStatusCard().setTunelDir(true);
                    dadosJogo.getStatusCard().setMantimentosRoubados(0);
                    dadosJogo.setTexto("As tropas foram capturadas, perdeu todos os mantimentos roubados e vai ter de enviar novas tropas. Devido a perda dos soldados a moral e reduzida por 1.");
                }
                dadosJogo.setJogadasDisp(dadosJogo.getJogadasDisp() - 1);
            }else{
                    dadosJogo.setTexto("As tropas encontram-se sobrecarregadas, nao conseguem roubar mais mantimentos.");
            }
        }else{
            dadosJogo.setTexto("Tem de estar nas linhas inimigas para realizar uma raid de mantimentos.");
        }
        return this;
    }
    
    @Override
    public IEstado sabotage(){
        dadosJogo.rollDice();
        
        if(dadosJogo.getStatusCard().getTunel() == 4){
            if(dadosJogo.getEnemyTracks().getTrincheiras()> 1){
                if(dadosJogo.getDice() + dadosJogo.getBonusEvent(7) > 4){
                    dadosJogo.getEnemyTracks().updateTrincheiras(-1);
                    dadosJogo.setTexto("As tropas realizaram dano as Trebuchets, de momento os inimigos tem " + dadosJogo.getEnemyTracks().getAriete() + ".");
                }
                if(dadosJogo.getDice() == 1){
                    dadosJogo.getStatusCard().updateMoral(-1);
                    dadosJogo.getStatusCard().setTunel(1);
                    dadosJogo.getStatusCard().setTunelDir(true);
                    dadosJogo.getStatusCard().setMantimentosRoubados(0);
                    dadosJogo.setTexto("As tropas foram capturadas, perdeu todos os mantimentos roubados e vai ter de enviar novas tropas. Devido a perda dos soldados a moral e reduzida por 1.");
                }
                dadosJogo.setJogadasDisp(dadosJogo.getJogadasDisp() - 1);
            }else{
                    dadosJogo.setTexto("As tropas nao conseguem atacar. Tente mais tarde");
            }
        }else{
            dadosJogo.setTexto("Tem de estar nas linhas inimigas para realizar uma sabotagem.");
        }
        return this;
    }
    @Override
    public IEstado cancel() {
        return this;
    }
    
    @Override
    public IEstado checkPoints(){
        if(dadosJogo.getJogadasDisp() <= 0){
            dadosJogo.setListaCards(dadosJogo.getListaCards() + 1);
            return new AwaitEndDayPhase(dadosJogo);        
        }
        return this;
    }
}
