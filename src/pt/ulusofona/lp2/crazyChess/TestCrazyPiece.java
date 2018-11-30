package pt.ulusofona.lp2.crazyChess;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCrazyPiece {
    @Test
    public void testeEquipa(){
        CrazyPiece pecaTeste = new CrazyPiece();
        pecaTeste.setIdEquipa(0);
        int equipaEsperada = 0;
        assertEquals(equipaEsperada,pecaTeste.getIdEquipa(), "A equipa esperada era 0!");
    }
}
