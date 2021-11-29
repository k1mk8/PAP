import java.util.*;


public class Tester{ 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Domyslny login: user, Domyslne haslo: password \n");;
        System.out.println("Podaj login: ");
        String login = sc.nextLine();
        System.out.println("Podaj haslo: ");
        String passwd = sc.nextLine();

        
        
        LoginModule.authenticate(login, passwd);

    }
}
