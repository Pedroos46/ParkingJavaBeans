
package parking;

/**
 *
 * @author Roger
 */


public class ObservadorIncrements2 implements ControlValorListener{
    private String percentatge;

    
    
    @Override
    public void fontIncrementada(ValorIncrementatEvent event){
        percentatge = String.valueOf(event.getSource().getValorMoto());

    }
    
    public String getPercentatge() { 
        return percentatge; 
    }
    
    @Override
    public String toString(){ return (percentatge + "%"); }
    }