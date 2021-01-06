package designModel.service.Impl.factory;
// 图像基本信息文件
public class ImageInfo {
    private int width;  // 图像宽度
    private int height;  // 图像高度
    private int r[][];  // 红色分量
    private int g[][];  // 绿色分量
    private int b[][];  // 蓝色分量

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[][] getR() {
        return r;
    }

    public void setR(int[][] r) {
        this.r = r;
    }

    public int[][] getG() {
        return g;
    }

    public void setG(int[][] g) {
        this.g = g;
    }

    public int[][] getB() {
        return b;
    }

    public void setB(int[][] b) {
        this.b = b;
    }

    public void  setRGB(int rgb[]){
        r = new int[height][width];
        g = new int[height][width];
        b = new int[height][width];

        int pos = 0;
        for (int i = 0; i < height; i++) {
            pos = width*i;
            for (int j = 0; j < width; j++) {
                r[i][j] = (rgb[pos+j]&0xff0000)>>16;
                g[i][j] = (rgb[pos+j]&0x00ff00)>>8;
                b[i][j] = rgb[pos+j]&0x0000ff;
            }
        }
    }
}
