package hu.flowacademy.carsharing.service;

import hu.flowacademy.carsharing.domain.Car;
import hu.flowacademy.carsharing.domain.Driver;
import hu.flowacademy.carsharing.domain.Reservation;
import hu.flowacademy.carsharing.repository.CarRepository;
import hu.flowacademy.carsharing.repository.DriverRepository;
import hu.flowacademy.carsharing.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Transactional
@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public void delete(String id) {
        try {
            List<Reservation> resByCar = reservationRepository.resByCar(id);
            if (resByCar.isEmpty()) {
                carRepository.deleteById(id);
            } else {
                throw new Exception("nem lehet torolni");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public Car getById(String id) {
        return carRepository.findById(id).get();
    }

    public List<Car> listByManufacturer(String manufacturer) {
        return carRepository.listByManufacturer(manufacturer);
    }

    public List<Car> listByValidReg() {
        return carRepository.carNotExpiredCars(LocalDate.now());
    }

    public List<Car> getAll() {
        return carRepository.findAll();
    }


}
