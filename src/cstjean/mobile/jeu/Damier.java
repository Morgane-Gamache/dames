package cstjean.mobile.jeu;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Damier pour jouer aux dames.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */

public class Damier {

    /**
     * Le nombre de lignes et de colonnes du damier.
     */
    public static final int TAILLE = 10;
    /**
     * Le nombre de cases utilisables par ligne.
     */
    private static final int NB_CASES_PAR_LIGNE = 5;
    /**
     * Le nombre de cases du damier.
     */
    private static final int NB_CASES = 50;

    /**
     * Map contenant les pions qui sont sur le damier.
     */
    private final TreeMap<Integer, Pion> pions;

    /**
     * Crée un damier vide.
     */
    public Damier() {
        this.pions = new TreeMap<>();
    }

    /**
     * Crée une copie d'un damier.
     *
     * @param autre Le damier à copier.
     */
    public Damier(Damier autre) {
        this.pions = new TreeMap<>(autre.pions);
    }

    /**
     * Trouve la ligne d'une case.
     *
     * @param numero Le numéro de la case, entre 1 et 50.
     * @return La ligne de la case.
     */
    public static int getLigne(int numero) {
        return (numero - 1) / NB_CASES_PAR_LIGNE;
    }

    /**
     * Trouve la colonne d'une case.
     *
     * @param numero Le numéro de la case.
     * @return La colonne de la case (entre 0 et 9).
     */
    public static int getColonne(int numero) {
        int colonne = (numero - 1) % NB_CASES_PAR_LIGNE * 2;
        if (getLigne(numero) % 2 == 0) {
            colonne++;
        }
        return colonne;
    }

    /**
     * Trouve le numéro de la case, avec une ligne et une colonne.
     *
     * @param ligne   La ligne, 0-9.
     * @param colonne La colonne, 0-9.
     * @return Le numéro de la case, 1 à 50. 0 si la case est pâle ou hors des limites.
     */
    public static int getNumero(int ligne, int colonne) {
        boolean horsDamier = ligne < 0 || ligne >= TAILLE || colonne < 0 || colonne >= TAILLE;
        if (horsDamier || (ligne + colonne) % 2 == 0) {
            return 0;
        }
        return ligne * NB_CASES_PAR_LIGNE + colonne / 2 + 1;
    }

    /**
     * Ajoute un pion sur le damier (dans la liste pions) à une position précise.
     *
     * @param index La position où l'on veut ajouter un pion.
     * @param pion  Le pion que l'on veut placer sur le damier.
     */
    public void ajouterPion(int index, Pion pion) {
        pions.put(index, pion);
    }

    /**
     * Cherche le pion se trouvant à un emplacement précis.
     *
     * @param index La position où l'on veut prendre un pion.
     * @return Le pion ou null.
     */
    public Pion getPion(int index) {
        return pions.get(index);
    }

    /**
     * Compte les pions qui sont sur le damier.
     *
     * @return Le nombre de pions sur le damier.
     */
    public int getNombrePions() {
        return pions.size();
    }

    /**
     * Ajoute les pions au damier.
     */

    public void initialiser() {
        for (int i = 1; i <= NB_CASES; i++) {
            if (i <= 20) {
                ajouterPion(i, new Pion(Pion.Couleur.NOIR));
            }
            if (i > 30) {
                ajouterPion(i, new Pion());
            }
        }
    }

    /**
     * Donne les déplacements valides pour une case.
     *
     * @param position La case de la pièce.
     * @return Les déplacements possibles.
     */
    public List<Deplacement> getDeplacementsValides(int position) {
        Pion pion = getPion(position);
        if (pion == null) {
            return new ArrayList<>();
        }
        return pion.getDeplacementsPossibles(this, position);
    }

    /**
     * Fait le déplacment. Gére la logique de retrait et de promotion.
     *
     * @param deplacement Le déplacement à effectuer.
     */
    public void deplacer(Deplacement deplacement) {
        Pion pion = pions.remove(deplacement.getDepart());

        if (deplacement.estPrise()) {
            pions.remove(deplacement.getPrise());
        }

        if (pion.doitEtrePromu(deplacement.getArrivee())) {
            pion = new Dame(pion.getCouleur());
        }
        pions.put(deplacement.getArrivee(), pion);
    }

    /**
     * Vérifie s'il y a au moins un déplacement possible, pour une couleur.
     *
     * @param couleur La couleur à vérifier.
     * @return Vrai si au moins une pièce de cette couleur peut bouger.
     */
    public boolean peutJouer(Pion.Couleur couleur) {
        for (int position = 1; position <= NB_CASES; position++) {
            Pion pion = getPion(position);
            if (pion != null && pion.getCouleur() == couleur && !getDeplacementsValides(position).isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
