package byog.lab5;

import org.junit.Test;

import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 40;
    private static final Random RANDOM = new Random(1029893289);

    /**
     * fill the <code>tiles</code> with a hexagon, given position and size
     */
    private static void addHexagon(TETile[][] tiles, int xPos, int yPos, int size) {
        TETile randomTile = randomTile();
        for (int r = 0; r < 2 * size; r++) {
            int tileNum = r < size ? size + 2 * r : size + 2 * (2 * size - 1 - r);
            int xStart = r < size ? xPos - r : xPos - (2 * size - 1 - r);
            int y = yPos + r;
            for (int x = xStart; x < xStart + tileNum; x++) {
                tiles[x][y] = randomTile;
            }
        }
    }

    /**
     * draw a tesselation of hexagons, given position and size
     */
    public static void drawHexagons(TETile[][] tiles, int xPos, int yPos, int size) {
        drawColHexagons(tiles, xPos, yPos, size, 5);
        drawColHexagons(tiles, xPos - (2 * size - 1), yPos + size, size, 4);
        drawColHexagons(tiles, xPos + (2 * size - 1), yPos + size, size, 4);
        drawColHexagons(tiles, xPos - 2 * (2 * size - 1), yPos + 2 * size, size, 3);
        drawColHexagons(tiles, xPos + 2 * (2 * size - 1), yPos + 2 * size, size, 3);
    }

    /**
     * draw hexagons recursively vertically
     */
    private static void drawColHexagons(TETile[][] tiles, int xPos, int yPos, int size, int num) {
        if (num == 0) {
            return;
        }
        addHexagon(tiles, xPos, yPos, size);
        drawColHexagons(tiles, xPos, yPos + 2 * size, size, num - 1);
    }

    /**
     * gets a random tile from Tile set
     */
    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(8);
        switch (tileNum) {
            case 0: return Tileset.WALL;
            case 1: return Tileset.FLOOR;
            case 2: return Tileset.GRASS;
            case 3: return Tileset.FLOWER;
            case 4: return Tileset.WATER;
            case 5: return Tileset.SAND;
            case 6: return Tileset.MOUNTAIN;
            default: return Tileset.TREE;
        }
    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] hexWorld = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                hexWorld[x][y] = Tileset.NOTHING;
            }
        }
        int size = 4;
        drawHexagons(hexWorld, (WIDTH - size) / 2, 0, size);
        ter.renderFrame(hexWorld);
    }

}
