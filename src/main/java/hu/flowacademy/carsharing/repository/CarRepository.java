package hu.flowacademy.carsharing.repository;

import hu.flowacademy.carsharing.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, String> {

    @Query("FROM Car car WHERE car.manufacturer = ?1")
    public List<Car> listByManufacturer(String manufacturer);

    @Query("FROM Car car")
    public List<Car> carList();

    @Query("FROM Car car WHERE car.expires > ?1")
    public List<Car> carNotExpiredCars(LocalDate localDate);
}