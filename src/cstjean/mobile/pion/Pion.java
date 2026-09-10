package cstjean.mobile.pion;

public class Pion {
    private final String couleur;

    public Pion() {
        this.couleur = "blanc";
    }
    public Pion(String couleur) {
        this.couleur = couleur;
    }

    public String getCouleur() {return couleur;}
}
