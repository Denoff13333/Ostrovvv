import java.util.*;
import java.util.concurrent.*;

public class EcoSystemSimulation {
    public static void main(String[] args) {
        SimulationConfig config = new SimulationConfig();
        Island island = new Island(config.islandWidth, config.islandHeight);

        initializeCreatures(island, config);

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> updateIsland(island, config), 0, config.tickDuration, TimeUnit.MILLISECONDS);
    }

    private static void initializeCreatures(Island island, SimulationConfig config) {
        Random random = new Random();
        for (int i = 0; i < config.initialCreatureCount; i++) {
            Creature creature = AnimalFactory.createRandomCreature(
                    random.nextInt(island.getWidth()),
                    random.nextInt(island.getHeight())
            );
            island.addCreature(creature);
        }
    }

    private static void updateIsland(Island island, SimulationConfig config) {
        List<Creature> newCreatures = new ArrayList<>();
        boolean hasPlantEaters = false;

        for (Habitat habitat : island.getAllHabitats()) {
            for (Creature creature : habitat.getCreatures()) {
                if (creature instanceof PlantEater) {
                    hasPlantEaters = true;
                }
            }

            habitat.updateCreatures(newCreatures, island);
            habitat.growPlant();
        }

        for (Creature creature : newCreatures) {
            island.addCreature(creature);
        }

        printIsland(island);

        if (!hasPlantEaters) {
            System.out.println("Все травоядные вымерли. Симуляция завершена.");
            System.exit(0);
        }
    }

    private static void printIsland(Island island) {
        for (int y = 0; y < island.getHeight(); y++) {
            for (int x = 0; x < island.getWidth(); x++) {
                Habitat habitat = island.getHabitat(x, y);
                System.out.print(habitat.getRepresentation());
            }
            System.out.println();
        }
        System.out.println("=".repeat(island.getWidth()));
    }
}
