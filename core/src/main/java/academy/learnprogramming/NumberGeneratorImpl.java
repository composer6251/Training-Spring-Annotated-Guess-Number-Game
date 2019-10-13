package academy.learnprogramming;

import org.springframework.stereotype.Component;

import java.util.Random;

//@Component//("generator") using
public class NumberGeneratorImpl implements NumberGenerator {

    // fields
    private final Random random = new Random();
    private int maxNumber = 100;

    //Public Methods
    @Override
    public int next() {

        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
