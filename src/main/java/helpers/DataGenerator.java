package helpers;

import org.apache.commons.lang3.RandomStringUtils;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataGenerator {
    public static String createPassword(int count) {
        StringBuilder characters = new StringBuilder(ConstantUtils.UPPER_CASE_LETTERS);
        characters.append(ConstantUtils.LOWER_CASE_LETTERS);
        characters.append(ConstantUtils.DECIMAL_DIGITS);
        return RandomStringUtils.random( count, characters.toString() );
    }
    public static String dataForEmail(){
        String data;
        return data = createPassword(ConstantUtils.RANGE_OF_EMAIL);
    }

    public static String createString(int count) {
        StringBuilder characters = new StringBuilder(ConstantUtils.LOWER_CASE_LETTERS);
        characters.append(ConstantUtils.DECIMAL_DIGITS);
        return RandomStringUtils.random(count, characters.toString() );
    }

    public static int selectRandomFromRange (int lowerBound, int upperBound) {
        List<Integer> rangeList = IntStream.range(lowerBound, upperBound).boxed().collect(Collectors.toList());
        return rangeList.get(new Random().nextInt(rangeList.size()));
    }

    public static String createRandomNumbersAsString (int count) {
        StringBuilder characters = new StringBuilder(ConstantUtils.DECIMAL_DIGITS);
        return RandomStringUtils.random(count, characters.toString() );
    }

}
