package hu.flowacademy.carsharing.service;

import hu.flowacademy.carsharing.domain.Car;
import hu.flowacademy.carsharing.domain.Driver;
import hu.flowacademy.carsharing.domain.Reservation;
import hu.flowacademy.carsharing.repository.CarRepository;
import hu.flowacademy.carsharing.repository.DriverRepository;
import hu.flowacademy.carsharing.repository.ReservationRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

@Transactional
@Service
public class ReservationService {

    @Autowired
    private CarService carService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation save(Reservation reservation) throws Exception {
        Driver driver = driverService.getById(reservation.getDriver().getFullname());
        Car car = carService.getById(reservation.getCar().getRegNum());
        if (car != null && driver != null && car.getExpires().isBefore(LocalDate.now()) && driver.getExpire().isBefore(LocalDate.now())) {
            List<Reservation> resByCar = reservationRepository.resByCar(car.getRegNum());
            boolean isFreeCar = true;
            for (var res: resByCar) {
                if (reservation.getStart().isBefore(res.getEndDate()) && reservation.getStart().isAfter(res.getStart())) {
                    isFreeCar = false;
                }
                if (reservation.getEndDate().isAfter(res.getStart()) && reservation.getEndDate().isBefore(res.getEndDate())) {
                    isFreeCar = false;
                }
            }
            if (isFreeCar) {
                return reservationRepository.save(reservation);
            }
        }
        throw new Exception("hiba");
    }

    public void delete(Long id) throws Exception {
        try {
            reservationRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception();
        }
    }
    public Reservation getById(Long id) {
        return reservationRepository.findById(id).get();
    }


   /* public Reservation update(Reservation reservation) {
        Driver driver = driverService.getById(reservation.getDriver().getFullname());
        Car car = carService.getById(reservation.getCar().getRegNum());

        if (car != null && driver != null && car.getExpires().isBefore(LocalDate.now()) && driver.getExpire().isBefore(LocalDate.now())) {
          return reservationRepository.save(reservation);
        }
        new Exception("Hiba");
        return null;

    }*/

    public List<Reservation> findByDriver(String driverName) {
        Driver driver = driverService.getByName(driverName);
        System.out.println(driver.getFullname());
        return reservationRepository.resByDriver(driver.getUsername());
    }


    public List<Reservation> findByCar(String carManufacturer) {
        return reservationRepository.resByManufacturer(carManufacturer);
    }
    public List<Reservation> findByInterval(LocalDate start,LocalDate end) {
        List<Reservation> allres = reservationRepository.findAll();
        Iterator i = allres.iterator();
        while(i.hasNext()) {
            Reservation res=(Reservation)i.next();
            if (res.getEndDate().isAfter(end) || res.getStart().isBefore(start)) {
                allres.remove(res);
            }
        }
        return allres;
    }


}
