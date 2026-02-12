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
    }
}