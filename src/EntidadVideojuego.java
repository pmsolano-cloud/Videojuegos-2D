public abstract class EntidadVideojuego {

    private String nombre;
    private int x;
    private int y;
    private int ancho;
    private int alto;
    private int energia;
    private String sprite;

    public EntidadVideojuego(String nombre, int x, int y, int ancho, int alto, int energia, String sprite) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.energia = energia;
        this.sprite = sprite;
    }

    public void mover(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public String getNombre() {
        return nombre;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public int getEnergia() {
        return energia;
    }

    public void recibirDanio(int cantidad) {
        energia -= cantidad;
    }
}