package org.example.repository;

import org.example.dao.AppointmentDAO;
import org.example.dao.DoctorDAO;
import org.example.dao.PatientDAO;
import org.example.entities.Appointment;
import org.example.entities.Doctor;
import org.example.entities.Patient;

import java.util.List;

public class HospitalRepository {

    // repository holds the DAOs — it is the only layer that touches them
    private final PatientDAO     patientDAO;
    private final DoctorDAO      doctorDAO;
    private final AppointmentDAO appointmentDAO;

    public HospitalRepository(PatientDAO patientDAO,
                              DoctorDAO doctorDAO,
                              AppointmentDAO appointmentDAO) {
        this.patientDAO     = patientDAO;
        this.doctorDAO      = doctorDAO;
        this.appointmentDAO = appointmentDAO;
    }

    // ── PATIENT ───
    public void    savePatient(Patient patient)
    { patientDAO.insert(patient); }
    public Patient getPatient(String id)
    { return patientDAO.findById(id); }
    public List<Patient> getAllPatients()
    { return patientDAO.findAll(); }
    public void    updatePatient(Patient patient)
    { patientDAO.update(patient); }
    public void    deletePatient(String id)
    { patientDAO.delete(id); }
    public boolean patientExists(String id)
    { return patientDAO.existsById(id); }

    // ── DOCTOR ──
    public void   saveDoctor(Doctor doctor)
    { doctorDAO.insert(doctor); }
    public Doctor getDoctor(String id)
    { return doctorDAO.findById(id); }
    public List<Doctor> getAllDoctors()
    { return doctorDAO.findAll(); }
    public void   updateDoctor(Doctor doctor)
    { doctorDAO.update(doctor); }
    public void   deleteDoctor(String id)
    { doctorDAO.delete(id); }
    public boolean doctorExists(String id)
    { return doctorDAO.existsById(id); }

    // ── APPOINTMENT ───
    public void        saveAppointment(Appointment a)
    { appointmentDAO.insert(a); }
    public Appointment getAppointment(String id)
    { return appointmentDAO.findById(id); }
    public List<Appointment> getAllAppointments()
    { return appointmentDAO.findAll(); }
    public void        updateAppointment(Appointment a)
    { appointmentDAO.update(a); }
    public void        deleteAppointment(String id)
    { appointmentDAO.delete(id); }
    public boolean     appointmentExists(String id)
    { return appointmentDAO.existsById(id); }
}