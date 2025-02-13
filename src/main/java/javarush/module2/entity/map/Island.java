package javarush.module2.entity.map;

import javarush.module2.entity.organism.animal.Animal;


// Клас острова
public class Island {
    private int width;
    private int height;
    private Location[][] grid;
    public Island (int width, int height){
        grid = new Location[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = new Location();
            }
        }
    }
//    public List<Location> getAdjacentLocations(Location currentLocation) {
//        List<Location> adjacentLocations = new ArrayList<>();
//
//        for (int i = 0; i < width; i++) {
//            for (int j = 0; j < height; j++) {
//                if (grid[i][j] == currentLocation) {
//                    if (i > 0) adjacentLocations.add(grid[i - 1][j]); // Вверх
//                    if (i < width - 1) adjacentLocations.add(grid[i + 1][j]); // Вниз
//                    if (j > 0) adjacentLocations.add(grid[i][j - 1]); // Вліво
//                    if (j < height - 1) adjacentLocations.add(grid[i][j + 1]); // Вправо
//                }
//            }
//        }
//        return adjacentLocations;
//    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public Location getLocation(int x, int y) {
        return grid[x][y];
    }

    public void moveAnimal(Animal animal, int oldX, int oldY, int newX, int newY) {
        grid[oldX][oldY].removeAnimal(animal);
        grid[newX][newY].addAnimal(animal);
    }
}
