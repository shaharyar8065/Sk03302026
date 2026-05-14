package org.example.dao.impl;

import org.example.config.DBUtil;
import org.example.dao.PatientDAO;
import org.example.entities.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl implements PatientDAO {

    @Override
    public void insert(Patient patient) {
        String sql = "INSERT INTO patients (id, name, disease) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, patient.getId());
            ps.setString(2, patient.getName());
            ps.setString(3, patient.getDisease());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Error inserting patient: " + e.getMessage());
        }
    }

    @Override
    public Patient findById(String id) {
        String sql = "SELECT * FROM patients WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return mapRow(rs);

        } catch (Exception e) {
            throw new RuntimeException("Error finding patient: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Patient> findAll() {
        String sql = "SELECT * FROM patients";
        List<Patient> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(mapRow(rs));

        } catch (Exception e) {
            throw new RuntimeException("Error fetching patients: " + e.getMessage());
        }
        return list;
    }

    @Override
    public void update(Patient patient) {
        String sql = "UPDATE patients SET name=?, disease=? WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, patient.getName());
            ps.setString(2, patient.getDisease());
            ps.setString(3, patient.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Error updating patient: " + e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM patients WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Error deleting patient: " + e.getMessage());
        }
    }

    @Override
    public boolean existsById(String id) {
        String sql = "SELECT id FROM patients WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            return ps.executeQuery().next();

        } catch (Exception e) {
            throw new RuntimeException("Error checking patient: " + e.getMessage());
        }
    }

    private Patient mapRow(ResultSet rs) throws SQLException {
        return new Patient(
                rs.getString("id"),
                rs.getString("name"),
                rs.getString("disease")
        );
    }
}