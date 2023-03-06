import java.lang.reflect.Field;
import java.security.spec.InvalidParameterSpecException;
import java.util.*;
import java.util.function.*;

public class CarShop {
    public static void main(String[] args) {
        CarShop shop = new CarShop();

        enterCarInfo(shop);

        // add car info
        shop.store(shop.new CarInfo("Honda", "Fit", 2013, 200500, 1.3, "A", 5550.50));
        shop.store(shop.new CarInfo("Toyota", "Prius", 2012, 88000, 1.8, "A", 8450.00));
        shop.store(shop.new CarInfo("Volkswagen", "Golf", 2016, 74550, 1.5, "B", 12500.00));
        shop.store(shop.new CarInfo("Toyota", "Yaris", 2011, 110100, 1.0, "A", 6500.50));
        shop.store(shop.new CarInfo("Toyota", "Prius", 2015, 52300, 1.8, "C", 9999.95));
        shop.store(shop.new CarInfo("Volkswagen", "Polo", 2012, 140820, 1.2, "B", 3050.50));

        shop.showSorted("price", false, true);
        shop.showHighest("price", true);
        shop.showLowest("price", true);
        shop.showStocks();
    }

    private static void enterCarInfo(CarShop shop) {
        final String[] validGrades = { "A", "B", "C", "D" };

        Boolean shouldContinue = true;

        while (shouldContinue) {
            String result = readInput(String.class, "Create new data? (Y/N): ",
                    v -> (v.equals("Y") || v.equals("N")));

            shouldContinue = result.equals("Y");

            if (!shouldContinue)
                break;

            String manufacturer = readInput(String.class, "Manufacturer: ", null);
            String model = readInput(String.class, "Model: ", null);
            String grade = readInput(String.class, "Grade (A/B/C/D): ",
                    v -> Arrays.stream(validGrades).anyMatch(g -> g.equals(v)));
            int year = readInput(Integer.class, "Year: ", v -> v >= 2000);
            double mileage = readInput(Double.class, "Mileage: ", v -> v >= 0.0);
            double price = readInput(Double.class, "Price (£): ", v -> v > 0.0);
            double engineSize = readInput(Double.class, "Engine Size (L): ", v -> v >= 1.0);

            shop.store(shop.new CarInfo(manufacturer, model, year, mileage, engineSize, grade, price));
            System.out.println("----- DATA CREATED -----");
        }
    }

    /**
     * Repeatly read and parse input value from the console until it passes
     * validation conditions.
     * 
     * @param <T>          Can be String, Integer, or Double
     * @param type         Assign the output type of this method
     * @param title        The text to show before reading from the console
     * @param validateFunc A function delegate validating the parsed input value
     * @return A value of type T
     */
    private static <T> T readInput(Class<T> type, String title, Function<T, Boolean> validateFunc) {
        while (true) {
            System.out.print(title);
            Scanner scanner = new Scanner(System.in);

            try {
                T value;

                if (type == String.class) {
                    value = type.cast(scanner.nextLine());
                } else if (type == Integer.class) {
                    value = type.cast(scanner.nextInt());
                } else if (type == Double.class) {
                    value = type.cast(scanner.nextDouble());
                } else {
                    throw new IllegalArgumentException("Unsupported class type");
                }

                if (validateFunc == null || validateFunc.apply(value)) {
                    return value;
                } else {
                    throw new InvalidParameterSpecException(null);
                }
            } catch (IllegalArgumentException e) {
                scanner.close();
                throw new Error(e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid value");
            }
        }
    }

    private final CarInfoStore infoStore;
    private final CarGradeStore gradeStore;
    private final CarStockStore stockStore;

    public CarShop() {
        infoStore = new CarInfoStore();
        gradeStore = new CarGradeStore();
        stockStore = new CarStockStore();

        // add default car grade
        gradeStore.store(new CarGrade("A", "Excellent", "Very slightly used, virtually as good as new."));
        gradeStore.store(new CarGrade("B", "Good", "Good condition but with visible flaws."));
        gradeStore.store(new CarGrade("C", "Average", "Average condition, with minor damage."));
        gradeStore.store(new CarGrade("D", "Poor",
                "Poor condition with significant damage, but the car is functional."));
    }

    public void store(CarInfo info) {
        infoStore.store(info);
        stockStore.store(info);
    }

    public void showSorted(String sortKey, Boolean descending, Boolean useCondition) {
        CarInfo[] sorted = infoStore.sort(sortKey, descending);
        showInfos(useCondition, sorted);
    }

    public void showHighest(String searchKey, Boolean useCondition) {
        CarInfo info = infoStore.search(searchKey, true);

        if (info != null)
            showInfos(useCondition, info);
    }

    public void showLowest(String searchKey, Boolean useCondition) {
        CarInfo info = infoStore.search(searchKey, false);

        if (info != null)
            showInfos(useCondition, info);
    }

    private void showInfos(Boolean useCondition, CarInfo... infos) {
        StringBuilder builder = new StringBuilder();
        builder.append(padEnd("ID", 5));
        builder.append(padEnd("Manufacturer", 15));
        builder.append(padEnd("Model", 8));
        builder.append(padEnd("Year", 7));
        builder.append(padEnd("Mileage", 12));
        builder.append(padEnd("Engine Size", 14));

        if (useCondition)
            builder.append(padEnd("Condition", 12));
        else
            builder.append(padEnd("Grade", 8));

        builder.append(padEnd("Price", 10));

        System.out.println(builder);
        builder.delete(0, builder.length());

        for (CarInfo info : infos) {
            builder.append(padEnd(String.format("%d", info.id), 5));
            builder.append(padEnd(info.manufacturer, 15));
            builder.append(padEnd(info.model, 8));
            builder.append(padEnd(String.format("%d", info.year), 7));
            builder.append(padEnd(String.format("%.2f", info.mileage), 12));
            builder.append(padEnd(String.format("%.1fL", info.engineSize), 14));

            if (useCondition)
                builder.append(padEnd(gradeStore.search("grade", info.grade).condition, 12));
            else
                builder.append(padEnd(info.grade, 8));

            builder.append(padEnd(String.format("£%.2f", info.price), 10));

            System.out.println(builder);
            builder.delete(0, builder.length());
        }

        System.out.println();
    }

    public void showStocks() {
        CarStock[] stocks = stockStore.toArray();

        StringBuilder builder = new StringBuilder();
        builder.append(padEnd("ID", 5));
        builder.append(padEnd("Manufacturer", 15));
        builder.append(padEnd("Number", 9));
        builder.append(padEnd("Price", 10));

        System.out.println(builder);
        builder.delete(0, builder.length());

        for (CarStock stock : stocks) {
            builder.append(padEnd(String.format("%d", stock.id), 5));
            builder.append(padEnd(stock.manufacturer, 15));
            builder.append(padEnd(String.format("%d", stock.number), 9));
            builder.append(padEnd(String.format("£%.2f", stock.price), 10));

            System.out.println(builder);
            builder.delete(0, builder.length());
        }

        System.out.println();
    }

    private static String padEnd(String text, int maxLength) {
        while (text.length() < maxLength)
            text += " ";

        return text;
    }

    public class CarInfoStore {
        private ArrayList<CarInfo> infoList;
        private Map<Integer, CarInfo> infoMap;

        public CarInfoStore() {
            infoList = new ArrayList<>();
            infoMap = new LinkedHashMap<>();
        }

        public void store(CarInfo info) {
            info.id = this.infoList.size() + 1;
            infoList.add(info);
            infoMap.put(info.id, info);
        }

        public CarInfo search(int id) {
            return infoMap.get(id);
        }

        public CarInfo search(String key, Boolean heighest) {
            BiFunction<CarInfo, CarInfo, Boolean> comparator = getComparator(key, heighest);
            CarInfo info = infoList.get(0);

            for (int i = 1; i < infoList.size(); i++) {
                if (comparator.apply(infoList.get(i), info))
                    info = infoList.get(i);
            }

            return info;
        }

        public CarInfo[] sort(String key, Boolean descending) {
            BiFunction<CarInfo, CarInfo, Boolean> comparator = getComparator(key, descending);

            infoList.sort((a, b) -> comparator.apply(a, b) ? -1 : 1);

            return infoList.toArray(new CarInfo[infoList.size()]);
        }

        public CarInfo[] toArray() {
            return infoList.toArray(new CarInfo[infoList.size()]);
        }

        private BiFunction<CarInfo, CarInfo, Boolean> getComparator(String key, Boolean descending) {
            BiFunction<CarInfo, CarInfo, Boolean> comparator;

            switch (key) {
                case "id":
                    comparator = (a, b) -> a.id < b.id;
                    break;
                case "manufacturer":
                    comparator = (a, b) -> a.manufacturer.compareTo(b.manufacturer) < 0;
                    break;
                case "model":
                    comparator = (a, b) -> a.model.compareTo(b.model) < 0;
                    break;
                case "grade":
                    comparator = (a, b) -> a.grade.compareTo(b.grade) < 0;
                    break;
                case "year":
                    comparator = (a, b) -> a.year < b.year;
                    break;
                case "mileage":
                    comparator = (a, b) -> a.mileage < b.mileage;
                    break;
                case "price":
                    comparator = (a, b) -> a.price < b.price;
                    break;
                case "engineSize":
                    comparator = (a, b) -> a.engineSize < b.engineSize;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid key: " + key);
            }

            return descending ? (a, b) -> !comparator.apply(a, b) : comparator;
        }
    }

    public class CarGradeStore {
        private Map<String, Map<Object, CarGrade>> searchEntries;
        private int itemCount;

        public CarGradeStore() {
            searchEntries = new LinkedHashMap<>();
            searchEntries.put("id", new LinkedHashMap<>());
            searchEntries.put("grade", new LinkedHashMap<>());
            searchEntries.put("condition", new LinkedHashMap<>());
        }

        public void store(CarGrade item) {
            try {
                item.id = itemCount;

                for (String keyName : searchEntries.keySet()) {
                    Field field = item.getClass().getDeclaredField(keyName);
                    Object value = field.get(item);
                    Map<Object, CarGrade> entry = searchEntries.get(keyName);

                    entry.put(value, item);
                }

                itemCount++;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        public CarGrade search(String keyName, Object keyValue) {
            try {
                return searchEntries.get(keyName).get(keyValue);
            } catch (Exception e) {
                return null;
            }
        }

        public int size() {
            return itemCount;
        }
    }

    public class CarStockStore {
        private Map<String, CarStock> stockMap;

        public CarStockStore() {
            stockMap = new LinkedHashMap<>();
        }

        public void store(CarInfo info) {
            if (!stockMap.containsKey(info.manufacturer)) {
                stockMap.put(info.manufacturer,
                        new CarStock(stockMap.size() + 1, info.manufacturer));
            }

            CarStock stock = stockMap.get(info.manufacturer);
            stock.setNumber(stock.getNumber() + 1);
            stock.setPrice(stock.getPrice() + info.price);
        }

        public CarStock[] toArray() {
            return stockMap.values().toArray(new CarStock[stockMap.size()]);
        }
    }

    public class CarInfo {
        public int id;
        public final String manufacturer;
        public final String model;
        public final int year;
        public final double mileage;
        public final double engineSize;
        public final String grade;
        public final double price;

        public CarInfo(String manufacturer, String model, int year,
                double mileage, double engineSize, String grade, double price) {
            this.manufacturer = manufacturer;
            this.model = model;
            this.year = year;
            this.mileage = mileage;
            this.engineSize = engineSize;
            this.grade = grade;
            this.price = price;
        }
    }

    public class CarGrade {
        public int id;
        public final String grade;
        public final String condition;
        public final String description;

        public CarGrade(String grade, String condition, String description) {
            this.grade = grade;
            this.condition = condition;
            this.description = description;
        }
    }

    public class CarStock {
        public final int id;
        public final String manufacturer;
        private int number;
        private double price;

        public CarStock(int id, String manufacturer) {
            this.id = id;
            this.manufacturer = manufacturer;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }
}