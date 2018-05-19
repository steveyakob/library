package com.jsuszynski.library;

import com.jsuszynski.library.commands.CommandProvider;
import com.jsuszynski.library.console.UserInputReader;
import com.jsuszynski.library.console.WelcomePrinter;

public class LibraryApp {

    private final WelcomePrinter welcomePrinter = new WelcomePrinter();
    private final UserInputReader userInputReader = new UserInputReader();
    private final CommandProvider commandProvider = new CommandProvider();

    public void run() {
        do {
            try {
                welcomePrinter.printWelcomeMessage();

                String command = userInputReader.getUserInput();

                commandProvider.recogniseCommand(command).execute();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (true);

    }
}