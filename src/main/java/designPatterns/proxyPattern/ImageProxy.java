package designPatterns.proxyPattern;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * 图片代理类：在图片加载前显示请等待，图片加载后显示真正的图片。
 */
public class ImageProxy implements Icon{
    ImageIcon imageIcon;
    URL imageUrl;
    Thread retrievalThread;
    boolean retrieving = false;//是否正常加载图片

    public ImageProxy(URL imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        if(imageIcon != null){
            imageIcon.paintIcon(c,g,x,y);
        }else{
           g.drawString("Loading CD cover,please wait...",x+300,y+190);
           if(!retrieving){
               retrieving = true;
               retrievalThread = new Thread(new Runnable() {
                   @Override
                   public void run() {
                        imageIcon = new ImageIcon(imageUrl,"CD over");
                        c.repaint();
                   }
               });
               retrievalThread.start();
           }
        }
    }

    @Override
    public int getIconWidth() {
        if(imageIcon != null){
            return imageIcon.getIconWidth();
        }else{
            return 800;
        }
    }

    @Override
    public int getIconHeight() {
        if(imageIcon != null){
            return imageIcon.getIconHeight();
        }else{
            return 600;
        }
    }
}
