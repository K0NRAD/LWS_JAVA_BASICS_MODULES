package schwarz.it.lws.java._001_004_system_io.find_the_bug;
/*
Task: Finde den Fehler

    Das folgende Programm ist ein einfacher Verkaufspreis-Rechner. Der Benutzer
    gibt den Nettoverkaufspreis und den Mehrwertsteuersatz in Prozent ein, das
    Programm gibt die Bruttoverkaufspreise aus.

Todo:

    Dem Programmierer ist es noch nicht gelungen das Programm zum Laufen zu bringen,
    unterstütze den Programmierer bei der Fehlersuche und der Behebung des Fehlers.

Bearbeitungszeit:

    10 Minuten
 */

import java.util.Scanner;

public class SalesPriceCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner("System.in");

        System.out.println("Sales Price Calculator");

        System.out.print("Enter net article price in euros:");
        float netArticlePrice = scanner.nextByte();

        System.out.print("Enter the value added tax in percent:");
        float addedTaxPercent = scanner.nextFloat();
        float valueAddedTax = netArticlePrice * addedTaxPercent * 0.01f;

        System.out.printf("The VAT is %.2f euros\n", valueAddedTax);
        float grossSellingPrice = netArticlePrice + valueAddedTax;

        System.out.printf("The gross selling price is %.2d euros", grossSellingPrice);
    }
}
