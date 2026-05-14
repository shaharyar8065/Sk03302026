package org.example.dao.impl;

import org.example.config.DBUtil;
import org.example.dao.DoctorDAO;
import org.example.entities.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {

    @Override
    public void insert(Doctor doctor) {
        String sql = "INSERT INTO doctors (id, name, specialization) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, doctor.getId());
            ps.setString(2, doctor.getName());
            ps.setString(3, doctor.getSpecialization());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Error inserting doctor: " + e.getMessage());
        }
    }

    @Override
    public Doctor findById(String id) {
        String sql = "SELECT * FROM doctors WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return mapRow(rs);

        } catch (Exception e) {
            throw new RuntimeException("Error finding doctor: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Doctor> findAll() {
        String sql = "SELECT * FROM doctors";
        List<Doctor> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(mapRow(rs));

        } catch (Exception e) {
            throw new RuntimeException("Error fetching doctors: " + e.getMessage());
        }
        return list;
    }

    @Override
    public void update(Doctor doctor) {
        String sql = "UPDATE doctors SET name=?, specialization=? WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Error updating doctor: " + e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM doctors WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Error deleting doctor: " + e.getMessage());
        }
    }

    @Override
    public boolean existsById(String id) {
        String sql = "SELECT id FROM doctors WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            return ps.executeQuery().next();

        } catch (Exception e) {
            throw new RuntimeException("Error checking doctor: " + e.getMessage());
        }
    }

    private Doctor mapRow(ResultSet rs) throws SQLException {
        return new Doctor(
                rs.getString("id"),
                rs.getString("name"),
                rs.getString("specialization")
        );
    }
}
