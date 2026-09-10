package cstjean.mobile.jeu;

import java.util.LinkedList;

public class Damier {

    private LinkedList<Pion> pions;

    public  Damier() {
        this.pions = new LinkedList<Pion>();
        for (int i = 0; i < 50; i ++) {
            pions.add(null);
        }
    }

    public void ajouterPion(int index, Pion pion) {
        index--;
        pions.add(index, pion);
    }

    public LinkedList<Pion> getListePions() {
        return pions;
    }

    public Pion getPositionPion(int index) {
        index--;
        return pions.get(index);
    }
}
