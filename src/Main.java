public class Main {
    public static void main(String[] args) {
        // Создание объектов class "Toy"
        Toy bear = new Toy(1, "Bear");
        Toy car = new Toy(2, "Car");
        Toy cubes = new Toy(3, "Cubes");
        Toy lego = new Toy(4, "Lego");
        Toy balloons = new Toy(5, "Balloons");
        Toy ball = new Toy(6, "Ball");
        Toy sword = new Toy(7, "Sword");
        Toy gun = new Toy(8,"Gun");
        Toy pistol = new Toy(9,"Pistol");

        // Создание объекта "Розыгрыш игрушек" с добавлением игрушек в розыгрыш
        ToyLottery toyLottery = new ToyLottery();
        toyLottery.addToyInListToy(bear);
        toyLottery.addToyInListToy(car);
        toyLottery.addToyInListToy(cubes);
        toyLottery.addToyInListToy(lego);
        toyLottery.addToyInListToy(balloons);
        toyLottery.addToyInListToy(ball);
        toyLottery.addToyInListToy(sword);
        toyLottery.addToyInListToy(gun);
        toyLottery.addToyInListToy(pistol);

        // Запускаем розыгрыш с управлением выпадения выигрыша, затем читаем файл
        toyLottery.lottteryToy();
        toyLottery.readFile();
        toyLottery.lottteryToy();
        toyLottery.readFile();
        // Проверяем оставшиеся игрушки в списке
        toyLottery.getToys();
        // просматриваем число игрушек в списке
        toyLottery.getToyCount();
    }
}