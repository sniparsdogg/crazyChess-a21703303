package pt.ulusofona.lp2.crazyChess;

public class PadreVila extends CrazyPiece {
    public boolean jogadaValida(int xO, int xD, int yO, int yD, Simulador simulador) {
        for(int i = 0; i < 3; i++) {
            if((xD == xO + i || xD == xO - i) && (yD == yO + i || yD == yO - i)) {
                if (xD == xO && yD == yO || (xD < 0 || xD > simulador.getTamanhoTabuleiro()) || (yD < 0 || yD > simulador.getTamanhoTabuleiro()) ) {
                    return false;
                }
                if(i >= 2){
                    if(xO > xD && yO > yD) { // diagonal noroeste
                        for(int j = 0; j < simulador.getPecasMalucas().size(); i++){
                            if((simulador.getPecasMalucas().get(j).getPosicao().x < xO && simulador.getPecasMalucas().get(j).getPosicao().x > xD) && (simulador.getPecasMalucas().get(j).getPosicao().y < yO && simulador.getPecasMalucas().get(j).getPosicao().y > yD)){
                                return false;
                            }
                        }
                    } else if(xO < xD && yO > yD) { // diagonal nordeste
                        for(int j = 0; j < simulador.getPecasMalucas().size(); j++){
                            if((simulador.getPecasMalucas().get(j).getPosicao().x > xO && simulador.getPecasMalucas().get(j).getPosicao().x < xD) && (simulador.getPecasMalucas().get(j).getPosicao().y < yO && simulador.getPecasMalucas().get(j).getPosicao().y > yD)){
                                return false;
                            }
                        }
                    } else if(xO > xD && yO < yD) { // diagonal sudoeste
                        for(int j = 0; j < simulador.getPecasMalucas().size(); i++){
                            if((simulador.getPecasMalucas().get(j).getPosicao().x < xO && simulador.getPecasMalucas().get(j).getPosicao().x > xD) && (simulador.getPecasMalucas().get(j).getPosicao().y > yO && simulador.getPecasMalucas().get(j).getPosicao().y < yD)){
                                return false;
                            }
                        }
                    } else if(xO < xD && yO < yD) { // diagonal sudeste
                        for(int j = 0; j < simulador.getPecasMalucas().size(); i++){
                            if((simulador.getPecasMalucas().get(j).getPosicao().x > xO && simulador.getPecasMalucas().get(j).getPosicao().x < xD) && (simulador.getPecasMalucas().get(j).getPosicao().y > yO && simulador.getPecasMalucas().get(j).getPosicao().y < yD)){
                                return false;
                            }
                        }
                    }
                    }
                    CrazyPiece pecaATestar = simulador.pecaNaPosicao(this.posicao.x - 1, this.posicao.y -1);
                    if(pecaATestar.getIdTipo() != 1 ){
                        pecaATestar = simulador.pecaNaPosicao(this.posicao.x, this.posicao.y - 1);
                        if(pecaATestar.getIdTipo() != 1){
                            pecaATestar = simulador.pecaNaPosicao(this.posicao.x + 1, this.posicao.y -1);
                            if(pecaATestar.getIdTipo() != 1) {
                                pecaATestar = simulador.pecaNaPosicao(this.posicao.x + 1, this.posicao.y);
                                if(pecaATestar.getIdTipo() != 1){
                                    pecaATestar = simulador.pecaNaPosicao(this.posicao.x + 1, this.posicao.y + 1);
                                    if(pecaATestar.getIdTipo() != 1){
                                        pecaATestar = simulador.pecaNaPosicao(this.posicao.x, this.posicao.y + 1);
                                        if(pecaATestar.getIdTipo() != 1){
                                            pecaATestar = simulador.pecaNaPosicao(this.posicao.x - 1, this.posicao.y + 1);
                                            if(pecaATestar.getIdTipo() != 1){
                                                pecaATestar = simulador.pecaNaPosicao(this.posicao.x + 1, this.posicao.y);
                                                if(pecaATestar.getIdTipo() != 1){
                                                    return true;
                                                }
                                            }
                                        }
                                    }
                                }
                                }
                            }
                        }
                    }
                }
        return false;
    }

    @Override
    public String toString() {
        if (this.capturada) {
            return (this.id + "| Padre da Vila | 3 | " + this.idEquipa + " | " + this.alcunha + " @ (n/a)");
        }
        return (this.id + " | Padre da Vila | 3 | " + this.idEquipa + " | " + this.alcunha + " @ " + this.posicao);
    }

}
