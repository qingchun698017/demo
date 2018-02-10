package designPatterns.proxyPattern;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 代理模式：为另一个对象提供一个替身或占位符以控制对这个对象的访问
 */
public class Test {
    public Test() throws MalformedURLException {
        Icon icon = new ImageProxy(new URL(""));
        Component component = new Component() {
        };
        Frame frame = new Frame();
        frame.setVisible(true);
        frame.add(component);

    }
}
