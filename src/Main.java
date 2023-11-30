import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        int id;
        String puesto;
        ArrayList<Trabajador> plantilla = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Número de empleados: ");
        int num = scanner.nextInt();

        for(int i=0; i<num; i++){
            System.out.println("Identificador: ");
            id = scanner.nextInt();
            System.out.println("Puesto: ");
            puesto = scanner.nextLine();
            plantilla.add(new Trabajador(id,puesto));
        }

        Iterator<Trabajador> iterator = plantilla.iterator();
        Trabajador actual;
        String fueraHorario = "Fuera de horario: ";
        int time = LocalDateTime.now().getHour();
        while (iterator.hasNext()) {
            actual = iterator.next();
            if(time < actual.getEntrada() || time > actual.getSalida()){
                fueraHorario += actual.getId();
            }
        }

        String jenkinsfile = "pipeline {\n" +
                "    agent any\n" +
                "    stages {\n" +
                "        stage('Ejemplo') {\n" +
                "            steps {\n" +
                "                script {\n" +
                "                    echo \"La unidad base es: "+fueraHorario+"\"\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}\n";
        File file = new File("C:\\Users\\dazanonr\\Documents\\IntelliJ Projects\\Ejercicios Java Indra\\Ejercicio Jenkins 4\\Jenkinsfile");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(jenkinsfile);
    }
}