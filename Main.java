// main program file for ascii renderer

import java.lang.Runnable;

class Main {
    public static void main(String[] args) {
        Canvas newCanvas = new Canvas(20, 10);

        Render renderer = new Render(newCanvas);

        int x = 2;
        int delta = 1;

        while(true) {
            synchronized(renderer) {
                newCanvas.clear();

                newCanvas.drawBorder(1);
                newCanvas.togglePoint(x, 4);
                newCanvas.togglePoint(x, 5);

                x += delta;

                if(x < 2 || x > 20 - 3) {
                    delta *= -1;
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

class Render implements Runnable {
    Thread renderThread;
    Canvas canvas;

    public Render(Canvas canvas) {
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