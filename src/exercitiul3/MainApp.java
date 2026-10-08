/*
3. Să se insereze într-o anumită poziție a unui șir de caractere, un alt șir. Datele vor fi
preluate de la tastatură sau din fișier. Să se șteargă o porțiune a unui șir de caractere care
începe dintr-o anumită poziție și are un anumit număr de caractere. Se recomandă utilizarea
clasei StringBuilder
 */

package exercitiul3;

import java.util.Scanner;

//import static jdk.internal.org.jline.utils.Colors.s;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Introdu sirul initial: ");
        String sirInitial= scanner.nextLine();
        StringBuilder sb= new StringBuilder(sirInitial);
        System.out.println("Introdu sirul care vrei sa fie inserat: ");
        String sirDeInserat= scanner.nextLine();
        System.out.println("Introdu pozitia de inserare(intre 0 si " + sb.length() + "): ");
        int pozitieInserare= scanner.nextInt();
        sb.insert(pozitieInserare, sirDeInserat);
        System.out.println("Sirul dupa inserare este: " + sb.toString());
        System.out.println("\nIntrodu pozitia de start pentru stergere: ");
        int pozitieStergere= scanner.nextInt();
        System.out.println("Introdu numarul de caractere pe care vrei sa-l stergi: ");
        int numarCaractere= scanner.nextInt();
        sb.delete(pozitieStergere, pozitieStergere + numarCaractere);
        System.out.println("Sirul final dupa stergere este: " + sb.toString());
        scanner.close();
    }
}
