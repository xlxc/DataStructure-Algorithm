package utils;

import java.io.*;

/**
 * @author: xuejing
 * @date: 2021/03/20 15:25
 */
public class 输入输出方式 {

    public static void main(String[] args) throws IOException {
        // 使用bufferReader 和 bufferWriter 来替代 Scanner 进行输入输出，效率会更快
        // 当然要注意，在使用 bufferWriter 进行输出的时候，最后需要在 write() 方法之后调用 flush(),才可以
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        System.out.println("请输出一串字符串");
        String str = br.readLine();
        bw.write("你好，你输入的结果是：" + str);
        bw.newLine();
        bw.write(str);
        bw.flush();
        br.close();
        bw.close();
    }
}
