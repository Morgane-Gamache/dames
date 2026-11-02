package cstjean.mobile.jeu;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe partie pour gérer les tours et l'historique de la partie.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */
public class Partie {

    /**
     * Le damier de la partie.
     */
    private Damier damier;
    /**
     * Le joueur blanc.
     */
    private final Joueur joueurBlanc;
    /**
     * Le joueur noir.
     */
    private final Joueur joueurNoir;
    /**
     * Le joueur dont c'est le tour.
     */
    private Joueur joueurCourant;

    /**
     * Les déplacements effectués, dans l'ordre.
     */
    private final List<Deplacement> historique = new ArrayList<>();

    /**
     * Une copie du damier avant chaque déplacement joué.
     */
    private final List<Damier> damiersPrecedents = new ArrayList<>();

    /**
     * Crée une partie avec un damier initialisé.
     *
     * @param nomBlanc Le nom du joueur blanc.
     * @param nomNoir Le nom du joueur noir.
     */
    public Partie(String nomBlanc, String nomNoir) {
        this(nomBlanc, nomNoir, new Damier());
        damier.initialiser();
    }

    /**
     * Crée une partie à partir d'un damier préparé à des fins de test.
     *
     * @param nomBlanc Le nom du joueur blanc.
     * @param nomNoir Le nom du joueur noir.
     * @param damier Le damier de départ.
     */
    public Partie(String nomBlanc, String nomNoir, Damier damier) {
        this.damier = damier;

        joueurBlanc = new Joueur(Pion.Couleur.BLANC, nomBlanc);
        joueurNoir = new Joueur(Pion.Couleur.NOIR, nomNoir);
        joueurCourant = joueurBlanc;
    }

    public Joueur getJoueurCourant() {
        return joueurCourant;
    }

    public Damier getDamier() {
        return damier;
    }

    /**
     * Fait le déplacement pour le joueur courant puis change de joueur.
     *
     * @param depart La case de départ.
     * @param arrivee La case d'arrivée.
     * @throws IllegalArgumentException si le déplacement est invalide ou si la couleur de la pièce
     *     ne correspond pas à la couleur du joueur courant.
     */
    public void jouer(int depart, int arrivee) {
        Pion pion = damier.getPion(depart);
        if (pion == null || pion.getCouleur() != joueurCourant.getCouleur()) {
            throw new IllegalArgumentException("La case " + depart + " n'a pas une pièce du joueur courant.");
        }

        Deplacement choisi = null;
        for (Deplacement deplacement : damier.getDeplacementsValides(depart)) {
            if (deplacement.getArrivee() == arrivee) {
                choisi = deplacement;
            }
        }
        if (choisi == null) {
            throw new IllegalArgumentException("Déplacement invalide : " + depart + " vers " + arrivee + ".");
        }

        damiersPrecedents.add(new Damier(damier));
        historique.add(choisi);

        damier.deplacer(choisi);
        changerTour();
    }

    /**
     * Annule le dernier déplacement.
     *
     * @throws IllegalStateException s'il n'y a aucun déplacement existant dans l'historique.
     */
    public void annuler() {
        if (historique.isEmpty()) {
            throw new IllegalStateException("Aucun déplacement dans l'historique.");
        }
        damier = damiersPrecedents.remove(damiersPrecedents.size() - 1);
        historique.remove(historique.size() - 1);

        changerTour();
    }

    /**
     * Retourne le nombre de déplacements joués.
     *
     * @return Le nombre de déplacements dans l'historique.
     */
    public int getNombreDeplacements() {
        return historique.size();
    }

    /**
     * Obtient un déplacement dans l'historique via son index.
     *
     * @param index L'index du déplacement demandé.
     * @return Le déplacement.
     */
    public Deplacement getDeplacement(int index) {
        return historique.get(index);
    }

    /**
     * Vérifie si la partie est terminée.
     *
     * @return Vrai si la partie est terminée.
     */
    public boolean estTerminee() {
        return !damier.peutJouer(joueurCourant.getCouleur());
    }

    /**
     * Donne le gagnant.
     *
     * @return Le gagnant (ou null si la partie n'est pas terminée).
     */
    public Joueur getGagnant() {
        if (!estTerminee()) {
            return null;
        }
        if (joueurCourant == joueurBlanc) {
            return joueurNoir;
        } else {
            return joueurBlanc;
        }
    }

    private void changerTour() {
        if (joueurCourant == joueurBlanc) {
            joueurCourant = joueurNoir;
        } else {
            joueurCourant = joueurBlanc;
        }
    }
}
