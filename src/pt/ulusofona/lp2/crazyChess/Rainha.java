package pt.ulusofona.lp2.crazyChess;

public class Rainha extends CrazyPiece {
    int valorRelativo = 8;
    public boolean jogadaValida(int xO, int xD, int yO, int yD, Simulador simulador) {
        if((xD <= xO + 5 && xD >= xO - 5) && (yD <= yO + 5 && yD >= yO - 5)) {
            if (xD == xO && yD == yO || (xD < 0 || xD > simulador.getTamanhoTabuleiro() - 1) || (yD < 0 || yD > simulador.getTamanhoTabuleiro() - 1)) {
                return false;
            }
            for (int i = 0; i < simulador.getPecasMalucas().size(); i++) {
                if (simulador.getPecasMalucas().get(i).getPosicao().x == xD && simulador.getPecasMalucas().get(i).getPosicao().y == yD && simulador.getPecasMalucas().get(i).getIdEquipa() == this.idEquipa) {
                    return false;
                }
            }
            for (int count = 0; count <= 5; count++) {
                if (xO + count == xD && yO == yD) { // horizontal este
                    for (int i = 0; i < simulador.getPecasMalucas().size(); i++) {
                        if (simulador.getPecasMalucas().get(i).getPosicao().x > xO && simulador.getPecasMalucas().get(i).getPosicao().x < xD && simulador.getPecasMalucas().get(i).getPosicao().y == yD) {
                            return false;
                        }
                    }
                    for (int i = 0; i < simulador.getPecasMalucas().size(); i++) {
                        if ((simulador.getPecasMalucas().get(i).getPosicao().x == xD && simulador.getPecasMalucas().get(i).getPosicao().y == yD && ((simulador.getPecasMalucas().get(i).getIdTipo() == 1 || simulador.getPecasMalucas().get(i).getIdTipo() == 9 ) && simulador.getPecasMalucas().get(i).getIdEquipa() != this.idEquipa))) {
                            return false;
                        }
                    }
                    return true;
                } else if (xO - count == xD && yO == yD) { // horizontal oeste
                    for (int i = 0; i < simulador.getPecasMalucas().size(); i++) {
                        if (simulador.getPecasMalucas().get(i).getPosicao().x < xO && simulador.getPecasMalucas().get(i).getPosicao().x > xD && simulador.getPecasMalucas().get(i).getPosicao().y == yD) {
                            return false;
                        }
                    }
                    for (int i = 0; i < simulador.getPecasMalucas().size(); i++) {
                        if ((simulador.getPecasMalucas().get(i).getPosicao().x == xD && simulador.getPecasMalucas().get(i).getPosicao().y == yD && ((simulador.getPecasMalucas().get(i).getIdTipo() == 1 || simulador.getPecasMalucas().get(i).getIdTipo() == 9 ) && simulador.getPecasMalucas().get(i).getIdEquipa() != this.idEquipa))) {
                            return false;
                        }
                    }
                    return true;
                } else if (xO == xD && yO - count == yD) { // vertical norte
                    for (int i = 0; i < simulador.getPecasMalucas().size(); i++) {
                        if (simulador.getPecasMalucas().get(i).getPosicao().y < yO && simulador.getPecasMalucas().get(i).getPosicao().y > yD && simulador.getPecasMalucas().get(i).getPosicao().x == xD) {
                            return false;
                        }
                    }
                    for (int i = 0; i < simulador.getPecasMalucas().size(); i++) {
                        if ((simulador.getPecasMalucas().get(i).getPosicao().x == xD && simulador.getPecasMalucas().get(i).getPosicao().y == yD && ((simulador.getPecasMalucas().get(i).getIdTipo() == 1 || simulador.getPecasMalucas().get(i).getIdTipo() == 9 ) && simulador.getPecasMalucas().get(i).getIdEquipa() != this.idEquipa))) {
                            return false;
                        }
                    }
                    return true;
                } else if (xO == xD && yO + count == yD) { // vertical sul
                    for (int i = 0; i < simulador.getPecasMalucas().size(); i++) {
                        if (simulador.getPecasMalucas().get(i).getPosicao().y > yO && simulador.getPecasMalucas().get(i).getPosicao().y < yD && simulador.getPecasMalucas().get(i).getPosicao().x == xD) {
                            return false;
                        }
                    }
                    for (int i = 0; i < simulador.getPecasMalucas().size(); i++) {
                        if ((simulador.getPecasMalucas().get(i).getPosicao().x == xD && simulador.getPecasMalucas().get(i).getPosicao().y == yD && ((simulador.getPecasMalucas().get(i).getIdTipo() == 1 || simulador.getPecasMalucas().get(i).getIdTipo() == 9 ) && simulador.getPecasMalucas().get(i).getIdEquipa() != this.idEquipa))) {
                            return false;
                        }
                    }
                    return true;

                } else if (xO + count == xD && yO - count == yD) { // diagonal nordeste
                    for (int i = 0; i < simulador.getPecasMalucas().size(); i++) {
                        for (int f = 1; f < count; f++) {
                            CrazyPiece pecaAComparar = simulador.pecaNaPosicao(xO + f, yO - f);
                            if (pecaAComparar != null) {
                                return false;
                            }
                        }
                    }
                    for (int i = 0; i < simulador.getPecasMalucas().size(); i++) {
                        if ((simulador.getPecasMalucas().get(i).getPosicao().x == xD && simulador.getPecasMalucas().get(i).getPosicao().y == yD && ((simulador.getPecasMalucas().get(i).getIdTipo() == 1 || simulador.getPecasMalucas().get(i).getIdTipo() == 9 ) && simulador.getPecasMalucas().get(i).getIdEquipa() != this.idEquipa))) {
                            return false;
                        }
                    }
                    return true;

                } else if (xO - count == xD && yO - count == yD) { // diagonal noroeste
                    for (int i = 0; i < simulador.getPecasMalucas().size(); i++) {
                        for (int f = 1; f < count; f++) {
                            CrazyPiece pecaAComparar = simulador.pecaNaPosicao(xO - f, yO - f);
                            if (pecaAComparar != null) {
                                return false;
                            }
                        }
                    }
                    for (int i = 0; i < simulador.getPecasMalucas().size(); i++) {
                        if ((simulador.getPecasMalucas().get(i).getPosicao().x == xD && simulador.getPecasMalucas().get(i).getPosicao().y == yD && ((simulador.getPecasMalucas().get(i).getIdTipo() == 1 || simulador.getPecasMalucas().get(i).getIdTipo() == 9 ) && simulador.getPecasMalucas().get(i).getIdEquipa() != this.idEquipa))) {
                            return false;
                        }
                    }
                    return true;

                } else if (xO + count == xD && yO + count == yD) { // diagonal sudeste
                    for (int i = 0; i < simulador.getPecasMalucas().size(); i++) {
                        for (int f = 1; f < count; f++) {
                            CrazyPiece pecaAComparar = simulador.pecaNaPosicao(xO + f, yO + f);
                            if (pecaAComparar != null) {
                                return false;
                            }
                        }
                    }
                    for (int i = 0; i < simulador.getPecasMalucas().size(); i++) {
                        if ((simulador.getPecasMalucas().get(i).getPosicao().x == xD && simulador.getPecasMalucas().get(i).getPosicao().y == yD && ((simulador.getPecasMalucas().get(i).getIdTipo() == 1 || simulador.getPecasMalucas().get(i).getIdTipo() == 9 ) && simulador.getPecasMalucas().get(i).getIdEquipa() != this.idEquipa))) {
                            return false;
                        }
                    }
                    return true;

                } else if (xO - count == xD && yO + count == yD) { // diagonal sudoeste
                    for (int i = 0; i < simulador.getPecasMalucas().size(); i++) {
                        for (int f = 1; f < count; f++) {
                            CrazyPiece pecaAComparar = simulador.pecaNaPosicao(xO - f, yO + f);
                            if (pecaAComparar != null) {
                                return false;
                            }
                        }
                    }
                    for (int i = 0; i < simulador.getPecasMalucas().size(); i++) {
                        if ((simulador.getPecasMalucas().get(i).getPosicao().x == xD && simulador.getPecasMalucas().get(i).getPosicao().y == yD && ((simulador.getPecasMalucas().get(i).getIdTipo() == 1 || simulador.getPecasMalucas().get(i).getIdTipo() == 9 ) && simulador.getPecasMalucas().get(i).getIdEquipa() != this.idEquipa))) {
                            return false;
                        }
                    }
                    return true;
                }
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
            return (this.id + "| Rainha | 8 | " + this.idEquipa + " | " + this.alcunha + " @ (n/a)");
        }
        return (this.id + " | Rainha | 8 | " + this.idEquipa + " | " + this.alcunha + " @ (" + this.posicao + ")");
    }

    public String getImagePNG(){ // Getter da imagem.
        if(this.getIdEquipa() == 10) {
            return("rainhaPreta.png");
        }
        return("rainhaBranca.png");
    }

}