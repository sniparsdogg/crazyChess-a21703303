package pt.ulusofona.lp2.crazyChess;

public class Rei extends CrazyPiece {

    int valorRelativo = 1000;

    public boolean jogadaValida(int xO, int xD, int yO, int yD, Simulador simulador) {
        if ((xD == xO || xD == xO + 1 || xD == xO - 1) && (yD == yO || yD == yO + 1 || yD == yO - 1)) {
            if (xD == xO && yD == yO || (xD < 0 || xD > simulador.getTamanhoTabuleiro() - 1) || (yD < 0 || yD > simulador.getTamanhoTabuleiro() - 1) ) {
                return false;
            }
            for (int i = 0; i < simulador.getPecasMalucas().size(); i++) {
                if (simulador.getPecasMalucas().get(i).getPosicao().x == xD && simulador.getPecasMalucas().get(i).getPosicao().y == yD && simulador.getPecasMalucas().get(i).getIdEquipa() == this.idEquipa) {
                    return false;
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
            return (this.id + " | Rei | (infinito) | " + this.idEquipa + " | " + this.alcunha + " @ (n/a)");
        }
        return (this.id + " | Rei | (infinito) | " + this.idEquipa + " | " + this.alcunha + " @ (" + this.posicao + ")");
    }

    @Override
    public String getImagePNG(){ // Getter da imagem.
        if(this.getIdEquipa() == 10) {
            return("reiPreto.png");
        }
        return("reiBranco.png");
    }
}