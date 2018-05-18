package co.com.poli.AppInventario2.DATA;

import co.com.poli.AppInventario2.Model.Producto;
import java.util.ArrayList;
import java.util.List;

public class ListaProductos {
    private static List<Producto> lista;
    
    static {
        lista = new ArrayList<Producto>() {
            {
                add(new Producto("15", "Producto 15", 10d));
                add(new Producto("25", "Producto 25", 20d));
                add(new Producto("35", "Producto 35", 30d));
                add(new Producto("45", "Producto 45", 40d));
                add(new Producto("55", "Producto 55", 50d));
            }
        };
    }
    
    public static List<Producto> getProductos(){
        return lista;
    }
    
    public static void setProductos(List<Producto> newLista){
        lista = newLista;
    }
}
