package package08_EstruturasDeDados1.challenge.entities;

public class TaxPayer {

	private double salaryInCome;
	private double servicesInCome;
	private double capitalIncome;
	private double healthSpending;
	private double educantionSpending;

	public TaxPayer() {
	}

	public TaxPayer(double salaryInCome, double servicesInCome, double capitalIncome, double healthSpending,
			double educantionSpending) {

		this.salaryInCome = salaryInCome;
		this.servicesInCome = servicesInCome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educantionSpending = educantionSpending;
	}

	public double salaryTax() {

		double salaryTax = getSalaryInCome() / 12;

		if (salaryTax < 3000.0) {
			salaryTax = getSalaryInCome() * 0.0;
		} else if (salaryTax < 5000.0) {
			salaryTax = getSalaryInCome() * 0.10;
		} else if (salaryTax > 5000.0) {
			salaryTax = getSalaryInCome() * 0.20;
		}
		return salaryTax;
	}

	public double servicesTax() {
		return getServicesInCome() * 0.15;
	}

	public double capitalTax() {
		return getCapitalIncome() * 0.20;
	}

	public double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}

	public double taxRebate() {
		double taxRebate = 0.0;
		double maxTaxRebate = grossTax() * 0.30;
		double deductiveExpenses = getEducantionSpending() + getHealthSpending();

		if (deductiveExpenses > maxTaxRebate) {
			taxRebate = maxTaxRebate;
		} else {
			taxRebate = deductiveExpenses;
		}
		return taxRebate;
	}

	public double netTax() {
		return grossTax() - taxRebate();
	}

	public double getSalaryInCome() {
		return salaryInCome;
	}

	public double getServicesInCome() {
		return servicesInCome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public double getEducantionSpending() {
		return educantionSpending;
	}

	public void setEducantionSpending(double educantionSpending) {
		this.educantionSpending = educantionSpending;
	}

}
