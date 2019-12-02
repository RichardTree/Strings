package org.softwire.training.Strings;
import java.text.DateFormatSymbols;

public class Main {

  public static void main(String[] args) {
    String text = "Publication Date,Title,Authors,"
        + "29/07/1954,Lord of the Rings,John Ronald Reuel Tolkien,"
        + "01/08/1996,A Game of Thrones,George Raymond Martin,"
        + "21/06/2003,Harry Potter and the Order of the Phoenix,Joanne Rowling";

    parseCSV(text);
    System.out.println(parseCSV(text));
  }

  public static String parseCSV (String text){
    String[] csvArray = text.split(",");
    StringBuilder sb = new StringBuilder(30);

    String o = String.format("| Pub Date    | %s | %s |", padLeft(csvArray[1],29), padRight(csvArray[2],21));

    sb.append(o);
    sb.append("\n");
    sb.append("|=====================================================================|");
    sb.append("\n");

    for (int i = 3; i <= 9; i += 3) {
      sb.append("| ");
      sb.append(csvArray[i].substring(0,2));
      sb.append(" ");
      sb.append(getMonth(Integer.parseInt(csvArray[i].substring(3,5))).substring(0,3));
      sb.append(" ");
      sb.append(Integer.parseInt(csvArray[i].substring(6,10)));
      sb.append(String.format(" | %1$.29s | %2$.21s |", padLeft(ellipsize(csvArray[i+1],29),29), padLeft(ellipsize(csvArray[i+2],21),21)));
      if (i < 9){
        sb.append("\n");
      }
    }
    return sb.toString();
  }

  public static String padRight(String s, int n) {
    return String.format("%-" + n + "s", s);
  }

  public static String padLeft(String s, int n) {
    return String.format("%" + n + "s", s);
  }

  public static String getMonth(int month) {
    return new DateFormatSymbols().getMonths()[month-1];
  }

  public static String ellipsize(String input, int maxLength) {
    String ellip = "...";
    if (input == null || input.length() <= maxLength
        || input.length() < ellip.length()) {
      return input;
    }
    return input.substring(0, maxLength - ellip.length()).concat(ellip);
  }
}

