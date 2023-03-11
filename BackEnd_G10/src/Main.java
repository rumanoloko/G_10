public class Main {
    public static void main(String[] args) {
        Hub h = new Hub();
        Contenedor a = new Contenedor(1,1,1,"España",
                "K lo K","Albania","Expres");
        Contenedor b = new Contenedor(2,2,1,"España",
                "123123123123123","Albania","Expres");
        Contenedor c = new Contenedor(3,3,1,"España",
                "123123123123123","Albania","Expres");


        h.apilarContenedor(a);
        h.apilarContenedor(b);
        h.apilarContenedor(c);
        h.apilarContenedor(c);
        System.out.println(h.toString());

    }
}