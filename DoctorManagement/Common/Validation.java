
package Common;

import Model.Doctor;
import java.util.ArrayList;

public class Validation {
    public boolean checkDuplicate(ArrayList<Doctor> ld, String name, String specialization, int availability) {
        for (Doctor doctor : ld) {
            if (name.equalsIgnoreCase(doctor.getName())
                    && specialization.equalsIgnoreCase(doctor.getSpecialization())
                    && availability == doctor.getAvailability()) {
                return false;
            }
        }
        return true;
    }

    public boolean checkCodeExist(ArrayList<Doctor> ld, String code) {
        for (Doctor doctor : ld) {
            if (code.equalsIgnoreCase(doctor.getCode())) {
                return false;
            }
        }
        return true;
    }
}
