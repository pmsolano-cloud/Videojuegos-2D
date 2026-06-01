public class GestorEntradas {

    public void moverJugador(Jugador jugador, String direccion) {

        switch (direccion) {

            case "ARRIBA":
                jugador.mover(0, -1);
                break;

            case "ABAJO":
                jugador.mover(0, 1);
                break;

            case "IZQUIERDA":
                jugador.mover(-1, 0);
                break;

            case "DERECHA":
                jugador.mover(1, 0);
                break;
        }
    }

    public void disparar() {
        System.out.println("Disparo realizado");
    }
}