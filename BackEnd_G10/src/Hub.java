public class Hub {

    private Contenedor [][] complex;
    private byte libresPrioridad1 = 10, libresPrioridad2 = 10, libresPrioridad3 = 100;
    public Hub(){
        complex = new Contenedor[10][12];
    }

    public void apilarContenedor(Contenedor c){
        boolean error = false;
        for(int i=0; i<12; i++){
            if(error) break;
            for(int j=9; j>=0; j--){
                if(complex[j][i]==null)
                    continue;
                if(complex[j][i].getItentificador()==c.getItentificador())
                    //error = true;
                    error = false;
                    break;
            }
        }
        if(error){
            System.out.println("¡ERROR! El identificador de ese contenedor debe ser unico");
        }else{

            if(c.getPrioridad()==1 && complex[0][0]!=null)
                System.out.println("¡ERROR! Ya no caben más contenedores de prioridad 1");
            if(c.getPrioridad()==1 && complex[0][0]==null){
                for(int i=9; i>=0; i--){
                    if(complex[i][0]==null){
                        complex[i][0]=c;
                        libresPrioridad1--;
                        break;
                    }
                }
            }

            if(c.getPrioridad()==2 && complex[0][1]!=null)
                System.out.println("¡ERROR! Ya no caben más contenedores de prioridad 2");
            if(c.getPrioridad()==2 && complex[0][1]==null){

                for(int i=9; i>=0; i--){
                    if(complex[i][1]==null){
                        complex[i][1]=c;
                        libresPrioridad2--;
                        break;
                    }
                }
            }

            if(c.getPrioridad()==3){
                boolean hueco=false;
                for(int i=2;i<12; i++){
                    if(hueco) break;
                    for(int j=9; j>=0; j--){
                        if(complex[j][i]==null){
                            hueco = true;
                            complex[j][i]=c;
                            libresPrioridad3--;
                            break;
                        }
                    }
                }
                if(!hueco) System.out.println("¡ERROR! Ya no caben más contenedores de prioridad 3");
            }
        }
    }

    public void desapilarContenedor(int columna){

        if(columna<1 && columna>12) System.out.println("la columna " + columna + " no existe");

        if(columna==1 && complex[9][0]==null) System.out.println("No hay contenedores en la columna " + columna + " para desapilar");
        if(columna==1 && complex[9][0]!=null){
            for(int i=0; i<10; i++){
                if(complex[i][0]!=null){
                    complex[i][0]=null;
                    libresPrioridad1++;
                    break;
                }
            }
        }

        if(columna==2 && complex[9][1]==null)
            System.out.println("No hay contenedores en la columna " + columna + " para desapilar");
        if(columna==2 && complex[9][1]!=null){
            for(int i=0; i<10; i++){
                if(complex[i][1]!=null){
                    complex[i][1]=null;
                    libresPrioridad2++;
                    break;
                }
            }
        }

        if(columna>2 && columna<13){
            boolean vacio=false;
            if(complex[9][columna-1]==null)
                System.out.println("No hay contenedores en la columna " + columna + " para desapilar");
            else{
                for(int i=0; i<10; i++){

                    if(complex[i][columna-1]!=null){
                        complex[i][columna-1]=null;
                        libresPrioridad3++;
                        break;
                    }
                }
            }
        }

    }

    public String toString(){
        String s="  ";
        for(int j=0; j<12; j++) {
            if(j<9)
                s += "   " + (j+1);
            if(j>=9)
                s += "  " + (j+1);
        }
        s+= "\n";

        for(int i=0; i<10; i++){
            if(i<9)
                s += " " + (i+1) + ": ";
            if(i==9)
                s += (i+1) + ": ";


            for(int j=0; j<12; j++){
                if(complex[i][j]==null)
                    s += "[ ] ";
                else{
                    if(complex[i][j].getPrioridad()==1)
                        s += "[1] ";
                    if(complex[i][j].getPrioridad()==2)
                        s += "[2] ";
                    if(complex[i][j].getPrioridad()==3)
                        s += "[3] ";
                }
            }
            s += "\n";
        }
        return s;
    }

    public void mostrarDatosContenedor(int id){
        boolean presente=false;
        for(int i=0; i<10; i++){
            for(int j=0; j<12; j++){

                if(complex[i][j]!=null && complex[i][j].getItentificador()==id){
                    presente=true;
                    System.out.println("Identificador: " + complex[i][j].getItentificador() +
                            "\nPrioridad: " + complex[i][j].getPrioridad() +
                            "\nPeso: " + complex[i][j].getPeso() +
                            "\nPais de procedencia: " + complex[i][j].getPaísProcedencia() +
                            "\nEmpresa emitido: " + complex[i][j].getEmpresaEmisora() +
                            "\nEmpresa Receptor: " + complex[i][j].getEmpresaReceptora() +
                            "\nDescripción: " + complex[i][j].getDescripción());
                }

            }
        }
        //if(!presente) System.out.println("No existe ningún contenecodor con el identificador " + ide);
    }

    public int contenedoresPais(String país){
        int cantidad=0;
        for(int i=0; i<10; i++){
            for(int j=0; j<12; j++){
                if(complex[i][j]==null)
                    continue;
                if(complex[i][j].getPaísProcedencia().equals(país))
                    cantidad++;
            }
        }
        return cantidad;
    }

    public byte getLibresPrioridad1() {
        return libresPrioridad1;
    }

    public byte getLibresPrioridad2() {
        return libresPrioridad2;
    }

    public byte getLibresPrioridad3() {
        return libresPrioridad3;
    }
}
