package hu.flowacademy.carsharing.repository;

import hu.flowacademy.carsharing.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    /*@Query("FROM Reservation reservation where car.regNum = ?1 AND driver.username = ?2")
    public Reservation getByCarIdAndDriverId(String carId,String driverId);*/
    @Query("FROM Reservation reservation where car.regNum = ?1")
    public List<Reservation> resByCar(String carId);

    @Query("FROM Reservation reservation where driver.username = ?1")
    public List<Reservation> resByDriver(String driverId);

    @Query("FROM Reservation reservation WHERE car_manufacturer = ?1")
    public List<Reservation> resByManufacturer(String manufacturer);

}
