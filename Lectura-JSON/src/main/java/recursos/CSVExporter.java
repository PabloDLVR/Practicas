package recursos;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.PrintWriter;

// CSVExporter.java
public class CSVExporter {
    public static void exportToCSV(String path, JSONArray productosFiltrados) {
        try (PrintWriter writer = new PrintWriter(new File(path))) {
            writer.println("code,clientName,initialDate,total,description,comentario"); // Cabecera ejemplo

            for (int i = 0; i < productosFiltrados.length(); i++) {
                JSONObject producto = productosFiltrados.getJSONObject(i);
                String code = producto.optString("code", "");
                String clientName = producto.optString("clientName", "");
                String initialDate = producto.optString("initialDate", "");
                String total = producto.optString("total", "");
                String description = producto.optString("description", "");
                String comentario = producto.optString("comment", "");
                writer.printf("%s,%s,%s,%s,%s,%s%n", code,clientName,initialDate,total, description, comentario);
            }

            System.out.println("✅ CSV exportado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}