import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryDecimalConverter {

    // Método para converter decimal em binário manualmente
    public static String decimalToBinaryManual(int num) {
        int resto;
        List<Integer> numeros = new ArrayList<>();

        while (num > 0) {
            if (num % 2 >= 1) {
                resto = 1;
            } else {
                resto = 0;
            }
            num = num / 2;
            numeros.add(resto);
        }

        Collections.reverse(numeros);
        StringBuilder binaryStr = new StringBuilder();
        for (Integer numero : numeros) {
            binaryStr.append(numero);
        }
        return binaryStr.toString();
    }

    // Método para converter binário em decimal manualmente
    public static int binaryToDecimalManual(String binary) {
        // Validar se a string contém apenas 0 e 1
        for (char c : binary.toCharArray()) {
            if (c != '0' && c != '1') {
                throw new NumberFormatException("Entrada inválida");
            }
        }

        List<Integer> numeros = new ArrayList<>();
        for (char c : binary.toCharArray()) {
            numeros.add(Character.getNumericValue(c));
        }

        double resultado = 0;
        double digito;

        for (int i = numeros.size() - 1; i >= 0; i--) {
            int numero = numeros.get(i);
            digito = Math.pow(2, (numeros.size() - 1 - i));
            resultado += digito * numero;
        }
        return (int) resultado;
    }

    public static void main(String[] args) {
        // Criar a tela principal
        JFrame frame = new JFrame("Conversor Binário-Decimal");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criar os componentes
        JLabel inputLabel = new JLabel("Digite o número:");
        JTextField inputField = new JTextField(20);
        JButton binToDecButton = new JButton("Binário para Decimal");
        JButton decToBinButton = new JButton("Decimal para Binário");
        JLabel resultLabel = new JLabel("Resultado:");
        JTextField resultField = new JTextField(20);
        resultField.setEditable(false);

        // Adicionar ação para o botão de Binário para Decimal
        binToDecButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                try {
                    int decimal = binaryToDecimalManual(input);
                    resultField.setText(String.valueOf(decimal));
                } catch (NumberFormatException ex) {
                    resultField.setText("Entrada inválida");
                }
            }
        });

        // Adicionar ação para o botão de Decimal para Binário
        decToBinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                try {
                    int decimal = Integer.parseInt(input);
                    String binary = decimalToBinaryManual(decimal);
                    resultField.setText(binary);
                } catch (NumberFormatException ex) {
                    resultField.setText("Entrada inválida");
                }
            }
        });

        // Adicionar os componentes ao frame
        JPanel panel = new JPanel();
        panel.add(inputLabel);
        panel.add(inputField);
        panel.add(binToDecButton);
        panel.add(decToBinButton);
        panel.add(resultLabel);
        panel.add(resultField);

        frame.add(panel);
        frame.setVisible(true);
    }
}
