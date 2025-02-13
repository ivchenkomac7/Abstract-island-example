package javarush.module2.entity.map;

// Клас острова
public class Island {
//    private int width;
//    private int height;

    private Location[][] grid;
    public Island (int width, int height){
        grid = new Location[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = new Location();
            }
        }
    }
}
