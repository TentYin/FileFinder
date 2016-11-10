import java.io.*;
import java.util.*;
/**
 * Created by Administrator(TentYin) on 11/9/2016.
 */
public class NoteFinder{
    public static void main(String[] args)throws IOException{
        System.out.println("Please input file path: ");
        Scanner sc=new Scanner(System.in );
        String filePath=null;
        filePath=sc.nextLine();
        ReadTxtFile(filePath);
        System.out.println("FilePath: "+filePath);
        System.out.println("Please input the keyword that you want to find: ");
        Scanner scn=new Scanner(System.in );
        String keyWord=null;
        keyWord=scn.nextLine();
        new NoteFinder().FindKeyWord(filePath,keyWord);
    }
    public static void ReadTxtFile(String filePath) {
        try {
            String encoder="GBK";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoder);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineResult = null;
                while((lineResult = bufferedReader.readLine()) != null){
                    System.out.println(lineResult);
                }
                read.close();
            }
            else{
                System.out.println("NoteFinder cannot find the file specified, please check your path then try again");
                System.out.println("PS:是不是忘打[ .txt] 了╮(╯▽╰)╭");
            }
        } catch (Exception e) {
            System.err.println("Error:");
            e.printStackTrace();//上周听了两个小时课这周开始做作业时我就记得个catch error ╮(╯▽╰)╭
        }
    }
    public void FindKeyWord(String filePath,String keyWord)throws IOException {
        try {
            String encoder="GBK";
            File file=new File(filePath);
            if(file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoder);
                BufferedReader bufferedReader = new BufferedReader(read);
                String next = null;
                int line = 1;
                while ((next = bufferedReader.readLine()) != null) {
                    if (next.indexOf(keyWord) > -1) {
                        System.out.println("Number" + line + "Line:  " + next);
                    }
                    line++;
                }
            }
            else {
                System.out.println("NoteFinder cannot find the file specified, please check your path then try again");
            }
        }catch (Exception e){
            System.err.println("Error:");
            e.printStackTrace();
        }
    }
}
