package net.codejava.Attendance;

import java.time.LocalDate;
// import java.sql.Date;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Attendance {
    private Integer id;
    private LocalDate date;
    private LocalTime clock_in;
    private LocalTime clock_out;

    public Attendance() {
    }

    public Attendance(Integer id, LocalDate date, LocalTime clock_in, LocalTime clock_out) {
        this.id = id;
        this.date = date;
        this.clock_in = clock_in;
        this.clock_out = clock_out;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getClock_in() {
        return clock_in;
    }

    public void setClock_in(LocalTime clock_in) {
        this.clock_in = clock_in;
    }

    public LocalTime getClock_out() {
        return clock_out;
    }

    public void setClock_out(LocalTime clock_out) {
        this.clock_out = clock_out;
    }

}
