package pe.edu.upeu.tictactoe.modelo;

public class ModelTic {
    String partido;
    String jugadorUno;
    String jugadorDos;
    String ganador;
    Integer turno;

    public Integer getTurno() {
        return turno;
    }

    public void setTurno(Integer turno) {
        this.turno = turno;
    }

    public String getValorJugador1() {
        return valorJugador1;
    }

    public void setValorJugador1(String valorJugador1) {
        this.valorJugador1 = valorJugador1;
    }

    public String getValorJugador2() {
        return valorJugador2;
    }

    public void setValorJugador2(String valorJugador2) {
        this.valorJugador2 = valorJugador2;
    }

    String valorJugador1;
    String valorJugador2;
    int punto=0;
    String estado;


    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getJugadorUno() {
        return jugadorUno;
    }

    public void setJugadorUno(String jugadorUno) {
        this.jugadorUno = jugadorUno;
    }

    public String getJugadorDos() {
        return jugadorDos;
    }

    public void setJugadorDos(String jugadorDos) {
        this.jugadorDos = jugadorDos;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public int getPunto() {
        return punto;
    }

    public void setPunto(int punto) {
        this.punto = punto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ModelTic{" +
                "partido='" + partido + '\'' +
                ", jugadorUno='" + jugadorUno + '\'' +
                ", jugadorDos='" + jugadorDos + '\'' +
                ", ganador='" + ganador + '\'' +
                ", turno=" + turno +
                ", valorJugador1='" + valorJugador1 + '\'' +
                ", valorJugador2='" + valorJugador2 + '\'' +
                ", punto=" + punto +
                ", estado='" + estado + '\'' +
                '}';
    }
}
