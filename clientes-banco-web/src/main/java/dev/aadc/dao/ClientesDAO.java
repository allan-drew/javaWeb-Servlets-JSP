package dev.aadc.dao;


import dev.aadc.model.Clientes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ClientesDAO implements InterfaceClientesDAO {

    private final Connection conect;

    public ClientesDAO(Connection connection) {
        this.conect = connection;
    }


    // ========================================================================================================================
    @Override
    public Clientes save(Clientes clientes) {

        String sql = "INSERT INTO `clientesbanco`.`clientes` (nome, idade, email, renda) VALUES (?, ?, ?, ?)";

        try {
            // An object that represents a precompiled SQL statement.
            // A SQL statement is precompiled and stored in a PreparedStatement object.
            PreparedStatement preparedStatement = conect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                // This object can then be used to efficiently execute this statement multiple times.

            preparedStatement.setString(1, clientes.getNome());
            preparedStatement.setInt(2, clientes.getIdade());
            preparedStatement.setString(3, clientes.getEmail());
            preparedStatement.setDouble(4, clientes.getRenda());

            preparedStatement.executeUpdate(); // Executes the SQL statement in this PreparedStatement object

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    System.out.println("Generated ID: " + generatedId);
                } else {
                    throw new SQLException("Creating record failed, no ID obtained.");
                }
            }

            //
            preparedStatement.close();
            //generatedKeys.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return clientes;
    }
    // ========================================================================================================================



    // ========================================================================================================================
    @Override
    public Clientes update(Clientes clientes) {

        String sql = "UPDATE `clientesbanco`.`clientes` SET nome = ?, idade = ?, email = ?, renda = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = conect.prepareStatement(sql);

            preparedStatement.setString(1, clientes.getNome());
            preparedStatement.setInt(2, clientes.getIdade());
            preparedStatement.setString(3, clientes.getEmail());
            preparedStatement.setDouble(4, clientes.getRenda());

            preparedStatement.setInt(5, clientes.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return clientes;

    }
    // ========================================================================================================================



    // ========================================================================================================================
    @Override
    public void delete(Integer id) {

        String sql = "DELETE FROM `clientesbanco`.`clientes` WHERE id = ?";

        try {
            PreparedStatement preparedStatement = conect.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    // ========================================================================================================================



    // ========================================================================================================================
    @Override
    public List<Clientes> findAll() {

        String sql = "SELECT id, nome, idade, email, renda FROM `clientesbanco`.`clientes`";

        List<Clientes> ListaDeTodosOsClientes = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = conect.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                Integer idade = rs.getInt("idade");
                String email = rs.getString("email");
                Double renda = rs.getDouble("renda");

                Clientes clienteRecuperadoDaBaseDeDados = new Clientes(id, nome, idade, email, renda);
                ListaDeTodosOsClientes.add(clienteRecuperadoDaBaseDeDados);
            }

            preparedStatement.close();
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ListaDeTodosOsClientes;
    }
    // ========================================================================================================================


    // ========================================================================================================================
    @Override
    public Optional<Clientes> findById(Integer id) {

        String sql = "SELECT id, nome, idade, email, renda FROM `clientesbanco`.`clientes` WHERE id = ?";

        Clientes clienteEncontrado = null;

        try {
            PreparedStatement preparedStatement = conect.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer idEncontrado = rs.getInt("id");
                String nomeEncontrado = rs.getString("nome");
                Integer idadeEncontrada = rs.getInt("idade");
                String emailEncontrado = rs.getString("email");
                Double rendaEncontrada = rs.getDouble("renda");

                clienteEncontrado = new Clientes(idEncontrado, nomeEncontrado, idadeEncontrada,emailEncontrado, rendaEncontrada);

            }

            preparedStatement.close();
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.ofNullable(clienteEncontrado);

    }
    // ========================================================================================================================



}
