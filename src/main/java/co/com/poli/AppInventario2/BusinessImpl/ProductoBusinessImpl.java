package co.com.poli.AppInventario2.BusinessImpl;

import co.com.poli.AppInventario2.DAO.IProductoDao;
import co.com.poli.AppInventario2.Model.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.poli.AppInventario2.Business.IProductoBusiness;

@Service
public class ProductoBusinessImpl implements IProductoBusiness{
    
    @Autowired IProductoDao productos;
    
    @Override
    public List<Producto> getProductos() {
        return productos.getProductos();
    }
}
