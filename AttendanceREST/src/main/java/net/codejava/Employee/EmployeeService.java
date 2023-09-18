// This is the fifth step Create the Service
package net.codejava.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// This is the important source code
// Use @Service
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public java.util.List<Employee> listAll() {
        return repo.findAll();
    }

    public void save(Employee attendance) {
        repo.save(attendance);
    }

    public Employee get(Integer eid) {
        return repo.findById(eid).get();
    }

    public void delete(Integer eid) {
        repo.deleteById(eid);
    }
}
