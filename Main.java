// main program file for ascii renderer

class Main {
    public static void main(String[] args) {
        Canvas newCanvas = new Canvas(20, 10);

        newCanvas.togglePoint(5, 5);
        newCanvas.drawBorder(1);

        for(int i = 0; i < 5; i++) {
            System.out.println(newCanvas);

            newCanvas.returnCursor();
        }

        System.out.println(newCanvas);
    }
}