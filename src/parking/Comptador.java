/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import java.util.ArrayList;

/**
 *
 * @author Roger
 */
public class Comptador {
    private ArrayList<ControlValorListener>listeners = new ArrayList();
    
    private int valorMaximCotxe= 20;
    private int valorCotxe=20;
    
    private int valorMaximMoto= 20;
    private int valorMoto=20;
    
    public String notificacio = "Notificacio";
    
    public Comptador() {}
    public Comptador(int valorMaximCotxe, int valorMaximMoto){
        this.valorMaximCotxe= valorMaximCotxe;
        this.valorMaximMoto= valorMaximMoto;
    }

    Comptador(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void incrementaValorCotxe(){
        if(valorCotxe == valorMaximCotxe){
            System.out.println("Nothing to do here.");
        }else{
            valorCotxe++;
            notificaIncrement(0);
            notificacio = "Ha entrat un cotxe";

        }
    }
    
    public void desIncrementaValorCotxe(){
        if(valorCotxe == 0){
            System.out.println("Nothing to do here.");
        }else{            
            notificacio = "Ha sortit un cotxe";
            valorCotxe--;
            notificaIncrement(0);

        } 
    }
    
    public void incrementaValorMoto(){
        if(valorMoto == valorMaximMoto){
            System.out.println("Nothing to do here.");
        }else{
            valorMoto++;
            notificaIncrement(1);
            notificacio = "Ha entrat una moto";
        }
    }
    
    public void desIncrementaValorMoto(){
        if(valorMoto == 0){
            System.out.println("Nothing to do here.");
        }else{
            valorMoto--;
            notificaIncrement(1);
            notificacio = "Ha sortit una moto";

        }
    }

    public int getValorMaximCotxe() {
        return valorMaximCotxe;
    }

    public int getValorCotxe() {
        return valorCotxe;
    }

    public int getValorMaximMoto() {
        return valorMaximMoto;
    }

    public int getValorMoto() {
        return valorMoto;
    }
    
    public String getNotificacion(){
        return notificacio;
    }
    
    public void afegirObservador(ControlValorListener ctrl){
        listeners.add(ctrl);
    }

    public void eliminarObservador(ControlValorListener ctrl){
        listeners.remove(ctrl);
    }

    private void notificaIncrement(Integer i){
        ValorIncrementatEvent event = new ValorIncrementatEvent(this, 1);
        
        for(ControlValorListener x: listeners)
            x.fontIncrementada(event);
    }
}

