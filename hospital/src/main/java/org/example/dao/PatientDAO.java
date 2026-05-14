package org.example.dao;

import org.example.entities.Patient;

import java.util.List;

public interface PatientDAO {

    void         insert(Patient patient);
    Patient      findById(String id);
    List<Patient> findAll();
    void         update(Patient patient);
    void         delete(String id);
    boolean      existsById(String id);
}
