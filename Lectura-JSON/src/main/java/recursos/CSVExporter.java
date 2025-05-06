package recursos;

import org.json.JSONArray;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.*;

public class CSVExporter {
    public static void exportToCSV(String filePath, JSONArray filtrados) {
        String url = "jdbc:mysql://localhost:3306/naturprintdb";
        String user = "root";
        String password = "123456789";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM productos");
             PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {

            writer.println("numero,fecha_lanzada,cliente,cantidad,trabajo,familia,fecha_entrega,notas");

            while (rs.next()) {
                writer.printf("%d,%s,%s,%d,%s,%s,%s,%s%n",
                        rs.getInt("numero"),
                        rs.getDate("fecha_lanzada"),
                        rs.getString("cliente"),
                        rs.getInt("cantidad"),
                        rs.getString("trabajo"),
                        rs.getString("familia"),
                        rs.getDate("fecha_entrega"),
                        rs.getString("notas").replace(",", " "));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
