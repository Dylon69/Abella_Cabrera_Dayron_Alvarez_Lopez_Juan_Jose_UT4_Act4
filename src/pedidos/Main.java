package pedidos;

public class Main {
    public static void main(String[] args) {
        Pedido p1 = new Pedido("Dayron");
        p1.agregarArticulo("Pizza", 1, 12.50);
        p1.agregarArticulo("Coca-Cola", 2, 2.00);

        Pedido p2 = new Pedido("Juan Jose");
        p2.agregarArticulo("Hamburguesa", 2, 8.00);

        System.out.println("---------Pedidos---------");
        System.out.println("Pedido 1 - ID: " + p1.getidPedido() + " | Cliente: " + p1.getnombreCliente());
        System.out.println("Total a pagar: " + p1.calcularTotal() + "€");
        System.out.println("Estado: " + p1.getestado());

        System.out.println("\nPedido 2 - ID: " + p2.getidPedido() + " | Cliente: " + p2.getnombreCliente());
        System.out.println("Total a pagar: " + p2.calcularTotal() + "€");
        System.out.println("Estado: " + p2.getestado());

        //Pruebas adicionales

        System.out.println("\n=== PRUEBA 1: Máximo 5 artículos ===");
        Pedido pedido1 = new Pedido("Ana");

        pedido1.agregarArticulo("Hamburguesa", 1, 8);
        pedido1.agregarArticulo("Patatas", 1, 3);
        pedido1.agregarArticulo("Agua", 1, 1.5);
        pedido1.agregarArticulo("Postre", 1, 4);
        pedido1.agregarArticulo("Cafe", 1, 1.2);

        // Este debería fallar
        pedido1.agregarArticulo("Extra", 1, 2);

        System.out.println(pedido1);


        System.out.println("\n=== PRUEBA 2: Cambios de estado ===");
        Pedido pedido2 = new Pedido("Luis");

        pedido2.cambiarEstado(EstadoPedido.LISTO_PARA_ENTREGAR);
        pedido2.cambiarEstado(EstadoPedido.ENTREGADO);

        // Intento inválido (retroceder estado)
        pedido2.cambiarEstado(EstadoPedido.EN_PREPARACION);

        System.out.println(pedido2);


        System.out.println("\n=== PRUEBA 3: Cálculo de totales ===");
        Pedido pedido3 = new Pedido("Marta");

        pedido3.agregarArticulo("Menu", 3, 9.5);
        pedido3.agregarArticulo("Bebida", 2, 2);

        System.out.println("Total esperado: 32.5");
        System.out.println("Total calculado: " + pedido3.calcularTotal());
    }
}

