import designModel.service.IShape2;
import designModel.service.Impl.Circle2;

import java.awt.*;

public class Shape2Test {
    public static void main(String[] args) {
        IShape2 obj = new Circle2(10.f);
        int nId = obj.query("getArea");
//        IShape2 obj = new Circle2(10.f);
        float dispatch = (float) obj.dispatch(nId, null);
        System.out.println("半径10圆面积："+dispatch);
    }
}
