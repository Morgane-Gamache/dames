package cstjean.mobile.jeu;

/**
 * Pions pour jeu de dames.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */
public class Pion {
    /**  La couleur du pion.*/
    private final String couleur;

    /**  Crée un pion ayant une couleur blanche comme couleur par défaut.*/
    public Pion() {
        this.couleur = "blanc";
    }

    /**
     * Crée un pion n'ayant pas de couleur par défaut.
     *
     * @param couleur La couleur du pion.
     */
    public Pion(String couleur) {
        this.couleur = couleur;
    }

    /**
     * Récupère la couleur du pion.
     *
     * @return La couleur du pion.
     */
    public String getCouleur() {
        return couleur;
    }
}
