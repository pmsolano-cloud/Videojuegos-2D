public class SistemaPuntuacion {

    private int puntos;
    private int enemigosEliminados;
    private boolean logroDesbloqueado;

    public void sumarPuntos(int cantidad) {
        puntos += cantidad;
    }

    public void enemigoEliminado() {

        enemigosEliminados++;

        if (enemigosEliminados >= 3
                && !logroDesbloqueado) {

            logroDesbloqueado = true;

            System.out.println(
                    "LOGRO DESBLOQUEADO: CAZADOR DE DRONES");
        }
    }
}