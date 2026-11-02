package cstjean.mobile.jeu;

import java.util.ArrayList;
import java.util.List;

/**
 * Pions pour jeu de dames.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */

public class Pion {
    /**
     * La couleur du pion.
     */
    public enum Couleur {
        /**
         * La couleur du pion blanc.
         */
        BLANC,
        /**
         * La couleur du pion noir.
         */
        NOIR
    }

    /**
     * La couleur du pion.
     *
     */
    private final Couleur couleur;

    /**
     * Crée un pion ayant une couleur blanche comme couleur par défaut.
     */
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
     * Obtient la lettre de la pièce.
     *
     * @return La lettre de la pièce.
     */

    protected char getLettre() {
        return 'p';
    }

    /**
     * Obtient la lettre de la pièce selon la couleur.
     * Minuscule si blanc, majuscule sinon.
     *
     * @return La lettre de la pièce.
     */
    public Character getRepresentation() {
        if (getCouleur() == Couleur.BLANC) {
            return getLettre();
        } else {
            return Character.toUpperCase(getLettre());
        }
    }

    /**
     * Donne les déplacements possibles du pion.
     *
     * @param damier Le damier en question.
     * @param position La case du pion, 1-50.
     * @return La liste des déplacements possibles.
     */

    public List<Deplacement> getDeplacementsPossibles(Damier damier, int position) {
        int avant = 1;
        if (couleur == Couleur.BLANC) {
            avant = -1;
        }
        List<Deplacement> deplacements = new ArrayList<>();
        int ligne = Damier.getLigne(position);
        int colonne = Damier.getColonne(position);

        for (int pasLigne = -1; pasLigne <= 1; pasLigne += 2) {
            for (int pasColonne = -1; pasColonne <= 1; pasColonne += 2) {
                int voisine = Damier.getNumero(ligne + pasLigne, colonne + pasColonne);
                Pion pionVoisin = damier.getPion(voisine);
                boolean voisineVide = voisine != 0 && pionVoisin == null;
                boolean voisineAdverse = pionVoisin != null && pionVoisin.getCouleur() != couleur;
                int derriere = Damier.getNumero(ligne + 2 * pasLigne, colonne + 2 * pasColonne);
                boolean derriereVide = derriere != 0 && damier.getPion(derriere) == null;

                if (voisineVide && pasLigne == avant) {
                    deplacements.add(new Deplacement(position, voisine));
                } else if (voisineAdverse && derriereVide) {
                    deplacements.add(new Deplacement(position, derriere, voisine));
                }
            }
        }
        return deplacements;
    }

    /**
     * Vérifie si le pion doit être promu.
     *
     * @param arrivee La case d'arrivée.
     * @return Vrai si le pion doit avoir une promotion.
     */
    public boolean doitEtrePromu(int arrivee) {
        if (couleur == Couleur.BLANC) {
            return Damier.getLigne(arrivee) == 0;
        } else {
            return Damier.getLigne(arrivee) == Damier.TAILLE - 1;
        }
    }
}
