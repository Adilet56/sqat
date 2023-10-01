package org.springframework.boot;
import java.sql.SQLException;



public class Main {

    public static void main(String[] args) {
        CRUDOperations crud = new CRUDOperations();

        // Create
        try {
            crud.createRecord("Эдди");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Read
        try {
            String data = crud.readRecord(1);
            System.out.println("Прочитано: " + data);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Update
        try {
            crud.updateRecord(1, "Мэтью");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Delete
     try {
            crud.deleteRecord(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}