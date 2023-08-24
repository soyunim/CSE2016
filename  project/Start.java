import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start extends JFrame {
    private JButton start = new JButton("게임시작");
    private JButton how = new JButton("게임방법");

    public Start() {
        setTitle("순서맞추기게임");
        setSize(351,400);
        setLayout(null);
        setLocationRelativeTo(null);

        add(start); start.setSize(300,100); start.setLocation(25,70);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ea) {
                try{
                    dispose();
                    nextFrame();
                }catch(Exception e){}
            }
        });

        add(how); how.setSize(300,100); how.setLocation(25,190);
        how.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ea) {
                try{
                    dispose();
                    howFrame();
                }catch(Exception e){}
            }
        });

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void nextFrame(){
        Select select = new Select();
        select.setVisible(true);
    }

    void howFrame(){
        How how = new How();
        how.setVisible(true);
    }

    public static void main(String[] args) {
        Start start = new Start();
    }
}