package cstjean.mobile.jeu;

import java.util.List;

/**
 * Tests pour les dames.
 *
 * @author Morgane Gamache, Ian LeBlanc
 */
public class TestDame extends TestPion {
    /**
     * Teste qu'une dame est blanche par défaut.
     */
    public void testDameParDefaut() {
        assertEquals(Pion.Couleur.BLANC, new Dame().getCouleur());
        assertFalse(creerPion(Pion.Couleur.BLANC).doitEtrePromu(1));
    }

    /**
     * Teste le fait qu'une dame a 17 déplacements possibles au maximum.
     */
    public void testDeplacementsDame() {
        Damier damier = new Damier();
        damier.ajouterPion(28, creerPion(Pion.Couleur.BLANC));
        assertEquals(17, damier.getDeplacementsValides(28).size());
    }

    /**
     * Teste la prise à distance, n'importe quelle case libre après la pièce prise.
     */
    public void testPriseDame() {
        Damier damier = new Damier();
        damier.ajouterPion(46, creerPion(Pion.Couleur.BLANC));
        damier.ajouterPion(28, new Pion(Pion.Couleur.NOIR));
        damier.ajouterPion(14, new Pion(Pion.Couleur.NOIR));

        List<Deplacement> deplacements = damier.getDeplacementsValides(46);
        assertEquals("[46-41, 46-37, 46-32, 46x23, 46x19]", deplacements.toString());
        assertEquals(28, deplacements.get(3).getPrise());

        damier.ajouterPion(37, new Pion(Pion.Couleur.BLANC));
        assertEquals("[46-41]", damier.getDeplacementsValides(46).toString());
    }

    @Override
    protected Pion creerPion(Pion.Couleur couleur) {
        return new Dame(couleur);
    }

    @Override
    protected char getLettreAttendue() {
        return 'd';
    }
}
