package com.example.demo.Service;

import com.example.demo.Model.Degree;
import com.example.demo.Repository.DegreeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DegreeService {
    private static final Logger LOG = LogManager.getLogger(DegreeService.class);
    private final DegreeRepository degreeRepository;

    public DegreeService(DegreeRepository degreeRepository) {

        this.degreeRepository = degreeRepository;
    }

    /**
     * @return
     * @author RaisAhmad
     * @date 29/10/2021
     */

    public ResponseEntity<Object> listAllDegree() {

        List<Degree> degreeList = degreeRepository.findAll();

        if (degreeList.isEmpty()) {
            LOG.info("List is empty ");
            return new ResponseEntity<>("No data available", HttpStatus.NOT_FOUND);
        } else {
            LOG.info("List of degrees : " + degreeList);
            return new ResponseEntity<>(degreeList, HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> degreeById(long id) {

        Optional<Degree> degree;
        degree = degreeRepository.findById(id);
        return new ResponseEntity<>(degree, HttpStatus.OK);
    }

    public Degree findDegreeById(long id) {

        Optional<Degree> degree1;
        degree1 = degreeRepository.findById(id);
        Degree degree = degree1.get();
        return degree;
    }

    /**
     * @param degree
     * @return
     * @author RaisAhmad
     * @date 29/10/2021
     */
    public ResponseEntity<Object> saveDegree(Degree degree) {

        try {

            Calendar date = Calendar.getInstance();
            degree.setDate(date.getTime());

            if (degree.getName() == null) {
                return new ResponseEntity<>("Degree name can't be empty", HttpStatus.BAD_REQUEST);
            } else {
                LOG.info("Degree saved ");
                return ResponseEntity.ok().body(degreeRepository.save(degree));
            }
        } catch (Exception e) {
            LOG.info("Degree alreday exists ");
            return new ResponseEntity<>("Degree already exist ", HttpStatus.CONFLICT);
        }

    }

    /**
     * @param degree
     * @author RaisAhmad
     * @date 29/10/2021
     */

    public ResponseEntity<Object> updateDegree(Degree degree) {
        try {
            Calendar date = Calendar.getInstance();
            degree.setUpdatedDate(date.getTime());
            degreeRepository.save(degree);
            LOG.info("Degree updated ");
            return new ResponseEntity<>("Degree updated ", HttpStatus.CONFLICT);

        } catch (Exception e) {
            LOG.info("Degree not updated ");
            return new ResponseEntity<>("Degree not found ", HttpStatus.CONFLICT);
        }
    }


    public ResponseEntity<Object> updateDegreeAngular(Degree degree, String name) {
        try {
            Calendar date = Calendar.getInstance();
            degree.setUpdatedDate(date.getTime());
            degree.setName(name);
            degreeRepository.save(degree);
            LOG.info("Degree updated ");
            return new ResponseEntity<>("Degree updated ", HttpStatus.CONFLICT);

        } catch (Exception e) {
            LOG.info("Degree not updated ");
            return new ResponseEntity<>("Degree not found ", HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<Object> deleteDegree(long id) {
        try {
             degreeRepository.deleteAllById(Collections.singleton(id));
             return new ResponseEntity<> ("Degree  deleted successfully ", HttpStatus.OK);

            } catch (Exception e) {
            LOG.info("Degree not found ");
            return new ResponseEntity<>("Degree not found ", HttpStatus.CONFLICT);
        }

    }

}
