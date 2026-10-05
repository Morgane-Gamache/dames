package cstjean.mobile.jeu;

/**
 * Pour afficher.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */
public class Affichage {

    /**
     * Crée un string du plateau de dames et pions.
     *
     * @param damier Est un damier contenant les pions.
     *
     * @return plateau Retourne le string.
     *
     */

    public String creerAffichage(Damier damier) {
        char tiret = '-';
        StringBuilder plateau = new StringBuilder();
        int position = 1;

        for (int ligne = 0; ligne < 10; ligne++) {

            for (int colonne = 0; colonne < 10; colonne++) {
                if ((ligne + colonne) % 2 == 0) {
                    plateau.append(tiret);
                } else {
                    if (damier.getPion(position) == null) {
                        plateau.append(tiret);
                    } else {
                        plateau.append(damier.getPion(position).getRepresentation());
                    }

                    position++;
                }
            }

            plateau.append("\n");
        }

        return plateau.toString();
    }

    /**
     * Affiche le plateau de dames et pions.
     *
     * @param plateau Est un string contenant des pions.
     *
     */

    public void afficher(String plateau) {
        System.out.println(plateau);
    }
}
