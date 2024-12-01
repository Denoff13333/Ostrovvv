import java.util.List;

abstract class PlantEater extends Creature {
    public PlantEater(String name, int x, int y, int initialEnergy) {
        super(name, x, y, initialEnergy);
    }

    @Override
    void eat(Habitat cell) {
        if (cell.hasPlant()) {
            cell.consumePlant();
            energy += 2;
            System.out.println(name + " съел растение");
        }
    }
}
