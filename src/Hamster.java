import java.util.List;
import java.util.Random;

class Hamster extends PlantEater {
    public Hamster(int x, int y) {
        super("Hamster", x, y, 3);
    }

    @Override
    void move(Island island) {
        Random random = new Random();
        x = Math.max(0, Math.min(island.getWidth() - 1, x + random.nextInt(3) - 1));
        y = Math.max(0, Math.min(island.getHeight() - 1, y + random.nextInt(3) - 1));
    }

    @Override
    void reproduce(List<Creature> newAnimals) {
        if (new Random().nextInt(100) < 25) {
            newAnimals.add(new Hamster(x, y));
        }
    }

    @Override
    public String getSymbol() {
        return "🐹";
    }
}
