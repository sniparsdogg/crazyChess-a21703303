package pt.ulusofona.lp2.crazyChess;

import java.io.IOException;

public class InvalidSimulatorInputException extends IOException {

    int linha;
    int dadosNaLinha;
    int pecasEmJogo;

    InvalidSimulatorInputException(int x, int y){
        this.linha = x;
        this.dadosNaLinha = y;
    }

    InvalidSimulatorInputException(int x, int y, int z) {
        this.linha = x;
        this.dadosNaLinha = y;
        this.pecasEmJogo = z;
    }

    public int getLinhaErro(){
        return linha;
    }

    public String getDescricaoProblema(){
        if(linha <= 2) {
            if (dadosNaLinha < 1) {
                return ("DADOS A MENOS (Esperava: 1 ; Obtive: " + dadosNaLinha);
            } else {
                return ("DADOS A MAIS (Esperava: 1 ; Obtive: " + dadosNaLinha);
            }
        } else if(linha > 2 && linha <= 2 + pecasEmJogo) {
            if (dadosNaLinha < 4) {
                return ("DADOS A MENOS (Esperava: 4 ; Obtive: " + dadosNaLinha);
            } else {
                return ("DADOS A MAIS (Esperava: 4 ; Obtive: " + dadosNaLinha);
            }
        } else if(linha > 2 + pecasEmJogo && linha <= 2 + pecasEmJogo * 2){
            if(dadosNaLinha < pecasEmJogo){
                return ("DADOS A MENOS (Esperava: " + pecasEmJogo + " ; Obtive: " + dadosNaLinha);
            } else {
                return ("DADOS A MAIS (Esperava: " + pecasEmJogo + " ; Obtive: " + dadosNaLinha);
            }
        }
        if (dadosNaLinha < 7){
            return ("DADOS A MENOS (Esperava: 7 ; Obtive: " + dadosNaLinha);
        }
            return ("DADOS A MAIS (Esperava: 7 ; Obtive: " + dadosNaLinha);
        }
    }
