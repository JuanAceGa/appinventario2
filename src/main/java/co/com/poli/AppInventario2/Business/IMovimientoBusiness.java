
package co.com.poli.AppInventario2.Business;

import co.com.poli.AppInventario2.Model.Movimiento;
import java.util.List;

public interface IMovimientoBusiness {
    List<Movimiento> getMovimientos();
    Movimiento getMovimiento(String idMovimiento);
    String create(Movimiento mov);
    String delete(String idMovimiento);
}
