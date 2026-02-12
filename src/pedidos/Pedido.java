package pedidos;

public class Pedido {
    private static int contadorPedidos = 1;
    private int idPedido;
    private String nombreCliente;
    private EstadoPedido estado;
    private Articulo[] listaArticulos;
    private int numArticulos;

    public Pedido(String nombreCliente) {
        this.idPedido = contadorPedidos++;
        this.nombreCliente = nombreCliente;
        this.estado = EstadoPedido.EN_PREPARACION;
        this.listaArticulos = new Articulo[5];
        this.numArticulos = 0;
    }

    public void agregarArticulo(String nombre, int cantidad, double precio) {
        if (numArticulos < 5) {
            listaArticulos[numArticulos] = new Articulo(nombre, cantidad, precio);
            numArticulos++;
            System.out.println("Artículo añadido.");
        } else {
            System.out.println("No se pueden añadir más artículos.");
        }
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
}