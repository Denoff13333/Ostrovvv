import java.util.Random;

class AnimalFactory {
    private static final Random random = new Random();

    public static Creature createRandomCreature(int x, int y) {
        int choice = random.nextInt(5);
        switch (choice) {
            case 0:
                return new Wolf(x, y);
            case 1:
                return new Rabbit(x, y);
            case 2:
                return new Deer(x, y);
            case 3:
                return new Bear(x, y);
            case 4:
                return new Fox(x, y);
            default:
                return new Rabbit(x, y);
        }
    }
}
