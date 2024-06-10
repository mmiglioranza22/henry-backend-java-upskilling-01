public class Frase {
    private String frase;

    public Frase(String frase) {
        this.frase = frase;
    }

    public int caracteres() {
        return this.frase.length();
    }

    public String contieneHola() {
        return this.frase.indexOf("Hola") != -1 ? "Si" : "No";
    }

    public String primerFrase() {
        String[] splitted = this.frase.split(" ");
        int primerFraseLen = splitted[0].length();
        return this.frase.substring(0, primerFraseLen);
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }
}
