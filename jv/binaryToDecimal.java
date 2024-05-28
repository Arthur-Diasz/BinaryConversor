import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class binaryToDecimal {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int resto;
        List<Integer> numeros = new ArrayList<>();

        System.out.println("Digite um número decimal para ser convertido em binário");
        int num = scn.nextInt();
        
        while (num > 0 ) {
            if (num % 2 >= 1) {
                resto = 1;
            } else {
                resto = 0;
            }
            num = num / 2;
            numeros.add(resto);
        }
        
        
        Collections.reverse(numeros);

        System.out.print("O numero " +num+ "convertido para binário é: ");
        for (Integer numero : numeros) {
            System.out.print(numero + " ");
        }
        
        System.out.println();
        
        double resultado = 0;
        double digito = 0;

        for (int i = numeros.size() - 1; i >= 0; i--) {
            
            int numero = numeros.get(i);
            
            digito = Math.pow(2, (numeros.size() - 1 - i));
            
            resultado += digito * numero;
            
        }
        System.out.print("O binario convertido para decimal é: " +resultado);
        
        scn.close();
    }
}
