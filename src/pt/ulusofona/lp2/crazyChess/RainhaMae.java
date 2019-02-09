package pt.ulusofona.lp2.crazyChess;

public class RainhaMae extends CrazyPiece {
    int movimentos = 0;
    public void somarMovimentos(){
        movimentos++;
    }
    @Override
    public boolean jogadaValida(int xO, int yO, int xD, int yD, Simulador simulador) {
        if((xD <= xO + 4 && xD >= xO - 4) || (yD <= yO + 4 && yD >= yO - 4)) {
            if (xD == xO && yD == yO || (xD < 0 || xD > simulador.getTamanhoTabuleiro()) || (yD < 0 || yD > simulador.getTamanhoTabuleiro()) ) {
                return false;
            }
            if(xO > xD && yO == yD) { // horizontal oeste
                for(int i = 0; i < simulador.getPecasMalucas().size(); i++){
                    if(simulador.getPecasMalucas().get(i).getPosicao().x < xO && simulador.getPecasMalucas().get(i).getPosicao().x > xD  && simulador.getPecasMalucas().get(i).getPosicao().y == yD){
                        return false;
                    }
                }
            } else if(xO < xD && yO == yD) { // horizontal este
                for(int i = 0; i < simulador.getPecasMalucas().size(); i++){
                    if(simulador.getPecasMalucas().get(i).getPosicao().x > xO && simulador.getPecasMalucas().get(i).getPosicao().x < xD  && simulador.getPecasMalucas().get(i).getPosicao().y == yD){
                        return false;
                    }
                }
            } else if (xO == xD && yO > yD) { // vertical norte
                for(int i = 0; i < simulador.getPecasMalucas().size(); i++){
                    if(simulador.getPecasMalucas().get(i).getPosicao().y < yO && simulador.getPecasMalucas().get(i).getPosicao().y > yD  && simulador.getPecasMalucas().get(i).getPosicao().x == xD){
                        return false;
                    }
                }
            } else if(xO == xD && yO < yD) { // vertical sul
                for(int i = 0; i < simulador.getPecasMalucas().size(); i++){
                    if(simulador.getPecasMalucas().get(i).getPosicao().y > yO && simulador.getPecasMalucas().get(i).getPosicao().y < yD  && simulador.getPecasMalucas().get(i).getPosicao().x == xD){
                        return false;
                    }
                }
            } else if(xO > xD && yO > yD) { // diagonal noroeste
                for(int i = 0; i < simulador.getPecasMalucas().size(); i++){
                    if((simulador.getPecasMalucas().get(i).getPosicao().x < xO && simulador.getPecasMalucas().get(i).getPosicao().x > xD) && (simulador.getPecasMalucas().get(i).getPosicao().y < yO && simulador.getPecasMalucas().get(i).getPosicao().y > yD)){
                        return false;
                    }
                }
            } else if(xO < xD && yO > yD) { // diagonal nordeste
                for(int i = 0; i < simulador.getPecasMalucas().size(); i++){
                    if((simulador.getPecasMalucas().get(i).getPosicao().x > xO && simulador.getPecasMalucas().get(i).getPosicao().x < xD) && (simulador.getPecasMalucas().get(i).getPosicao().y < yO && simulador.getPecasMalucas().get(i).getPosicao().y > yD)){
                        return false;
                    }
                }
            } else if(xO > xD && yO < yD) { // diagonal sudoeste
                for(int i = 0; i < simulador.getPecasMalucas().size(); i++){
                    if((simulador.getPecasMalucas().get(i).getPosicao().x < xO && simulador.getPecasMalucas().get(i).getPosicao().x > xD) && (simulador.getPecasMalucas().get(i).getPosicao().y > yO && simulador.getPecasMalucas().get(i).getPosicao().y < yD)){
                        return false;
                    }
                }
            } else if(xO < xD && yO < yD) { // diagonal sudeste
                for(int i = 0; i < simulador.getPecasMalucas().size(); i++){
                    if((simulador.getPecasMalucas().get(i).getPosicao().x > xO && simulador.getPecasMalucas().get(i).getPosicao().x < xD) && (simulador.getPecasMalucas().get(i).getPosicao().y > yO && simulador.getPecasMalucas().get(i).getPosicao().y < yD)){
                        return false;
                    }
                }
            } else { // verificação se a peça a obter é rainha
                for(int i = 0; i < simulador.getPecasMalucas().size(); i++){
                    if((simulador.getPecasMalucas().get(i).getPosicao().x == xD && simulador.getPecasMalucas().get(i).getPosicao().y == yD && (simulador.getPecasMalucas().get(i).getId() == 1 || simulador.getPecasMalucas().get(i).getIdEquipa() == this.idEquipa))){
                        return false;
                    }
                }
            }
            somarMovimentos();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
      //  if (this.capturada) {
            return (this.id + " | " + this.idEquipa + " | 7 | Rainha Mãe | " + this.alcunha + " | " + this.movimentos);
      //  }
      //  return (this.id + " | Rainha Mãe | 7 | " + this.idEquipa + " | " + this.alcunha + " @ " + this.posicao);
    }

}

