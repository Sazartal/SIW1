public class Main {

    public static void main(String[] args) {

        CrimeCaseService service = new CrimeCaseService();

        Investigator investigator1 =
                new Investigator("John Smith", "Detective");

        Investigator investigator2 =
                new Investigator("Anna Brown", "Senior Detective");

        PoliceDepartment department =
                new PoliceDepartment("Central Police Department");

        department.addInvestigator(investigator1);
        department.addInvestigator(investigator2);

        TheftCase theft = new TheftCase(
                1, "Stolen Car", "Bishkek",
                "John Smith", 10, 15000, 3);

        MurderCase murder = new MurderCase(
                2, "Murder Investigation", "Bishkek",
                "Anna Brown", 20, 1, false);

        CyberCrimeCase cyber = new CyberCrimeCase(
                3, "Online Fraud", "Internet",
                "John Smith", 5, "Phishing", 200);

        service.addCase(theft);
        service.addCase(murder);
        service.addCase(cyber);

        department.addCase(theft);
        department.addCase(murder);
        department.addCase(cyber);

        System.out.println("\n===== ALL CASES =====");
        service.showAllCases();

        System.out.println("\n===== INVESTIGATORS =====");
        department.showInvestigators();

        System.out.println("\n===== SEARCH CASE =====");
        CrimeCase found = service.findCase(2);

        if (found != null) {
            found.displayInfo();
        }

        System.out.println("\n===== SORT BY ID =====");
        service.sortById();

        System.out.println("\n===== SORT BY PRIORITY =====");
        service.sortByPriority();

        System.out.println("\n===== SORT BY DAYS OPEN =====");
        service.sortByDaysOpen();

        System.out.println("\n===== CASES BY TYPE =====");
        service.showCasesByType();

        System.out.println("\n===== REPORT =====");
        ReportPrinter printer = new ReportPrinter();
        printer.printReport(theft);
        printer.printReport(cyber);

        System.out.println("\n===== INTERFACES =====");
        theft.collectEvidence();
        theft.interviewWitness("Michael");
        murder.collectEvidence();
        cyber.generateReport();

        System.out.println("\n===== CASE FILE =====");
        theft.addNote("Witness statement received.");
        theft.addNote("CCTV footage collected.");
        theft.getCaseFile().showNotes();

        System.out.println("\n===== UPDATE CASE =====");
        service.updateCaseDays(1, 15);

        System.out.println("\n===== PROCESS QUEUE =====");
        service.processNextCase();

        System.out.println("\n===== DELETE CASE =====");
        service.removeCase(3);

        System.out.println("\nTotal cases: " + service.getTotalCases());
        System.out.println("Unique cases: " + service.getUniqueCasesCount());
    }
}