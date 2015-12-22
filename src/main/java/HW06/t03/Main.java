package HW06.t03;

import java.util.ArrayList;
import java.util.List;

/**
 * ������� ���������� � ������������ ���������. ����� ������ ���������.
 */
public class Main {
    public static void main(String[] args) {
        //correct
        Doctor doctor1 = new Doctor();

        /**incorrect
         * ��� ������ "���" �������
         */
//        Doctor doctor2 = new MedicalStaff();

        //correct
        Doctor doctor3 = new HeadDoctor();

        //correct
        Object object1 = new HeadDoctor();

        /**incorrect
         * ��� ������ "���" �������
         */
//        HeadDoctor doctor5 = new Object();

        /**incorrect
         * "sibling" - ������
         */
//        Doctor doctor6  = new Nurse();

        /**incorrect
         * "sibling" - ������
         */
//        Nurse nurse = new Doctor();

        Object object2 = new Nurse();

        //correct
        List<Doctor> list1= new ArrayList<Doctor>();

        /**incorrect
         * ��������� ���������� ��������� � ������ � �������
         */
//        List<MedicalStaff> list2 = new ArrayList<Doctor>();

        /**incorrect
         * ��������� ���������� ��������� � ������ � �������
         */
//        List<Doctor> list3 = new ArrayList<MedicalStaff>();

        /**incorrect
         * ��������� ���������� ��������� � ������ � �������
         */
//        List<Object> list4 = new ArrayList<Doctor>();

        //correct
        List<Object> list5 = new ArrayList<Object>();
    }
}
