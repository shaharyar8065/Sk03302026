package org.example.dao;

import org.example.entities.Doctor;

import java.util.List;

public interface DoctorDAO {
    void         insert(Doctor doctor);
    Doctor       findById(String id);
    List<Doctor> findAll();
    void         update(Doctor doctor);
    void         delete(String id);
    boolean      existsById(String id);


}
