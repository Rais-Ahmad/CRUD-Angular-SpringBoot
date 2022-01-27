package com.example.demo.Repository;

import com.example.demo.Model.Degree;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 
 * @author RaisAhmad
 * @date 29/10/2021
 * @Discription Degree Repository
 *
 */

public interface DegreeRepository extends JpaRepository<Degree, Long> {

	Optional<Degree> findByName(String name);

}
