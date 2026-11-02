package cstjean.mobile.jeu;

import junit.framework.TestCase;

/**
 * Test pour la classe joueur.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */
public class TestJoueur extends TestCase {
    /**
     * Teste la création d'un joueur (Pions de couleur blanc et nom du joueur Alex).
     */
    public void testCreer() {
        Joueur joueur = new Joueur(Pion.Couleur.BLANC, "Alex");
        assertEquals(Pion.Couleur.BLANC, joueur.getCouleur());
        assertEquals("Alex", joueur.getNom());
    }
}
