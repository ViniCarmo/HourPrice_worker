package Entities;

import Entities.enumm.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker(String workerName, WorkerLevel level, String baseSalario, Department department) {

    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;

    }

    public void setContracts(List<HourContract> contracts) {
        this.contracts = contracts;
    }

    public void addContracts(HourContract contract) {
        contracts.add(contract);
    }

    public void remveContract(HourContract contract) {
        contracts.remove(contract);
    }

    public Double calculaGanho(int year, int mounth) {
        double soma = baseSalary;

        Calendar calendar = Calendar.getInstance();
        for (HourContract c : contracts) {
            calendar.setTime(c.getDate());
            int c_month = 1 + calendar.get(Calendar.MONTH);
            int c_year = calendar.get(Calendar.YEAR);

            if (c_year == year & c_month == mounth) {
                return soma += c.totalValue();
            }
        }
        return null;
    }
}

