package org.example.dao;

import org.example.entities.Appointment;

import java.util.List;

public interface AppointmentDAO {
    void              insert(Appointment appointment);
    Appointment       findById(String id);
    List<Appointment> findAll();
    void              update(Appointment appointment);
    void              delete(String id);
    boolean           existsById(String id);
}
