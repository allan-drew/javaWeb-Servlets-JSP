package dev.aadc.dao;

import dev.aadc.model.Clientes;

import java.util.List;
import java.util.Optional;

public interface InterfaceClientesDAO {

    Clientes save (Clientes clientes); // CREATE
    Clientes update (Clientes clientes); // UPDATE
    void delete (Integer id); // DELETE
    List<Clientes> findAll(); // READ
    Optional<Clientes> findById(Integer id); // READ (método também usado para fazer o update)

}
