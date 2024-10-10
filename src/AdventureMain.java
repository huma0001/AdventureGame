public class AdventureMain {

    public static void main(String[] args) {
        // Starter spillet
        Ui ui = new Ui();
        AdventureGameController gameController = new AdventureGameController();

        ui.introduktion();
        gameController.startGame();

    }
}