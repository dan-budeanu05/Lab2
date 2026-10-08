/*
1. Fișierul judete_in.txt, conține lista neordonată a județelor din țară. Să se încarce
datele din fișier într-un tablou de String-uri și să se ordoneze acest tablou cu ajutorul metodei
sort() din clasa Arrays. Să se returneze pe ce poziție se află în vectorul ordonat un județ
introdus de la tastatură. Se va utiliza metoda de căutare binară din clasa Arrays.
 */

package exercitiul1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Judete {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner= new Scanner(new File("src/exercitiul1/judete_in.txt"));
        String[] judete= new String[41];
        int i=0;
        while(scanner.hasNextLine()){
            judete[i]= scanner.nextLine();
            i++;
        }
        Arrays.sort(judete);
        Scanner tastatura= new Scanner(System.in);
        System.out.println("Introdu de la tastatura judetul cautat:");
        String judet= tastatura.nextLine();
        int pozitie= Arrays.binarySearch(judete, judet);
        if(pozitie>=0){
            System.out.println("Judetul este la pozitia: "+(pozitie+1));
        } else{
            System.out.println("Judetul nu a fost gasit.");
        }
        scanner.close();
        tastatura.close();
    }
}
