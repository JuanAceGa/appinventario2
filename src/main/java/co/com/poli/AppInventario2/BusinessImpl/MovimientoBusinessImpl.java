
package co.com.poli.AppInventario2.BusinessImpl;

import co.com.poli.AppInventario2.Business.IMovimientoBusiness;
import co.com.poli.AppInventario2.DAO.IMovimientoDao;
import co.com.poli.AppInventario2.DAO.IProductoDao;
import co.com.poli.AppInventario2.Model.Movimiento;
import co.com.poli.AppInventario2.Model.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimientoBusinessImpl implements IMovimientoBusiness{

    @Autowired IMovimientoDao movimientos;
    @Autowired IProductoDao productos;
    
    @Override
    public List<Movimiento> getMovimientos() {
        return movimientos.getMovimientos();
    }

    @Override
    public Movimiento getMovimiento(String idMovimiento) {
        return movimientos.getMovimiento(idMovimiento);
    }

    @Override
    public String create(Movimiento mov) {
        List<Producto> lista = productos.getProductos();
        Boolean esEntrada = false;
        
        if (mov.getTipo().equals("Entrada")) {
            esEntrada = true;
            
            if (mov.getPrecio() < 1) {
                return "El precio debe ser mayor que cero (0)";
            } else if (mov.getCantidad() < 1) {
                return "La cantidad debe ser mayor que cero (0)";
            }
        } else if (mov.getTipo().equals("Salida")) {
            esEntrada = false;
            
            if (mov.getPrecio() > 0) {
                return "El precio debe ser cero (0)";
            } else if (mov.getCantidad() < 1) {
                return "La cantidad debe ser mayor que cero (0)";
            }            
        }
        
        for (Producto p : lista) {
            if (p.getCodigo().equals(mov.getProducto().getCodigo())) {
                if (esEntrada) {
                    p.setExistencia(p.getExistencia() + mov.getCantidad());
                    
                    return movimientos.create(mov);
                } else {
                    if (p.getExistencia() < mov.getCantidad()) {
                        return "No hay existencia suficiente.";
                    }
                    
                    p.setExistencia(p.getExistencia() - mov.getCantidad());
                    
                    return movimientos.create(mov);
                }
            }
        }
        
        return "Producto no existe";
    }

    @Override
    public String delete(String idMovimiento) {
        List<Movimiento> lmov = getMovimientos();
        Movimiento mov = getMovimiento(idMovimiento);
        int index = 0;
        
        if (mov != null) {
            List<Producto> lprod = productos.getProductos();
            
            for (Producto p : lprod) {
                if (mov.getProducto().getCodigo().equals(p.getCodigo())) {
                    if (mov.getTipo().equals("Entrada")) {
                        p.setExistencia(p.getExistencia() - mov.getCantidad());
                        
                    } else if (mov.getTipo().equals("Salida")) {
                        p.setExistencia(p.getExistencia() + mov.getCantidad());
                        
                    }
                    
                    break;
                }
            }
            
            index = lmov.indexOf(mov);
            return movimientos.delete(index);
        } else {
            return "Movimiento no existe";
        }
    }
    
}
