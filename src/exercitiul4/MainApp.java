/*
4. Să se realizeze un program care citește numele si CNP-ul pe care îl au n persoane.
Valoarea lui n se citește de la tastatură. Programul va afișa informațiile introduse și în plus
pentru fiecare Persoana va afișa vârsta. Cât timp un CNP-ul este introdus greșit programul va
cere reintroducerea acestuia. Pentru simplitate se consideră că CNP-ul este valid dacă
îndeplinește următoarele condiții:
• Are 13 caractere
• Toate caracterele sunt cifre
• Prima cifră are una din valorile 1, 2, 5, 6
• Cifra de control a CNP-ului are o valoare validă.
Se va crea clasa Persoana cu variabile membre private nume (String) şi cnp (String).
Clasa va avea constructor cu parametri, gettere si settere în funcție de necesități şi metoda
getVarsta() care va calcula şi va returna vârsta persoanei extrăgând data nașterii din CNP şi
citind din sistem data curentă. Se va utiliza clasa LocalDate. Se va crea un vector în care se
vor adăuga obiectele de tip Persoana. Fiecare element din vectorul va fi afișat pe un rând în
formatul nume, CNP, varsta.
 */

package exercitiul4;

import java.util.Scanner;

public class MainApp {
    public static boolean cnpValid(String cnp) {
        if (cnp == null || cnp.length() != 13) {
            return false;
        }
        if(!cnp.matches("\\d+")){
            return false;
        }
        char primaCifra= cnp.charAt(0);
        if(primaCifra != '1' && primaCifra != '2' && primaCifra != '5' && primaCifra != '6') {
            return false;
        }
        int[] ponderi= {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
        int suma= 0;
        for(int i = 0; i < 12; i++) {
            suma += Character.getNumericValue(cnp.charAt(i)) * ponderi[i];
        }
        int rest= suma % 11;
        int cifraControlCalculata= (rest < 10) ? rest : 1;
        int cifraControlCnp= Character.getNumericValue(cnp.charAt(12));
        return cifraControlCalculata == cifraControlCnp;
    }
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.print("Introduceti numarul de persoane (n): ");
        int n = scanner.nextInt();
        scanner.nextLine();
        Persoana[] vectorPersoane= new Persoana[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nIntrodu datele pentru persoana " + (i + 1));
            System.out.print("Nume: ");
            String nume= scanner.nextLine();
            String cnp;
            while (true) {
                System.out.print("CNP: ");
                cnp= scanner.nextLine();
                if (cnpValid(cnp)) {
                    break; // Iesim din bucla daca CNP-ul e ok
                } else {
                    System.out.println("Eroare: CNP invalid. Te rog sa reintroduci.");
                }
            }
            vectorPersoane[i]= new Persoana(nume, cnp);
        }
        System.out.println("\nLista persoane");
        for (Persoana p : vectorPersoane) {
            System.out.println(p.getNume() + ", " + p.getCnp() + ", " + p.getVarsta());
        }
        scanner.close();
    }
}