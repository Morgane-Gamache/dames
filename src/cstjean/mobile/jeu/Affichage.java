package cstjean.mobile.jeu;

public class Affichage {
    private String plateau;
    private final Character tiret = '-';

    public String creerAffichage(Damier damier) {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                if (i % 10 == 0) {

                }
                if (damier.getPion(i) == null) {
                    plateau = plateau + tiret;
                } else {
                    plateau = plateau + damier.getPion(i).getRepresentation();

                }
            } else {
                plateau = plateau + tiret;
            }
        }
        return plateau;
    }
}
