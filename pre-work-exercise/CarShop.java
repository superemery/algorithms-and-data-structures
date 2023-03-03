import java.security.spec.InvalidParameterSpecException;
import java.util.*;
import java.util.function.*;

public class CarShop {
    public static void main(String[] args) {
        CarShop shop = new CarShop();

        shop.store("Honda", "Fit", 2013, 200_500, 1.3, "A", 5_550.50);
        shop.store("Toyota", "Prius", 2012, 88_000, 1.8, "A", 8_450.00);
        shop.store("Volkswagen", "Golf", 2016, 74_550, 1.5, "B", 12_500.00);
        shop.store("Toyota", "Yaris", 2011, 110_100, 1.0, "A", 6_500.50);
        shop.store("Toyota", "Prius", 2015, 52_300, 1.8, "C", 9_999.95);
        shop.store("Volkswagen", "Polo", 2012, 140_820, 1.2, "B", 3_050.50);

        displayReport(shop.search("price", false));
        displayReport(shop.search(5));
    }

    private static void displayReport(CarInfo... data) {
        StringBuilder builder = new StringBuilder();
        builder.append(padEnd("ID", 5));
        builder.append(padEnd("Manufacturer", 15));
        builder.append(padEnd("Model", 8));
        builder.append(padEnd("Year", 7));
        builder.append(padEnd("Mileage", 12));
        builder.append(padEnd("Engine Size", 14));
        builder.append(padEnd("Grade", 8));
        builder.append(padEnd("Price", 10));

        System.out.println(builder);
        builder.delete(0, builder.length());

        for (CarInfo info : data) {
            builder.append(padEnd(Integer.toString(info.getId()), 5));
            builder.append(padEnd(info.getManufacturer(), 15));
            builder.append(padEnd(info.getModel(), 8));
            builder.append(padEnd(Integer.toString(info.getYear()), 7));
            builder.append(padEnd(String.format("%.2f", info.getMileage()), 12));
            builder.append(padEnd(String.format("%.1f", info.getEngineSize()) + "L", 14));
            builder.append(padEnd(info.getGrade(), 8));
            builder.append(padEnd("£" + String.format("%.2f", info.getPrice()), 10));

            System.out.println(builder);
            builder.delete(0, builder.length());
        }
    }

    private static String padEnd(String text, int maxLength) {
        while (text.length() < maxLength)
            text += " ";

        return text;
    }

    private static void buildCarData(CarShop shop) {
        final String[] gradeOptions = { "A", "B", "C", "D" };

        Boolean shouldContinue = true;

        while (shouldContinue) {
            String manufacturer = readInput(String.class, "Manufacturer: ", null);
            String model = readInput(String.class, "Model: ", null);
            String grade = readInput(String.class, "Grade (A/B/C/D): ",
                    v -> Arrays.stream(gradeOptions).anyMatch(o -> o.equals(v)));
            int year = readInput(Integer.class, "Year: ", v -> v > 0);
            double mileage = readInput(Double.class, "Mileage: ", v -> v > 0);
            double price = readInput(Double.class, "Price (£): ", v -> v > 0);
            double engineSize = readInput(Double.class, "Engine Size (L): ", v -> v > 0);

            shop.store(manufacturer, model, year, mileage, engineSize, grade, price);

            String result = readInput(String.class, "Data created. Continue? (Y/N): ",
                    v -> (v.equals("Y") || v.equals("N")));

            shouldContinue = result.equals("Y");
        }
    }

    /**
     * Repeatly read and parse input value from the console until it passes
     * validation conditions.
     * 
     * @param <T>          Can be String, Integer, or Double
     * @param type         A generic Class object indicating the output type
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

    private ArrayList<CarInfo> dataList;
    private Map<Integer, CarInfo> dataMap;

    public CarShop() {
        dataList = new ArrayList<>();
        dataMap = new HashMap<>();
    }

    public void store(String manufacturer, String model,
            int year, double mileage, double engineSize, String grade, double price) {
        int id = this.dataList.size() + 1;
        CarInfo info = this.new CarInfo(id);
        info.setManufacturer(manufacturer);
        info.setModel(model);
        info.setYear(year);
        info.setMileage(mileage);
        info.setGrade(grade);
        info.setPrice(price);
        info.setEngineSize(engineSize);
        dataList.add(info);
        dataMap.put(id, info);
    }

    private CarInfo[] getDataList() {
        return dataList.toArray(new CarInfo[dataList.size()]);
    }

    public CarInfo search(int id) {
        return dataMap.get(id);
    }

    public CarInfo search(String key, Boolean heighest) {
        BiFunction<CarInfo, CarInfo, Boolean> comparator = getComparator(key, heighest);
        CarInfo info = dataList.get(0);

        for (int i = 1; i < dataList.size(); i++) {
            if (comparator.apply(dataList.get(i), info))
                info = dataList.get(i);
        }

        return info;
    }

    public void sort(String key) throws IllegalArgumentException {
        BiFunction<CarInfo, CarInfo, Boolean> comparator = getComparator(key, false);

        dataList.sort((a, b) -> comparator.apply(a, b) ? -1 : 1);
    }

    private BiFunction<CarInfo, CarInfo, Boolean> getComparator(String key, Boolean descending) {
        BiFunction<CarInfo, CarInfo, Boolean> comparator;

        switch (key) {
            case "id":
                comparator = (a, b) -> a.getId() < b.getId();
                break;
            case "manufacturer":
                comparator = (a, b) -> a.getManufacturer().compareTo(b.getManufacturer()) < 0;
                break;
            case "model":
                comparator = (a, b) -> a.getModel().compareTo(b.getModel()) < 0;
                break;
            case "grade":
                comparator = (a, b) -> a.getGrade().compareTo(b.getGrade()) < 0;
                break;
            case "year":
                comparator = (a, b) -> a.getYear() < b.getYear();
                break;
            case "mileage":
                comparator = (a, b) -> a.getMileage() < b.getMileage();
                break;
            case "price":
                comparator = (a, b) -> a.getPrice() < b.getPrice();
                break;
            case "engineSize":
                comparator = (a, b) -> a.getEngineSize() < b.getEngineSize();
                break;
            default:
                throw new IllegalArgumentException("Invalid key: " + key);
        }

        return descending ? (a, b) -> !comparator.apply(a, b) : comparator;
    }

    public class CarInfo {
        private final int id;
        private String manufacturer;
        private String model;
        private String grade;
        private int year;
        private double mileage;
        private double price;
        private double engineSize;

        public CarInfo(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public double getMileage() {
            return mileage;
        }

        public void setMileage(double mileage) {
            this.mileage = mileage;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getEngineSize() {
            return engineSize;
        }

        public void setEngineSize(double engineSize) {
            this.engineSize = engineSize;
        }
    }
}