package HW06.t03;

import java.util.ArrayList;
import java.util.List;

/**
 * Укажите корректные и некорректные операторы. Дайте ответу пояснение.
 */
public class Main {
    public static void main(String[] args) {
        //correct
        Doctor doctor1 = new Doctor();

        /**incorrect
         * тип ссылки "уже" объекта
         */
//        Doctor doctor2 = new MedicalStaff();

        //correct
        Doctor doctor3 = new HeadDoctor();

        //correct
        Object object1 = new HeadDoctor();

        /**incorrect
         * тип ссылки "уже" объекта
         */
//        HeadDoctor doctor5 = new Object();

        /**incorrect
         * "sibling" - классы
         */
//        Doctor doctor6  = new Nurse();

        /**incorrect
         * "sibling" - классы
         */
//        Nurse nurse = new Doctor();

        Object object2 = new Nurse();

        //correct
        List<Doctor> list1= new ArrayList<Doctor>();

        /**incorrect
         * требуются идентичные дженерики в ссылке и объекте
         */
//        List<MedicalStaff> list2 = new ArrayList<Doctor>();

        /**incorrect
         * требуются идентичные дженерики в ссылке и объекте
         */
//        List<Doctor> list3 = new ArrayList<MedicalStaff>();

        /**incorrect
         * требуются идентичные дженерики в ссылке и объекте
         */
//        List<Object> list4 = new ArrayList<Doctor>();

        //correct
        List<Object> list5 = new ArrayList<Object>();
    }
}
