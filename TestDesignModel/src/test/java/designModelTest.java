import designModel.controller.Algo;
import designModel.entities.Student;
import designModel.service.ILess;
import designModel.service.Impl.InteLess;
import designModel.service.Impl.StudentLess;


public class designModelTest {
    public static void main(String[] args) {
        Algo<Integer> obj = new Algo<>();
        ILess<Integer> cmp = new InteLess();
        Integer a[] = {3,9,2,8};
        Integer max = obj.getMax(a, cmp);
        System.out.println("integer max = "+ max);

        Algo<Student> obj2 = new Algo<>();
        ILess<Student> cmp2 = new StudentLess();
        Student s[] = {new Student("li",70),new Student("sun",90),
                        new Student("zhao",80)};
        Student max2 = obj2.getMax(s, cmp2);
        System.out.println("Student max grade ：" + max2.getGrade());
    }
}
