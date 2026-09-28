package cstjean.mobile.jeu;

import java.util.LinkedList;

/**
 * Damier pour jouer aux dames.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */

public class Damier {

    /**  Le nombre de cases du damier.*/
    private static final int NB_CASES = 50;

    /**  Liste contenant les pions qui sont sur le damier.*/
    private final LinkedList<Pion> pions;

    /**  Crée un damier avec une liste de 50 positions vides (null).*/
    public Damier() {
        this.pions = new LinkedList<>();
        for (int i = 0; i < NB_CASES; i++) {
            pions.add(null);
        }
    }

    /**
     * Ajoute un pion sur le damier (dans la liste pions) à une position précise.
     *
     * @param index La position où l'on veut ajouter un pion.
     * @param pion Le pion que l'on veut placer sur le damier.
     */
    public void ajouterPion(int index, Pion pion) {
        index--;
        pions.set(index, pion);
    }

    /**
     * Cherche le pion se trouvant à un emplacement précis.
     *
     * @param index La position où l'on veut prendre un pion.
     * @return Le pion ou null.
     */
    public Pion getPion(int index) {
        index--;
        return pions.get(index);
    }

    /**
     * Compte les pions qui sont sur le damier.
     *
     * @return Le nombre de pions sur le damier.
     */
    public int getNombrePions() {
        int nombrePions = 0;
        for (Pion pion : pions) {
            if (pion != null) {
                nombrePions++;
            }
        }
        return nombrePions;
    }
}
