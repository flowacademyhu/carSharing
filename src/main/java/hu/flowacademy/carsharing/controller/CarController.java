package hu.flowacademy.carsharing.controller;

import hu.flowacademy.carsharing.domain.Car;
import hu.flowacademy.carsharing.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        return ResponseEntity.ok(carService.save(car));
    }

    @PutMapping("/update")
    public ResponseEntity<Car> updateCar(@RequestBody Car car) {
        return ResponseEntity.ok(carService.save(car));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable String id) {
        carService.delete(id);
        return ResponseEntity.noContent().build();
    }

//1321
    @GetMapping("/find/{id}")
    public ResponseEntity<Car> findOneCar(@PathVariable String id) {
        return ResponseEntity.ok(carService.getById(id));
    }

    @GetMapping("/get-by-manufacturer/{manufacturer}")
    public ResponseEntity<List<Car>> listByManufacturer(@PathVariable String manufacturer) {
        return ResponseEntity.ok(carService.listByManufacturer(manufacturer));
    }
    @GetMapping("/get-by-valid-reg")
    public ResponseEntity<List<Car>> listByValidReg() {
        return ResponseEntity.ok(carService.listByValidReg());
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Car>> getAll() {
        return ResponseEntity.ok(carService.getAll());
    }
}
