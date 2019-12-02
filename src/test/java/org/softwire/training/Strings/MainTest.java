package org.softwire.training.Strings;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

  @Test
  public void parseCSV() {
    String input = "Publication Date,Title,Authors,"
        + "29/07/1954,Lord of the Rings,John Ronald Reuel Tolkien,"
        + "01/08/1996,A Game of Thrones,George Raymond Martin,"
        + "21/06/2003,Harry Potter and the Order of the Phoenix,Joanne Rowling";

    String output = "| Pub Date    |                         Title | Authors               |\n"
        + "|=====================================================================|\n"
        + "| 29 Jul 1954 |             Lord of the Rings | John Ronald Reuel ... |\n"
        + "| 01 Aug 1996 |             A Game of Thrones | George Raymond Martin |\n"
        + "| 21 Jun 2003 | Harry Potter and the Order... |        Joanne Rowling |";

    assertThat(Main.parseCSV(input), is(output));
  }
}