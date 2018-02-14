package calculadora;

import java.io.IOException;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class Calculadora extends MIDlet implements CommandListener {

    private Display display;
    private Form form;
    private TextField valorA;
    private TextField valorB;
    private StringItem resultado;
    private Command soma;
    private Command subtracao;
    private Command multiplicacao;
    private Command divisao;
    private Command exit;
    private Alert alert;

    public void startApp() {
        display = Display.getDisplay(this);
        getForm();
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void getForm() {
        form = new Form("Calculadora");
        valorA = new TextField("Valor: ", "0", 15, TextField.DECIMAL);
        valorB = new TextField("Valor: ", "0", 15, TextField.DECIMAL);
        resultado = new StringItem("Resultado: ", "0");

        soma = new Command("+", Command.ITEM, 1);
        subtracao = new Command("-", Command.ITEM, 2);
        multiplicacao = new Command("x", Command.ITEM, 3);
        divisao = new Command("/", Command.ITEM, 4);
        exit = new Command("Sair", Command.EXIT, 1);

        form.append(valorA);
        form.append(valorB);
        form.append(resultado);

        form.addCommand(soma);
        form.addCommand(subtracao);
        form.addCommand(multiplicacao);
        form.addCommand(divisao);
        form.addCommand(exit);

        display.setCurrent(form);
        form.setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == exit) {
            destroyApp(true);
            notifyDestroyed();
        } else if (c == soma) {
            if (valorA.getString().equals("") || valorB.getString().equals("")) {
                alerta();
            } else {
                resultado.setText(String.valueOf(soma(valorA.getString(), valorB.getString())));
            }
        } else if (c == subtracao) {
            if (valorA.getString().equals("") || valorB.getString().equals("")) {
                alerta();
            } else {
                resultado.setText(String.valueOf(subtracao(valorA.getString(), valorB.getString())));
            }
        } else if (c == divisao) {
            if (valorA.getString().equals("") || valorB.getString().equals("")) {
                alerta();
            } else {
                resultado.setText(String.valueOf(divisao(valorA.getString(), valorB.getString())));
            }
        } else if (c == multiplicacao) {
            if (valorA.getString().equals("") || valorB.getString().equals("")) {
                alerta();
            } else {
                resultado.setText(String.valueOf(multiplicacao(valorA.getString(), valorB.getString())));
            }
        }
    }

    public double soma(String valorA, String valorB) {
        double soma = Double.parseDouble(valorA) + Double.parseDouble(valorB);
        return soma;
    }

    public double subtracao(String valorA, String valorB) {
        double subtracao = Double.parseDouble(valorA) - Double.parseDouble(valorB);
        return subtracao;
    }

    public double divisao(String valorA, String valorB) {
        double divisao = Double.parseDouble(valorA) / Double.parseDouble(valorB);
        return divisao;
    }

    public double multiplicacao(String valorA, String valorB) {
        double multiplicacao = Double.parseDouble(valorA) * Double.parseDouble(valorB);
        return multiplicacao;
    }

    public void alerta() {
        try {
            alert = new Alert("Atenção", "                  Preencha todos os campos", Image.createImage("/icones/alerta.png"), AlertType.ALARM);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        alert.setTimeout(Alert.FOREVER);
        display.setCurrent(alert);
    }
}
