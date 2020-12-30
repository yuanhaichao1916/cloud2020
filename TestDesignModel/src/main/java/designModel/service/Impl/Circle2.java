package designModel.service.Impl;

import designModel.service.IShape2;

import java.util.Vector;

public class Circle2 implements IShape2 {
    static Vector<String> vec = new Vector<>();
    static {
        vec.add("getArea");
        vec.add("getPerimeter");
    }
    public float r;

    public Circle2() {
    }

    public Circle2(float r) {
        this.r = r;
    }
    @Override
    public int query(String strId) {
        int nId = vec.indexOf(strId);
        return nId;
    }

    @Override
    public Object dispatch(int nId, Object in) {
        Object obj = null;
        switch (nId) {
            case 0:
              obj = getArea(in);break;
            case 1:
              obj = getPerimeter(in);break;
        }
        return obj;
    }

    // 非多态方法
    Object getArea(Object in){
      float area = (float)Math.PI*r*r;
      return new Float(area);
    }
    // 非多态方法
    Object getPerimeter(Object in){
        float area = (float)Math.PI*r*2.0f;
        return new Float(area);
    }
}
