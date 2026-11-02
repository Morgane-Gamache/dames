package cstjean.mobile.jeu;

import junit.framework.TestCase;

/**
 * Test pour la classe Partie.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */
public class TestPartie extends TestCase {
    /**
     * Teste la création d'une partie.
     */
    public void testCreer() {
        Partie partie = new Partie("Ian", "Morgane");
        Damier damier = partie.getDamier();

        assertEquals("Ian", partie.getJoueurCourant().getNom());
        assertEquals(Pion.Couleur.BLANC, partie.getJoueurCourant().getCouleur());

        assertEquals(40, damier.getNombrePions());
        assertFalse(partie.estTerminee());
        assertNull(partie.getGagnant());
    }

    /**
     * Teste un coup valide.
     */
    public void testJouer() {
        Partie partie = new Partie("Ian", "Morgane");

        partie.jouer(31, 27);
        assertNull(partie.getDamier().getPion(31));
        assertNotNull(partie.getDamier().getPion(27));

        assertEquals("Morgane", partie.getJoueurCourant().getNom());

        partie.jouer(18, 22);
        assertEquals("Ian", partie.getJoueurCourant().getNom());
    }

    /**
     * Teste les coups invalides.
     */
    public void testJouerInvalide() {
        Partie partie = new Partie("Ian", "Morgane");

        try {
            partie.jouer(25, 20);
            fail("Une case vide n'est pas un pion.");
        } catch (IllegalArgumentException e) {
            //
        }
        try {
            partie.jouer(20, 24);
            fail("Le joueur blanc ne peut pas jouer une pièce noire.");
        } catch (IllegalArgumentException e) {
            //
        }
        try {
            partie.jouer(31, 22);
            fail("31 vers 22 est un déplacement invalide.");
        } catch (IllegalArgumentException e) {
            //
        }
        assertEquals("Ian", partie.getJoueurCourant().getNom());
    }

    /**
     * Teste le retour en arrière.
     */
    public void testAnnuler() {
        Partie partie = new Partie("Ian", "Morgane");
        partie.jouer(31, 27);
        partie.jouer(18, 22);

        assertEquals(2, partie.getNombreDeplacements());
        assertEquals("31-27", partie.getDeplacement(0).toString());

        partie.annuler();
        assertEquals(1, partie.getNombreDeplacements());
        assertNotNull(partie.getDamier().getPion(18));
        assertNull(partie.getDamier().getPion(22));
        assertEquals("Morgane", partie.getJoueurCourant().getNom());

        partie.annuler();
        assertNotNull(partie.getDamier().getPion(31));
        assertEquals("Ian", partie.getJoueurCourant().getNom());

        try {
            partie.annuler();
            fail("Il y a rien à annuler.");
        } catch (IllegalStateException e) {
            //
        }
    }

    /**
     * Teste la fin de partie quand blanc est bloqué.
     */
    public void testFinBlancBloque() {
        Damier damier = new Damier();
        damier.ajouterPion(6, new Pion(Pion.Couleur.BLANC));
        damier.ajouterPion(1, new Pion(Pion.Couleur.NOIR));

        Partie partie = new Partie("Ian", "Morgane", damier);
        assertTrue(partie.estTerminee());
        assertEquals("Morgane", partie.getGagnant().getNom());
    }

    /**
     * Teste la fin de partie quand le noir a zéro pièce.
     */
    public void testFinAucunePiece() {
        Damier damier = new Damier();
        damier.ajouterPion(32, new Pion(Pion.Couleur.BLANC));
        damier.ajouterPion(27, new Pion(Pion.Couleur.NOIR));

        Partie partie = new Partie("Ian", "Morgane", damier);
        partie.jouer(32, 21);

        assertTrue(partie.estTerminee());
        assertEquals("Ian", partie.getGagnant().getNom());
    }
}
