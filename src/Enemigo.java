public class Enemigo extends EntidadVideojuego {

    private String estadoIA;

    public String getEstadoIA() {
    return estadoIA;
}

    public Enemigo(String nombre, int x, int y) {
        super(nombre, x, y, 1, 1, 50, "enemigo.png");
        estadoIA = "PATRULLAR";
    }

public void actualizarIA(Jugador jugador) {

    int distancia =
            Math.abs(getX() - jugador.getX())
            + Math.abs(getY() - jugador.getY());

    if (distancia <= 1) {
        estadoIA = "ATACAR";
    } else if (distancia <= 5) {
        estadoIA = "PERSEGUIR";
    } else {
        estadoIA = "PATRULLAR";
    }

    System.out.println(
            getNombre()
            + " distancia="
            + distancia
            + " estado="
            + estadoIA);
            if (estadoIA.equals("PERSEGUIR")) {

    if (jugador.getX() > getX()) {
        mover(1, 0);
    } else if (jugador.getX() < getX()) {
        mover(-1, 0);
    }

    if (jugador.getY() > getY()) {
        mover(0, 1);
    } else if (jugador.getY() < getY()) {
        mover(0, -1);
    }
}
if (estadoIA.equals("PATRULLAR")) {
    mover(-1, 0);
}
}
}
