import java.util.*;
import java.util.function.BiFunction;

public class Quarterly_Report {
    private static final Map<String, double[]> RAW_DATA;
    private static final double TAX_RATE = 0.17;
    private static final String DATA_CURRENCY = "£";
    private static final int DATA_SCALE = 1000;
    private static final int TOTAL_QUARTERS = 4;
    private static final int MONTHS_IN_A_QUARTER = 3;

    static {
        RAW_DATA = new HashMap<>();
        RAW_DATA.put("Electrical", new double[] {
                Double.NaN, Double.NaN, Double.NaN,
                67, 63, 78, 78, 104, 103,
                Double.NaN, Double.NaN, Double.NaN });
        RAW_DATA.put("Kitchen", new double[] {
                Double.NaN, Double.NaN, Double.NaN,
                65, 67, 56, 45, 56, 72,
                Double.NaN, Double.NaN, Double.NaN });
        RAW_DATA.put("Bathroom", new double[] {
                Double.NaN, Double.NaN, Double.NaN,
                63, 63, 65, 71, 73, 69,
                Double.NaN, Double.NaN, Double.NaN });
        RAW_DATA.put("Soft Furnishing", new double[] {
                Double.NaN, Double.NaN, Double.NaN,
                18, 24, 22, 19, 17, 16,
                Double.NaN, Double.NaN, Double.NaN });
        RAW_DATA.put("Accessories", new double[] {
                Double.NaN, Double.NaN, Double.NaN,
                16, 23, 21, 19, 20, 19,
                Double.NaN, Double.NaN, Double.NaN });
    }

    public static void main(String[] args) {
        Quarterly_Report report = new Quarterly_Report();

        System.out.println("------  Quarterly Sales  ------");
        Map<String, double[]> quarterlySales = report.computeQuarterlySales();
        displayQuarterlySales(quarterlySales);

        System.out.println("------  Quarterly Best   ------");
        Map<Integer, Map.Entry<String, double[]>> quarterlyBest = report.computeQuarterlyBest();
        displayQuarterlyResults(quarterlyBest);

        System.out.println("------  Quarterly Worst  ------");
        Map<Integer, Map.Entry<String, double[]>> quarterlyWorst = report.computeQuarterlyWorst();
        displayQuarterlyResults(quarterlyWorst);

        System.out.println("------  Quarterly Taxes  ------");
        Map<Integer, Double> quarterlyTaxes = report.computeQuarterlyTaxes();
        displayQuarterlyTaxes(quarterlyTaxes);
    }

    private static void displayQuarterlySales(Map<String, double[]> quarterlySales) {
        StringBuilder builder = new StringBuilder();

        for (String department : quarterlySales.keySet()) {
            builder.append(department);
            builder.append('\n');

            int quarter = 0;

            for (double sales : quarterlySales.get(department)) {
                quarter++;

                if (Double.isNaN(sales))
                    continue;

                builder.append("Q" + quarter + ": ");
                builder.append(DATA_CURRENCY);
                builder.append(sales);
                builder.append('\n');
            }
        }

        System.out.println(builder);
    }

    private static void displayQuarterlyResults(Map<Integer, Map.Entry<String, double[]>> quarterlyResults) {
        StringBuilder builder = new StringBuilder();

        quarterlyResults.forEach((quarter, result) -> {
            String department = result.getKey();
            double[] monthlySales = result.getValue();

            builder.append("Q" + quarter + ": ");
            builder.append(department);
            builder.append(", ");

            for (int i = 0; i < monthlySales.length; i++) {
                builder.append(DATA_CURRENCY);
                builder.append(monthlySales[i]);

                if (i != monthlySales.length - 1)
                    builder.append(", ");
            }

            builder.append('\n');
        });

        System.out.println(builder);
    }

    private static void displayQuarterlyTaxes(Map<Integer, Double> quarterlyTaxes) {
        StringBuilder builder = new StringBuilder();

        quarterlyTaxes.forEach((quarter, tax) -> {
            builder.append("Q" + quarter + ": ");
            builder.append(DATA_CURRENCY);
            builder.append(tax);
            builder.append('\n');
        });

        System.out.println(builder);
    }

    // compute the total sales for each department per quarter
    public Map<String, double[]> computeQuarterlySales() {
        Map<String, double[]> quarterlySales = new HashMap<>(RAW_DATA.size());

        RAW_DATA.forEach((department, sales) -> {
            double q1Sales = DATA_SCALE * (sales[0] + sales[1] + sales[2]);
            double q2Sales = DATA_SCALE * (sales[3] + sales[4] + sales[5]);
            double q3Sales = DATA_SCALE * (sales[6] + sales[7] + sales[8]);
            double q4Sales = DATA_SCALE * (sales[9] + sales[10] + sales[11]);

            quarterlySales.put(department,
                    new double[] { q1Sales, q2Sales, q3Sales, q4Sales });
        });

        return quarterlySales;
    }

    public Map<Integer, Map.Entry<String, double[]>> computeQuarterlyBest() {
        // since calculating quarterly best and worst share similar code structures,
        // inject the different parts with function delegate
        return computeQuarterlyResults((quarterlySales, quarter) -> {
            double bestSales = Double.NEGATIVE_INFINITY;
            String bestDepartment = null;

            // derive the best performing department in the quarter
            // by comparing their quarterly sales results
            for (String department : quarterlySales.keySet()) {
                double sales = quarterlySales.get(department)[quarter - 1];

                if (sales > bestSales) {
                    bestSales = sales;
                    bestDepartment = department;
                }
            }

            return bestDepartment;
        });

    }

    public Map<Integer, Map.Entry<String, double[]>> computeQuarterlyWorst() {
        // since calculating quarterly best and worst share similar code structures,
        // inject the different parts with function delegate
        return computeQuarterlyResults((quarterlySales, quarter) -> {
            double worstSales = Double.POSITIVE_INFINITY;
            String worstDepartment = null;

            // derive the worst performing department in the quarter
            // by comparing their quarterly sales results
            for (String department : quarterlySales.keySet()) {
                double sales = quarterlySales.get(department)[quarter - 1];

                if (sales < worstSales) {
                    worstSales = sales;
                    worstDepartment = department;
                }
            }

            return worstDepartment;
        });
    }

    private Map<Integer, Map.Entry<String, double[]>> computeQuarterlyResults(
            BiFunction<Map<String, double[]>, Integer, String> function) {
        Map<String, double[]> quarterlySales = computeQuarterlySales();
        Map<Integer, Map.Entry<String, double[]>> quarterlyResults = new LinkedHashMap<>(TOTAL_QUARTERS);

        // iterate over all quarters
        for (int quarter = 1; quarter <= TOTAL_QUARTERS; quarter++) {
            // derive the resulting department from the logic injected
            String department = function.apply(quarterlySales, quarter);

            // check if the logic returns a valid department name
            if (!RAW_DATA.containsKey(department))
                continue;

            // store the valid quarter as kay and the department with
            // its monthly sales associated as value
            int index = (quarter - 1) * MONTHS_IN_A_QUARTER;
            double[] monthlySales = RAW_DATA.get(department);

            quarterlyResults.put(quarter,
                    new AbstractMap.SimpleEntry<String, double[]>(department,
                            new double[] {
                                    DATA_SCALE * monthlySales[index],
                                    DATA_SCALE * monthlySales[index + 1],
                                    DATA_SCALE * monthlySales[index + 2]
                            }));
        }

        return quarterlyResults;
    }

    public Map<Integer, Double> computeQuarterlyTaxes() {
        Map<String, double[]> quarterlySales = computeQuarterlySales();
        Map<Integer, Double> quarterlyTaxes = new LinkedHashMap<>(TOTAL_QUARTERS);

        // iterate over all quarters
        for (int quarter = 1; quarter <= TOTAL_QUARTERS; quarter++) {
            double quarterlyTotal = 0;

            // sum up the total sales of all departments in the same quarter
            for (double[] sales : quarterlySales.values()) {
                double amount = sales[quarter - 1];

                if (!Double.isNaN(amount))
                    quarterlyTotal += amount;
            }

            // calcualte the tax should be paid for the quarter as store it
            // as key-value pairs of quarter and value
            double tax = quarterlyTotal * TAX_RATE;
            quarterlyTaxes.put(quarter, tax);
        }

        return quarterlyTaxes;
    }
}