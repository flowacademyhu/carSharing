package hu.flowacademy.carsharing.util;

import hu.flowacademy.carsharing.domain.Car;
import hu.flowacademy.carsharing.domain.Driver;
import hu.flowacademy.carsharing.domain.Reservation;
import hu.flowacademy.carsharing.repository.CarRepository;
import hu.flowacademy.carsharing.repository.DriverRepository;
import hu.flowacademy.carsharing.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@Component
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public void run(String... args) throws Exception {

        Car car1 = new Car("1321","Ford","Fiesta",1966,LocalDate.now());
        Car car2 = new Car("4321","Opel","Corsa",2016,LocalDate.now());
        Car car3 = new Car("16432","Fityo","Fityo",2018,LocalDate.now());

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);

        Driver driver1 = new Driver("janiVagyok","jani123","Jani Kovacs",LocalDate.now(),false);
        Driver driver2 = new Driver("Feri1","FeriHid","Ferenc Hegedus",LocalDate.now(),true);
        Driver driver3 = new Driver("Pecze","gitpush","Tamas Pecze",LocalDate.now(),true);

        driverRepository.save(driver1);
        driverRepository.save(driver2);
        driverRepository.save(driver3);

        Reservation res1 = new Reservation(1, LocalDateTime.now(),LocalDate.of(2019, Month.APRIL,12),LocalDate.of(2019, Month.APRIL,12),"JoskaVagyok",car1,driver1);
        Reservation res2 = new Reservation(2, LocalDateTime.now(),LocalDate.of(2018, Month.JANUARY,1),LocalDate.of(2018, Month.FEBRUARY,12),"fontos",car1,driver2);

        reservationRepository.save(res1);
        reservationRepository.save(res2);

    }
}
