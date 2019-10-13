package academy.learnprogramming.console;

import academy.learnprogramming.Game;
import academy.learnprogramming.MessageGenerator;
import academy.learnprogramming.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component                      //******Use applistener for events
public class ConsoleNumberGuess //implements ApplicationListener<ContextRefreshedEvent>
{
    /*****CONSTANTS******/
    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    /*****FIELDS*********/
    @Autowired
    MessageGenerator messageGenerator;
    @Autowired
    Game game;

    //@Override  //******Use applistener for events
    @EventListener              //*******Parameter is mandatory*****//
    public void start(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("start() --> Container Ready for Use");

        Scanner scanner = new Scanner(System.in);

        while(true){

            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost()){
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play Again y/n?: ");
                String playAgainString = scanner.nextLine().trim();

                if(playAgainString.equalsIgnoreCase("y")){
                    //break;
                    game.reset();
                }


                log.info("game number: " + game.getNumber());
            }
        }

    }
}
