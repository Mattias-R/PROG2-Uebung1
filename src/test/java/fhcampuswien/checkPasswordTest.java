package fhcampuswien;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestTemplate;
import static org.junit.jupiter.api.Assertions.*;

public class checkPasswordTest {

    @Test
    @DisplayName("Test if PW is fine")
    public void testPasswordLength1(){
        PasswordValidator pw = new PasswordValidator();
        assertTrue(pw.checkPassword("meinnamEistkarl!1337"));
    }
    @Test
    @DisplayName("entered password fails if its too short ")
    public void testPasswordLength2(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("H@1nsP"));
    }
    @Test
    @DisplayName("entered password fails if its too long")
    public void testPasswordLength3(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("meinnamEistkarl!1337feuide"));
    }
    @Test
    @DisplayName("Return true if pw contains a lowercase letter")
    public void lowerCase1(){
        PasswordValidator pw = new PasswordValidator();
        assertTrue(pw.checkPassword("meinnamEistkarl!1337"));
    }
    @Test
    @DisplayName("Return false if pw doesnt contain a lowercase Letter")
    public void lowerCase2(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("MEINNAMEISTKARL!1337"));
    }
    @Test
    @DisplayName("Return true if pw contains a uppercase letter")
    public void upperCase1(){
        PasswordValidator pw = new PasswordValidator();
        assertTrue(pw.checkPassword("meinnamEistkarl!1337"));
    }
    @Test
    @DisplayName("Return false if pw doesnt contain a uppercase letter")
    public void upperCase2(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("meinnameistkarl!1337"));
    }
    @Test
    @DisplayName("Return false if pw doesnt contain a Number")
    public void numbersTest1(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("meinNameistkarl!"));
    }
    @Test
    @DisplayName("Return true if pw contains number")
    public void numbersTest2(){
        PasswordValidator pw = new PasswordValidator();
        assertTrue(pw.checkPassword("meinNameistkarl!1337"));
    }
    @Test
    @DisplayName("Return false if there is a row of numbers")
    public void numbersTest3(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("meinNameistkarl!1237"));
    }
    @Test
    @DisplayName("Return false if there is a row of numbers")
    public void numbersTest4(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("meinNameistkarl!321"));
    }
    @Test
    @DisplayName("Return false if the same number is 3 times in a row")
    public void numbersTest5(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("meinNameistkarl!13333"));
    }
    @Test
    @DisplayName("return False if the password doesnt contain a special Letter")
    public void specialLetter1(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("meinNameistkarl1337"));
    }
    @Test
    @DisplayName("return True if the password contains a special letter")
    public void specialLetter2(){
        PasswordValidator pw = new PasswordValidator();
        assertTrue(pw.checkPassword("meinNameistkarl!1337"));
    }
    @Test
    @DisplayName("return False if the password contains a wrong special Letter")
    public void specialLetter3(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("meinNameistkarl!+1337"));
    }

}



