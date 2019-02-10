package pt.ulusofona.lp2.crazyChess;

public class TorreVert extends CrazyPiece {
    int valorRelativo = 3;
    public boolean jogadaValida(int xO, int xD, int yO, int yD, Simulador simulador) {
        if(xD == xO) {
            if (xD == xO && yD == yO || (xD < 0 || xD > simulador.getTamanhoTabuleiro()) || (yD < 0 || yD > simulador.getTamanhoTabuleiro()) ) {
                return false;
            }
            for (int i = 0; i < simulador.getPecasMalucas().size(); i++) {
                if (simulador.getPecasMalucas().get(i).getPosicao().x == xD && simulador.getPecasMalucas().get(i).getPosicao().y == yD && simulador.getPecasMalucas().get(i).getIdEquipa() == this.idEquipa) {
                    return false;
                }
            }
            if(yD < yO){
                for(int i = 0; i < simulador.getPecasMalucas().size(); i++){
                    if(simulador.getPecasMalucas().get(i).getPosicao().y < yO && simulador.getPecasMalucas().get(i).getPosicao().y > yD  && simulador.getPecasMalucas().get(i).getPosicao().x == xD){
                        return false;
                    }
                }
            } else if (yD > yO) {
                for(int i = 0; i < simulador.getPecasMalucas().size(); i++){
                    if(simulador.getPecasMalucas().get(i).getPosicao().y > yO && simulador.getPecasMalucas().get(i).getPosicao().y < yD  && simulador.getPecasMalucas().get(i).getPosicao().x == xD){
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

    public int getValorRelativo(){
        return valorRelativo;
    }

    @Override
    public String toString() {
        if (this.capturada) {
            return (this.id + "| TorreV | 3 | " + this.idEquipa + " | " + this.alcunha + " @ (n/a)");
        }
        return (this.id + " | TorreV | 3 | " + this.idEquipa + " | " + this.alcunha + " @ " + this.posicao);
    }

    public String getImagePNG(){ // Getter da imagem.
        if(this.getIdEquipa() == 10) {
            return("torreVPreta.png");
        }
        return("torreVBranca.png");
    }
}
