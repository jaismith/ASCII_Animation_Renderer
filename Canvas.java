// class file for animation canvas

// imports
import java.lang.StringBuilder;

// class definition
class Canvas {
    // instance variables
    private int width;
    private int height;

    private boolean[][] array;

    // constructor
    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;

        array = new boolean[width][height];

        System.out.printf("Canvas object created with width %d and height %d.\n", width, height);
    }

    public boolean[][] getArray() {
        return array;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                switch(array[x][y]? 0 : 1) {
                    case 0:
                        output.append("#");
                        break;
                    
                    case 1:
                        output.append(" ");
                        break;
                }
            }

            output.append("\n");
        }

        return output.substring(0, output.length() - 1);
    }

    public void returnCursor() {
        for(int y = height; y > 0; y--) {
            System.out.print("\033[f");
        }
    }

    public void clear() {
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                array[x][y] = false;
            }
        }
    }

    public void togglePoint(int x, int y) {
        array[x][y] = !array[x][y];
    }

    public void drawBorder(int thickness) {
        for(int y = 0; y < thickness; y++) {
            for(int x = 0; x < width; x++) {
                array[x][y] = true;
            }
        }

        for(int y = thickness; y < height - 1; y++) {
            for(int x = 0; x < thickness; x++) {
                array[x][y] = true;
            }

            for(int x = width - thickness; x < width; x++) {
                array[x][y] = true;
            }
        }

        for(int y = height - thickness; y < height; y++) {
            for(int x = 0; x < width; x++) {
                array[x][y] = true;
            }
        }
    }
}
