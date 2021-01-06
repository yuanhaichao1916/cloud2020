package designModel.service.Impl.factory;

import designModel.service.IRead;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageRead implements IRead<ImageInfo> {

    @Override
    public void read(String fileName) {
        String readSuffix[] = ImageIO.getReaderFileSuffixes();
        for (int i = 0; i < readSuffix.length; i++) {
            System.out.println(readSuffix[i]);
        }
        String[] writerFileSuffixes = ImageIO.getWriterFileSuffixes();
        for (int i = 0; i < writerFileSuffixes.length; i++) {
            System.out.println(writerFileSuffixes[i]);
        }
    }

    public ImageInfo read(String ... in){
        BufferedImage bi = null;
        File f = new File(in[0]);
        try {
           bi = ImageIO.read(f);
        } catch (Exception e){
            e.printStackTrace();
        }
        int width = bi.getWidth();
        int height = bi.getHeight();
        int[] rgb = new int[width * height];
        // 将图像数据读到result 缓冲区
        bi.getRGB(0,0, width, height, rgb, width, height);
        ImageInfo obj = new ImageInfo();
        obj.setWidth(width);
        obj.setHeight(height);
        obj.setRGB(rgb);
        return obj;
    }

}
