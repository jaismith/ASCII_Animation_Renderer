// main program file for ascii renderer

// imports
import java.util.concurrent.Callable;

// class definition
class Main {
    private Canvas newCanvas = new Canvas(20, 10);
    private Controller controller = new Controller(newCanvas, new Draw());
    private int x = 2;
    private int delta = 1;

    public static void main(String[] args) {
        controller.run();
        
        System.out.printf("Controller object %s done\n", controller);
    }

    public class Draw implements Callable<Void> {
        public Void call() {
            newCanvas.clear();

            newCanvas.drawBorder(1);
            newCanvas.togglePoint(x, 4);
            newCanvas.togglePoint(x, 5);

            x += delta;

            if(x < 2 || x > 20 - 3) {
                delta *= -1;
            }

            return null;
        }
    }
}