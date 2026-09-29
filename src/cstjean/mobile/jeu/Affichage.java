package cstjean.mobile.jeu;

/**
 * Pour afficher.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */
public class Affichage {

    /**
     * Cree une string du plateau de dames et pions
     *
     * @param damier Est un damier contenant les pions.
     *
     * @return plateau Retourne la string.
     *
     */

    public String creerAffichage(Damier damier) {
        char tiret = '-';
        String plateau = "";
        int position = 1;

        for (int ligne = 0; ligne < 10; ligne++) {

            for (int colonne = 0; colonne < 10; colonne++) {
                if ((ligne + colonne) % 2 == 0) {
                    plateau += tiret;
                } else {
                    if (damier.getPion(position) == null) {
                        plateau += tiret;
                    } else {
                        plateau += damier.getPion(position).getRepresentation();
                    }

                    position++;
                }
            }

            plateau += "\n";
        }

        return plateau;
    }

    /**
     * Affiche le plateau de dames et pions.
     *
     * @param plateau Est une string contenant des pions.
     *
     */

    public void afficher(String plateau) {
        System.out.println(plateau);
    }
}
