import java.security.InvalidParameterException;

public class Operators {
    public static void main(String[] args) {
        try {
            if (args.length != 3)
                throw new InvalidParameterException("Invalid input format");

            int num1 = Integer.parseInt(args[1]);
            int num2 = Integer.parseInt(args[2]);

            switch (args[0].toLowerCase()) {
                case "add":
                    System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
                    break;
                case "substract":
                    System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
                    break;
                default:
                    throw new InvalidParameterException("Unsupported operator");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Cannot convert " + args[1] + " and " + args[2] + " to integers");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
