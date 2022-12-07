package presentation.console;

import domain.controllers.MatrixController;
import domain.interfaces.MatrixHelper;
import presentation.console.services.*;
import presentation.window.FrameMain;
import utils.SwingUtils;
import java.util.Locale;


public class Main {
    private static InputArgsHelper inputArgsService;
    private static MatrixHelper matrixService;
    private static InputArgs inputArgs;

    public static void main(String[] argv){
        inputArgsService = new InputArgsService(argv);
        matrixService = new MatrixController();
        inputArgs = ParseCmdArgs();
        execute(inputArgs.getAppInterface());
    }

    private static InputArgs ParseCmdArgs(){
        var inputArgs = new InputArgs();

        inputArgs.setInput(inputArgsService.getValueFor("input"));
        inputArgs.setOutput(inputArgsService.getValueFor("output"));
        inputArgs.setAppInterface(inputArgsService.getValueFor("interface"));

        return inputArgs;
    }

    private static void execute(String appInterface){
        switch (appInterface) {
            case "console" -> consoleApp();
            case "window" -> windowApp();
        }
    }

    private static void consoleApp(){
        matrixService.openMatrix(inputArgs.getInput());
        matrixService.printMatrix();
        matrixService.doTask();
        matrixService.saveMatrix(inputArgs.getOutput());
        matrixService.printMatrix();
    }

    private static void windowApp(){
        try{
            Locale.setDefault(Locale.ROOT);
            SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

            java.awt.EventQueue.invokeLater(() -> new FrameMain(matrixService, inputArgs).setVisible(true));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
