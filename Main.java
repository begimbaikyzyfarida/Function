import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;
public class Main {
    public static void main(String[] args) {
        Supplier<String> randomNumberSupplier = new Supplier<String>() {
            @Override
            public String get() {
                Scanner scanner = new Scanner(System.in);
                int a = scanner.nextInt();
                Random random = new Random();
                int b = random.nextInt(1, 6);
                String check = a == b ? "a==b" : "a!=b";
                return check;
            }
        };
        System.out.println(randomNumberSupplier.get());

        System.out.println("------------------------------------------------------");


        BiPredicate<Integer, Integer> biPredicate = (num, num2) -> num.equals(num2);
        Scanner scanner = new Scanner(System.in);
        Random ran = new Random();
        System.out.println("Enter an number:");
        int num1 = scanner.nextInt();
        int num2 = ran.nextInt(10) + 1;
        System.out.println("Are the two numbers equal? " + biPredicate.test(num1, num2));
        System.out.println("--------------------------------------------------------------");

        Supplier<Character> randomUppercaseLetterSupplier = () -> {
            Random random = new Random();
            char ran1 = (char) (random.nextInt(26) + 'A');
            return ran1;
        };

        System.out.println(randomUppercaseLetterSupplier.get());


        Supplier<String> constantValueSupplier = () -> "constanta";

        String constantValue = constantValueSupplier.get();
        System.out.println(constantValue);
        System.out.println("-----------------------------------------------------");


        List<String> wordList = List.of("apple", "berry", "strawberry");


        Supplier<String> randomWordSupplier = () -> {
            Random random = new Random();
            int randomIndex = random.nextInt(wordList.size());
            return wordList.get(randomIndex);
        };


        String randomWord = randomWordSupplier.get();
        System.out.println(randomWord);
        System.out.println("-----------------------------------------------------");


        int number = 5;

        Function<Integer, Integer> squareFunction = (x) -> x * x;
        int square = squareFunction.apply(number);

        System.out.println("Квадрат числа " + number + " равен " + square);

        System.out.println("-----------------------------------------------------");


        Function<String, String> function = new Function<String, String>() {
            @Override
            public String apply(String s) {
                String name = s;
                if (name == null || name.isEmpty()) {
                    return name;
                }

                char firstChar = Character.toUpperCase(name.charAt(0));
                return firstChar + name.substring(1);
            }
        };

        System.out.println(function.apply("adel"));
        System.out.println("--------------------------------------------------------");


        Function<List<Integer>, List<Integer>> doubleList = numbers -> {
            List<Integer> doubledNumbers = new ArrayList<>();
            for (Integer num : numbers) {
                doubledNumbers.add(num * 2);
            }
            return doubledNumbers;
        };

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(doubleList.apply(numbers));
        System.out.println("---------------------------------------------------------");



        List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5);
        Function<List<Integer>, Double> findMiddle = numbers1 -> {
            if (numbers1.isEmpty()) {
                return 0.0;
            }

            int sum = 0;
            for (Integer num : numbers1) {
                sum += num;
            }

            return (double) sum / numbers1.size();
        };

        double average = findMiddle.apply(numbersList);

        System.out.println("Original list: " + numbersList);
        System.out.println("Average: " + average);
        System.out.println("------------------------------------------------");


        Function<int[], String> checkPalindrome = numberArray -> {
            StringBuilder stringBuilder = new StringBuilder();

            for (int num : numberArray) {
                int originalNum = num;
                int rev = 0;
                int tempNum = num;

                while (tempNum != 0) {
                    int digit = tempNum % 10;
                    rev = rev * 10 + digit;
                    tempNum /= 10;
                }

                if (originalNum == rev) {
                    stringBuilder.append(num).append(" is a palindrome.\n");
                } else {
                    stringBuilder.append(num).append(" is not a palindrome.\n");
                }
            }

            return stringBuilder.toString();
        };

        int[] numberArray = {555};
        System.out.println(checkPalindrome.apply(numberArray));
    }
}
































