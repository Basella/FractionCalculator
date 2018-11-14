import java.util.Scanner;

public class FractionCalculator {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type 'Q' to quit");
        System.out.println("Please enter your numbers in the form 'a/b' where a and b are integers");
        System.out.println("---------------------------------------------------------");

        String in = "";
        while (!in.equalsIgnoreCase("Q")) {
            FractionCalculator A = new FractionCalculator();
            String operation = A.getOperation(input);

            Fraction firstFraction = A.getFraction(input);
            Fraction secondFraction = A.getFraction(input);
            if (operation.equals("+")) {
                Fraction addFractions = firstFraction.add(secondFraction);
                System.out.println(addFractions);
            } else if (operation.equals("-")) {
                Fraction subtractFractions = firstFraction.subtract(secondFraction);
                System.out.println(subtractFractions);
            } else if (operation.equals("*")) {
                Fraction multiplyFractions = firstFraction.multiply(secondFraction);
                System.out.println(multiplyFractions);
            } else if (operation.equals("/")) {
                Fraction divideFractions = firstFraction.divide(secondFraction);
                System.out.println(divideFractions);
            }
        }
        System.out.println("Goodbye");

    }
    private String getOperation (Scanner input){
        System.out.print("Please enter an operation (+ , -, *, /, = or Q to quit)");
        String userOperationChoice = input.next();

        while ((!userOperationChoice.equals("+")) && (!userOperationChoice.equals("-")) && (!userOperationChoice.equals("*")) && (!userOperationChoice.equals("/")) && (!userOperationChoice.equals("="))) {
            System.out.println("Invalid Input (+ , -, *, /, = or Q to quit)");
            userOperationChoice = input.next();
        }
        return userOperationChoice;
    }

    private boolean validFraction (String input){
        if ((!input.startsWith("-")) && (input.contains("-"))) {
            input.replace("-", "");
        }
        if (!input.contains("/")) {
            return true;
        } else {
            if ((input.substring(0, input.indexOf('/')) == "") || (input.substring(input.indexOf('/') + 1)) == "") {
                return false;
            } else {
                if ((input.substring(0, input.indexOf('/')).matches("\\d+")) && (input.substring(input.indexOf('/') + 1).matches("\\d+"))) {
                    return true;
                }
            }
        }
        return false;
    }

    private Fraction getFraction (Scanner input){
        String numeratorString = "";
        String denominatorString = "";
        System.out.println("Please enter a fraction");
        String userFractionChoice1 = input.next();

        boolean isItValid1 = validFraction(userFractionChoice1);
        while (!isItValid1) {
            System.out.println("Invalid fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero");
            userFractionChoice1 = input.next();
        }

        if (userFractionChoice1.contains("/")){
            numeratorString += userFractionChoice1.substring(0, userFractionChoice1.indexOf('/'));
            denominatorString += userFractionChoice1.substring(userFractionChoice1.indexOf('/') + 1);

            return new Fraction(Integer.parseInt(numeratorString), Integer.parseInt(denominatorString));
        }

        return   new Fraction(Integer.parseInt(numeratorString));

    }
}
