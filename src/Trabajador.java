import java.time.LocalDateTime;

public class Trabajador {

    int entrada, salida, hora;
    double  sueldo;
    String id, puesto;

    public Trabajador(String id, String puesto, int sueldo, int hora) {
        this.id = id;
        this.puesto = puesto;
        this.sueldo = sueldo;
        this.hora = hora;
        switch(this.puesto){
            case ("CEO"):{ this.entrada=7;this.salida=18;}
            case ("Jefe"):{ this.entrada=8;this.salida=18;}
            case ("Ingeniero"):{ this.entrada=9;this.salida=18;}
            case ("Analista"):{ this.entrada=9;this.salida=17;}
            case ("Scrum Master"):{ this.entrada=9;this.salida=18;}
            case ("RRHH"):{ this.entrada=9;this.salida=18;}
        }
    }

    boolean enHorario(){
        int time = LocalDateTime.now().getHour();
        if (time > this.getEntrada()){
            switch(this.puesto) {
                case ("CEO"): {
                    this.setSueldo(this.getSueldo()-(this.getSalida()*0.01));
                }
                case ("Jefe"): {
                    this.setSueldo(this.getSueldo()-(this.getSalida()*0.05));
                }
                case ("Ingeniero"): {
                    this.setSueldo(this.getSueldo()-(this.getSalida()*0.15));
                }
                case ("Analista"): {
                    this.setSueldo(this.getSueldo()-(this.getSalida()*0.2));
                }
                case ("Scrum Master"): {
                    this.setSueldo(this.getSueldo()-(this.getSalida()*0.1));
                }
                case ("RRHH"): {
                    this.setSueldo(this.getSueldo()-(this.getSalida()*0.09));
                }
            }
            System.out.println("Nuevo sueldo:" + this.getSueldo());
            return false;
        }
        else return true;
    }

    public int getEntrada() {return entrada;}

    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    public int getSalida() {
        return salida;
    }

    public void setSalida(int salida) {
        this.salida = salida;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSueldo() {return sueldo; }

    public void setSueldo(double sueldo) { this.sueldo = sueldo;}
}