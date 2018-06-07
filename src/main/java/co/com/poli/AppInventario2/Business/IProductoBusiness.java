
package co.com.poli.AppInventario2.Business;

import co.com.poli.AppInventario2.Model.Producto;
import java.util.List;

public interface IProductoBusiness {
    List<Producto> getProductos();
    
    Producto getProducto(String codigo);
    String create(Producto producto);
    String edit(Producto producto);
}
