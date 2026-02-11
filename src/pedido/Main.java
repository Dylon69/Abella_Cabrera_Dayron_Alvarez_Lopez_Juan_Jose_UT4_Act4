public class Main {
    public static void main(String[] args) {

        Pedido pedido = new Pedido("Carlos");

        pedido.agregarArticulo(new Articulo("Pizza", 2, 10));
        pedido.agregarArticulo(new Articulo("Refresco", 1, 2.5));

        pedido.mostrarResumen();

        pedido.cambiarEstado(EstadoPedido.LISTO_PARA_ENTREGAR);
        pedido.cambiarEstado(EstadoPedido.ENTREGADO);

        pedido.mostrarResumen();
    }
}

