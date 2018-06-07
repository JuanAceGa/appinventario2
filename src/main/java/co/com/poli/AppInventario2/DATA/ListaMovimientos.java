
package co.com.poli.AppInventario2.DATA;

import co.com.poli.AppInventario2.Model.Movimiento;
import java.util.ArrayList;
import java.util.List;

public class ListaMovimientos {
    private static List<Movimiento> lista;
    
    static {
        lista = new ArrayList();
    }
    
    public static List<Movimiento> getMovimientos(){
        return lista;
    }
    
    public static void setMovimiento(List<Movimiento> newLista){
        lista = newLista;
    }
}
