package pt.ulusofona.lp2.crazyChess;


public class Joker extends CrazyPiece {
    int valorRelativo = 4;
    int tipoJoker = 1;

    public void incrementaTipoJoker(){
        tipoJoker++;
        this.idTipo++;
        if(tipoJoker == 8){
            tipoJoker = 1;
            this.idTipo = 1;
        }
    }
     public String nomeTipoJoker(){
        switch(tipoJoker){
            case 1 :
                return "Rainha";
            case 2:
                return "Ponei Mágico";
            case 3:
                return "Padre da Vila";
            case 4:
                return "TorreH";
            case 5:
                return "TorreV";
            case 6:
                return "Lebre";
            case 7:
                return "Rainha Mãe";
        }
        return "Tipo invalido";
     }

    public boolean jogadaValida(int xO, int xD, int yO, int yD, Simulador simulador) {
        CrazyPiece movimento;
         switch(tipoJoker){
            case 1:
                movimento = new Rainha();
                movimento.id = this.id;
                movimento.idTipo = this.idTipo;
                movimento.idEquipa = this.idEquipa;
                movimento.alcunha = this.alcunha;
                movimento.posicao = this.posicao;
                movimento.capturada = this.capturada;
                movimento.joker = this.joker;
                return movimento.jogadaValida(xO, xD, yO, yD, simulador);

            case 2:
                movimento = new PoneiMagico();
                movimento.id = this.id;
                movimento.idTipo = this.idTipo;
                movimento.idEquipa = this.idEquipa;
                movimento.alcunha = this.alcunha;
                movimento.posicao = this.posicao;
                movimento.capturada = this.capturada;
                movimento.joker = this.joker;
                return movimento.jogadaValida(xO, xD, yO, yD, simulador);
            case 3:
                movimento = new PadreVila();
                movimento.id = this.id;
                movimento.idTipo = this.idTipo;
                movimento.idEquipa = this.idEquipa;
                movimento.alcunha = this.alcunha;
                movimento.posicao = this.posicao;
                movimento.capturada = this.capturada;
                movimento.joker = this.joker;
                return movimento.jogadaValida(xO, xD, yO, yD, simulador);
            case 4:
                movimento = new TorreHor();
                movimento.id = this.id;
                movimento.idTipo = this.idTipo;
                movimento.idEquipa = this.idEquipa;
                movimento.alcunha = this.alcunha;
                movimento.posicao = this.posicao;
                movimento.capturada = this.capturada;
                movimento.joker = this.joker;
                return movimento.jogadaValida(xO, xD, yO, yD, simulador);
            case 5:
                movimento = new TorreVert();
                movimento.id = this.id;
                movimento.idTipo = this.idTipo;
                movimento.idEquipa = this.idEquipa;
                movimento.alcunha = this.alcunha;
                movimento.posicao = this.posicao;
                movimento.capturada = this.capturada;
                movimento.joker = this.joker;
                return movimento.jogadaValida(xO, xD, yO, yD, simulador);
            case 6:
                movimento = new Lebre();
                movimento.id = this.id;
                movimento.idTipo = this.idTipo;
                movimento.idEquipa = this.idEquipa;
                movimento.alcunha = this.alcunha;
                movimento.posicao = this.posicao;
                movimento.capturada = this.capturada;
                movimento.joker = this.joker;
                return movimento.jogadaValida(xO, xD, yO, yD, simulador);
            case 7:
                movimento = new RainhaMae();
                movimento.id = this.id;
                movimento.idTipo = this.idTipo;
                movimento.idEquipa = this.idEquipa;
                movimento.alcunha = this.alcunha;
                movimento.posicao = this.posicao;
                movimento.capturada = this.capturada;
                movimento.joker = this.joker;
                return movimento.jogadaValida(xO, xD, yO, yD, simulador);
        }
        return false;
    }

    public int getValorRelativo(){
        return valorRelativo;
    }


    @Override
    public String toString(){
        if(capturada) {
            return (id + " | " + idTipo + "/" + nomeTipoJoker() + " | 4 | " + idEquipa + " | " + alcunha + " @ (n/a)");
        }
        return (id + " | " + idTipo + "/" + nomeTipoJoker() + " | 4 | " + idEquipa + " | " + alcunha + " @ (" + posicao + ")");
    }
}
