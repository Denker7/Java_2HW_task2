import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Interface {

    static ExplorerMap explorer = new ExplorerMap();
    static BufferedReader br = null;
    static Scanner console = new Scanner(System.in);

    public static void initialInterface() throws Exception {
        System.out.println("Создайте мапу для работы, её можно ввести из консоли в формате КЛЮЧ:ЗНАЧЕНИЕ;КЛЮЧ1:ЗНАЧЕНИЕ1");
        System.out.println("либо можно записать её из файла(написать путь до файла в консоль), формат для записи из файла аналогичен");
        System.out.println("Закончить выполнение приложения можно командой EXIT, так же введенной в консоль");
        inputData();
        headerInterface();

    }


    public static void headerInterface() throws Exception {
        System.out.println("Вы можете добавить значение через консоль командой 1");
        System.out.println("удалить элемент по ключу командой 2");
        System.out.println("вывести текущую мапу в консоль командой 3");
        System.out.println("вывести перевернутую мапу в консоль командой 4");
        System.out.println("Закончить выполнение приложения можно командой EXIT, так же введенной в консоль");
        String consoleIn = console.nextLine().toLowerCase();
        switch (consoleIn) {
            case "1":
                inputData();
                headerInterface();
                break;
            case "2":
                consoleRemove();
                headerInterface();
                break;
            case "3":
                consolePrint();
                headerInterface();
                break;
            case "4":
                consoleInversion();
                headerInterface();
                break;
            case "exit":
                break;
            default:
                System.out.println("Введены некорректные данные, повторите ввод");
                headerInterface();
                break;
        }
    }

    public static void inputData() throws Exception {
        System.out.println("Выберите вариант записи 1 через консоль 2 через файл");
        switch (console.nextLine().toLowerCase()) {
            case "1":
                consoleInput();
                break;
            case "2":
                fileInput();
                break;
            case "exit":
                break;
            default:
                System.out.println("Введены некорректные данные, повторите ввод");
                inputData();
                break;
        }
    }

    private static void consoleRemove() {
        System.out.println("Введите ключ мапы, для прекращения ввода введите команду cancel");
        System.out.println("Команда ALL отчистит мапу");
        String consoleInput = console.nextLine();
        explorer.remove(consoleInput);
    }

    private static void consolePrint() {
        explorer.print();
    }

    private static void consoleInversion() {
        explorer.inverseMap();
    }

    private static void consoleInput() {
//        System.out.println("Введите данные соответствующим паттерном, для прекращения ввода введите команду cancel");
        System.out.println("Введите данные соответствующим паттернум");
        String consoleInput = console.nextLine();
//        while (!consoleInput.toLowerCase().equals("cancel")) {
            addExplorer(consoleInput);
//            System.out.println("Введите еще либо закончите (cancel)");
//            consoleInput = console.nextLine();
//        }
    }

    private static void addExplorer(String consoleInput) {
        String[] arrString = consoleInput.split(";");
        for (String s : arrString) {
            String[] mapStr = s.split(":");
            mapStr = checArrayIndex(mapStr);
            explorer.add(mapStr[0], mapStr[1]);
        }
    }

    private static String[] checArrayIndex(String[] arr) {
        if (arr.length < 2) {
            arr = new String[]{arr[0], ""};
        }
        return arr;
    }

    private static void fileInput() throws Exception {
//        System.out.println("Введите путь до файла, для прекращения ввода введите команду cancel");
        System.out.println("Введите путь до файла");
        String path = console.nextLine();
//        String path = "D:\\JavaProject\\labs\\task2\\src\\test.txt";
//        while (!path.toLowerCase().equals("cancel")) {
            br = new BufferedReader(new FileReader(path));
            System.out.println("Вы ввели путь: " + path);
            addExplorer(br.readLine());
//            System.out.println("Введите еще либо закончите (cancel)");
//            path = console.nextLine();
//        }

    }
}
