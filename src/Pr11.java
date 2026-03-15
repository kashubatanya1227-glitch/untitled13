import java.io.*;
import java.util.Scanner;
public class Pr11 {

    static Scanner scanner = new Scanner(System.in);
    static String fileName = "text.txt";

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1 - Записати до файлу");
            System.out.println("2 - Прочитати файл");
            System.out.println("3 - Вийти");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                writeToFile();
            }
            else if (choice == 2) {
                readFile();
            }
            else if (choice == 3) {
                System.out.println("Вихід...");
                break;
            }
        }
    }

    public static void writeToFile() {
        try {
            FileWriter writer = new FileWriter(fileName, true);

            System.out.println("Введіть рядок (пустий рядок для завершення):");
            String text = scanner.nextLine();

            if (!text.equals("")) {
                writer.write(text + "\n");
            }

            writer.close();
        }
        catch (IOException e) {
            System.out.println("Помилка запису у файл");
        }
    }

    public static void readFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            System.out.println("\nВміст файлу:");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        }
        catch (IOException e) {
            System.out.println("Помилка читання файлу");
        }
    }
}