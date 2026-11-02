package cstjean.mobile.jeu;

/**
 * Classe joueur pour gérer les informations d'un joueur.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */
public class Joueur {
    /**
     * La couleur des pions du joueur.
     *
     */
    private final Pion.Couleur couleur;
    /**
     * Le nom du joueur.
     */
    private final String nom;

    /**
     * Le constructeur de la classe Joueur.
     *
     * @param couleur La couleur des pions du joueur.
     * @param nom     Le nom du joueur.
     */
    public Joueur(Pion.Couleur couleur, String nom) {
        this.couleur = couleur;
        this.nom = nom;
    }

    public Pion.Couleur getCouleur() {
        return couleur;
    }

    public String getNom() {
        return nom;
    }
}
