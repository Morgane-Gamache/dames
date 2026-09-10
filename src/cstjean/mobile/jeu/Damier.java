package cstjean.mobile.jeu;

import java.util.LinkedList;

/**
 * Damier pour jouer aux dames.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */

public class Damier {

    /**  Liste contenant les pions qui sont sur le damier.*/
    private final LinkedList<Pion> pions;

    /**  Crée un damier avec une liste de 50 positions vides (null).*/
    public Damier() {
        this.pions = new LinkedList<Pion>();
        for (int i = 0; i < 50; i++) {
            pions.add(null);
        }
    }

    /**
     * Ajoute un pion sur le damier (dans la liste pion) à une postion précise.
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
     * @param index La position où l'on veut ajouter un pion.
     * @return Un pion.
     */
    public Pion getPion(int index) {
        index--;
        return pions.get(index);
    }
}
