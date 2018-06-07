
package co.com.poli.AppInventario2.DAO;

import co.com.poli.AppInventario2.Model.Movimiento;
import java.util.List;

public interface IMovimientoDao {
    List<Movimiento> getMovimientos();
    Movimiento getMovimiento(String idMovimiento);
    String create(Movimiento mov);
    String delete(int index);
}
