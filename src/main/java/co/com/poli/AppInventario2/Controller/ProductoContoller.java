package co.com.poli.AppInventario2.Controller;

import co.com.poli.AppInventario2.Business.IProductoBusiness;
import co.com.poli.AppInventario2.Model.Producto;
import co.com.poli.AppInventario2.Path.Path;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class ProductoContoller {
    
    @Autowired IProductoBusiness productos;
    
    @GetMapping(Path.PathProducto.PRODUCTOS)
    public List<Producto> getProductos(HttpServletResponse hrs){
        return productos.getProductos();
    }
    
    @GetMapping(Path.PathProducto.PRODUCTO)
    public Producto getProducto(@PathVariable String codigo, HttpServletResponse hrs){
        return productos.getProducto(codigo);
    }
    
    @PostMapping(Path.PathProducto.PRODUCTOS)
    public String create(@RequestBody Producto producto, HttpServletResponse hrs){
        return productos.create(producto);
    }
    
    @PutMapping(Path.PathProducto.PRODUCTOS)
    public String edit(@RequestBody Producto producto, HttpServletResponse hrs){
        return productos.edit(producto);
    }    
}
