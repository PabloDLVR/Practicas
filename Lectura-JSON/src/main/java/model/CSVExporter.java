package model;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.io.PrintWriter;

// CSVExporter.java
public class CSVExporter {
    public static void exportToCSV(String path, JSONArray productosFiltrados) {
        try (PrintWriter writer = new PrintWriter(new File(path))) {
            writer.println("id,cliente,comentario"); // Cabecera ejemplo

            for (int i = 0; i < productosFiltrados.length(); i++) {
                JSONObject producto = productosFiltrados.getJSONObject(i);
                String id = producto.optString("id", "");
                String cliente = producto.optString("client", "");
                String comentario = producto.optString("comment", "");
                writer.printf("%s,%s,%s%n", id, cliente, comentario);
            }
            System.out.println("✅ CSV exportado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

