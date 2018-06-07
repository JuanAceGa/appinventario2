
package co.com.poli.AppInventario2.DAOImpl;

import co.com.poli.AppInventario2.DAO.IProductoDao;
import co.com.poli.AppInventario2.DATA.ListaProductos;
import co.com.poli.AppInventario2.Model.Producto;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoDaoImpl implements IProductoDao{

    @Override
    public List<Producto> getProductos() {
        return ListaProductos.getProductos();
    }

    @Override
    public Producto getProducto(String codigo) {
        List<Producto> lista = ListaProductos.getProductos();
        
        for (Producto p : lista) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        
        return null;
    }

    @Override
    public String create(Producto producto) {
        List<Producto> lista = ListaProductos.getProductos();
        lista.add(producto);
        
        ListaProductos.setProductos(lista);
        
        return "Producto creado";
    }

    @Override
    public String edit(Producto producto, int index) {
        List<Producto> lista = ListaProductos.getProductos();
        lista.add(index, producto);
       
        return "Producto actualizado.";
    }
}
