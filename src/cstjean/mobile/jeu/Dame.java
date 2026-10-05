package cstjean.mobile.jeu;

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
}
