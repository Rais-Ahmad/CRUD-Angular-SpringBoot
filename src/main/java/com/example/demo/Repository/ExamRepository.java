package com.example.demo.Repository;

import com.example.demo.Model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author RaisAhmad
 * @date 29/10/2021
 * @Discription Exam Repository
 *
 */

public interface ExamRepository extends JpaRepository<Exam, Long> {

}
