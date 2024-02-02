
package Repository;

import Model.Doctor;
import DataAcess.DoctorDAO;
import java.util.ArrayList;

public class DoctorRepository implements IDoctorRepository {
    @Override
    public void addDoctor(ArrayList<Doctor> ld) {
        DoctorDAO.Instance().addDoctor(ld);
    }

    @Override
    public void updateDoctor(ArrayList<Doctor> ld) {
        DoctorDAO.Instance().updateDoctor(ld);
    }

    @Override
    public void deleteDoctor(ArrayList<Doctor> ld) {
        DoctorDAO.Instance().deleteDoctor(ld);
    }

    @Override
    public void searchDoctor(ArrayList<Doctor> ld) {
        DoctorDAO.Instance().searchDoctor(ld);
    }
}
