package exercitiul4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Persoana {
    private String nume;
    private String cnp;

    public Persoana(String nume, String cnp){
        this.nume= nume;
        this.cnp= cnp;
    }
    public String getNume(){
        return nume;
    }
    public void setNume(String nume){
        this.nume= nume;
    }
    public String getCnp(){
        return cnp;
    }
    public void setCnp(String cnp){
        this.cnp= cnp;
    }
    public int getVarsta(){
        int s= Character.getNumericValue(cnp.charAt(0));
        int an= Integer.parseInt(cnp.substring(1, 3));
        if(s==1 || s==2){
            an += 1900;
        } else if(s==5 || s==6){
            an+=2000;
        }
        int luna= Integer.parseInt(cnp.substring(3,5));
        int zi= Integer.parseInt(cnp.substring(5,7));
        LocalDate dataNasterii= LocalDate.of(an,luna,zi);
        LocalDate dataCurenta= LocalDate.now();
        return (int) ChronoUnit.YEARS.between(dataNasterii, dataCurenta);
    }
}
