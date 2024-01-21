package package08_EstruturasDeDados1.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import package08_EstruturasDeDados1.challenge.entities.TaxPayer;

public class AppContribuintes {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);

		TaxPayer taxPayer = new TaxPayer();
		List<TaxPayer> taxPayerList = new ArrayList<>();

		System.out.print("Quantos contribuintes você vai digitar? "); 

		int n = scan.nextInt();

		double salaryInCome, servicesInCome, capitalInCome, healthSpeding, educationSpeding;

		for (int i = 0; i < n; i++) {
			System.out.println("\nDigite os dados do " + (i + 1) + "º contribuinte:");
			System.out.print("Renda anual com salário: ");
			salaryInCome = scan.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			servicesInCome = scan.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			capitalInCome = scan.nextDouble();
			System.out.print("Gastos médicos: ");
			healthSpeding = scan.nextDouble();
			System.out.print("Gastos educacionais: ");
			educationSpeding = scan.nextDouble();

			taxPayer = new TaxPayer(salaryInCome, servicesInCome, capitalInCome, healthSpeding, educationSpeding);

			taxPayerList.add(taxPayer);
		}
		System.out.println();
		for (int i = 0; i < taxPayerList.size(); i++) {
			System.out.println("Resumo do " + (i + 1) + "º contribuinte:");
			System.out.printf("Imposto bruto total: %.2f\n", taxPayerList.get(i).grossTax());
			System.out.printf("Abatimento: %.2f\n", taxPayerList.get(i).taxRebate());
			System.out.printf("Imposto devido: %.2f\n\n", taxPayerList.get(i).netTax());
		}
		scan.close();
	}
}
