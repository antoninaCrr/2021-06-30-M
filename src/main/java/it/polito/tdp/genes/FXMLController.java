/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.genes;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.genes.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model ;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnContaArchi"
    private Button btnContaArchi; // Value injected by FXMLLoader

    @FXML // fx:id="btnRicerca"
    private Button btnRicerca; // Value injected by FXMLLoader

    @FXML // fx:id="txtSoglia"
    private TextField txtSoglia; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doContaArchi(ActionEvent event) {
    	
    	 String soglia = txtSoglia.getText();
    	 double valore;
         
         try {
         	valore = Double.parseDouble(soglia);
         }catch(NumberFormatException e) {
         	this.txtResult.appendText("Devi inserire un valore soglia numerico\n");
         	return;
         }
         
         if(model.verificaSoglia(valore)) {
        	 String result = model.contaArchi(valore);
        	 String[] ris = result.split(";");
        	 this.txtResult.appendText("Soglia: "+valore+" Maggiori: "+ris[1]+" Minori: "+ris[0]+"\n");
         }else {
        	 this.txtResult.appendText("Soglia non valida\n");
        	 return;
         }
    	

    }

    @FXML
    void doRicerca(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnContaArchi != null : "fx:id=\"btnContaArchi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnRicerca != null : "fx:id=\"btnRicerca\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtSoglia != null : "fx:id=\"txtSoglia\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
   
    }

	public void setModel(Model model) {
		this.model = model ;
		
       this.model.creaGrafo();
    	
    	txtResult.appendText("Grafo creato!\n");
    	txtResult.appendText("# Vertici : " + this.model.nVertici() + "\n");
    	txtResult.appendText("# Archi : " + this.model.nArchi() + "\n");
    	txtResult.appendText("Peso minimo: "+model.pesoMin()+" Peso massimo: "+model.pesoMax()+"\n");
		
		
		
	}
}
