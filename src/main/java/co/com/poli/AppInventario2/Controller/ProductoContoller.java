package co.com.poli.AppInventario2.Controller;

import co.com.poli.AppInventario2.Business.IProductoBusiness;
import co.com.poli.AppInventario2.Model.Producto;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class ProductoContoller {
    
    @Autowired IProductoBusiness productos;
    
    @GetMapping(value = "productos")
    public List<Producto> getProductos(HttpServletResponse hrs){
        return productos.getProductos();
    }
}
