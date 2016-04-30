/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;


/**
 *
 * @author Roger
 */
public class ObservadorIncrements3 implements ControlValorListener{
    private String notificacion;
        
    @Override
    public void fontIncrementada(ValorIncrementatEvent event) {
        notificacion = String.valueOf(event.getSource().getNotificacion());
    }
    
    public String getPercentatge() {
        return notificacion;
    }
    
    
}
