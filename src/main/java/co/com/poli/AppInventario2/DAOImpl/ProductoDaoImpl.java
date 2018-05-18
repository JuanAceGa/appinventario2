
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
}
