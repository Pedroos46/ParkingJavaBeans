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
public class ObservadorIncrements1 implements ControlValorListener{
    private String percentatge;
        
    @Override
    public void fontIncrementada(ValorIncrementatEvent event) {
        percentatge = String.valueOf(event.getSource().getValorCotxe());
    }
    
    public String getPercentatge() {
        return percentatge;
    }
    
    @Override
    public String toString(){
        return (percentatge + "%");
    }
}
