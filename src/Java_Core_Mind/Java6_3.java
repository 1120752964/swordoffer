package Java_Core_Mind;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;
import javax.swing.*;
public class Java6_3 {
    public static void main(String[] args) {
        //创建一个timer调用listener  一秒一次
        var listener = new TimerPrinter();
        var timer = new Timer(1000,listener);
        timer.start();

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);

    }
}
class TimerPrinter implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("time"+ Instant.ofEpochMilli(e.getWhen()));
        Toolkit.getDefaultToolkit().beep();
    }
}