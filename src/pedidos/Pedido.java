package pedidos;

public class Pedido {
    private static int contadorPedidos = 1;
    private int idPedido;
    private String nombreCliente;
    private EstadoPedido estado;
    private Articulo[] listaArticulos;
    private int numArticulos;

    public Pedido(String nombreCliente) {

        if (nombreCliente == null || nombreCliente.trim().isEmpty()) {
        throw new IllegalArgumentException("El nombre del cliente no puede estar vacío.");
    }
        this.idPedido = contadorPedidos++;
        this.nombreCliente = nombreCliente;
        this.estado = EstadoPedido.EN_PREPARACION;
        this.listaArticulos = new Articulo[5];
        this.numArticulos = 0;
    }
    

    public void agregarArticulo(String nombre, int cantidad, double precio) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("Error: el nombre del artículo no puede estar vacío.");
            return;
        }

        if (numArticulos >= 5) {
            System.out.println("Error: no se pueden añadir más de 5 artículos al pedido.");
            return;
        }
           
        if (numArticulos < 5) {
            listaArticulos[numArticulos] = new Articulo(nombre, cantidad, precio);
            numArticulos++;
            System.out.println("Artículo añadido.");
        } else {
            System.out.println("No se pueden añadir más artículos.");
        }
    }

    public void cambiarEstado(EstadoPedido nuevoEstado) {

        if (nuevoEstado.ordinal() < estado.ordinal()) {
            System.out.println("Error: no se puede retroceder el estado del pedido.");
            return;
        }

        if (nuevoEstado == estado) {
            System.out.println("El pedido ya está en ese estado.");
            return;
        }

        estado = nuevoEstado;
        System.out.println("Estado actualizado correctamente a: " + estado);
    }


    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < numArticulos; i++) {
            total += listaArticulos[i].getSubtotal();
        }
        return total;
    }

    public int getidPedido() { return idPedido; }
    public String getnombreCliente() { return nombreCliente; }
    public EstadoPedido getestado() { return estado; }
    public Articulo[] getListaArticulos() { return listaArticulos; }
    public int getNumArticulos() { return numArticulos; }

    public void setEstado(EstadoPedido estado) { this.estado = estado; }


    public void mostrarResumen() {
        System.out.println("----- RESUMEN DEL PEDIDO -----");
        System.out.println("ID Pedido: " + idPedido);
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Estado: " + estado);

        System.out.println("\nArtículos:");
        for (Articulo a : listaArticulos) {
            if (a != null) {
                System.out.println("- " + a.getNombre() +" | Cantidad: " + a.getCantidad() +" | Precio unidad: " + a.getPrecioUnidad());
            }

        System.out.println("\nTotal del pedido: " + calcularTotal() + " €");
        System.out.println("--------------------------------");
        }
    }
}