package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;//para que reconosca los graficos creo



@Component
public class CalcControl {
    @FXML
    TextField txtResultado;

    @FXML
    public void accionButton(ActionEvent event) {
        System.out.println("Holas");
        Button button = (Button) event.getSource();
        switch (button.getId()) {
            case "btn7", "btn8", "btn9", "btn6", "btn5", "btn4", "btn3", "btn2", "btn1": {
                escribirNumeros(button.getText());
            }
            break;
            case "btnSum", "btnRest", "btnMul", "btnDiv": {
                operador(button.getText());
            }
            break;
            case "btnIgual": {
                calcularResultado();
            }
            break;
            case "btnBorrar": {
                txtResultado.clear();
            }
        }
    }

    public void escribirNumeros(String valor) {
        txtResultado.appendText(valor);
    }

    public void operador(String valor) {
        txtResultado.appendText(" " + valor + " ");
    }

    public void calcularResultado() {
        String[] valores = txtResultado.getText().split("");
        double val1 = Double.parseDouble(valores[0]);
        double val2 = Double.parseDouble(valores[1]);
        switch (valores[1]) {
            case "+": {txtResultado.setText(String.valueOf(val1 + val2));}break;
            case "-": {txtResultado.setText(String.valueOf(val1 - val2));}break;
            case "*": {txtResultado.setText(String.valueOf(val1 * val2));}break;
            case "/": {txtResultado.setText(String.valueOf(val1 / val2));}break;
        }
    }
}

