
package co.com.poli.AppInventario2.Controller;

import co.com.poli.AppInventario2.Business.IMovimientoBusiness;
import co.com.poli.AppInventario2.Model.Movimiento;
import co.com.poli.AppInventario2.Path.Path;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class MovimientoController {
    @Autowired IMovimientoBusiness movimientos;
    
    @GetMapping(Path.PathMovimiento.MOVIMIENTOS)
    public List<Movimiento> getMovimientos(HttpServletResponse hrs){
        return movimientos.getMovimientos();
    }
    
    @GetMapping(Path.PathMovimiento.MOVIMIENTO)
    public Movimiento getMovimiento(@PathVariable String idMovimiento, HttpServletResponse hrs){
        return movimientos.getMovimiento(idMovimiento);
    }
    
    @PostMapping(Path.PathMovimiento.MOVIMIENTOS)
    public String create(@RequestBody Movimiento mov, HttpServletResponse hrs){
        return movimientos.create(mov);
    }
    
    @PutMapping(Path.PathMovimiento.MOVIMIENTO)
    public String delete(@PathVariable String idMovimiento, HttpServletResponse hrs) {
        return movimientos.delete(idMovimiento);
    }
}   

