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

    @Override
    public Producto getProducto(String codigo) {
        return productos.getProducto(codigo);
    }

    @Override
    public String create(Producto producto) {
        String msg = "El producto ya existe.";
        List<Producto> lista = productos.getProductos();
        
        for (Producto p : lista) {
            if (p.getCodigo().equals(producto.getCodigo())) {
                return msg;
            }
        }
        
        return productos.create(producto);
    }

    @Override
    public String edit(Producto producto) {
        String msg = "El producto no existe";
        List<Producto> lista = getProductos();
        int index;
        Producto productoActual = productos.getProducto(producto.getCodigo());
        
        if (lista.contains(productoActual)) {
            index = lista.indexOf(producto);
            Producto p = lista.get(index);
            
            p.setNombre(producto.getNombre());
            p.setExistencia(producto.getExistencia());
            p.setStock(producto.getStock());
            
            return productos.edit(p, index);
        } else {
            return msg;
        }
    }
}
