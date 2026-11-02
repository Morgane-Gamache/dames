package cstjean.mobile.jeu;

import java.util.List;
import junit.framework.TestCase;

/**
 * Tests pour les pions.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */

public class TestPion extends TestCase {
    /**
     * Le damier de test.
     */
    private Damier damier;

    /**
     * Donne un nouveau damier avant chaque test.
     */
    public void setUp() {
        damier = new Damier();
    }

    /**
     * Teste la création de pions.
     */
    public void testCreer() {
        Pion pionA = creerPion(Pion.Couleur.BLANC);
        Pion pionB = creerPion(Pion.Couleur.NOIR);
        assertEquals(Pion.Couleur.BLANC, pionA.getCouleur());
        assertEquals(Pion.Couleur.NOIR, pionB.getCouleur());
        assertEquals(getLettreAttendue(), pionA.getRepresentation().charValue());
        assertEquals(Character.toUpperCase(getLettreAttendue()), pionB.getRepresentation().charValue());

    }

    /** Teste qu'un pion est blanc par défaut. */
    public void testCouleurParDefaut() {
        assertEquals(Pion.Couleur.BLANC, new Pion().getCouleur());
    }

    /**
     * Teste les déplacements simples.
     */
    public void testDeplacementsSimples() {
        damier.initialiser();
        assertEquals("[31-26, 31-27]", damier.getDeplacementsValides(31).toString());
        assertEquals("[20-24, 20-25]", damier.getDeplacementsValides(20).toString());
        assertTrue(damier.getDeplacementsValides(36).isEmpty());
    }

    /**
     * Teste les prises possibles d'un pion.
     */
    public void testPrises() {
        damier.ajouterPion(28, new Pion(Pion.Couleur.BLANC));
        damier.ajouterPion(22, new Pion(Pion.Couleur.NOIR));
        damier.ajouterPion(33, new Pion(Pion.Couleur.NOIR));
        List<Deplacement> deplacements = damier.getDeplacementsValides(28);
        assertEquals("[28x17, 28-23, 28x39]", deplacements.toString());
        assertEquals(22, deplacements.get(0).getPrise());

        damier.ajouterPion(17, new Pion(Pion.Couleur.NOIR));
        assertEquals("[28-23, 28x39]", damier.getDeplacementsValides(28).toString());

        damier.ajouterPion(6, new Pion(Pion.Couleur.BLANC));
        damier.ajouterPion(1, new Pion(Pion.Couleur.NOIR));
        assertTrue(damier.getDeplacementsValides(6).isEmpty());
    }

    /**
     * Crée la pièce à tester.
     *
     * @param couleur La couleur de la pièce.
     * @return La pièce créée.
     */
    protected Pion creerPion(Pion.Couleur couleur) {
        return new Pion(couleur);
    }

    /**
     * Donne la lettre attendue pour la pièce.
     *
     * @return La lettre attendue.
     */
    protected char getLettreAttendue() {
        return 'p';
    }
}
