/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import java.util.EventObject;

    public class ValorIncrementatEvent extends EventObject{
        private int increment=0;
        public ValorIncrementatEvent(Comptador o, int increment) {
        super(o);
    this.increment = increment;
    }
    
    @Override
    public Comptador getSource(){
        return (Comptador) super.getSource();
    }

    public int getIncrement() {
        return increment;
    }
}