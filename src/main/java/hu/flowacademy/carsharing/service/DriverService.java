package hu.flowacademy.carsharing.service;

import hu.flowacademy.carsharing.domain.Driver;
import hu.flowacademy.carsharing.domain.Reservation;
import hu.flowacademy.carsharing.repository.DriverRepository;
import hu.flowacademy.carsharing.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public Driver save(Driver driver) {
        return driverRepository.save(driver);
    }

    public void delete(String id) throws Exception {
        try {
            List<Reservation> resByDriver = reservationRepository.resByDriver(id);
            if (resByDriver.isEmpty()) {
                driverRepository.deleteById(id);
            } else {
                throw new Exception("nem lehet kitorolni  a drivert");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public Driver getById(String id) {
        return driverRepository.findById(id).get();
    }

    public Driver getByName(String name) {
        return driverRepository.getByName(name);
    }
}
