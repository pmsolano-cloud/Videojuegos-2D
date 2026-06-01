import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MotorJuego motor = new MotorJuego();

        Jugador jugador =
                new Jugador(
                        "Mercenario",
                        0,
                        0);

        Enemigo enemigo =
                new Enemigo(
                        "Drone Corporativo",
                        8,
                        0);

        GestorEntradas entradas =
                new GestorEntradas();

        motor.agregarEntidad(jugador);
        motor.agregarEntidad(enemigo);

        motor.iniciarPartida();

        Scanner scanner = new Scanner(System.in);

        boolean salir = false;

        System.out.println("=================================");
        System.out.println("      CYBERBOOM 2084");
        System.out.println("=================================");

        while (!salir) {

            System.out.println("\n---------------------------");
            System.out.println("VIDA: " + jugador.getEnergia());
            System.out.println("POSICION JUGADOR: ("
                    + jugador.getX()
                    + ","
                    + jugador.getY()
                    + ")");
            System.out.println("POSICION ENEMIGO: ("
                    + enemigo.getX()
                    + ","
                    + enemigo.getY()
                    + ")");
            System.out.println("---------------------------");

            System.out.println("1 - Izquierda");
            System.out.println("2 - Derecha");
            System.out.println("3 - Arriba");
            System.out.println("4 - Abajo");
            System.out.println("5 - Disparar");
            System.out.println("6 - Pausar");
            System.out.println("7 - Reanudar");
            System.out.println("8 - Salir");

            System.out.print("Selecciona una opcion: ");

            String opcion = scanner.nextLine();

            switch (opcion) {

                case "1":
                    entradas.moverJugador(
                            jugador,
                            "IZQUIERDA");
                    break;

                case "2":
                    entradas.moverJugador(
                            jugador,
                            "DERECHA");
                    break;

                case "3":
                    entradas.moverJugador(
                            jugador,
                            "ARRIBA");
                    break;

                case "4":
                    entradas.moverJugador(
                            jugador,
                            "ABAJO");
                    break;

                case "5":
                    entradas.disparar();
                    break;

                case "6":
                    motor.pausar();
                    break;

                case "7":
                    motor.reanudar();
                    break;

                case "8":
                    salir = true;
                    continue;

                default:
                    System.out.println("Opcion invalida.");
                    continue;
            }

            enemigo.actualizarIA(jugador);

            motor.actualizar();

            if (motor.detectarColision(
                    jugador,
                    enemigo)) {

                System.out.println(
                        "\n*** COLISION DETECTADA ***");

                jugador.recibirDanio(20);

                System.out.println(
                        "Vida restante: "
                                + jugador.getEnergia());

                if (jugador.getEnergia() <= 0) {

                    motor.gameOver();

                    System.out.println(
                            "\n===== GAME OVER =====");

                    salir = true;
                }
            }
        }

        scanner.close();

        System.out.println(
                "\nGracias por jugar CyberBoom 2084");
    }
}