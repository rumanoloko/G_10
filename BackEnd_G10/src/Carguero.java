public class Carguero {
    private Hub[] carguero;

    public Carguero(){
        carguero = new Hub[3];
        for(int i=0; i<carguero.length; i++){
            carguero[i] = new Hub();
        }
    }

    public void apilarContenedor(Contenedor c){
        boolean hayHueco = false;
        switch (c.getPrioridad()){

            case 1:

                    for(int i=0; i<carguero.length; i++){
                        if(carguero[i].getLibresPrioridad1()!=0){
                            carguero[i].apilarContenedor(c);
                            hayHueco= !hayHueco;
                            break;
                        }
                    }
                if(!hayHueco)
                    System.out.println("No caben más contenedores de prioridad 1 en todo el carguero");
                break;

            case 2:

                for(int i=0; i<carguero.length; i++){
                    if(carguero[i].getLibresPrioridad2()!=0){
                        carguero[i].apilarContenedor(c);
                        hayHueco= !hayHueco;
                        break;
                    }
                }
                if(!hayHueco)
                    System.out.println("No caben más contenedores de prioridad 2 en todo el carguero");
                break;

            default:

                for(int i=0; i<carguero.length; i++){
                    if(carguero[i].getLibresPrioridad3()!=0){
                        carguero[i].apilarContenedor(c);
                        hayHueco= !hayHueco;
                        break;
                    }
                }
                if(!hayHueco)
                    System.out.println("No caben más contenedores de prioridad 3 en todo el carguero");
                break;
        }

    }

    public void mostrarDatosContenedor(int id){
        for(int i=0; i< carguero.length; i++){
            carguero[i].mostrarDatosContenedor(id);
        }
    }

    public String toString(){
        String s ="";
        for(int i=0; i< carguero.length; i++)
            s += "\nHub " + (i+1) + ":\n" + carguero[i].toString();
        return s;
    }
}
