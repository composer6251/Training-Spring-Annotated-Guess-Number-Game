package academy.learnprogramming.console;


import academy.learnprogramming.AppConfig;
import academy.learnprogramming.MessageGenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        log.info("Guess the number game");

        // create context (container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //get numberGenerator bean from context (container) with component annotation, SPRING auto names bean (numberGeneratorImpl) so this ref is invalid
        //NumberGenerator numberGenerator = context.getBean("numberGenerator", NumberGenerator.class);

        //Get bean by type and not name
        //NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        //get game bean from context (container)
        //Game game = context.getBean(Game.class);

        // Calling from bean instead
       // game.reset();

        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        log.debug(messageGenerator.getMainMessage());
        log.debug(messageGenerator.getResultMessage());

        //close context (container) to prevent memory resource leaks
        context.close();
    }
}
