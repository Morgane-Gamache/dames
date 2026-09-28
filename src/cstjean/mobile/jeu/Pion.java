package cstjean.mobile.jeu;

/**
 * Pions pour jeu de dames.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */

public class Pion {
    /**  La couleur du pion.*/
    public enum Couleur {
        /** La couleur du pion blanc.*/
        BLANC,
        /** La couleur du pion noir.*/
        NOIR
    }

    /**
     * La couleur du pion.
     * */
    private final Couleur couleur;

    /**  Crée un pion ayant une couleur blanche comme couleur par défaut.*/
    public Pion() {
        this(Couleur.BLANC);
    }

    /**
     * Crée un pion de la couleur donnée.
     *
     * @param couleur La couleur du pion.
     */
    public Pion(Couleur couleur) {
        this.couleur = couleur;
    }

    /**
     * Récupère la couleur du pion.
     *
     * @return La couleur du pion.
     */
    public Couleur getCouleur() {
        return couleur;
    }

    /**
     * Récupère la représentation du pion.
     *
     * @return La représentation du pion.
     */
    public Character getRepresentation() {
        if (couleur == Couleur.BLANC) {
            return 'p';
        } else {
            return 'P';
        }
    }
}
