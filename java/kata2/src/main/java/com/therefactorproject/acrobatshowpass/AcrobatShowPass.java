package com.therefactorproject.acrobatshowpass;

import java.util.Locale;

import static java.util.Locale.US;

public class AcrobatShowPass {
  private final String name;
  private final double basePrice;
  private final double taxRate;

  public AcrobatShowPass(String name, double basePrice, double taxRate) {
    this.name = name;
    this.basePrice = basePrice;
    this.taxRate = taxRate;
  }

  public void printAndArchive(int printerId) {

    var receipt = receiptFrom(this.basePrice, this.taxRate);

    println("🎟️ Printing on Acrobat Show printer #" + printerId);
    println("Show: " + name);

    println("======================");
    printf(US, "Base price: %.2f€\n", receipt.basePrice());
    printf(US, "Tax: %.2f€\n", receipt.tax());
    printf(US, "TOTAL: %.2f€\n", receipt.totalPrice());

    archive();
  }

  private static Receipt receiptFrom(double basePriceValue, double taxRateValue) {
    double taxValue = basePriceValue * (taxRateValue / 100);
    double totalPriceValue = basePriceValue + taxValue;
    return new Receipt(taxValue, totalPriceValue, basePriceValue, taxRateValue);
  }

  private record Receipt(double tax, double totalPrice, double basePrice, double taxRate){}

  private void archive() {
    System.out.println("🤸 Archiving Acrobat Show pass of " + name + " in the circus records...");
  }

  private void printf(Locale locale, String format, double totalPrice) {
    System.out.printf(locale, format, totalPrice);
  }

  private static void println(String x) {
    System.out.println(x);
  }
}
