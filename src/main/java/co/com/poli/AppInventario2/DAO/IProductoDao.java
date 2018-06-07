
package co.com.poli.AppInventario2.DAO;

import co.com.poli.AppInventario2.Model.Producto;
import java.util.List;

public interface IProductoDao {
    
    List<Producto> getProductos();
    Producto getProducto(String codigo);
    String create(Producto producto);
    String edit(Producto producto, int index);
}
