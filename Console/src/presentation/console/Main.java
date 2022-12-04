package presentation.console;

import domain.controllers.MatrixController;
import domain.interfaces.MatrixHelper;
import presentation.console.services.*;

public class Main {
    private static InputArgsHelper inputArgsService;

    public static void main(String[] argv){
        inputArgsService = new InputArgsService(argv);
    }

    private static void execute(){
        String input = inputArgsService.getValueFor("input");
        String output = inputArgsService.getValueFor("output");

        String appInterface = inputArgsService.getValueFor("interface");
    }

    private static void interfaceSelection(String appInterface){
        switch (appInterface) {
            case "console" -> consoleApp();
            case "windowApp" -> windowApp();
        }
    }

    private static void consoleApp(){

    }

    private static void windowApp(){

    }
}
