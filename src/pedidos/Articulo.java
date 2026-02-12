package pedidos;
public class Articulo {

    private String nombre;
    private int cantidad;
    private double precioUnidad;

    public Articulo(String nombre, int cantidad, double precioUnidad) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del artículo no puede estar vacío.");
        }

        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que 0.");
        }

        if (precioUnidad <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que 0.");
        }

        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
    }
    

    //Calcula el total del articulo concreto
    public double getSubtotal() {
        return cantidad * precioUnidad;
    }

    //Getters para que "Pedido" lea los datos
    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
    public double getPrecioUnidad() { return precioUnidad; }

}


