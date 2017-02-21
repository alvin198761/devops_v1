package org.alvin.auth.system.utils;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by tangzhichao on 2016/8/17.
 */
public class VerifyCodeUtil {

    private static String [] mapTable = getCodeArray();


    private static String [] getCodeArray(){
        List<String> list = new ArrayList<>();
        for (int i = 0 ;i <= 127 ;i++){
            String s = new String(Character.toChars(i));
            if(!s.matches("[0-9a-zA-Z]")){
                continue;
            }
            list.add(s);
        }
         return list.toArray(new String[0]);
    }


    public static String getCertPic(  OutputStream os) {
        int width =  60;
        int height = 25;
        if(width<=0)width=60;
        if(height<=0)height=20;
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        // 获取图形上下文
        Graphics g = image.getGraphics();
        // 设定背景色
        g.setColor(new Color(0xDCDCDC));
        g.fillRect(0, 0, width, height);
        //画边框
        g.setColor(Color.black);
        g.drawRect(0,0,width-1,height-1);
        // 取随机产生的认证码
        String strEnsure = "";
        // 4代表4位验证码,如果要生成更多位的认证码,则加大数值
        for(int i=0; i<4; ++i) {
            strEnsure+=mapTable[(int)(mapTable.length*Math.random())];
        }
        // 　　将认证码显示到图像中,如果要生成更多位的认证码,增加drawString语句
        g.setColor(Color.black);
        g.setFont(new Font("Atlantic Inline",Font.PLAIN,18));
        String str = strEnsure.substring(0,1);
        g.drawString(str,8,17);
        str = strEnsure.substring(1,2);
        g.drawString(str,20,15);
        str = strEnsure.substring(2,3);
        g.drawString(str,35,18);
        str = strEnsure.substring(3,4);
        g.drawString(str,45,15);
        // 随机产生10个干扰点
        Random rand = new Random();
        for (int i=0;i<10;i++) {
            int x = rand.nextInt(width);
            int y = rand.nextInt(height);
            g.drawOval(x,y,1,1);
        }
        // 释放图形上下文
        g.dispose();
        try {
            // 输出图像到页面
            ImageIO.write(image, "JPEG", os);
        } catch (IOException e) {
            return "";
        }
        return strEnsure;
    }
}
