public class raffle_toys {
    public static void main(String[] args) {
        store_toys store = new store_toys();

        toys toy1 = new toys(1, "Пазл", 10, 20);
        toys toy2 = new toys(2, "Солдатики", 200, 40);
        toys toy3 = new toys(3, "Слайм", 200, 90);
        toys toy4 = new toys(3, "Кукла", 50, 30);
        toys toy5 = new toys(3, "металлический конструктор", 200, 90);

        store.addToy(toy1);
        store.addToy(toy2);
        store.addToy(toy3);
        store.addToy(toy4);
        store.addToy(toy5);


        store.changeToyFrequency(1, 30);

        store.organizeRaffle();

        toys prizeToy = store.getPrizeToy();
        if (prizeToy != null) {
            System.out.println("Выигрышная игрушка: " + prizeToy.getName());
        }
    }
}

