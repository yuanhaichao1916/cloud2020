package designModel.service.Impl;

import designModel.entities.Student;
import designModel.service.ILess;
import org.springframework.stereotype.Service;

@Service
public class StudentLess implements ILess<Student> {
    @Override
    public boolean less(Student x, Student y) {
        return x.getGrade() < y.getGrade();
    }
}
