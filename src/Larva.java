import java.util.List;
import java.util.ArrayList;
import java.util.Random;

class Larva extends PlantEater {
    public Larva(int x, int y) {
        super("Larva", x, y, 2);
    }

    @Override
    void move(Island island) {
    }

    @Override
    void reproduce(List<Creature> newCreatures) {
        if (new Random().nextInt(100) < 10) {
            newCreatures.add(new Larva(x, y));
        }
    }

    @Override
    public String getSymbol() {
        return "🐛";
    }
}
