package pt.ulusofona.lp2.crazyChess;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Simulador {
    int tamanho;
    List<CrazyPiece> pecas;
    List<CrazyPiece> pecasA;
    List<CrazyPiece> pecasB;


   public Simulador(){
    }

    public boolean iniciaJogo(File ficheiroInicial){
        try {
            Scanner scannerFicheiro = new Scanner(ficheiroInicial);

            while (scannerFicheiro.hasNextLine()) {
                String linha = scannerFicheiro.nextLine();

            }

        } catch (FileNotFoundException exception) {
            System.out.println("Erro: o ficheiro " + ficheiroInicial + " não foi encontrado.");
            return false;
        }
        return true;
    }

    public int getTamanhoTabuleiro(){
        return 0;
    }

    public boolean processaJogada(int xO, int yO, int xD, int yD){
        return true;
    }

/*    public List<CrazyPiece> getPecasMalucas(){

    }
*/
    public boolean jogoTerminado() {
        return true;
    }

  /*  public List<String> getAutores(){

    }

    public List<String> getResultados(){

    }
*/
    public int getIDPeca (int x, int y){
        return 0;
    }

    public int getIDEquipaAJogar(){
        return 0;
    }

}
