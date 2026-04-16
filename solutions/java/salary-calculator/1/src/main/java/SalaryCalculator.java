public class SalaryCalculator {
    int baseSalary = 1000;
    public double salaryMultiplier(int daysSkipped) {
        if (daysSkipped>=5){
            return 0.85;
        }
        else{
            return 1.0;
        }
    }

    public int bonusMultiplier(int productsSold) {
        int multiplier = 10;
        if (productsSold>=20){
            multiplier = 13;
        }
        return multiplier;
    }

    public double bonusForProductsSold(int productsSold) {
        return productsSold * bonusMultiplier(productsSold);
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        double finalSalary = (baseSalary * salaryMultiplier(daysSkipped)) + bonusForProductsSold(productsSold);
        if (finalSalary>2000){
            finalSalary = 2000.0;
        }
        return finalSalary;
    }
}
