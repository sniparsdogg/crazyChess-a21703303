package pt.ulusofona.lp2.crazyChess;

public abstract class CrazyPiece {

    int id;
    int idTipo;
    int idEquipa;
    String alcunha;
    Posicao posicao = new Posicao();
    boolean capturada;
    boolean joker = false;
    int valorRelativo;
    int capturas = 0;
    int pontos = 0;
    int moveValidos = 0;
    int moveInvalidos = 0;
    Integer turnoMovido;

    CrazyPiece(){

    }

    public int getTurnoMovido(){
        return this.turnoMovido;
    }

    public int getId(){ // Getter do ID.
        return id;
    }

    public void setId(int i){ // Setter do ID.
        this.id = i;
    }

    public void setIdTipo(int i) { // Setter do tipo da peça.
        this.idTipo = i;
    }

    public int getIdTipo(){
        return idTipo;
    }

    public int getIdEquipa() { // Getter da equipa da peça.
        return idEquipa;
    }

    public void setIdEquipa(int i) { // Setter da equipa da peça.
        this.idEquipa = i;
    }

    public void setAlcunha(String s) { // Setter da alcunha.
        this.alcunha = s;
    }

    public int getValorRelativo(){
        return valorRelativo;
    }

    public int getCapturas(){
        return capturas;
    }

    public void somaCapturas(){
        capturas++;
    }

    public void somaPontos(int pontosASomar){
        this.pontos += pontosASomar;
    }

    public int getPontos(){
        return pontos;
    }

    public void somaMoveValidos(){
        moveValidos++;
    }

    public void somaMoveInvalidos(){
        moveInvalidos++;
    }

    public int getMoveValidos(){
        return moveValidos;
    }

    public int getMoveInvalidos(){
        return moveInvalidos;
    }

    public double getRacioMoves(){
        if(moveValidos > 0 || moveInvalidos > 0) {
            return (double)moveInvalidos/(double)(moveValidos) ;
        }
        return 0;
    }

    public double getRacioPontos(){
        if(capturas > 0){
            return (double)pontos/(double)capturas;
        }
        return 0;
    }

    public String getAlcunha() { // Getter da alcunha.
        return alcunha;
    }

    public void setTurnoMovido(){

    }

    public void setCapturada() { // Setter do estado de captura da peça.
        capturada = true;
    }

    public boolean getCapturada() {
        return capturada;
    }

    public void setPosicao(int posX, int posY) { // Setter da posição da peça.
        this.posicao.x = posX;
        this.posicao.y = posY;
    }

    public abstract boolean jogadaValida(int xO, int xD, int yO, int yD, Simulador simulador);

    public Posicao getPosicao() { // Getter da posição da peça.
        return posicao;
    }

    public void setJoker(){
        joker = true;
    }

    public boolean getJoker(){
        return joker;
    }

    public String getImagePNG(){ // Getter da imagem.
        if(this.getIdEquipa() == 10) {
            return("PecasPretas.png");
        }
        return("PecasBrancas.png");
    }

    public void incrementaTipoJoker(){

    }

    public String toString(){ // Override da string da classe para podermos atribuir à mesma a string requerida pelo enunciado.
        if(capturada) {
            return (id + " | " + idTipo + " | " + idEquipa + " | " + alcunha + " @ (n/a)");
        }
        return (id + " | " + idTipo + " | " + idEquipa + " | " + alcunha + " @ (" + posicao + ")");
    }
}
