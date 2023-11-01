package Controller;
import Repository.LNSRepository;
import View.Menu;

public class LNSController extends Menu {
    private final LNSRepository lnsRepository;
    static String[] options = {"Count Word In File","Find File By Word","Exit"};

    public LNSController() {
        super("========== Word Program =========", options);
        lnsRepository = new LNSRepository();
    }

    @Override
    public void execute(int choice) {
        switch(choice) {
            case 1:
                lnsRepository.actionCW();
                break;
            case 2:
                lnsRepository.actionFF();
                break;
            case 3:
                System.out.println("Exit.");
                break;
            default:
                System.out.println("Invalid!");
        }
    }
}
