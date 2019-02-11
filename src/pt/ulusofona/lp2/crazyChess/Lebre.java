package pt.ulusofona.lp2.crazyChess;

public class Lebre extends CrazyPiece {
    int valorRelativo = 2;
    public boolean jogadaValida(int xO, int xD, int yO, int yD, Simulador simulador) {
        if (simulador.turno % 2 == 0) {
            if ((xD == xO - 1 || xD == xO + 1) && (yD == yO - 1 || yD == yO + 1)) {
                if (xD == xO && yD == yO || (xD < 0 || xD > simulador.getTamanhoTabuleiro() - 1) || (yD < 0 || yD > simulador.getTamanhoTabuleiro() - 1) ) {
                    return false;
                }
                for (int i = 0; i < simulador.getPecasEmJogo().size(); i++){
                    if(simulador.getPecasEmJogo().get(i).getPosicao().x == xD && simulador.getPecasEmJogo().get(i).getPosicao().y == yD && simulador.getPecasEmJogo().get(i).getIdEquipa() == this.idEquipa){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public int getValorRelativo(){
        return valorRelativo;
    }

    @Override
    public String toString() {
        if (this.capturada) {
            return (this.id + " | Lebre | 2 | " + this.idEquipa + " | " + this.alcunha + " @ (n/a)");
        }
        return (this.id + " | Lebre  | 2 | " + this.idEquipa + " | " + this.alcunha + " @ (" + this.posicao + ")");
    }

    public String getImagePNG(){ // Getter da imagem.
        if(this.getIdEquipa() == 10) {
            return("lebrePreta.png");
        }
        return("lebreBranca.png");
    }

}
