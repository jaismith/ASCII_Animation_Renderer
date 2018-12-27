// controller object to manage renderer and allow passthrough graphics functions to be run

// imports
import java.util.concurrent.Callable;

// class definition
public class Controller {
    Renderer renderer;
    Callable<Void> method;

    public Controller(Canvas canvas, Callable<Void> method) {
        renderer = new Renderer(canvas);
        this.method = method;
    }

    public void run() {
        while(true) {
            synchronized(renderer) {
                try {
                    method.call();
                } catch(Exception e) {
                    System.out.printf("Error running callable method:\n%s", e);
                }

                renderer.notify();
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted");
            }
        }
    }
}