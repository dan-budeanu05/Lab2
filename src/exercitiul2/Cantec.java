/*
2. Fișierul cantec_in.txt conține versurile unui cântec la alegere. Să se scrie un
program care creează fișierul cantec_out.txt, care conține versurile cântecului original dar în
plus în dreptul fiecărui rând sunt afișate numărul de cuvinte de pe rând şi numărul de vocale
de pe fiecare rând. În dreptul rândurilor care se încheie cu o grupare de litere aleasă se va
pune o steluță (*). Rândurile pentru care un număr generat aleator este mai mic decât 0.1 vor
fi scrise cu majuscule (se vor genera aleator numere între 0 şi 1).
Se va defini o clasă Vers, care are o variabilă membră privată un șir de caractere
reprezentând versul și se va dezvolta câte un operator pentru fiecare cerință de mai sus (o
metodă care returnează numărul de cuvinte, o metodă care returnează numărul de vocale, etc).
Se va crea un vector de obiecte de tip Vers care va conține informația preluată din fișierul de
intrare.
 */

package exercitiul2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Cantec {
    public static void main(String[] args) throws FileNotFoundException {
            Scanner scanner = new Scanner(new File("src/exercitiul2/cantec_in.txt"));
            Vers[] vectorVersuri = new Vers[100];
            int n = 0;
            while (scanner.hasNextLine()) {
                vectorVersuri[n] = new Vers(scanner.nextLine());
                n++;
            }
            scanner.close();
            PrintStream fluxOut = new PrintStream(new File("cantec_out.txt"));
            for (int i = 0; i < n; i++) {
                fluxOut.println(vectorVersuri[i].toString());
            }
            fluxOut.close();
    }
}
