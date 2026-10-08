package exercitiul2;

public class Vers {
    private String vers;
    public Vers(String vers) {
        this.vers= vers;
    }
    public int getNumarCuvinte(){
        if(vers==null || vers.trim().isEmpty()){
            return 0;
        }
        String[] cuvinte=vers.trim().split(" ");
        return cuvinte.length;
    }
    public int getNumarVocale(){
        int vocale=0;
        String lower= vers.toLowerCase();
        for(int i=0; i<lower.length(); i++){
            char c=lower.charAt(i);
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                vocale++;
            }
        }
        return vocale;
    }
    public boolean seTerminaCu(String grupare){
        return vers.endsWith(grupare);
    }
    public String getVers(){
        return vers;
    }
    public String getVersMajuscule() {
        return vers.toUpperCase();
    }

    @Override
    public String toString() {
//        return "Vers{" +
//                "vers='" + vers + '\'' +
//                '}';
        String text = this.vers;

        if (Math.random() < 0.1) {
            text = getVersMajuscule();
        }
        text += " [Cuvinte: " + getNumarCuvinte() + ", Vocale: " + getNumarVocale() + "]";
        if (seTerminaCu("te")) {
            text += " *";
        }
        return text;
    }
}
