package pt.ulusofona.lp2.crazyChess;

public class Resultados {
    int capturasPretas = 0;
    int capturasBrancas = 0;
    int validasPretas = 0;
    int validasBrancas = 0;
    int invalidasPretas = 0;
    int invalidasBrancas = 0;

    public Resultados() {
    }

    public int getCapturasPretas() {
        return capturasPretas;
    }

    public int getCapturasBrancas() {
        return capturasBrancas;
    }

    public int getValidasPretas() {
        return validasPretas;
    }

    public int getValidasBrancas() {
        return validasBrancas;
    }

    public int getInvalidasPretas() {
        return invalidasPretas;
    }

    public int getInvalidasBrancas() {
        return invalidasBrancas;
    }

    public void somaCapturasPretas() {
        capturasPretas++;
    }

    public void somaCapturasBrancas() {
        capturasBrancas++;
    }

    public void somaValidasPretas() {
        validasPretas++;
    }

    public void somaValidasBrancas(){
        validasBrancas++;
    }

    public void somaInvalidasPretas(){
        invalidasPretas++;
    }

    public void somaInvalidasBrancas(){
        invalidasBrancas++;
    }
}
