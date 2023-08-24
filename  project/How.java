import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class How extends JFrame{
    private JButton back = new JButton("뒤로가기");
    private JButton start = new JButton("게임시작");
    JLabel text = new JLabel("<html>숫자를 순서대로 배열하는 게임이다.<br>작은 숫자부터 차례로 왼쪽에서부터 오른쪽으로 배열한다.<br>" +
            "마지막 자리에는 빈칸이 오도록 한다.<br>" +
            "<br>(예시)<br>[EASY MODE]<br>1 2 3<br>4 5 6<br>7 8 0<br><br>0의 자리에 빈 칸이 오도록 한다.</html>", SwingConstants.CENTER);

    public How() {
        setTitle("게임방법");
        setSize(351, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add("North", back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ea) {
                try {
                    dispose();
                    backFrame();
                } catch (Exception e) { }
            }
        });
        add("South", start);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ea) {
                try {
                    dispose();
                    selectFrame();
                } catch (Exception e) { }
            }
        });

        add("Center", text);
        setVisible(true);
    }

    void backFrame() {
        Start start = new Start();
        start.setVisible(true);
    }
    void selectFrame(){
        Select select = new Select();
        select.setVisible(true);
    }
        public static void main(String[] args){
            How how = new How();
        }
    }