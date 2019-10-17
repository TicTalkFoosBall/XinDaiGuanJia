package hxz.www.commonbase.util;

import java.io.File;

/**
 * Created by Jay on 2018/2/9.
 * <p>
 * Note:
 */
public class ModifyFileName {

    public static void main(String[] args) {
        start();
    }

    static String rootPath = "D:\\aaaaaaa\\播放语音序列";

    static String oldStr = "msg_chatdetail_gif_playvoice_0";
    static String newStr = "voice_playing_";

    public static void start() {
        try {
            File file = new File(rootPath);  //实验报告存放路径
            String[] fileName = file.list();  //用于存放文件底下所有子文件名的数组
            for (int i = 0; i < fileName.length; i++) {
                String name = fileName[i] ;
//                if (name.contains(oldStr)) {
//                    System.out.println("File exist: " + i);
//                } else {
//                    System.out.println("File does not exist: " + i);
//                    continue;
//                }
                System.out.println(name);
                //开始重命名
                File toBeRenamed = new File(rootPath, name);
                //检查要重命名的文件是否存在
                if (!toBeRenamed.exists()) {
                    System.out.println("File does not exist: " + i);
                    return;
                }

//                oldStr = "ic_live_in_level_"+name;
                //修改文件名                                                                                                              icon_anchor_grade0          ic_anchor_level_0
                File newFile = new File(rootPath, name.replace(oldStr, newStr));
//                File newFile = new File(rootPath, oldStr);
                if (toBeRenamed.renameTo(newFile)) {
                    System.out.println("File renamed success!!.");
                } else {
                    System.out.println("Error renmaing file");
                }

//                Logs.e("filename", fileName.length + ";;;;;;;;;;" + fileName[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
