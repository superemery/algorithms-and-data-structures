import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class BirdTable {
   public static void main(String args[]) {
      // Declare and build an array interactively - see the Temperature Project
      final int RECORDING_DAYS = 7;
      int[] records = new int[RECORDING_DAYS];

      for (int i = 0; i < records.length; i++) {
         String record = JOptionPane.showInputDialog("Enter record for day " + (i + 1));
         records[i] = Integer.parseInt(record);
      }

      // Display Output using a histogram of '*' - see Histogram Project
      JTextArea outputArea = new JTextArea();
      outputArea.setText(buildTableRows(records));

      JOptionPane.showMessageDialog(null, outputArea,
            "Histogram Printing Program", JOptionPane.INFORMATION_MESSAGE);
   }

   private static String buildTableRows(int[] records) {
      final String TITLE_STRING = "Days\tNo. Blue Tits\tHistogram\n";

      StringBuilder builder = new StringBuilder(TITLE_STRING);

      for (int i = 0; i < records.length; i++) {
         int day = i + 1;
         int numBlueTits = records[i];
         String histogram = createHistogram(records[i]);

         builder.append(day);
         builder.append("\t");
         builder.append(numBlueTits);
         builder.append("\t");
         builder.append(histogram);
         builder.append(i == records.length - 1 ? "" : "\n");
      }

      return builder.toString();
   }

   private static String createHistogram(int count) {
      String histogram = "";

      for (int i = 0; i < count; i++) {
         histogram += "*";
      }

      return histogram;
   }
}