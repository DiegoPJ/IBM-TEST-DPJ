package com.example.IBMTESTDiego.Pastor.Jimenez;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement; // Esta es la línea corregida
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProveedorService {
    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @Value("${spring.datasource.username}")
    private String databaseUsername;

    @Value("${spring.datasource.password}")
    private String databasePassword;

    public List<String> fetchProveedores(int clientId) {
        List<String> proveedores = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM proveedores WHERE id_cliente = " + clientId);

            while (resultSet.next()) {
                String idProveedor = resultSet.getString("id_proveedor");
                String nombre = resultSet.getString("nombre");
                String fechaAlta = resultSet.getString("fecha_alta");
                String idCliente = resultSet.getString("id_cliente");

                proveedores.add(idProveedor + ", " + nombre + ", " + fechaAlta + ", " + idCliente);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos.");
            e.printStackTrace();
        }

        return proveedores;
    }
}
