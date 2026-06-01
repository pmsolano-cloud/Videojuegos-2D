import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MotorJuego motor = new MotorJuego();

        Jugador jugador =
                new Jugador(
                        "Mercenario",
                        0,
                        0);

        Enemigo drone1 =
                new Enemigo(
                        "Drone A",
                        5,
                        0);

        Enemigo drone2 =
                new Enemigo(
                        "Drone B",
                        8,
                        2);

        Enemigo drone3 =
                new Enemigo(
                        "Drone C",
                        -4,
                        1);

        GestorEntradas entradas =
                new GestorEntradas();

        motor.agregarEntidad(jugador);
        motor.agregarEntidad(drone1);
        motor.agregarEntidad(drone2);
        motor.agregarEntidad(drone3);

        motor.iniciarPartida();

        Scanner scanner = new Scanner(System.in);

        boolean salir = false;

        System.out.println("================================");
        System.out.println(" CYBERBOOM 2084");
        System.out.println(" Sobrevive a los drones");
        System.out.println("================================");

        while (!salir) {

            System.out.println("\nVida: "
                    + jugador.getEnergia());

            System.out.println("Drones activos: "
                    + motor.contarEnemigos());

            System.out.println("\nPosicion jugador: ("
                    + jugador.getX()
                    + ","
                    + jugador.getY()
                    + ")");

            System.out.println("\n1. Izquierda");
            System.out.println("2. Derecha");
            System.out.println("3. Arriba");
            System.out.println("4. Abajo");
            System.out.println("5. Disparar");
            System.out.println("6. Salir");

            System.out.print("\nAccion: ");

            String opcion =
                    scanner.nextLine();

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

                    for (EntidadVideojuego entidad
                            : motor.getEntidades()) {

                        if (entidad instanceof Enemigo) {

                            int distancia =
                                    Math.abs(
                                            entidad.getX()
                                                    - jugador.getX())
                                            +
                                            Math.abs(
                                                    entidad.getY()
                                                            - jugador.getY());

                            if (distancia <= 1) {

                                System.out.println(
                                        entidad.getNombre()
                                                + " destruido");

                                motor.eliminarEntidad(
                                        entidad);

                                break;
                            }
                        }
                    }

                    break;

                case "6":
                    salir = true;
                    continue;

                default:
                    System.out.println(
                            "Opcion invalida");
                    continue;
            }

            for (EntidadVideojuego entidad
                    : motor.getEntidades()) {

                if (entidad instanceof Enemigo) {

                    Enemigo enemigo =
                            (Enemigo) entidad;

                    enemigo.actualizarIA(
                            jugador);

                    if (enemigo.getEstadoIA()
                            .equals("PERSEGUIR")) {

                        if (enemigo.getX()
                                > jugador.getX()) {

                            enemigo.mover(-1, 0);

                        } else {

                            enemigo.mover(1, 0);
                        }
                    }
                }
            }

            motor.actualizar();

            for (EntidadVideojuego entidad
                    : motor.getEntidades()) {

                if (entidad instanceof Enemigo) {

                    if (motor.detectarColision(
                            jugador,
                            entidad)) {

                        System.out.println(
                                "\n*** IMPACTO ***");

                        jugador.recibirDanio(
                                20);

                        System.out.println(
                                "Vida restante: "
                                        + jugador.getEnergia());
                    }
                }
            }

            if (jugador.getEnergia()
                    <= 0) {

                System.out.println(
                        "\n===== GAME OVER =====");

                motor.gameOver();

                salir = true;
            }

            if (motor.contarEnemigos()
                    == 0) {

                System.out.println(
                        "\n===== VICTORIA =====");

                System.out.println(
                        "Has destruido todos los drones.");

                salir = true;
            }
        }

        scanner.close();

        System.out.println(
                "\nGracias por jugar.");
    }
}