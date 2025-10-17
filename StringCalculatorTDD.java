import java.util.ArrayList;
import java.util.List;

public class StringCalculatorTDD {

    public int add(String numbers) {
        if (isEmpty(numbers)) {
            return 0;
        }

        String delimiter = getDelimiter(numbers);
        String numbersPart = getNumbersPart(numbers);

        String[] tokens = splitNumbers(numbersPart, delimiter);
        List<Integer> negativeNumbers = new ArrayList<>();

        int sum = calculateSum(tokens, negativeNumbers);

        if (!negativeNumbers.isEmpty()) {
            throwNegativeNumbersException(negativeNumbers);
        }

        return sum;
    }

    // --- Helper Methods ---

    private boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private String getDelimiter(String numbers) {
        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf("\n");
            return numbers.substring(2, delimiterEndIndex);
        }
        return ",|\n";
    }

    private String getNumbersPart(String numbers) {
        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf("\n");
            return numbers.substring(delimiterEndIndex + 1);
        }
        return numbers;
    }

    private String[] splitNumbers(String numbers, String delimiter) {
        return numbers.split(delimiter);
    }

    private int calculateSum(String[] tokens, List<Integer> negativeNumbers) {
        int sum = 0;

        for (String token : tokens) {
            if (token.isEmpty()) continue;
            int num = Integer.parseInt(token.trim());

            if (num < 0) {
                negativeNumbers.add(num);
            }

            sum += num;
        }

        return sum;
    }

    private void throwNegativeNumbersException(List<Integer> negativeNumbers) {
        String message = "negative numbers not allowed: " +
                negativeNumbers.toString().replaceAll("[\\[\\]]", "");
        throw new IllegalArgumentException(message);
    }
}
