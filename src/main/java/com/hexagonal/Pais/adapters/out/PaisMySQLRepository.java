package com.hexagonal.Pais.adapters.out;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.hexagonal.Pais.domain.models.Pais;
import com.hexagonal.Pais.infrastrucure.PaisRepository;

public class PaisMySQLRepository implements PaisRepository {
    private final String url;
    private final String user;
    private final String password;

    public PaisMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Pais pais) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO Paises (nombre_pais) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, pais.getNombre_pais());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Pais pais) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE Paises SET nombre_pais = ? WHERE id_pais = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, pais.getNombre_pais());
                statement.setInt(2, pais.getId_pais());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Pais> findById(int id_pais) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_pais,nombre_pais FROM Paises WHERE id_pais = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_pais);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Pais pais = new Pais(
                                resultSet.getInt("id_pais"),
                                resultSet.getString("nombre_pais"));
                        return Optional.of(pais);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(int id_pais) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM Paises WHERE id_pais = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_pais);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pais> findAll() {
        List<Pais> paises = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_pais,nombre_pais FROM Paises";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Pais pais = new Pais(
                            resultSet.getInt("id_pais"),
                            resultSet.getString("nombre_pais"));
                    paises.add(pais);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paises;
    }
}
