import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonReadeer {
    public static JSONArray obtenerProductosDesdeUrl(String urlString) {
        JSONArray productosFiltrados = new JSONArray();

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder jsonString = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                jsonString.append(line);
            }
            in.close();

            JSONArray productos = new JSONArray(jsonString.toString());

            for (int i = 0; i < productos.length(); i++) {
                JSONObject producto = productos.getJSONObject(i);

                if (producto.has("comentario") && producto.getString("comentario").equalsIgnoreCase("probado en ot")) {
                    productosFiltrados.put(producto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productosFiltrados;
    }
}
