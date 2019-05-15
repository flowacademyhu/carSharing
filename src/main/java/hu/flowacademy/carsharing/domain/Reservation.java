package hu.flowacademy.carsharing.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="reservations")
public class Reservation {

    @Id
    @SequenceGenerator(name="idgenerator", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "idgenerator", strategy = GenerationType.SEQUENCE)
    @Column
    private long id;

    @Column(name = "reservation_time")
    private LocalDateTime reservationTime;

    @Column
    private LocalDate start;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "car_regnum", foreignKey = @ForeignKey(name = "fk_car_reservation"))
    private Car car;


    @ManyToOne
    @JoinColumn(name = "driver_username", foreignKey = @ForeignKey(name = "fk_reservation_driverid"))
    private Driver driver;

    public Reservation(long id, LocalDateTime reservationTime, LocalDate start, LocalDate endDate, String description, Car car, Driver driver) {
        this.id = id;
        this.reservationTime = reservationTime;
        this.start = start;
        this.endDate = endDate;
        this.description = description;
        this.car = car;
        this.driver = driver;
    }

    public Reservation() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
