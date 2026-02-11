import java.util.ArrayList;

public class Pedido {

    private static int contadorId = 1;

    private int id;
    private String nombreCliente;
    private ArrayList<Articulo> articulos;
    private EstadoPedido estado;

    private static final int MAX_ARTICULOS = 5;

    // Constructor
    public Pedido(String nombreCliente) {
        this.id = contadorId++;
        this.nombreCliente = nombreCliente;
        this.articulos = new ArrayList<>();
        this.estado = EstadoPedido.EN_PREPARACION;
    }

    // Añadir artículo
    public void agregarArticulo(Articulo articulo) {
        if (articulos.size() < MAX_ARTICULOS) {
            articulos.add(articulo);
        } else {
            System.out.println("No se pueden añadir más de 5 artículos.");
        }
    }

    // Calcular precio total
    public double calcularTotal() {
        double total = 0;
        for (Articulo a : articulos) {
            total += a.calcularSubtotal();
        }
        return total;
    }

    // Cambiar estado (sin retroceder)
    public void cambiarEstado(EstadoPedido nuevoEstado) {
        if (nuevoEstado.ordinal() >= estado.ordinal()) {
            estado = nuevoEstado;
        } else {
            System.out.println("No se puede retroceder el estado del pedido.");
        }
    }

    // Mostrar resumen
    public void mostrarResumen() {
        System.out.println("Pedido ID: " + id);
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Estado: " + estado);

        System.out.println("Artículos:");
        for (Articulo a : articulos) {
            System.out.println("- " + a.getNombre() +
                    " | Cantidad: " + a.getCantidad() +
                    " | Precio unidad: " + a.getPrecioUnidad());
        }

        System.out.println("Total: " + calcularTotal() + " €");
    }
}
