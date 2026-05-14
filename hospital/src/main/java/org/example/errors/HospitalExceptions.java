package org.example.errors;

public class HospitalExceptions {

    public static class PatientNotFoundException extends RuntimeException {
        public PatientNotFoundException(String patientId) {
            super("Patient not found with ID: " + patientId);
        }
    }

    public static class DoctorNotFoundException extends RuntimeException {
        public DoctorNotFoundException(String doctorId) {
            super("Doctor not found with ID: " + doctorId);
        }
    }

    public static class AppointmentNotFoundException extends RuntimeException {
        public AppointmentNotFoundException(String appointmentId) {
            super("Appointment not found with ID: " + appointmentId);
        }
    }


    public static class AppointmentConflictException extends RuntimeException {
        public AppointmentConflictException(String doctorName, String date) {
            super("Dr. " + doctorName + " already has an appointment on " + date);
        }
    }

}
