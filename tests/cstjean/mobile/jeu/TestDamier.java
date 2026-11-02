package cstjean.mobile.jeu;

import junit.framework.TestCase;

/**
 * Tests pour le damier.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */

public class TestDamier extends TestCase {

    /**
     * Le damier utilisé pour les tests.
     */
    private Damier damier;

    /**
     * Crée un nouveau damier avant chaque test.
     */
    public void setUp() {
        damier = new Damier();
    }

    /**
     * Teste qu'un damier est vide au départ.
     */
    public void testDamierVide() {
        assertEquals(0, damier.getNombrePions());
        assertNull(damier.getPion(1));
        assertNull(damier.getPion(50));
    }

    /**
     * Teste l'ajout de pions à un damier.
     */
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

    /**
     * Teste l'initialisation.
     */
    public void testInitialiser() {
        assertEquals(0, damier.getNombrePions());
        damier.initialiser();
        assertEquals(40, damier.getNombrePions());
    }

    /**
     * Teste la conversion entre numéro de case et ligne/colonne.
     */
    public void testConversions() {
        assertEquals(0, Damier.getLigne(1));
        assertEquals(1, Damier.getColonne(1));
        assertEquals(1, Damier.getLigne(6));
        assertEquals(0, Damier.getColonne(6));
        assertEquals(9, Damier.getLigne(50));
        assertEquals(8, Damier.getColonne(50));

        assertEquals(1, Damier.getNumero(0, 1));
        assertEquals(6, Damier.getNumero(1, 0));
        assertEquals(50, Damier.getNumero(9, 8));
        assertEquals(0, Damier.getNumero(0, 0));
        assertEquals(0, Damier.getNumero(-1, 0));
        assertEquals(0, Damier.getNumero(10, 1));
        assertEquals(0, Damier.getNumero(1, -1));
        assertEquals(0, Damier.getNumero(0, 11));
    }

    /**
     * Teste les déplacements valides d'une case vide/occupée.
     */
    public void testDeplacementsValides() {
        damier.initialiser();
        assertTrue(damier.getDeplacementsValides(25).isEmpty());
        assertEquals(2, damier.getDeplacementsValides(31).size());
    }

    /**
     * Teste un déplacement normal et une prise.
     */
    public void testDeplacer() {
        damier.initialiser();
        damier.deplacer(new Deplacement(31, 27));
        assertNull(damier.getPion(31));
        assertEquals('p', damier.getPion(27).getRepresentation().charValue());

        damier.deplacer(new Deplacement(18, 22));
        damier.deplacer(new Deplacement(27, 18, 22));
        assertNull(damier.getPion(22));
        assertEquals(Pion.Couleur.BLANC, damier.getPion(18).getCouleur());
        assertEquals(39, damier.getNombrePions());
    }

    /**
     * Teste la promotion avec les deux couleurs.
     */
    public void testPromotion() {
        damier.ajouterPion(6, new Pion(Pion.Couleur.BLANC));
        damier.ajouterPion(45, new Pion(Pion.Couleur.NOIR));
        damier.deplacer(new Deplacement(6, 1));
        damier.deplacer(new Deplacement(45, 50));
        assertEquals('d', damier.getPion(1).getRepresentation().charValue());
        assertEquals('D', damier.getPion(50).getRepresentation().charValue());
    }

    /**
     * Teste qu'une copie du damier ne change pas quand l'original change.
     */
    public void testCopie() {
        damier.initialiser();
        Damier copie = new Damier(damier);

        damier.deplacer(new Deplacement(31, 27));
        assertNotNull(copie.getPion(31));
        assertNull(copie.getPion(27));
        assertEquals(40, copie.getNombrePions());
    }

    /**
     * Teste si une couleur peut encore jouer.
     */
    public void testPeutJouer() {
        assertFalse(damier.peutJouer(Pion.Couleur.BLANC));

        damier.ajouterPion(6, new Pion(Pion.Couleur.BLANC));
        damier.ajouterPion(1, new Pion(Pion.Couleur.NOIR));

        assertFalse(damier.peutJouer(Pion.Couleur.BLANC));
        assertTrue(damier.peutJouer(Pion.Couleur.NOIR));
    }
}
