
package Repository;

import Model.Doctor;
import java.util.ArrayList;

public interface IDoctorRepository {
    void addDoctor(ArrayList<Doctor> ld);

    void updateDoctor(ArrayList<Doctor> ld);

    void deleteDoctor(ArrayList<Doctor> ld);

    void searchDoctor(ArrayList<Doctor> ld);
}
