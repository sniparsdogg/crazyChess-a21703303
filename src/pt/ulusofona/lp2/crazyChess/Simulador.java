package pt.ulusofona.lp2.crazyChess;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulador {

    int tamanho; // Tamanha do tabuleiro.
    ArrayList<CrazyPiece> pecas = new ArrayList<CrazyPiece>();
    ArrayList<CrazyPiece> pecasPretas = new ArrayList<CrazyPiece>();
    ArrayList<CrazyPiece> pecasBrancas = new ArrayList<CrazyPiece>();
    int turno;

   public Simulador(){

   }
   public boolean iniciaJogo(File ficheiroInicial){ // Função que inicia o jogo.
        try {
            Scanner scannerFicheiro = new Scanner(ficheiroInicial);
            tamanho = Integer.parseInt(scannerFicheiro.nextLine());
            int pecasEmJogo = Integer.parseInt(scannerFicheiro.nextLine());
            for (int i = 0; i < pecasEmJogo; i++) {
                String linha = scannerFicheiro.nextLine();
                String coluna[] = linha.split(":");
                if (coluna.length == 4) {
                    CrazyPiece peca = new CrazyPiece();
                    peca.setId(Integer.parseInt(coluna[0]));
                    peca.setIdTipo(Integer.parseInt(coluna[1]));
                    peca.setIdEquipa(Integer.parseInt(coluna[2]));
                    peca.setAlcunha(coluna[3]);
                    pecas.add(peca);
                    if(peca.idEquipa == 0) {
                        pecasPretas.add(peca);
                    } else {
                        pecasBrancas.add(peca);
                    }
                }
            }
            for(int i = 0; i < tamanho; i++) {
                String linha = scannerFicheiro.nextLine();
                String coluna[] = linha.split(":");
                for(int j = 0; j < 4; j++) {
                    if(!(Integer.parseInt(coluna[j]) == 0)){
                        pecas.get(Integer.parseInt(coluna[j])-1).posicao.setPosicao(j,i);

                    }
                }
            }
            turno = 0;
        } catch (FileNotFoundException exception) {
            System.out.println("Erro: o ficheiro " + ficheiroInicial + " não foi encontrado.");
            return false;
        }
        return true;
    }

    public int getTamanhoTabuleiro(){
        return tamanho;
    } // Função que permite obter o tamanho do tabuleiro.

    public boolean processaJogada(int xO, int yO, int xD, int yD){
        if(xD == xO || xD == xO+1 || xD == xO - 1) {
            for (int i = 0; i < getPecasMalucas().size(); i++){
                if(getPecasMalucas().get(i).posicao.x == xO && getPecasMalucas().get(i).posicao.y == yO && getPecasMalucas().get(i).getIdEquipa() == getIDEquipaAJogar()){
                    if(yD == yO || yD == yO + 1 || yD == yO - 1) {
                        if (xD == xO && yD == yO) {
                            return false;
                        } else {
                            getPecasMalucas().get(i).posicao.setPosicao(xD, yD);
                            turno++;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public List<CrazyPiece> getPecasMalucas(){ // Devolve as peças.
        return pecas;
    }

    public boolean jogoTerminado() {
        return false;
    } // Função que termina o jogo.
    public List<String> getAutores(){
        ArrayList<String> autores = new ArrayList<String>();
        autores.add("Augusto Gouveia - 21703303");
        autores.add("Renato Cruz - 21705487");
        return autores;
    }
/*
    public List<String> getResultados(){

    }
*/
    public int getIDPeca (int x, int y){ // Obtém o ID da peça nas coordenadas dadas.
        for (int i = 0; i < getPecasMalucas().size(); i++){
            if(getPecasMalucas().get(i).posicao.x == x && getPecasMalucas().get(i).posicao.y == y){
                return getPecasMalucas().get(i).getId();
            }
        }

        return 0;
    }

    public int getIDEquipaAJogar() { // Função que retorna qual é a equipa a jogar.
        if(turno % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

}
