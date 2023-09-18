// This is third step Create the Repository interface
package net.codejava.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

// Use JpaRepository<nameofProduct,Type of KeyID>
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
