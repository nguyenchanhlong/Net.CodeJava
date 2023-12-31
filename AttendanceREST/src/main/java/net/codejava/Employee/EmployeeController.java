package net.codejava.Employee;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // Use GetMapping to listAll
    @GetMapping("/employees")
    public List<Employee> list() {
        return service.listAll();
    }

    // Use GetMapping to list a single value by ID
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> get(@PathVariable Integer id) {
        // This help api not show the error with mean NOT FOUND
        try {
            Employee employee = service.get(id);
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }

    // Use PostMapping to POST
    @PostMapping("employees")
    public ResponseEntity<?> add(@RequestBody Employee employee) {
        /*
         * This is the function with the Exist Employee
         * if it exist the Httpstatus will show the error
         */

        List<Employee> existingEmployees = service.listAll();
        for (Employee existingEmployee : existingEmployees) {
            if (existingEmployee.getId().equals(employee.getId())) {
                return new ResponseEntity<>("Employee with ID: " + employee.getId() + " already exist",
                        HttpStatus.BAD_REQUEST);
            }
        }
        service.save(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
     * {
     * "id":1,
     * "name": "Long",
     * "phone": "03165484984",
     * "email": "dada@gmail.com"
     * }
     * This is the JSON file if want to PUT
     */
    @PutMapping("/employees/{id}")
    public ResponseEntity<?> update(@RequestBody Employee employee, @PathVariable Integer id) {
        try {
            Employee existEmployee = service.get(id);
            // Employee existEmployee = service.get(id);
            service.save(employee);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
