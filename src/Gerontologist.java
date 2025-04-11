// Gerontologist.java
public class Gerontologist extends Doctor {
    private boolean performsHouseCalls;
    private double visitFee;

    public Gerontologist(String name) {
        super(name);
        this.performsHouseCalls = true;
        this.visitFee = 0.0;
    }

    public Gerontologist(String name, boolean performsHouseCalls, double visitFee) {
        super(name);
        this.performsHouseCalls = performsHouseCalls;
        this.visitFee = visitFee;
    }

    public boolean performsHouseCalls() {
        return performsHouseCalls;
    }

    public double getVisitFee() {
        return visitFee;
    }

    public void setPerformsHouseCalls(boolean performsHouseCalls) {
        this.performsHouseCalls = performsHouseCalls;
    }

    public void setVisitFee(double visitFee) throws PatientException {
        if (visitFee < 0) {
            throw new PatientException("Visit fee cannot be negative");
        }
        this.visitFee = visitFee;
    }

	/*
	 * public void setVisitFee(double visitFee) { if (visitFee >= 0) { this.visitFee
	 * = visitFee; } else { this.visitFee = 0.0; } }
	 */
    
    @Override
    public void addPatient(Patient p) throws PatientException {
        int currentYear = java.time.Year.now().getValue();
        int patientAge = currentYear - p.getBirthYear();
        
        if (patientAge <= 65) {
            throw new PatientException("Gerontologist can only treat patients over 65 years old");
        }
        super.addPatient(p);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nGerontologist: %s | visit fee=%02.2f", 
                (performsHouseCalls ? "performs house calls" : "no house calls"), 
                visitFee);
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (o instanceof Gerontologist) {
            Gerontologist other = (Gerontologist) o;
            return this.performsHouseCalls == other.performsHouseCalls && 
                   Math.abs(this.visitFee - other.visitFee) < 0.05;
        }
        return false;
    }
}