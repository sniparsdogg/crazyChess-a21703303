package pt.ulusofona.lp2.crazyChess;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCrazyPiece { // Teste da função setIdEquipa da classe CrazyPiece.
    @Test
    public void testeEquipa(){
        CrazyPiece pecaTeste = new CrazyPiece();
        pecaTeste.setIdEquipa(0);
        int equipaEsperada = 0;
        assertEquals(equipaEsperada,pecaTeste.getIdEquipa());
    }
}
