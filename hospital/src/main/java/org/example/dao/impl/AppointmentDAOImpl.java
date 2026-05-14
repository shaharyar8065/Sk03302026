package org.example.dao.impl;

import org.example.config.DBUtil;
import org.example.dao.AppointmentDAO;
import org.example.entities.Appointment;
import org.example.entities.Doctor;
import org.example.entities.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAOImpl implements AppointmentDAO {

    @Override
    public void insert(Appointment appointment) {
        String sql = "INSERT INTO appointments (id, patient_id, doctor_id, date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, appointment.getId());
            ps.setString(2, appointment.getPatient().getId());
            ps.setString(3, appointment.getDoctor().getId());
            ps.setString(4, appointment.getDate());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Error inserting appointment: " + e.getMessage());
        }
    }

    @Override
    public Appointment findById(String id) {
        String sql = "SELECT a.id, a.date, "
                + "p.id as p_id, p.name as p_name, p.disease, "
                + "d.id as d_id, d.name as d_name, d.specialization "
                + "FROM appointments a "
                + "JOIN patients p ON a.patient_id = p.id "
                + "JOIN doctors  d ON a.doctor_id  = d.id "
                + "WHERE a.id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return mapRow(rs);

        } catch (Exception e) {
            throw new RuntimeException("Error finding appointment: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Appointment> findAll() {
        String sql = "SELECT a.id, a.date, "
                + "p.id as p_id, p.name as p_name, p.disease, "
                + "d.id as d_id, d.name as d_name, d.specialization "
                + "FROM appointments a "
                + "JOIN patients p ON a.patient_id = p.id "
                + "JOIN doctors  d ON a.doctor_id  = d.id";
        List<Appointment> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(mapRow(rs));

        } catch (Exception e) {
            throw new RuntimeException("Error fetching appointments: " + e.getMessage());
        }
        return list;
    }

    @Override
    public void update(Appointment appointment) {
        String sql = "UPDATE appointments SET date=? WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, appointment.getDate());
            ps.setString(2, appointment.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Error updating appointment: " + e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM appointments WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Error deleting appointment: " + e.getMessage());
        }
    }

    @Override
    public boolean existsById(String id) {
        String sql = "SELECT id FROM appointments WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            return ps.executeQuery().next();

        } catch (Exception e) {
            throw new RuntimeException("Error checking appointment: " + e.getMessage());
        }
    }

    private Appointment mapRow(ResultSet rs) throws SQLException {
        Patient patient = new Patient(
                rs.getString("p_id"),
                rs.getString("p_name"),
                rs.getString("disease")
        );
        Doctor doctor = new Doctor(
                rs.getString("d_id"),
                rs.getString("d_name"),
                rs.getString("specialization")
        );
        return new Appointment(
                rs.getString("id"),
                patient,
                doctor,
                rs.getString("date")
        );
    }
}