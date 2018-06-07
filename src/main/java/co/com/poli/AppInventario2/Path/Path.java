
package co.com.poli.AppInventario2.Path;

public class Path {
    public class PathProducto {
        public static final String PRODUCTOS = "/productos";
        public static final String PRODUCTO = "/producto/{codigo}";
    }
    
    public class PathMovimiento {
        public static final String MOVIMIENTOS = "/movimientos";
        public static final String MOVIMIENTO = "/movimiento/{idMovimiento}";
    }
}
