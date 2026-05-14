package org.example.services;

import org.example.entities.Appointment;
import org.example.entities.Doctor;
import org.example.entities.Patient;
import org.example.errors.HospitalExceptions;
import org.example.repository.HospitalRepository;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HospitalService {

    private final HospitalRepository  repository;
    private final NotificationService notificationService;

    public HospitalService(HospitalRepository repository,
                           NotificationService notificationService) {
        this.repository          = repository;
        this.notificationService = notificationService;
    }

    // ── PATIENT ───

    public void registerPatient(Patient patient) {
        if (repository.patientExists(patient.getId())) {
            System.out.println("Patient already exists: " + patient.getId());
            return;
        }
        repository.savePatient(patient);
        notificationService.notify(patient.getName(), "You have been registered.");
        System.out.println("Patient registered: " + patient.getName());
    }

    public Patient getPatient(String id) {
        Patient p = repository.getPatient(id);
        if (p == null) throw new HospitalExceptions.PatientNotFoundException(id);
        return p;
    }

    public List<Patient> getAllPatients() {
        return repository.getAllPatients();
    }

    public void updatePatient(Patient patient) {
        if (!repository.patientExists(patient.getId()))
            throw new HospitalExceptions.PatientNotFoundException(patient.getId());
        repository.updatePatient(patient);
        System.out.println("Patient updated: " + patient.getName());
    }

    public void deletePatient(String id) {
        if (!repository.patientExists(id))
            throw new HospitalExceptions.PatientNotFoundException(id);
        repository.deletePatient(id);
        System.out.println("Patient deleted: " + id);
    }

    // lambda + predicate
    public List<Patient> filterPatients(Predicate<Patient> condition) {
        return repository.getAllPatients()
                .stream()
                .filter(condition)
                .collect(Collectors.toList());
    }

    // ── DOCTOR ───

    public void registerDoctor(Doctor doctor) {
        if (repository.doctorExists(doctor.getId())) {
            System.out.println("Doctor already exists: " + doctor.getId());
            return;
        }
        repository.saveDoctor(doctor);
        notificationService.notify(doctor.getName(), "Welcome Dr. " + doctor.getName());
        System.out.println("Doctor registered: " + doctor.getName());
    }

    public Doctor getDoctor(String id) {
        Doctor d = repository.getDoctor(id);
        if (d == null) throw new HospitalExceptions.DoctorNotFoundException(id);
        return d;
    }

    public List<Doctor> getAllDoctors() {
        return repository.getAllDoctors();
    }

    public void updateDoctor(Doctor doctor) {
        if (!repository.doctorExists(doctor.getId()))
            throw new HospitalExceptions.DoctorNotFoundException(doctor.getId());
        repository.updateDoctor(doctor);
        System.out.println("Doctor updated: " + doctor.getName());
    }

    public void deleteDoctor(String id) {
        if (!repository.doctorExists(id))
            throw new HospitalExceptions.DoctorNotFoundException(id);
        repository.deleteDoctor(id);
        System.out.println("Doctor deleted: " + id);
    }

    // ── APPOINTMENT ───

    public void bookAppointment(Appointment appointment) {
        if (!repository.patientExists(appointment.getPatient().getId()))
            throw new HospitalExceptions.PatientNotFoundException(
                    appointment.getPatient().getId());

        if (!repository.doctorExists(appointment.getDoctor().getId()))
            throw new HospitalExceptions.DoctorNotFoundException(
                    appointment.getDoctor().getId());

        // conflict check — same doctor, same date
        boolean conflict = repository.getAllAppointments()
                .stream()
                .anyMatch(a ->
                        a.getDoctor().getId().equals(appointment.getDoctor().getId())
                                && a.getDate().equals(appointment.getDate())
                );
        if (conflict)
            throw new HospitalExceptions.AppointmentConflictException(
                    appointment.getDoctor().getName(), appointment.getDate());

        repository.saveAppointment(appointment);
        notificationService.notify(appointment.getPatient().getName(),
                "Appointment booked with Dr. " + appointment.getDoctor().getName()
                        + " on " + appointment.getDate());
        System.out.println("Appointment booked: " + appointment.getId());
    }

    public Appointment getAppointment(String id) {
        Appointment a = repository.getAppointment(id);
        if (a == null) throw new HospitalExceptions.AppointmentNotFoundException(id);
        return a;
    }

    public List<Appointment> getAllAppointments() {
        return repository.getAllAppointments();
    }

    public void updateAppointment(Appointment appointment) {
        if (!repository.appointmentExists(appointment.getId()))
            throw new HospitalExceptions.AppointmentNotFoundException(appointment.getId());
        repository.updateAppointment(appointment);
        System.out.println("Appointment updated: " + appointment.getId());
    }

    public void cancelAppointment(String id) {
        if (!repository.appointmentExists(id))
            throw new HospitalExceptions.AppointmentNotFoundException(id);
        repository.deleteAppointment(id);
        System.out.println("Appointment cancelled: " + id);
    }
}