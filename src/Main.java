import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String id, puesto;
        int sueldo, hora;

        ArrayList<Trabajador> plantilla = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Número de empleados: ");
        int num = Integer.parseInt(scanner.nextLine());

        for(int i=0; i<num; i++){
            System.out.println("Identificador: ");
            id = scanner.nextLine();
            System.out.println("Puesto: ");
            puesto = scanner.nextLine();
            System.out.println("Sueldo: ");
            sueldo = Integer.parseInt(scanner.nextLine());
            System.out.println("Hora de entrada: ");
            hora = Integer.parseInt(scanner.nextLine());

            plantilla.add(new Trabajador(id,puesto,sueldo,hora));
        }

        Iterator<Trabajador> iterator = plantilla.iterator();
        Trabajador actual;
        String fueraHorario = "";
        while (iterator.hasNext()) {
            actual = iterator.next();
            if(!actual.enHorario()){
                fueraHorario += actual.getPuesto()+ " " + actual.getId();
            }
        }

       String jenkinsfile = "pipeline {\n" +
                "    agent any\n" +
                "    stages {\n" +
                "        stage('Ejemplo') {\n" +
                "            steps {\n" +
                "                script {\n" +
                "                    echo \"Fuera de horario: "+fueraHorario+"\"\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}\n";
        File file = new File("C:\\Users\\dazanonr\\Documents\\IntelliJ Projects\\Ejercicios Java Indra\\Ejercicio Jenkins 4\\Jenkinsfile");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(jenkinsfile);
        bufferedWriter.close();
    }
}