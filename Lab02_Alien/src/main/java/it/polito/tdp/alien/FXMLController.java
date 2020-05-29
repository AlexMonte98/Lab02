package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Parole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	Parole parole=new Parole();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtArea;

    @FXML
    private Button btnClear;

    @FXML
    void doClear(ActionEvent event) {
    	txtArea.clear();
    	txtParola.clear();

    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String controllo=txtParola.getText();
    	String[] p1;
    	if(controllo.contains(" ")) {
    		p1=controllo.split(" "); 
    		String p2=new String(p1[0]);
    		String p3=new String(p1[1]);
    		if(!(p2==null&& p3==null)) {
    			this.parole.inserireParola(p2,p3 );
    			
    		}
    		
    		System.out.println(p1[0]+" "+p1[1]);
    		for(String cs: this.parole.elencoParole) {
    			if(cs!=null) {
    				System.out.println(cs);
    			}
    		}
    		System.out.println("AJNAJ");
    		for(String cx:this.parole.mappaParole.values()) {
    			System.out.println(cx);
    			System.out.println("AJNAJ222222222222");
    			System.out.println(this.parole.mappaParole.keySet());
    		}
    		
    		return;
    	}    	
    	if(this.parole.cerca(controllo)!=null) {
    		
    		txtArea.setText(this.parole.cerca(controllo)); 
    		return;
    	}
    	
    	
    	txtArea.clear();
    	txtParola.clear();
    	return;
    
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}