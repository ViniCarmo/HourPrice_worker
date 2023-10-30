package App;

import Entities.Department;
import Entities.HourContract;
import Entities.Worker;
import Entities.enumm.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Entre com o nome do departamento: ");
        String departmentName = scanner.nextLine();

        System.out.println("Entre com os dados do funcionario: ");
        System.out.print("Name: ");
        String workerName = scanner.nextLine();

        System.out.print("Nivel: ");
        String workerLevel = scanner.nextLine();

        System.out.print("Salario base: ");
        Double baseSalario = scanner.nextDouble();


        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalario, new Department(departmentName) );

        System.out.println("Quantos contratos esse trabalhador vai ter?");
        int n = scanner.nextInt();

        for (int i=1; i <= n; i++){
            System.out.println("Entre com a #" + i + "data: ");
            System.out.print("date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(scanner.next());
            System.out.println("Valor por hora: ");
            double valuePerHour = scanner.nextDouble();
            System.out.println("Horas: ");
            int hours = scanner.nextInt();
            HourContract hourContract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContracts(hourContract);
        }

        System.out.println("Entre com mes e ano para calcular o salario (MM/YYYY): ");
        String monthAndYear = scanner.next();
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("na Data" + monthAndYear + "ganhou: " + String.format("%.2f", worker.calculaGanho(year, month)));




    }
}