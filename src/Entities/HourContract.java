package Entities;

import java.util.Date;

public class HourContract {
    private Date date;
    private Double valueHour;
    private Integer hours;

public HourContract(){

}

public HourContract(Date date, Double valueHour, Integer hours) {
        this.date = date;
        this.valueHour = valueHour;
        this.hours = hours;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValueHour() {
        return valueHour;
    }

    public void setValueHour(Double valueHour) {
        this.valueHour = valueHour;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Double totalValue(){
    return valueHour * hours;
    }
}
