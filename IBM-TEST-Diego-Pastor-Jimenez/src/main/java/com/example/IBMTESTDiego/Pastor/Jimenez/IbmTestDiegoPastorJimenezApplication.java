package com.example.IBMTESTDiego.Pastor.Jimenez;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class IbmTestDiegoPastorJimenezApplication {

    @Autowired
    private ProveedorService proveedorService;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Por favor, ingrese el código del cliente como parámetro.");
            return;
        }

        int clientId = Integer.parseInt(args[0]);

        ConfigurableApplicationContext context = SpringApplication.run(IbmTestDiegoPastorJimenezApplication.class, args);
        IbmTestDiegoPastorJimenezApplication application = context.getBean(IbmTestDiegoPastorJimenezApplication.class);
        application.run(clientId);
    }

    public void run(int clientId) {
        List<String> proveedores = proveedorService.fetchProveedores(clientId);

        if (proveedores.isEmpty()) {
            System.out.println("El cliente no tiene proveedores asignados.");
        } else {
            try {
                File outputFile = new File("proveedores_" + clientId + ".txt");
                FileWriter fileWriter = new FileWriter(outputFile);

                fileWriter.write("id_proveedor, nombre, fecha de alta, id_cliente\n");
                for (String proveedor : proveedores) {
                    fileWriter.write(proveedor + "\n");
                }

                fileWriter.close();
                System.out.println("Archivo generado exitosamente: " + outputFile.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("Error al generar el archivo de proveedores.");
                e.printStackTrace();
            }
        }
    }
}
