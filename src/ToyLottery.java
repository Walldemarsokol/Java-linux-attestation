import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class ToyLottery {
    private List<Toy> listToys = new ArrayList<>();
    private int toyCount;

    public List<Toy> getToys() {
        return listToys;
    }

    public int getToyCount() {
        System.out.println("Количечтово игрушек = ");
        return toyCount;
    }

    // добавить игрушку в розыгрыш
    public List<Toy> addToyInListToy(Toy name) {
        listToys.add(name);
        toyCount++;
        return listToys;
    }

    // удалить игрушку из спискка по имени
    private List<Toy> deleteToyInListToy(Toy name) {
        listToys.remove(name);
        toyCount--;
        return listToys;
    }

    // запись выигранных игрушек в файл ".txt"
    private void saveInFile() {
        try (FileWriter writer = new FileWriter("winningToys.txt", true)) {
            String text = listToys.get(0).getToyName();
            writer.write(text + "\n");
            writer.close();
        } catch (Exception ex) {
            System.out.println("Ошибка записи файла");
        }
    }

    // чтение файла с выигранными игрушками
    public void readFile() {
        try {
            FileReader fr = new FileReader("winningToys.txt");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }

        } catch (Exception ex) {
            System.out.println("Ошибка чтения файла");
        }
    }

    // Розыгрыш, с регулируемым шансом на победу
    // если выигрыш, то записываем имя игрушки в файл
    // и удаляем её из списка разыгрываемых игрушек
    public void lottteryToy() {
        Scanner scan = new Scanner(System.in);
        int chance = 50;
        System.out.println("Шанс на выигрыш по умолчанию 50%");
        System.out.println("Если хотите изменить шанс на победу, нажмите 1");
        System.out.println("Если хотите оставить шанс на победу по умолчанию, нажмите 2");
        String changeСhance = scan.next();
        if (changeСhance.equals("1")) {
            System.out.println("Введите число от 1 до 100, это процентное соотношение на победу!");
            chance = scan.nextInt();
        }
        if (chance >= 0 && chance <= 100) {
            Random rnd = new Random();
            int num = rnd.nextInt(100);
            if (num > chance) {
                System.out.println("Вы проиграли, попробуйте заново");
            } else if (num < chance) {
                System.out.println("Поздравляю, вы выиграли!!!");
                saveInFile();
                deleteToyInListToy(listToys.get(0));
            }
        } else {
            System.out.println("Вы ввели не верное значение! Попробуйте заново");
        }
    }
}
