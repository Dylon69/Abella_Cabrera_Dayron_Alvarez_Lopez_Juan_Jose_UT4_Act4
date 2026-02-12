package pedidos;
public class Articulo {

    private String nombre;
    private int cantidad;
    private double precioUnidad;

    public Articulo(String nombre, int cantidad, double precioUnidad) {
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


