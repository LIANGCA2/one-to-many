package com.leo.one.to.many.repositories;

import com.leo.one.to.many.entitis.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author LIULE9
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
