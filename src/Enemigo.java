public class Enemigo extends EntidadVideojuego {

    private String estadoIA;

    public Enemigo(String nombre, int x, int y) {
        super(nombre, x, y, 1, 1, 50, "enemigo.png");
        estadoIA = "PATRULLAR";
    }

    public void actualizarIA(Jugador jugador) {

        int distancia = Math.abs(getX() - jugador.getX())
                + Math.abs(getY() - jugador.getY());

        if (distancia <= 1) {
            estadoIA = "ATACAR";
        } else if (distancia <= 5) {
            estadoIA = "PERSEGUIR";
        } else {
            estadoIA = "PATRULLAR";
        }

        System.out.println(getNombre() + " -> " + estadoIA);
    }
}