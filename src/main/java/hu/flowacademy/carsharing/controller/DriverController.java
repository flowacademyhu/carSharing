package hu.flowacademy.carsharing.controller;

import hu.flowacademy.carsharing.domain.Driver;
import hu.flowacademy.carsharing.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/add")
    public ResponseEntity<Driver> addTodoItem(@RequestBody Driver driver) {
        return ResponseEntity.ok(driverService.save(driver));
    }

    @PutMapping("/update")
    public ResponseEntity<Driver> updateTodoItem(@RequestBody Driver driver) {
        return ResponseEntity.ok(driverService.save(driver));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTodoItem(@PathVariable String id) {
        try {
            driverService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Driver> findOneItem(@PathVariable String id) {
        return ResponseEntity.ok(driverService.getById(id));
    }
}
