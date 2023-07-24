import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class store_toys {
    private ArrayList<toys> toys;
    private ArrayList<toys> prizeToys;
    private String prizeFilePath;

    public store_toys() {
        toys = new ArrayList<toys>();
        prizeToys = new ArrayList<toys>();
        prizeFilePath = "prize_toys.txt";
    }

    public void addToy(toys toy) {
        toys.add(toy);
    }

    public void changeToyFrequency(int toyId, double newFrequency) {
        for (toys toy : toys) {
            if (toy.getId() == toyId) {
                toy.setFrequency(newFrequency);
            }
        }
    }

    public void organizeRaffle() {
        prizeToys.clear();

        for (toys toy : toys) {
            double random = Math.random() * 100;
            if (random < toy.getFrequency()) {
                prizeToys.add(toy);
            }
        }
    }
    public toys getPrizeToy() {
        if (!prizeToys.isEmpty()) {
            toys prizeToy = prizeToys.remove(0);
            prizeToy.setQuantity(prizeToy.getQuantity() - 1);

            try {
                FileWriter writer = new FileWriter(prizeFilePath, true);
                writer.write(prizeToy.getName() + "\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Ошибка при записи в файл игрушки");
            }

            return prizeToy;
        } else {
            System.out.println("Все игрушки кончились");
            return null;
        }
    }
}


  


