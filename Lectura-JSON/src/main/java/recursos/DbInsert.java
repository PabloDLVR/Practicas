package recursos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.json.JSONArray;
import org.json.JSONObject;

public class DbInsert {
    public static void insertProducts(JSONArray products) {
        String url = "jdbc:mysql://localhost:3306/tu_base_datos";
        String user = "root";
        String password = "tu_contraseña";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO productos (numero, fecha_lanzada, cliente, cantidad, trabajo, familia, fecha_entrega, notas) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            for (int i = 0; i < products.length(); i++) {
                JSONObject prod = products.getJSONObject(i);

                stmt.setInt(1, prod.getInt("numero"));
                stmt.setString(2, prod.getString("fecha_lanzada"));
                stmt.setString(3, prod.getString("cliente"));
                stmt.setInt(4, prod.getInt("cantidad"));
                stmt.setString(5, prod.getString("trabajo"));
                stmt.setString(6, prod.getString("familia"));
                stmt.setString(7, prod.getString("fecha_entrega"));
                stmt.setString(8, prod.getString("notas"));

                stmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
