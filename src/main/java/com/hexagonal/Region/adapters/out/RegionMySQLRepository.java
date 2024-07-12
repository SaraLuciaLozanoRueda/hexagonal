package com.hexagonal.Region.adapters.out;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.hexagonal.Region.domain.models.Region;
import com.hexagonal.Region.infrastructure.RegionRepository;

public class RegionMySQLRepository implements RegionRepository {
    private final String url;
    private final String user;
    private final String password;

    public RegionMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Region region) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO Regiones (nombre_region,id_pais) VALUES (?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, region.getNombre_region());
                statement.setInt(2, region.getId_pais());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Region region) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE Regiones SET nombre_region = ?,id_pais = ? WHERE id_region = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, region.getNombre_region());
                statement.setInt(2, region.getId_pais());
                statement.setInt(3, region.getId_region());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Region> findById(int id_region) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_region,nombre_region,id_pais FROM Regiones WHERE id_region = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_region);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Region region = new Region(
                                resultSet.getInt("id_region"),
                                resultSet.getString("nombre_region"),
                                resultSet.getInt("id_pais"));
                        return Optional.of(region);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(int id_region){
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "DELETE FROM Regiones WHERE ud_region = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id_region);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Region> findAll(){
        List<Region> regiones = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id_region,nombre_region,id_pais FROM Regiones";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Region region = new Region(
                        resultSet.getInt("id_region"),
                        resultSet.getString("nombre_region"),
                        resultSet.getInt("id_pais"));
                    regiones.add(region);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return regiones;
    }
}
