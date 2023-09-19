package net.codejava.Attendance;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendanceController {

    @Autowired
    private AttendanceService service;

    @GetMapping("/attendances")
    public List<Attendance> list() {
        return service.listAll();
    }

    @GetMapping("/attendances/{id}")
    public ResponseEntity<Attendance> get(@PathVariable Integer id) {
        try {
            Attendance attendance = service.get(id);
            return new ResponseEntity<Attendance>(attendance, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Attendance>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/attendances")
    public void add(@RequestBody Attendance attendance) {
        service.save(attendance);
    }

    @PutMapping("/attendances/{id}")
    public ResponseEntity<?> check_out(@PathVariable Integer id) {
        LocalTime currentTime = LocalTime.now(); // Get the current time
        try {
            // Call the updateClockOut method from the service
            service.updateClockOut(id, currentTime);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
