package pt.ulusofona.lp2.crazyChess;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulador {

    int tamanho;
    ArrayList<CrazyPiece> pecas = new ArrayList<CrazyPiece>();
    ArrayList<CrazyPiece> pecasA = new ArrayList<CrazyPiece>();
    ArrayList<CrazyPiece> pecasB = new ArrayList<CrazyPiece>();
    int turno;

   public Simulador(){

   }
   public boolean iniciaJogo(File ficheiroInicial){
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
                        pecasA.add(peca);
                    } else {
                        pecasB.add(peca);
                    }
                }
            }
            for(int i = 0; i < tamanho; i++) {
                String linha = scannerFicheiro.nextLine();
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
    }

    public boolean processaJogada(int xO, int yO, int xD, int yD){
        if(xD == xO || xD == xO+1 || xD == xO - 1) {
            if(yD == yO || yD == yO + 1 || yD == yO - 1) {
                if (xD == xO && yD == yO) {
                    return false;
                } else {
                    turno++;
                    return true;
                }
            }
        }
        return false;
    }

    public List<CrazyPiece> getPecasMalucas(){
        return pecas;
    }

    public boolean jogoTerminado() {
        return false;
    }
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
    public int getIDPeca (int x, int y){
        return 0;
    }

    public int getIDEquipaAJogar() {
        if(turno % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

}
