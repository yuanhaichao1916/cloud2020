import designModel.service.Impl.Circle;
import designModel.service.Impl.Rect;
import designModel.service.Impl.ShapeProc;
import designModel.service.Ishape;

public class ShapeTest {
    public static void main(String[] args) {
        Ishape shape = new Circle();
        ShapeProc obj = new ShapeProc(shape);
        float process = obj.process();
        System.out.println("圆面积："+ process);

        Ishape ishape = new Rect();
        ShapeProc obj2 = new ShapeProc(ishape);
        float v = obj2.process();
        System.out.println("矩形面积"+v);
    }
}
