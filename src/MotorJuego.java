import java.util.ArrayList;
import java.util.List;

public class MotorJuego {

    private String estado;
    private List<EntidadVideojuego> entidades;

    public MotorJuego() {
        estado = "MENU";
        entidades = new ArrayList<>();
    }

    public void iniciarPartida() {
        estado = "JUGANDO";
    }

    public void pausar() {
        estado = "PAUSA";
    }

    public void reanudar() {
        estado = "JUGANDO";
    }

    public void gameOver() {
        estado = "GAME_OVER";
    }

    public void agregarEntidad(EntidadVideojuego entidad) {
        entidades.add(entidad);
    }

    public void eliminarEntidad(EntidadVideojuego entidad) {
        entidades.remove(entidad);
    }

    public List<EntidadVideojuego> getEntidades() {
        return entidades;
    }

    public void actualizar() {

        System.out.println("\n=== GAME LOOP ===");

        for (EntidadVideojuego entidad : entidades) {

            entidad.mover(1, 0);

            System.out.println(
                    entidad.getNombre()
                            + " -> (" +
                            entidad.getX() +
                            "," +
                            entidad.getY() +
                            ")");
        }
    }
    public boolean detectarColision(
        EntidadVideojuego a,
        EntidadVideojuego b) {

    return a.getX() < b.getX() + b.getAncho()
            && a.getX() + a.getAncho() > b.getX()
            && a.getY() < b.getY() + b.getAlto()
            && a.getY() + a.getAlto() > b.getY();
}
}
