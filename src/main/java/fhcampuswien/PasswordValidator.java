package fhcampuswien;

public class PasswordValidator {
    public boolean checkPassword(String password){
        return passwordLength(password) && passwordUperLowerCase(password) && passwordContainsNumber(password) && passwordContainsSpecialLetter(password) &&passwordNumberRow(password) && passwordSameNumber(password);
    }
    public boolean passwordLength(String password){
        //checks password length
        if(password.length() <= 25 && password.length() >= 8){
            return true;
        }
        return false;
    }
    public boolean passwordUperLowerCase(String password){
        //this boolean checks if there is one upper case in it
        boolean LowerCase = !password.equals(password.toLowerCase());
        //this boolean checks if there is one lower case in it
        boolean UperCase = !password.equals(password.toUpperCase());

        return LowerCase & UperCase;
    }
    public boolean passwordContainsNumber(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 48 && password.charAt(i) <= 57) {
                return true;
            }
        }   
            return false;
    }
    public boolean passwordContainsSpecialLetter(String password){
            char[] eq = {'(', ')','#','$','!','%','/','@'};

            for(int i = 0; i< password.length(); i++){
                for(int k = 0; k< eq.length; k++){
                    if(password.charAt(i) == eq[k]){
                        return true;
                    }
                }
            }
        return false;
    }
    public boolean passwordNumberRow(String password){
        // it is not necessary to compare numbers after length-2
        for(int i = 0; i < password.length()-2; i++){
            if(password.charAt(i) >= 48 && password.charAt(i) <=57){
                //checks if there is a row of numbers
                if(password.charAt(i) - password.charAt(i+1) == 1 && password.charAt(i) - password.charAt(i+2) == 2 || password.charAt(i) - password.charAt(i+1) == -1 && password.charAt(i) - password.charAt(i+2) == -2){
                    return false;
                }
            }
        }

        return true;
    }
    public boolean passwordSameNumber(String password){
        // it is not necessary to compare numbers after length-2
        for(int i = 0; i < password.length()-2; i++){
            if(password.charAt(i) >= 48 && password.charAt(i) <=57){
                //checks if a number is 3 times in a row
                if(password.charAt(i+1) == password.charAt(i) && password.charAt(i+2) == password.charAt(i) && password.charAt(i+3) == password.charAt(i)){
                    return false;
                }
            }
        }

        return true;
    }

}
