package hu.flowacademy.carsharing.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "cars")
public class Car {

    @Id
    @Column(name = "regnum")
    private String regNum;

    @Column
    private String manufacturer;

    @Column
    private String type;

    @Column
    private int year;

    @Column
    private LocalDate expires;

    @OneToMany(mappedBy = "car")
    private List<Reservation> reservation;




    public Car() {
    }

    public Car(String regNum, String manufacturer, String type, int year, LocalDate expires) {
        this.regNum = regNum;
        this.manufacturer = manufacturer;
        this.type = type;
        this.year = year;
        this.expires = expires;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String  regNum) {
        this.regNum = regNum;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public LocalDate getExpires() {
        return expires;
    }

    public void setExpires(LocalDate expires) {
        this.expires = expires;
    }



}
