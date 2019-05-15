package hu.flowacademy.carsharing.controller;
import hu.flowacademy.carsharing.domain.Car;
import hu.flowacademy.carsharing.domain.Driver;
import hu.flowacademy.carsharing.domain.Reservation;
import hu.flowacademy.carsharing.service.CarService;
import hu.flowacademy.carsharing.service.DriverService;
import hu.flowacademy.carsharing.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private CarService carService;

    @Autowired
    DriverService driverService;

    @PostMapping("/add")
    public ResponseEntity<Reservation> addTodoItem(@RequestBody Reservation reservation) {
        try {
            return ResponseEntity.ok(reservationService.save(reservation));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PutMapping("/update")
    public ResponseEntity<Reservation> updateTodoItem(@RequestBody Reservation reservation) {
        try {
            return ResponseEntity.ok(reservationService.save(reservation));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTodoItem(@PathVariable Long id) {
        try {
            reservationService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Reservation> findOneItem(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.getById(id));
    }

    @GetMapping("/find-by-driver/{driver}")
    public ResponseEntity<List<Reservation>> findByDrivers(@PathVariable String driver) {
        return ResponseEntity.ok(reservationService.findByDriver(driver));
    }

    @GetMapping("/find-by-interval")
    public ResponseEntity<List<Reservation>> findByInterval(LocalDate start,LocalDate end) {
        return ResponseEntity.ok(reservationService.findByInterval(start,end));
    }
}