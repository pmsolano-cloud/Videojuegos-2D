public class SistemaPuntuacion {

    private int puntos;
    private int enemigosEliminados;

    public void sumarPuntos(int cantidad) {
        puntos += cantidad;
    }

    public void enemigoEliminado() {

        enemigosEliminados++;

        if (enemigosEliminados >= 3) {
            System.out.println("LOGRO DESBLOQUEADO: Cazador de Drones");
        }
    }
}