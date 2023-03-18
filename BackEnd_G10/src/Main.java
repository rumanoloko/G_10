public class Main {
    public static void main(String[] args) {
        Hub h = new Hub();
        Contenedor a = new Contenedor(1,1,1,"España",
                "K lo K","Albania","Expres");
        Contenedor b = new Contenedor(2,2,1,"España",
                "123123123123123","Albania","Expres");
        Contenedor c = new Contenedor(3,3,1,"España",
                "123123123123123","Albania","Expres");

        Carguero carg = new Carguero();

        for(int i=0; i<301; i++)
            carg.apilarContenedor(c);

        h.apilarContenedor(a);
        h.apilarContenedor(a);
        h.apilarContenedor(a);
        h.apilarContenedor(a);
        System.out.println(carg.toString());


    }
}