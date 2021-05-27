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








/*
    @Test
    @DisplayName("TEST")
    public boolean checkk(String password){
        String k = "meinnamEistkarl!1337";
        lengthTest(k);
        return checkUpperLowerCase(k) && lengthTest(k) && numbers(k) && specialCharacterTest(k);
    }

    @Test
    public void checkMyPassword(){
        String k = "meinnamEistkarl!1337";
        lengthTest(k);
        checkUpperLowerCase(k);
        numbers(k);
        specialCharacterTest(k);
    }

    public boolean lengthTest(String s){
        if(s.length() <= 25 && s.length() >= 8){
            System.out.println("Your password with length: " + s.length() + " is valid.");
            return true;
        }else{
            return false;
        }
    }

    public boolean checkUpperLowerCase(String s){
        //this boolean checks if there is one upper case in it
        boolean LowerCase = !s.equals(s.toLowerCase());
        //this boolean checks if there is one lower case in it
        boolean UperCase = !s.equals(s.toUpperCase());
        if(LowerCase && UperCase){
            System.out.println("Lowercase and Uppercase test passed.");
        }else{
            System.out.println("There has to be one Uppercase and one Lowercase");
        }
        return LowerCase && UperCase;
    }

    public boolean specialCharacterTest(String s){
        char[] eq = {'(', ')','#','$','!','%','/','@'};
        for(int i = 0; i< s.length(); i++){
            for(int k = 0; k< eq.length; k++){
                if(s.charAt(i) == eq[k]);
                System.out.println("Special-Letter Test passed.");
                return true;
            }
        }
        System.out.println("there is no Number in the provided password.");
        return false;
    }

    public boolean numbers(String s){
        boolean hasNumber = false;

        // it is not necessary to compare numbers after length-2
        for(int i = 0; i < s.length()-2; i++){
            if(s.charAt(i) >= 48 && s.charAt(i) <=57){
                hasNumber = true;
                //checks if there is a row of numbers
                if(s.charAt(i) - s.charAt(i+1) == 1 && s.charAt(i) - s.charAt(i+2) == 2 || s.charAt(i) - s.charAt(i+1) == -1 && s.charAt(i) - s.charAt(i+2) == -2){
                    System.out.println("found row of numbers " + s.charAt(i) + " " + s.charAt(i+1) + " " + s.charAt(i+2));
                    return false;
                }
                //checks if a number is 3 times in a row
                if(s.charAt(i) == s.charAt(i) && s.charAt(i+1)  == s.charAt(i) && s.charAt(i+2) == s.charAt(i)){
                    System.out.println("found row of numbers " + s.charAt(i) + " " + s.charAt(i+1) + " " + s.charAt(i+2));
                    return false;
                }
            }
        }
        //return only hasNumber because if there were a row, it would have returned false already.
        return hasNumber;
    }




    public void numberInARowTest(String s){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 48 && s.charAt(i) <=57){
                if(i == s.length()-2){
                    System.out.println("number test passed");
                    assert(true);
                    return;
                }
                    if(s.charAt(i) - s.charAt(i+1) == 1 && s.charAt(i) - s.charAt(i+2) == 2 || s.charAt(i) - s.charAt(i+1) == -1 && s.charAt(i) - s.charAt(i+2) == -2){
                        System.out.println("found row of number " + s.charAt(i) + " " + s.charAt(i+1) + " " + s.charAt(i+2));
                        assert(false);
                        return;
                }
            }
        }
        System.out.println("number test passed");
        assert(true);
    }

    public void sameNumberInARow(String s){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 48 && s.charAt(i) <=57){
                if(i == s.length()-2){
                    System.out.println("number test passed");
                    assert(true);
                    return;
                }
                if(s.charAt(i) == s.charAt(i) && s.charAt(i+1)  == s.charAt(i) && s.charAt(i+2) == s.charAt(i)){
                    System.out.println("found row of number " + s.charAt(i) + " " + s.charAt(i+1) + " " + s.charAt(i+2));
                    assert(false);
                    return;
                }
            }
        }
        System.out.println("number test passed");
        assert(true);
    }


    public void hasNumberTest(String s){
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if(c >= 48 && c <=57){
                System.out.println("Has a Number Test passed.");
                assert(true);
                return;
            }
        }
        System.out.println("there is no Number in the provided password.");
        assert(false);
    }

        public void upperCaseTest(String s){
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >=65 && c <=90){
                System.out.println("upper-case Letter Test passed.");
                assert(true);
                return;
            }
        }
        System.out.println("there is no upper-case Letter in the provided password.");
        assert(false);
    }


    public void lowerCaseTest(String s){
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if(c >= 97 && c <=122){
                System.out.println("lower-case Letter Test passed.");
                assert(true);
                return;
            }
        }
        System.out.println("there is no lower-case Letter in the provided password.");
        assert(false);
    }

        public boolean specialCharacterTest(String s){
        char[] eq = {'(', ')','#','$','!','%','/','@'};
        for(int i = 0; i< s.length(); i++){
            for(int k = 0; k< eq.length; k++){
                if(s.charAt(i) == eq[k]);
                System.out.println("Special-Letter Test passed.");
                assert(true);
            }
        }
        System.out.println("there is no Number in the provided password.");
        assert(false);
    }

*/

}



