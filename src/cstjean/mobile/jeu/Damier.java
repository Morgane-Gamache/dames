package cstjean.mobile.jeu;

import com.sun.source.tree.Tree;
import java.util.TreeMap;

/**
 * Damier pour jouer aux dames.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */

public class Damier {

    /**  Le nombre de cases du damier.*/
    private static final int NB_CASES = 50;

    /**  Liste contenant les pions qui sont sur le damier.*/
    private final TreeMap<Integer, Pion> pions;

    /**  Crée un damier avec une liste de 50 positions vides (null).*/
    public Damier() {
        this.pions = new TreeMap<>();
        //for (int i = 0; i < NB_CASES; i++) {
          //  pions.put(null, null);
        //}
    }

    /**
     * Ajoute un pion sur le damier (dans la liste pions) à une position précise.
     *
     * @param index La position où l'on veut ajouter un pion.
     * @param pion Le pion que l'on veut placer sur le damier.
     */
    public void ajouterPion(int index, Pion pion) {
        //index--;
        pions.put(index, pion);
    }

    /**
     * Cherche le pion se trouvant à un emplacement précis.
     *
     * @param index La position où l'on veut prendre un pion.
     * @return Le pion ou null.
     */
    public Pion getPion(int index) {
        //index--;
        return pions.get(index);
    }

    /**
     * Compte les pions qui sont sur le damier.
     *
     * @return Le nombre de pions sur le damier.
     */
    public int getNombrePions() {
        int nombrePions = 0;
        for (Pion pion : pions.values()) {
            if (pion != null) {
                nombrePions++;
            }
        }
        return nombrePions;
    }

    /**
     * Ajoute les pions au damier. Les cases null serviront pour l'affichage.
     */

    public void initialiser() {
        for (int i = 1; i <= 50; i++) {
            if (i <= 20) {
                ajouterPion(i, new Pion(Pion.Couleur.NOIR));
            }
            if (i > 20 && i <= 30) {
                ajouterPion(i, null);
            }
            if (i > 30) {
                ajouterPion(i, new Pion());
            }
        }
    }

}
