import designModel.service.Impl.ShapeProc;
import designModel.service.Ishape;

import java.io.FileInputStream;
import java.util.Properties;

public class Shape3Test {
    public static void main(String[] args) throws Exception {
  /*      Ishape ishape = null;
        ishape = (Ishape) Class.forName(args[0]).getConstructor().newInstance();
        ShapeProc shapeProc = new ShapeProc(ishape);
        float process = shapeProc.process();
        System.out.println("所求面积是：" + process);*/


        Properties p = new Properties();
        // xml 格式
        p.loadFromXML(new FileInputStream("d:/shaper.properties"));
        // properties格式 k-v
        p.load(new FileInputStream("d:/shaper.properties")); //装配配置文件
        // 根据键"shape"，获取类名字符串
        String cname = p.getProperty("shape");
        Ishape shape = null;
        shape = (Ishape)Class.forName(cname).getConstructor().newInstance();
        ShapeProc shapeProc = new ShapeProc(shape);
        float process = shapeProc.process();
        System.out.println("所求面积是：" + process);
    }
}
