import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu {
    private SystemFacade systemFacade;
    private List<Motherboard> motherboards;
    private List<CPU> cpus;
    private List<GPU> gpus;
    private Scanner scanner;

    public Menu(SystemFacade systemFacade, List<Motherboard> motherboards, List<CPU> cpus, List<GPU> gpus) {
        this.systemFacade = systemFacade;
        this.motherboards = motherboards;
        this.cpus = cpus;
        this.gpus = gpus;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить компонент");
            System.out.println("2. Вывести информацию о всех компонентах");
            System.out.println("3. Вывести все возможные варианты сборки систем");
            System.out.println("4. Выйти");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        addComponent();
                        break;
                    case 2:
                        displayComponentInfo();
                        break;
                    case 3:
                        buildSystems();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Неверный выбор. Пожалуйста, выберите существующую опцию.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Вы должны ввести целое число.");
                scanner.nextLine(); // Очистить буфер ввода
            }
        }
    }

    private void addComponent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите тип компонента:");
        System.out.println("1. Процессор");
        System.out.println("2. Видеокарта");
        System.out.println("3. Материнская плата");
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addCPU();
                    break;
                case 2:
                    addGPU();
                    break;
                case 3:
                    addMotherboard();
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите существующий тип компонента.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Вы должны ввести целое число.");
            scanner.nextLine(); // Очистить буфер ввода
        }
    }
    private void addCPU() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите производителя:");
        String manufacturer = scanner.nextLine().trim();

        System.out.println("Введите название:");
        String name = scanner.nextLine().trim();

        System.out.println("Введите количество ядер:");
        while (!scanner.hasNextInt()) {
            System.out.println("Неверный ввод. Пожалуйста, введите целое число для количества ядер.");
            System.out.print("Введите количество ядер: ");
            scanner.next(); // Считываем неверный ввод, чтобы избежать зацикливания
        }
        int amountCores = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.println("Введите сокет:");
        String socket = scanner.nextLine().trim();

        System.out.println("Введите частоту:");
        while (!scanner.hasNextDouble()) {
            System.out.println("Неверный ввод. Пожалуйста, введите число для частоты.");
            System.out.print("Введите частоту: ");
            scanner.next(); // Считываем неверный ввод, чтобы избежать зацикливания
        }
        double clock = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        // Создание экземпляра CPU и добавление в список cpus
        CPU cpu = Factory.createCPU(manufacturer, name, amountCores, socket, clock);
        cpus.add(cpu);
        System.out.println("Процессор успешно добавлен.");
    }

    private void addGPU() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите производителя:");
        String manufacturer = scanner.nextLine().trim();

        System.out.println("Введите название:");
        String name = scanner.nextLine().trim();

        System.out.println("Введите порт:");
        String port = scanner.nextLine();

        System.out.println("Введите частоту:");
        while (!scanner.hasNextDouble()) {
            System.out.println("Неверный ввод. Пожалуйста, введите число для частоты.");
            System.out.print("Введите частоту: ");
            scanner.next(); // Считываем неверный ввод, чтобы избежать зацикливания
        }
        double clock = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        // Создание экземпляра CPU и добавление в список cpus
        GPU gpu = Factory.createGPU(manufacturer, name, port, clock);
        gpus.add(gpu);
        System.out.println("Видеокарта успешно добавлена.");
    }

    private void addMotherboard() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите производителя:");
        String manufacturer = scanner.nextLine().trim();

        System.out.println("Введите название:");
        String name = scanner.nextLine().trim();

        System.out.println("Введите порт:");
        String port = scanner.nextLine();

        System.out.println("Введите сокет:");
        String socket = scanner.nextLine();

        Motherboard mb = Factory.createMotherboard(manufacturer, name, port, socket);
        motherboards.add(mb);
        System.out.println("Видеокарта успешно добавлена.");
    }

    private void displayComponentInfo() {
        systemFacade.displayComponents();

    }
    private void buildSystems() {
        ComponentVisitor visitor = new ComponentVisitor();
        systemFacade.buildAndOutputSystems(visitor);
    }
}
