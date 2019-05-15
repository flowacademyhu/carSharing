package hu.flowacademy.carsharing.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String fullname;

    @Column
    private LocalDate expire;

    @Column
    private boolean isActive;

    public Driver(String username, String password, String fullname, LocalDate expire, boolean isActive) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.expire = expire;
        this.isActive = isActive;
    }

    public Driver() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDate getExpire() {
        return expire;
    }

    public void setExpire(LocalDate expire) {
        this.expire = expire;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
