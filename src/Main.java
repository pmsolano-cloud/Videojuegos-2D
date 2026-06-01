public class Main {

    public static void main(String[] args) {

        MotorJuego motor = new MotorJuego();

        Jugador jugador =
                new Jugador("Mercenario", 0, 0);

        Enemigo enemigo =
                new Enemigo("Drone Corporativo", 3, 0);

        GestorEntradas entradas =
                new GestorEntradas();

        motor.iniciarPartida();

        motor.agregarEntidad(jugador);
        motor.agregarEntidad(enemigo);

        entradas.moverJugador(jugador, "DERECHA");

        motor.actualizar();

        enemigo.actualizarIA(jugador);

        if (motor.detectarColision(jugador, enemigo)) {
            jugador.recibirDanio(10);
            System.out.println("COLISION DETECTADA");
        }

        motor.pausar();
        motor.reanudar();
        motor.gameOver();
    }
}