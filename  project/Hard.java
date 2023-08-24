import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.*;

public class Hard extends JFrame {
    private JButton back = new JButton("뒤로가기");
    private Hardmode hardmode = new Hardmode();

    public Hard() {
        setTitle("Hard Mode");
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

        hardmode.setLayout(new BoxLayout(hardmode, BoxLayout.Y_AXIS));

        add("Center", hardmode);
        setVisible(true);
    }

    void backFrame() {
        Select select = new Select();
        select.setVisible(true);
    }

    public static void main(String[] args) {
        Hard hard = new Hard();
    }

}

class Hardmode extends JPanel implements MouseListener {
    public void mouseReleased(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }

    public int[][] data = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 0}};
    public Random rand;
    public Hardmode() {
        addMouseListener(this);
        rand = new Random();
        for (int i = 0; i < 100; i++) {
            init();
        }
    }

    public void mousePressed(MouseEvent e) {
        int size = 70;
        int x = e.getX() / size;
        int y = e.getY() / size;
        move(x, y);
        checkanswer();
    }

    public void paint(Graphics g) { //숫자패드가 화면에 보이게 하는 거.
        paintComponents(g);
        int size = 70;
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                String str = Integer.toString(data[y][x]);
                int dx = x * size;
                int dy = y * size;
                g.drawRect(dx, dy, size, size);
                if (data[y][x] != 0) {
                    g.drawString(str, dx + size / 2, dy + size / 2);
                }
            }
        }
    }

    public void checkanswer() {
        int x, y, n;
        n = 1;
        for (x = 0; x < 5; x++) {
            for (y = 0; y < 5; y++) {
                if (n != data[x][y]) {
                    return;
                }
                if (n == 24) {
                    n = 0;
                } else {
                    n++;
                }
            }
        }

        JOptionPane.showMessageDialog(this, "*^^*", "success!", JOptionPane.INFORMATION_MESSAGE);
    }



    public void move(int x, int y) {
        try {
            if ((y - 1) >= 0) {
                if (data[y - 1][x] == 0) {
                    data[y - 1][x] = data[y][x];
                    data[y][x] = 0;
                    repaint();
                    return;
                }
            }
            if ((y + 1) <= 4) {
                if (data[y + 1][x] == 0) {
                    data[y + 1][x] = data[y][x];
                    data[y][x] = 0;
                    repaint();
                    return;
                }
            }
            if ((x + 1) <= 4) {
                if (data[y][x + 1] == 0) {
                    data[y][x + 1] = data[y][x];
                    data[y][x] = 0;
                    repaint();
                    return;
                }
            }
            if ((x - 1) >= 0) {
                if (data[y][x - 1] == 0) {
                    data[y][x - 1] = data[y][x];
                    data[y][x] = 0;
                    repaint();
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }



    public void init() { //서버가 켜질 때 한 번만 실행 ,, 랜덤으로 숫자배열하는 거
        int count, x, y, ran;
        int temp;
        for (count = 0; count < 100; count++) {
            x = rand.nextInt(5);
            y = rand.nextInt(5);
            ran = rand.nextInt(4);
            try {
                if ((x + 1) <= 4 || (x - 1) >= 0 || (y + 1) <= 4 || (y - 1) >= 0) {
                    if (ran == 0) {
                        if ((x - 1) >= 0) {
                            temp = data[y][x - 1];
                            data[y][x - 1] = data[y][x];
                            data[y][x] = temp;
                            repaint();
                            return;
                        }
                    }
                    if (ran == 1) {
                        if ((x + 1) < 5) {
                            temp = data[y][x + 1];
                            data[y][x + 1] = data[y][x];
                            data[y][x] = temp;
                            repaint();
                            return;
                        }
                    }
                    if (ran == 2) {
                        if ((y - 1) >= 0) {
                            temp = data[y - 1][x];
                            data[y - 1][x] = data[y][x];
                            data[y][x] = temp;
                            repaint();
                            return;
                        }
                    }
                    if (ran == 3) {
                        if ((y + 1) < 5) {
                            temp = data[y + 1][x];
                            data[y + 1][x] = data[y][x];
                            data[y][x] = temp;
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}