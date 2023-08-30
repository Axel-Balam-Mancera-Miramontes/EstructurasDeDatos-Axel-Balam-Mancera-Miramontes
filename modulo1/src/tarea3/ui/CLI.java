/**
 * @author Axel Balam Mancera Miramontes
 */

package tarea3.ui;

import tarea3.process.Notations;

import java.util.Scanner;

/**
 * CLI contains all the data tha is going to be processed by the Passengers class.
 * CLI defines the details of the user menu and executes it.
 */
public class CLI {
    /**
     * Data used by process package.
     */

    /**
     * Creating the user menu.
     */
    private static Menu menu = new Menu();

    /**
     *  Menu options.
     */
    private static String INFIX_TO_POSTFIX = "Reescribir una expresión en notación infija a su equivalente en notación postfija.";

    /**
     * Other usefull texts.
     */
    private static String INPUT_INFIX_EXPRESSION = "Ingrese una expresión matemática en notación infija:";
    private static String OUTPUT_INFIX = "La expresión matemática en notación infija ingresada es: %s\n";
    private static String OUTPUT_POSTFIX = "La expresión equivalente en notación postfija es: %s\n";
    private static String ANS = "El resultado de evaluar la expresión dada es: %d";

    /**
     * Menu actions.
     */
    /**
     * Defines the action that adds the capitains into a list.
     */
    private static MenuActionPrototype infixToPostfix = () -> {
        String infix = new String();
        String postfix = new String();
        int ans;
        Scanner input = new Scanner(System.in);

        System.out.println(INPUT_INFIX_EXPRESSION);
        infix = input.next();

        System.out.printf(OUTPUT_INFIX, infix);

        postfix = Notations.infixToPostfix(infix);
        System.out.printf(OUTPUT_POSTFIX, postfix);
        //System.out.printf(ANS, ans);

    };

    /**
     * Adding the menu options and actions.
     */
    static {
        menu
                .addOption(INFIX_TO_POSTFIX, infixToPostfix)
                .addExitOption();
    }

    /**
     * Showing the menu and executing the actions associated to each option.
     */
    public static void launchApp() {
        do {
            menu.showMenu();
            menu.requestOption();
            int option = menu.readOption();
            menu.executeOption(option);
        } while (menu.isAlive());
    }
}