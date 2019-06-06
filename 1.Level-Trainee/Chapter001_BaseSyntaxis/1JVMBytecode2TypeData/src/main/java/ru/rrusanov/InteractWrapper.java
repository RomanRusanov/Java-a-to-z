package ru.rrusanov;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The class contain all calculators and provide interaction with them.
 */
public class InteractWrapper {
    /**
     * The collection contain all calculators.
     */
    private List<Interact> interactsCalcs = new LinkedList<>();
    /**
     * The field contain instance of console input.
     */
    private ConsoleInput consoleInput = new ConsoleInput();
    /**
     * The field contain that user input from console.
     */
    private String userChoose = "";

    /**
     * The method add calculator to collection.
     * @param interact Instance interact with calculator.
     */
    public void addInteract(Interact interact) {
        this.interactsCalcs.add(interact);
    }

    /**
     * The method print all menus in console.
     */
    public void writeToConsoleMenu() {
        this.interactsCalcs.forEach(Interact::writeToConsoleMenu);
    }

    /**
     * The method find matched action in calculators collection.
     * @return Matched calculator.
     */
    public Interact findMatchedInteract() {
        Interact result = null;
        Iterator<Interact> iterator = this.interactsCalcs.iterator();
        boolean userChooseCorrect = false;
        while (!userChooseCorrect) {
            while (iterator.hasNext()) {
                Interact currentInt = iterator.next();
                Map<String, Action> intActions = currentInt.getActions();
                if (intActions.getOrDefault(this.userChoose, null) != null) {
                    result = currentInt;
                    userChooseCorrect = true;
                    break;
                }
            }
            if (!userChooseCorrect) {
                this.userChoose = getUserChoose();
            }
            iterator = this.interactsCalcs.iterator();
        }
        return result;
    }

    /**
     * The method execute algorithm interaction.
     */
    public void executeAction() {
        do {
            this.writeToConsoleMenu();
            this.userChoose = this.getUserChoose();
            Interact interact = findMatchedInteract();
            interact.takeArgumentsFromConsole();
            interact.executeAction(this.userChoose);
            interact.printResultToConsole();
        } while (!"y".equals(this.consoleInput.ask("Exit?(y) ")));
    }

    /**
     * The method get input from console.
     * @return String that user input.
     */
    public String getUserChoose() {
        return new ConsoleInput().ask("Choose the action: ");
    }

}
