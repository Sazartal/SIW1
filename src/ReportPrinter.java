public class ReportPrinter {

    public void printReport(CrimeCase crimeCase) {
        if (crimeCase == null) {
            System.out.println("Error: case not found.");
            return;
        }

        System.out.println("===== CRIME CASE REPORT =====");
        crimeCase.displayInfo();

        if (crimeCase instanceof Reportable) {
            Reportable reportable = (Reportable) crimeCase;
            reportable.generateReport();
        } else {
            System.out.println("No additional report available.");
        }

        System.out.println("=============================");
    }
}