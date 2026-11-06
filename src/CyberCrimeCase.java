public class CyberCrimeCase extends CrimeCase implements Reportable {

    private String attackType;
    private int affectedUsers;

    public CyberCrimeCase(int caseId, String title, String location,
                          String investigator, int daysOpen,
                          String attackType, int affectedUsers) {

        super(caseId, title, location, investigator, daysOpen);
        this.attackType = attackType;
        this.affectedUsers = affectedUsers;
    }

    public String getAttackType() {
        return attackType;
    }

    public int getAffectedUsers() {
        return affectedUsers;
    }

    @Override
    public String getCaseType() {
        return "Cyber crime";
    }

    @Override
    public double calculatePriority() {
        return affectedUsers / 10.0;
    }

    @Override
    public double calculateDamage() {
        return affectedUsers * 10.0;
    }

    @Override
    public void generateReport() {
        System.out.println("Cyber crime report: " + attackType
                + ", affected users: " + affectedUsers
                + ", damage: " + calculateDamage());
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Case type: " + getCaseType());
        System.out.println("Attack type: " + attackType);
        System.out.println("Affected users: " + affectedUsers);
    }

    public void blockAttack() {
        System.out.println("Attack blocked: " + attackType);
    }

    public void traceIpAddress() {
        System.out.println("Tracing IP address for case " + getCaseId());
    }
}