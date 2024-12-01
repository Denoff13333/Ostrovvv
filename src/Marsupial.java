import java.util.List;
import java.util.ArrayList;
import java.util.Random;

class Marsupial extends PlantEater {
    public Marsupial(int x, int y) {
        super("Marsupial", x, y, 10);
    }

    @Override
    void move(Island island) {
        Random random = new Random();
        x = Math.max(0, Math.min(island.getWidth() - 1, x + random.nextInt(3) - 1));
        y = Math.max(0, Math.min(island.getHeight() - 1, y + random.nextInt(3) - 1));
    }

    @Override
    void reproduce(List<Creature> newCreatures) {
        if (new Random().nextInt(100) < 20) {
            newCreatures.add(new Marsupial(x, y));
        }
    }

    @Override
    public String getSymbol() {
        return "🦘";
    }
}
