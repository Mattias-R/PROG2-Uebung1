package fhcampuswien;


public class Prog2UE1 {
    public static void main(String[] args){
        String x = "Test!124";
        PasswordValidator ne = new PasswordValidator();
        System.out.println(ne.checkPassword(x));
    }
}
