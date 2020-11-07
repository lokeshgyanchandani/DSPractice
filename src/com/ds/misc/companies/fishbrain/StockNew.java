package com.ds.misc.companies.fishbrain;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class StockNew {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int numBands = Integer.parseInt(scanner.nextLine());
		double taxBands[][] = new double[numBands][2];
		for (int i = 0; i < numBands; i++) {
			String taxBand = scanner.nextLine();
			taxBands[i][0] = Double.parseDouble(taxBand.split(" ")[0]);
			taxBands[i][1] = Double.parseDouble(taxBand.split(" ")[1]) / 100;
		}
		double maxTaxBand = Double.parseDouble(scanner.nextLine()) / 100;
		int numInputs = Integer.parseInt(scanner.nextLine());
		DecimalFormat df = new DecimalFormat("#.######");
		df.setRoundingMode(RoundingMode.FLOOR);
		double outputs[] = new double[numInputs];
		for (int i = 0; i < numInputs; i++) {
			String money = scanner.nextLine();
			double moneyEarned = Double.parseDouble(money.split(" ")[0]);
			double tax = 0;
			double moneyPostTax = Double.parseDouble(money.split(" ")[1]);

			for (int j = 0; j < numBands; j++) {
				if ((moneyEarned = moneyEarned - taxBands[j][0]) <= 0) {
					if (moneyEarned + (moneyPostTax / (1 - taxBands[j][1])) < 0) {
						tax = tax + moneyPostTax / (1 - taxBands[j][1]);
						moneyPostTax = 0;
						break;
					} else {
						tax = tax - moneyEarned;
						moneyPostTax = moneyPostTax - moneyEarned * taxBands[j][1] + moneyEarned;
						moneyEarned = 0;
					}
				}
			}
			if (moneyPostTax > 0) {
				tax = tax + moneyPostTax / (1 - maxTaxBand);
			}
			outputs[i] = Double.parseDouble(df.format(tax));
		}
		for (int i = 0; i < numInputs; i++)
			System.out.printf("%.6f\n", outputs[i]);
	}
}
