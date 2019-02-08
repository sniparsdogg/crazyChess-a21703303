package pt.ulusofona.lp2.crazyChess;

public class TorreHor extends CrazyPiece {
    public boolean jogadaValida(int xO, int xD, int yO, int yD, Simulador simulador) {
        if(yO == yD) {
            if (xD == xO && yD == yO || (xD < 0 || xD > simulador.getTamanhoTabuleiro()) || (yD < 0 || yD > simulador.getTamanhoTabuleiro()) ) {
                return false;
            }
            if(xD < xO){
                for(int i = 0; i < simulador.getPecasMalucas().size(); i++){
                    if(simulador.getPecasMalucas().get(i).getPosicao().x < xO && simulador.getPecasMalucas().get(i).getPosicao().x > xD  && simulador.getPecasMalucas().get(i).getPosicao().y == yD){
                        return false;
                    }
                }
            } else if (xD > xO) {
                for(int i = 0; i < simulador.getPecasMalucas().size(); i++){
                    if(simulador.getPecasMalucas().get(i).getPosicao().x > xO && simulador.getPecasMalucas().get(i).getPosicao().x < xD  && simulador.getPecasMalucas().get(i).getPosicao().y == yD){
                        return false;
                    }
                }
            } else {
                for (int i = 0; i < simulador.getPecasMalucas().size(); i++){
                    if(simulador.getPecasMalucas().get(i).getPosicao().x == xD && simulador.getPecasMalucas().get(i).getPosicao().y == yD && simulador.getPecasMalucas().get(i).getIdEquipa() == this.idEquipa){
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.capturada) {
            return (this.id + "| TorreH | 3 | " + this.idEquipa + " | " + this.alcunha + " @ (n/a)");
        }
        return (this.id + " | TorreH | 3 | " + this.idEquipa + " | " + this.alcunha + " @ " + this.posicao);
    }

}
