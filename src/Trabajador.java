import java.time.LocalDate;

public class Trabajador {

    int id, entrada, salida;
    String puesto;

    public Trabajador(int id, String puesto) {
        this.id = id;
        this.puesto = puesto;
        switch(this.puesto){
            case ("CEO"):{ this.entrada=7;this.salida=18;}
            case ("Jefe"):{ this.entrada=8;this.salida=18;}
            case ("Ingeniero"):{ this.entrada=9;this.salida=18;}
            case ("Analista"):{ this.entrada=9;this.salida=17;}
            case ("Scrum Master"):{ this.entrada=9;this.salida=18;}
            case ("RRHH"):{ this.entrada=9;this.salida=18;}
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEntrada() {
        return entrada;
    }

    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    public int getSalida() {
        return salida;
    }

    public void setSalida(int salida) {
        this.salida = salida;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }


}