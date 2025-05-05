import org.json.JSONArray;
import org.json.JSONObject;
import recursos.CSVExporter;
import recursos.DbConnection;

import java.sql.Connection;

public class Entrada {
    public static void main(String[] args) {
        String url = "https://raw.githubusercontent.com/PabloDLVR/Practicas/06f8fb240bc2ad96a50aa31d5f5d4d99b1badbf6/ordenes_generadas_completo.json";
        JSONArray productos = JsonReadeer.obtenerProductosDesdeUrl(url);

        Connection conn = DbConnection.getConnection();
        if (conn != null) {
            System.out.println("✅ Conexión exitosa");
        } else {
            System.out.println("❌ Error de conexión");
        }

        if (productos != null) {
            for (int i = 0; i < productos.length(); i++) {
                JSONObject producto = productos.getJSONObject(i);

                // Verificamos si tiene el campo "comentario"
                if (producto.has("comment")) {
                    String comentario = producto.getString("comment").toLowerCase();
                    if (comentario.equals("probando en ot")) {
                        System.out.println("Producto " + i + ": " + producto.toString(2));
                    }
                }
            }
        } else {
            System.out.println("No se pudieron obtener productos.");
        }

        String csvPath = "productos.csv";
        CSVExporter.exportToCSV(csvPath);


    }
}

