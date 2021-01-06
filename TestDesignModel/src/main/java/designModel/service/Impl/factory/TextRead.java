package designModel.service.Impl.factory;

import designModel.service.IRead;

import java.io.File;
import java.io.FileInputStream;

public class TextRead implements IRead<String> {
    @Override
    public void read(String fileName) {

    }
    // 读取文本
    public String read(String ... in){  // 可输入0或多个参数
        String result = null;   //result是结果串
        try {
            File file = new File(in[0]);    // in[0] 表示文件名称
            long length = file.length();
            FileInputStream input = new FileInputStream(in[0]);
            byte buf[] = new byte[(int) length]; // 缓冲区大小等于文件长度
            input.read(buf);                     // 一次读完文件
            result = new String(buf, in[1]);     // 按in[1]编码方式转化成可见字符串
            input.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }
}
