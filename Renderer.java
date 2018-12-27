// program file for Renderer class

// imports
import java.lang.Runnable;

// class definition
class Renderer implements Runnable {
    Thread renderThread;
    Canvas canvas;

    public Renderer(Canvas canvas) {
        this.canvas = canvas;

        renderThread = new Thread(this, "Render Thread");
        System.out.printf("Render thread created: %s\n", renderThread);
        renderThread.start();
    }

    public void run() {
        while(true) {
            synchronized(this) {
                try {
                    wait();

                    System.out.println(canvas);
                    canvas.returnCursor();

                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    System.out.printf("Render thread %s interrupted.\n", renderThread);
                }
            }
        }
    }
}
