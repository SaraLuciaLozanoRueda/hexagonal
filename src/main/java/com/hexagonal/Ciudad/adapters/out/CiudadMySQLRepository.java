package com.hexagonal.Ciudad.adapters.out;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.hexagonal.Ciudad.domain.models.Ciudad;
import com.hexagonal.Ciudad.infraestructure.CiudadRepository;

public class CiudadMySQLRepository implements CiudadRepository {
    private final String url;
    private final String user;
    private final String password;

    public CiudadMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Ciudad ciudad) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO Ciudades (nombre_ciudad) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, ciudad.getNombre_ciudad());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Ciudad ciudad) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE Ciudades SET nombre_ciudad  = ?,id_region = ? WHERE id_ciudad = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, ciudad.getNombre_ciudad());
                statement.setInt(2, ciudad.getId_region());
                statement.setInt(3, ciudad.getId_ciudad());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Ciudad> findById(int id_ciudad) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_ciudad,nombre_ciudad,id_region FROM Ciudades WHERE id_ciudad = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_ciudad);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Ciudad ciudad = new Ciudad(
                                resultSet.getInt("id_ciudad"),
                                resultSet.getString("nombre_ciudad"),
                                resultSet.getInt("id_region"));
                        return Optional.of(ciudad);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(int id_ciudad){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM Ciudades WHERE id_ciudad = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_ciudad);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ciudad> findAll(){
        List<Ciudad> ciudades = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_ciudad,nombre_ciudad, id_region FROM Ciudades";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Ciudad ciudad = new Ciudad(
                            resultSet.getInt("id_ciudad"),
                            resultSet.getString("nombre_ciudad"),
                            resultSet.getInt("id_region"));
                    ciudades.add(ciudad);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ciudades;
        
    }
}
