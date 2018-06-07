
package co.com.poli.AppInventario2.DAOImpl;

import co.com.poli.AppInventario2.DAO.IMovimientoDao;
import co.com.poli.AppInventario2.DATA.ListaMovimientos;
import co.com.poli.AppInventario2.Model.Movimiento;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class MovimientoDaoImpl implements IMovimientoDao{

    @Override
    public List<Movimiento> getMovimientos() {
        return ListaMovimientos.getMovimientos();
    }

    @Override
    public Movimiento getMovimiento(String idMovimiento) {
        List<Movimiento> lista = getMovimientos();
        
        for(Movimiento m : lista) {
            if (m.getIdMovimiento().equals(idMovimiento)){
                return m;
            }
        }
        
        return null;
    }

    @Override
    public String create(Movimiento mov) {
        List<Movimiento> lista = getMovimientos();
        lista.add(mov);
        
        ListaMovimientos.setMovimiento(lista);
        
        return "Movimiento creado";
    }    

    @Override
    public String delete(int index) {
        List<Movimiento> lista = getMovimientos();
        lista.remove(index);
        
        return "Movimiento eliminado";
    }
}
