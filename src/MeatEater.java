import java.util.List;
import java.util.Optional;

abstract class MeatEater extends Creature {
    public MeatEater(String name, int x, int y, int initialEnergy) {
        super(name, x, y, initialEnergy);
    }

    @Override
    void eat(Habitat habitat) {
        Optional<Creature> prey = habitat.getPlantEaters().stream().findFirst();
        prey.ifPresent(creature -> {
            habitat.removeCreature(creature);
            energy +=
                    energy += 5;
            System.out.println(name + " съел " + creature.name);
        });
    }
}
