package com.example.demo.Repository;

import com.example.demo.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author RaisAhmad
 * @date 29/10/2021
 * @Discription Department Repository
 *
 */

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
