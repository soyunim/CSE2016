import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Select extends JFrame {
    private JButton easy = new JButton("EASY(3*3)");
    private JButton normal = new JButton("NORMAL(4*4)");
    private JButton hard = new JButton("HARD(5*5)");
    private JButton back = new JButton("뒤로가기");

    public Select() {
        this.setTitle("난이도선택");
        this.setSize(351,400);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        add(easy); easy.setSize(330,50); easy.setLocation(10,20);
        add(normal); normal.setSize(330,50); normal.setLocation(10,80);
        add(hard); hard.setSize(330,50); hard.setLocation(10, 140);
        add(back); back.setSize(330,50); back.setLocation(10, 300);
        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ea) {
                try{
                    dispose();
                    easyFrame();
                }catch(Exception a){}
            }
        });

        normal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent no) {
                try{
                    dispose();
                    normalFrame();;
                }catch(Exception a){}
            }
        });

        hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent h) {
                try{
                    dispose();
                    hardFrame();
                }catch(Exception a){}
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ea) {
                try{
                    dispose();
                    backFrame();
                }catch(Exception e){}
            }
        });

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    void easyFrame(){
        Easy easy = new Easy();
        easy.setVisible(true);
    }

    void normalFrame(){
        Normal normal = new Normal();
        normal.setVisible(true);
    }

    void hardFrame(){
        Hard hard = new Hard();
        hard.setVisible(true);
    }
    void backFrame(){
        Start start = new Start();
        start.setVisible(true);
    }
    public static void main(String[] args) {
        Select select = new Select();
    }
}