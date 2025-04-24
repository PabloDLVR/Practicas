import org.json.JSONArray;
import org.json.JSONObject;

public class Entrada {
    public static void main(String[] args) {
        String url = "https://raw.githubusercontent.com/PabloDLVR/Practicas/refs/heads/main/extraccion%20ffe.json"; // Reemplaza por la URL real
        JSONArray productos = JsonReadeer.obtenerProductosDesdeUrl(url);
        for (int i = 0; i < productos.length(); i++) {
            JSONObject producto = productos.getJSONObject(i);
            System.out.println("Producto " + i + ": " + producto.toString(2)); // pretty print
        }
    }
}

