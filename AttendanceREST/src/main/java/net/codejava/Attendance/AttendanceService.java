package net.codejava.Attendance;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository repo;

    public List<Attendance> listAll() {
        return repo.findAll();
    }

    public void save(Attendance attendance) {
        LocalTime currentTime = LocalTime.now();
        LocalDate currentDate = LocalDate.now();

        attendance.setDate(currentDate);
        attendance.setClock_in(currentTime);
        repo.save(attendance);
    }

    public Attendance get(Integer id) {
        return repo.findById(id).get();
    }

    public void updateClockOut(Integer id, LocalTime currentTime) {
        Attendance attendance = repo.findById(id).orElse(null);
        if (attendance != null) {
            if (attendance.getClock_out() == null) {
                attendance.setClock_out(currentTime);
                repo.save(attendance);
            }
        }
    }

    // This statement can't delete
}
