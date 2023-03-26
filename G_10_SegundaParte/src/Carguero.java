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
        if(!Idduplicado(c)){
            switch (c.getPrioridad()){

                case 1:

                    for(int i=0; i<carguero.length; i++){
                        if(carguero[i].getLibresPrioridad1()!=0){
                            carguero[i].apilarContenedor(c);
                            hayHueco= !hayHueco;
                            break;
                        }
                    }
                    if(!hayHueco){}
                    //System.out.println("No caben más contenedores de prioridad 1 en todo el carguero");
                    break;

                case 2:

                    for(int i=0; i<carguero.length; i++){
                        if(carguero[i].getLibresPrioridad2()!=0){
                            carguero[i].apilarContenedor(c);
                            hayHueco= !hayHueco;
                            break;
                        }
                    }
                    if(!hayHueco){}
                    //System.out.println("No caben más contenedores de prioridad 2 en todo el carguero");
                    break;

                default:

                    for(int i=0; i<carguero.length; i++){
                        if(carguero[i].getLibresPrioridad3()!=0){
                            carguero[i].apilarContenedor(c);
                            hayHueco= !hayHueco;
                            break;
                        }
                    }
                    if(!hayHueco){}
                    //System.out.println("No caben más contenedores de prioridad 3 en todo el carguero");
                    break;
            }
        } else{
            //System.out.println("El id no es unico para ese contenedor");
        }

    }

    public boolean Idduplicado(Contenedor c){
        for(int i=0; i< carguero.length; i++){
            for(int j=0; j<12; j++){
                for(int k=9; k>=0; k--){
                    if(carguero[i].getComplex()[k][j]!=null && carguero[i].getComplex()[k][j].getItentificador()==c.getItentificador())
                        return true;
                }
            }
        }
        return false;
    }

    public Contenedor desapilarContenedor(int hub, int columna){
        Contenedor c;
        if(hub>0 && hub<4 && columna>0 && columna<13)
            return carguero[hub-1].desapilarContenedor(columna);
        return null;
    }

    public void mostrarDatosContenedor(int id){
        for(int i=0; i< carguero.length; i++){
            carguero[i].mostrarDatosContenedor(id);
        }
    }

    public int contenedoresporPais(String pais){
        int cantidad=0;
        for(int i=0; i<carguero.length; i++){
            cantidad += carguero[i].contenedoresPais(pais);
        }
        return cantidad;
    }

    public String toString(){
        String s ="";
        for(int i=0; i< carguero.length; i++)
            s += "\nHub " + (i+1) + ":\n" + carguero[i].toString();
        return s;
    }

    public Hub[] getCarguero() {
        return carguero;
    }
}