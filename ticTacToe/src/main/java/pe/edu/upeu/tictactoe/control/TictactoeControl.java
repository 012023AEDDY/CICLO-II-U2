package pe.edu.upeu.tictactoe.control;

import com.sun.glass.ui.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;
import pe.edu.upeu.tictactoe.modelo.ModelTic;

import java.util.Random;

// esta clase une a fxml (intefaz de tic tac toe, con el codigo que vamos a escribir aqui)
@Component
public class TictactoeControl {
    ModelTic modelTic = new ModelTic();
    @FXML
    public TextField jugador1;
    @FXML
    public TextField jugador2;
    public Label LabelJugador1;
    public Label LabelJugador2;
    public Label turnoJugador;
    //para los botones
    Button[][] table;
    @FXML
    Button btn7,bnt8,bnt9,bnt4,bnt5,bnt6,bnt1,bnt2,bnt3;
    boolean turno=true;

    @FXML
    public void initialize(){
        anular();
        System.out.println("holi");
        table = new Button[][]{
                {btn7,bnt8,bnt9},
                {bnt4,bnt5,bnt6},
                {bnt1,bnt2,bnt3}

        };
    }
    @FXML
    public void accionButton(ActionEvent event) {
        Button holi=(Button) event.getSource();
        System.out.println("holi"+holi.toString());
       /* holi.setText(turno?"X":"O");
        turno=!turno;//este es para combinar "X","O"
        System.out.println("+noeturno"+turno);*/
        if (modelTic.getTurno()==1){
            holi.setText("X");
            turnoJugador.setText("turno del jugador 2");
            modelTic.setTurno(2);
        }else {
            holi.setText("0");
            turnoJugador.setText("turno del jugador 1");
            modelTic.setTurno(1);

        }
        System.out.println(holi.toString()+" "+holi.getText());
        imprimir();


        if (verificarGanador()) {
            String ganador = modelTic.getTurno() == 1 ? modelTic.getJugadorDos() : modelTic.getJugadorUno();
            turnoJugador.setText("¡Ganador: " + ganador + "!");
            guardarResultado(ganador);
            activadDesactiva(true);
        }
    }
    @FXML
    void imprimir (){
        System.out.println("Estado actual de la matriz:");
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {

                String ojo = table[i][j].getText().isEmpty() ? " " : table[i][j].getText();
                System.out.print(ojo + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    @FXML
    public void iniciar(){


        modelTic.setJugadorUno(jugador1.getText());
        modelTic.setJugadorDos(jugador2.getText());

        activadDesactiva(false);
        Random random = new Random();


        int randomInt = random.nextInt(2);
        if (randomInt==0){
            modelTic.setTurno(1);
        }else {
            modelTic.setTurno(2);
        }
        turnoJugador.setText(modelTic.getTurno().toString());
        LabelJugador1.setText(modelTic.getJugadorUno().toString());
        LabelJugador2.setText(modelTic.getJugadorDos().toString());
        System.out.println("Número entero aleatorio (0 o 1): " + randomInt);


    }
    public void anular(){
        activadDesactiva(true);
    }
    public void activadDesactiva(boolean incicador){
        btn7.setDisable(incicador);
        bnt8.setDisable(incicador);
        bnt9.setDisable(incicador);
        bnt4.setDisable(incicador);
        bnt5.setDisable(incicador);
        bnt6.setDisable(incicador);
        bnt1.setDisable(incicador);
        bnt2.setDisable(incicador);
        bnt3.setDisable(incicador);
    }
    @FXML
    public boolean verificarGanador() {
        // Comprobar filas
        for (int i = 0; i < 3; i++) {
            if (!table[i][0].getText().isEmpty() &&
                    table[i][0].getText().equals(table[i][1].getText()) &&
                    table[i][1].getText().equals(table[i][2].getText())) {
                return true;
            }
        }

        // Comprobar columnas
        for (int i = 0; i < 3; i++) {
            if (!table[0][i].getText().isEmpty() &&
                    table[0][i].getText().equals(table[1][i].getText()) &&
                    table[1][i].getText().equals(table[2][i].getText())) {
                return true;
            }
        }

        // Comprobar diagonales
        if (!table[0][0].getText().isEmpty() &&
                table[0][0].getText().equals(table[1][1].getText()) &&
                table[1][1].getText().equals(table[2][2].getText())) {
            return true;
        }

        if (!table[0][2].getText().isEmpty() &&
                table[0][2].getText().equals(table[1][1].getText()) &&
                table[1][1].getText().equals(table[2][0].getText())) {
            return true;
        }

        return false;
    }
    @FXML
    public void guardarResultado(String ganador) {}

}