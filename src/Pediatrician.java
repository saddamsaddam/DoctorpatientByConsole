// Pediatrician.java
public class Pediatrician extends Doctor {
    private boolean hasPrivatePractice;
    private String hospitalName;

    public Pediatrician(String name) {
        super(name);
        this.hasPrivatePractice = false;
        this.hospitalName = "";
    }

    public Pediatrician(String name, boolean hasPrivatePractice, String hospitalName) {
        super(name);
        this.hasPrivatePractice = hasPrivatePractice;
        this.hospitalName = hospitalName;
    }

    public boolean hasPrivatePractice() {
        return hasPrivatePractice;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    @Override
    public void addPatient(Patient p) throws PatientException {
        int currentYear = java.time.Year.now().getValue();
        int patientAge = currentYear - p.getBirthYear();
        
        if (patientAge >= 18) {
            throw new PatientException("Pediatrician can only treat patients under 18 years old");
        }
        super.addPatient(p);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nPediatrician: %s | hospital name=%15s", 
                (hasPrivatePractice ? "has private practice" : "does not have private practice"), 
                hospitalName);
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (o instanceof Pediatrician) {
            Pediatrician other = (Pediatrician) o;
            return this.hasPrivatePractice == other.hasPrivatePractice && 
                   this.hospitalName.equals(other.hospitalName);
        }
        return false;
    }
}