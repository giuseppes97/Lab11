package it.polito.tdp.bar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BarController {
   Simulatore sim;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea testorisultati;

    @FXML
    private Button bottone;

    @FXML
    void simula(ActionEvent event) {
    sim.init();
    sim.run();
    
    testorisultati.appendText("\n\n"+sim.toString());
    }

    @FXML
    void initialize() {
        assert testorisultati != null : "fx:id=\"testorisultati\" was not injected: check your FXML file 'Bar.fxml'.";
        assert bottone != null : "fx:id=\"bottone\" was not injected: check your FXML file 'Bar.fxml'.";

    }

	public void setSim(Simulatore sim2) {
		this.sim=sim2;
		
	}
}
