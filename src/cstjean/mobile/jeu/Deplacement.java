package cstjean.mobile.jeu;

/**
 * Classe déplacement pour gérer les déplacements.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */
public class Deplacement {
    /**
     * La case de départ (1 à 50).
     */
    private final int depart;
    /**
     * La case d'arrivée.
     */
    private final int arrivee;
    /**
     * La case de la pièce prise.
     * Zéro s'il n'y a pas de prise.
     */
    private final int prise;

    /**
     * Déplacement sans prise.
     *
     * @param depart La case de départ.
     * @param arrivee La case d'arrivée.
     */
    public Deplacement(int depart, int arrivee) {
        this(depart, arrivee, 0);
    }

    /**
     * Déplacement avec prise.
     *
     * @param depart La case de départ.
     * @param arrivee La case d'arrivée.
     * @param prise La case de la pièce prise.
     */
    public Deplacement(int depart, int arrivee, int prise) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.prise = prise;
    }

    /**
     * Getter de la case de départ.
     *
     * @return La case de départ.
     */
    public int getDepart() {
        return depart;
    }

    /**
     * Getter de la case d'arrivée.
     *
     * @return La case d'arrivée.
     */
    public int getArrivee() {
        return arrivee;
    }

    /**
     * Getter de la pièce prise.
     *
     * @return La case de la pièce prise ou 0.
     */
    public int getPrise() {
        return prise;
    }

    /**
     * Vérifie si le déplacement prend une pièce.
     *
     * @return Vrai dans le cas où il y a une prise.
     */
    public boolean estPrise() {
        return prise != 0;
    }

    /**
     * Donne le déplacement en notation Manoury.
     *
     * @return Le déplacement en notation Manoury.
     */
    @Override
    public String toString() {
        if (estPrise()) {
            return depart + "x" + arrivee;
        } else {
            return depart + "-" + arrivee;
        }
    }
}
