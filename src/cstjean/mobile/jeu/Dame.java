package cstjean.mobile.jeu;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe dame pour quand un pion est promu.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */

public class Dame extends Pion {
    /**
     * Appelle le constructeur de pion pour initialiser le constructeur de la classe Dame.
     */
    public Dame() {
        super();
    }

    /**
     * Appelle le constructeur de pion pour initialiser le constructeur de la classe Dame, avec paramètre couleur.
     *
     * @param couleur la couleur de la Dame.
     */
    public Dame(Couleur couleur) {
        super(couleur);
    }

    @Override
    protected char getLettre() {
        return 'd';
    }

    @Override
    public List<Deplacement> getDeplacementsPossibles(Damier damier, int position) {
        List<Deplacement> deplacements = new ArrayList<>();

        for (int pasLigne = -1; pasLigne <= 1; pasLigne += 2) {
            for (int pasColonne = -1; pasColonne <= 1; pasColonne += 2) {
                deplacements.addAll(getDeplacementsDiagonale(damier, position, pasLigne, pasColonne));
            }
        }
        return deplacements;
    }

    @Override
    public boolean doitEtrePromu(int arrivee) {
        return false;
    }

    private List<Deplacement> getDeplacementsDiagonale(Damier damier, int position, int pasLigne, int pasColonne) {
        int ligne = Damier.getLigne(position) + pasLigne;
        int colonne = Damier.getColonne(position) + pasColonne;
        int numero = Damier.getNumero(ligne, colonne);
        int prise = 0;
        List<Deplacement> deplacements = new ArrayList<>();

        while (numero != 0) {
            Pion pion = damier.getPion(numero);
            if (pion == null) {
                deplacements.add(new Deplacement(position, numero, prise));
            } else if (prise == 0 && pion.getCouleur() != getCouleur()) {
                prise = numero;
            } else {
                break;
            }

            ligne += pasLigne;
            colonne += pasColonne;
            numero = Damier.getNumero(ligne, colonne);
        }
        return deplacements;
    }
}
