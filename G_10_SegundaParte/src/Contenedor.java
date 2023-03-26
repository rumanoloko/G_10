public class Contenedor {
    private int itentificador, prioridad;
    private double peso;
    private String paísProcedencia;
    private String descripción, empresaEmisora, empresaReceptora;


    public Contenedor(int itentificador, int prioridad, double peso, String paísProcedencia, String descripción, String empresaEmisora, String empresaReceptora) {

        this.itentificador = itentificador;
        if(prioridad>=0 && prioridad<=3)
            this.prioridad = prioridad;
        //else System.out.println("ERROR");

        if(peso>=1)
            this.peso = peso;
        //else System.out.println("ERROR");

        this.paísProcedencia = paísProcedencia;
        if(descripción.length()<=100)
            this.descripción = descripción;
        //else System.out.println("ERROR");

        if(empresaEmisora.length()<=20)
            this.empresaEmisora = empresaEmisora;
        //else System.out.println("ERROR");

        if(empresaReceptora.length()<=20)
            this.empresaReceptora = empresaReceptora;
        //else System.out.println("ERROR");
    }

    public int getItentificador() {
        return itentificador;
    }

    public void setItentificador(int itentificador) {
        this.itentificador = itentificador;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        if(prioridad>0 && prioridad<4) this.prioridad = prioridad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if(peso>=1) this.peso = peso;
    }

    public String getPaísProcedencia() {
        return paísProcedencia;
    }

    public void setPaísProcedencia(String paísProcedencia) {
        this.paísProcedencia = paísProcedencia;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        if(descripción.length()<=100) this.descripción = descripción;
        //else System.out.println("Tamaño de descripción excede los 100 caracteres");
    }

    public String getEmpresaEmisora() {
        return empresaEmisora;
    }

    public void setEmpresaEmisora(String empresaEmisora) {
        if(empresaEmisora.length()<=20) this.empresaEmisora = empresaEmisora;
        //else System.out.println("Tamaño del nombre de la empresa emisora excede los 20 caracteres");
    }

    public String getEmpresaReceptora() {
        return empresaReceptora;
    }

    public void setEmpresaReceptora(String empresaReceptora) {
        if(empresaReceptora.length()<=20) this.empresaReceptora = empresaEmisora;
        //else System.out.println("Tamaño del nombre de la empresa recetora excede los 20 caracteres");
    }
}
