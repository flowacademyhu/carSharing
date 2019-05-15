package hu.flowacademy.carsharing.repository;

import hu.flowacademy.carsharing.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriverRepository extends JpaRepository<Driver,String> {
    @Query("FROM Driver driver WHERE driver.fullname = ?1")
    public Driver getByName(String name);
}
