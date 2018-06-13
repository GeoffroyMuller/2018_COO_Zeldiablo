package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestAventurier.class,
    TestCoordonnee.class,
    TestEntree.class,
    TestMonstre.class,
    TestDonjon.class,
    TestEtage.class,
    TestGestionnaireTexture.class,
    TestMonstre.class,
    TestMur.class,
    TestSalle.class,
    TestSortie.class,
    TestVide.class,
    TestZeldiabloJeu.class,
    TestZone.class,
    TestPortailFin.class,
    TestStats.class
    
})
public class AllTests {

}

