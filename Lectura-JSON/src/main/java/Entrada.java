import org.json.JSONArray;
import org.json.JSONObject;

public class Entrada {
    public static void main(String[] args) {
        String url = "https://raw.githubusercontent.com/PabloDLVR/Practicas/main/extraccion%20ffe.json";
        JSONArray productos = JsonReadeer.obtenerProductosDesdeUrl(url);

        if (productos != null) {
            for (int i = 0; i < productos.length(); i++) {
                JSONObject producto = productos.getJSONObject(i);
                System.out.println("Producto " + i + ": " + producto.toString(2)); // pretty print
            }
        } else {
            System.out.println("No se pudieron obtener productos.");
        }
    }
}
