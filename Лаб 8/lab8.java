import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import numberone.*;


public class lab8 {
    private static fraction parsefraction(String str){
        int a = str.indexOf("/");
        if(a == -1){
            throw new IllegalArgumentException();
        }
        try {
            int first = Integer.parseInt(str.substring(0, a));
            int second = Integer.parseInt(str.substring(a + 1));
            return new fraction(first, second);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        
        
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("Введите выражение в формате:  a/b ( + | _ | * | : ) c/d ");
            try {
                String userInput = in.nextLine();
                userInput = userInput.replaceAll(" ", "");
                Pattern p = Pattern.compile("[+|_|*|:]");
                Matcher m = p.matcher(userInput);
                if (!m.find()) {
                    throw new IllegalArgumentException();
                }
                int index = m.start();
                String first = userInput.substring(0, index);
                String second = userInput.substring(index + 1);
                char operation = userInput.charAt(index);

                fraction a = parsefraction(first);
                fraction b = parsefraction(second);

                switch(operation){
                    case '+':
                        System.out.println("Сумма равна: " + a.sum(b));
                        break;
                    case '_':
                        System.out.println("Разность равна: " + a.sub(b));
                        break;
                    case '*':
                        System.out.println("Произведение равно: " + a.multi(b));
                        break;
                    case ':':
                        System.out.println("Частное равно: " + a.div(b));
                        break;
                    default:
                        break;
                }
                in.close();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка. Повторите ввод! ");
            }
        }
    }
}