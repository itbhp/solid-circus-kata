package com.therefactorproject.acrobatshowpass;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AcrobatShowPassTest {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @BeforeEach
  void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  void tearDown() {
    System.setOut(originalOut);
  }

  @Test
  void shouldPrintPassDetailsToConsole() {
    var pass = new AcrobatShowPass("The Great Aerial Show", 15, 4);
    pass.printAndArchive(5);

    var output = outContent.toString();

    assertTrue(output.contains("🎟️ Printing on Acrobat Show printer #5"));
    assertTrue(output.contains("Show: The Great Aerial Show"));
    assertTrue(output.contains("Base price: 15.00€"));
    assertTrue(output.contains("Tax: 0.60€"));
    assertTrue(output.contains("TOTAL: 15.60€"));
  }

  @Test
  void shouldLogArchivingMessage() {
    var pass = new AcrobatShowPass("Skywalkers", 12, 4);
    pass.printAndArchive(1);

    var output = outContent.toString();

    assertTrue(output.contains("🤸 Archiving Acrobat Show pass of Skywalkers in the circus records..."));
  }
}
