public class MurderCase extends CrimeCase implements Investigable {

    private int victimsCount;
    private boolean weaponFound;

    public MurderCase(int caseId, String title, String location,
                      String investigator, int daysOpen,
                      int victimsCount, boolean weaponFound) {

        super(caseId, title, location, investigator, daysOpen);
        this.victimsCount = victimsCount;
        this.weaponFound = weaponFound;
    }

    public int getVictimsCount() {
        return victimsCount;
    }

    public boolean isWeaponFound() {
        return weaponFound;
    }

    @Override
    public String getCaseType() {
        return "Murder";
    }

    @Override
    public double calculatePriority() {
        double priority = victimsCount * 50;

        if (!weaponFound) {
            priority += 20;
        }

        return priority;
    }

    @Override
    public void collectEvidence() {
        System.out.println("Collecting evidence in murder case "
                + getCaseId());
    }

    @Override
    public void interviewWitness(String witnessName) {
        System.out.println("Interviewing witness: " + witnessName);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Case type: " + getCaseType());
        System.out.println("Victims: " + victimsCount);
        System.out.println("Weapon found: " + weaponFound);
    }

    public void findWeapon() {
        weaponFound = true;
        System.out.println("Weapon found in case " + getCaseId());
    }

    public void orderAutopsy() {
        System.out.println("Autopsy ordered for case " + getCaseId());
    }
}