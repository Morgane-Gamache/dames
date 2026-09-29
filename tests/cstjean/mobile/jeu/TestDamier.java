package cstjean.mobile.jeu;

import junit.framework.TestCase;

/**
 * Tests pour le damier.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */

public class TestDamier extends TestCase {

    /**  Le damier utilisé pour les tests.*/
    private Damier damier;

    /**  Crée un nouveau damier avant chaque test.*/
    public void setUp() {
        damier = new Damier();
    }

    /**  Teste qu'un damier est vide au départ.*/
    public void testDamierVide() {
        assertEquals(0, damier.getNombrePions());
        assertNull(damier.getPion(1));
        assertNull(damier.getPion(50));
    }

    /**  Teste l'ajout de pions à un damier.*/
    public void testAjouterPion() {
        Pion pionB = new Pion(Pion.Couleur.NOIR);
        damier.ajouterPion(3, pionB);
        assertEquals(1, damier.getNombrePions());
        assertEquals(pionB, damier.getPion(3));
        assertEquals(Pion.Couleur.NOIR, damier.getPion(3).getCouleur());

        Pion pionA = new Pion();
        damier.ajouterPion(2, pionA);
        assertEquals(2, damier.getNombrePions());
        assertEquals(pionA, damier.getPion(2));
        assertEquals(Pion.Couleur.BLANC, damier.getPion(2).getCouleur());
    }

    public void testInitialiser() {
        assertEquals(0, damier.getNombrePions());
        damier.initialiser();
        assertEquals(40, damier.getNombrePions());
    }
}
