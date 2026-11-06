public class TheftCase extends CrimeCase
        implements Investigable, Reportable {

    private double stolenValue;
    private int itemsCount;

    public TheftCase(int caseId, String title, String location,
                     String investigator, int daysOpen,
                     double stolenValue, int itemsCount) {

        super(caseId, title, location, investigator, daysOpen);
        this.stolenValue = stolenValue;
        this.itemsCount = itemsCount;
    }

    public double getStolenValue() {
        return stolenValue;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    @Override
    public String getCaseType() {
        return "Theft";
    }

    @Override
    public double calculatePriority() {
        return stolenValue / 1000;
    }

    @Override
    public double calculateDamage() {
        return stolenValue;
    }

    @Override
    public void collectEvidence() {
        System.out.println("Collecting evidence for theft case "
                + getCaseId());
    }

    @Override
    public void interviewWitness(String witnessName) {
        System.out.println("Interviewing witness: " + witnessName);
    }

    @Override
    public void generateReport() {
        System.out.println("Theft report: " + stolenValue
                + " damage, " + itemsCount + " stolen items.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Case type: " + getCaseType());
        System.out.println("Stolen value: " + stolenValue);
        System.out.println("Items count: " + itemsCount);
    }

    public double calculateAverageItemValue() {
        if (itemsCount == 0) {
            return 0;
        }

        return stolenValue / itemsCount;
    }

    public void recoverItems(int count) {
        if (count > 0 && count <= itemsCount) {
            itemsCount -= count;
            System.out.println(count + " items recovered.");
        }
    }
}