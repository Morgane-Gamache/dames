package cstjean.mobile.jeu;

/**
 * Classe joueur pour gérer les informations d'un joueur.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */
public class Joueur {
    /**
     * La couleur du joueur.
     */
    public enum Couleur {
        /**
         * La couleur du joueur blanc.
         */
        BLANC,
        /**
         * La couleur du joueur noir.
         */
        NOIR
    }

    /**
     * La couleur du pion.
     *
     */
    private final Couleur couleur;
    private final String nom;

    public Joueur(Couleur couleur, String nom) {
        this.couleur = couleur;
        this.nom = nom;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public String getNom() {
        return nom;
    }


}
