/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author Roger
 */
public class FXMLDocumentController implements Initializable {
    
    
    @FXML public Label notificacion;
    @FXML public Button SurtCotxe;
    @FXML public Button EntraCotxe;
    @FXML public Button SurtMoto;
    @FXML public Button EntraMoto;
    @FXML public Label PlacesDisponibles1;
    @FXML public Label PlacesDisponibles2;

 
    Comptador font = new Comptador();
    
    ObservadorIncrements1 obs1 = new ObservadorIncrements1();
    ObservadorIncrements2 obs2 = new ObservadorIncrements2();
    ObservadorIncrements3 obs3 = new ObservadorIncrements3();

    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        font.afegirObservador(obs1); 
        font.afegirObservador(obs2); 
        font.afegirObservador(obs3);
        
        PlacesDisponibles2.setText(String.valueOf(font.getValorMoto()));
        PlacesDisponibles1.setText(String.valueOf(font.getValorMaximCotxe())); 
        
        try{
            Task task = new Task<Void>() {

            @Override
            public Void call() throws Exception {
                int i = 0;
                while (true) {
                    final int finalI = i;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {   
                            
                            try{                            
                                notificacion.setText(obs3.getPercentatge());
                            } catch (Exception e){
                                System.out.println(e);
                            }
                        }
                    });
                i++;
                Thread.sleep(1500);
                }
            }
            };

            Thread th = new Thread(task);
            th.setDaemon(true);
            th.start();
        }
        catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
 
    }  
        
    
    @FXML public void SurtMoto(ActionEvent event) throws Exception {
        //moto surt
        try{
            font.desIncrementaValorMoto();
            PlacesDisponibles2.setText(obs2.getPercentatge());
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    @FXML public void EntraMoto(ActionEvent event) throws Exception{
        //entra moto
        try{ 
            font.incrementaValorMoto();
            PlacesDisponibles2.setText(obs2.getPercentatge());
        } catch (Exception e){
            System.out.println(e);
        }
    }
       
    
    @FXML public void EntraCotxe(ActionEvent event) throws Exception {
        
        try{
            font.incrementaValorCotxe(); 
            PlacesDisponibles1.setText(obs1.getPercentatge());
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    @FXML public void SurtCotxe(ActionEvent event) throws Exception {
        //surt cotxe
        try{
            font.desIncrementaValorCotxe();
            PlacesDisponibles1.setText(obs1.getPercentatge());
        } catch (Exception e){
            System.out.println(e);
        }
    }      
}
