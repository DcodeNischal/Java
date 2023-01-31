import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomDialog {
    static JDialog d;
    static JLabel l;
    static JButton btn;

    public static void newDialog(JFrame frame, String message, String title) {
        d = new JDialog(frame, title, true);
        d.setSize(300, 150);
        d.setLayout(new FlowLayout());
        l = new JLabel(message);
        btn = new JButton("OK");
        d.add(btn);
        d.add(l);
        l.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        d.setLocationRelativeTo(frame);
        d.setLayout(new BoxLayout(d.getContentPane(), BoxLayout.Y_AXIS));
        d.setVisible(true);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.dispose();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Message");
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton btn = new JButton("Click");
        frame.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomDialog.newDialog(frame, "Hello", "Message");
            }
        });
        frame.setVisible(true);
    }
}