package deqo.isodate;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsoDateTest {

    final String ok1 = "2000-12-31"; //note aux correcteurs: cas nominal attendu
    final String ok2 = "2001-12-31"; //note aux correcteurs: cas nominal attendu
    final String ko = "2019"; //note aux correcteurs: ici ça peut être une autre date invalide

    IsoDate isoDateOk1;
    IsoDate isoDateOk2;


    @Before
    public void setUp() throws Exception {
        isoDateOk1 = new IsoDate(2000,12,31);
        isoDateOk2 = new IsoDate(ok2);
    }

    @Test
    public void contructeurDetaille_Avec_toString() {
        assertEquals(ok1, isoDateOk1.toString());
    }

    @Test
    public void contructeurString_Avec_toString() {
        assertEquals(ok2, isoDateOk2.toString());
    }

    @Test
    public void contructeurDetaille_Avec_toIsoDays() {
        assertEquals("2000-366", isoDateOk1.toIsoDays().toString());
    }

    @Test
    public void contructeurString_Avec_toIsoDays() {
        assertEquals("2001-365", isoDateOk2.toIsoDays().toString());
    }

    @Test(expected = IsoDateException.class)
    public void constructeurKO() throws IsoDateException {
        new IsoDate(ko);
    }

    //note aux correcteurs: ce n'est pas attendu qu'ils fassent un test
    // pour detecter le bug
    @Test
    public void testBug_Nb_Chiffres() throws IsoDateException {
        isoDateOk1= new IsoDate("2019-01-01");
        assertEquals("2019-01-01", isoDateOk1.toString());
    }
}