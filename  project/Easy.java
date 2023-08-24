import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.*;

public class Easy extends JFrame {
    private JButton back = new JButton("뒤로가기");
    private Easymode easymode = new Easymode();

    public Easy(){
        setTitle("Easy Mode");
        setSize(351, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add("North",back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ea) {
                try{
                    dispose();
                    backFrame();
                }catch(Exception e){}
            }
        });
        easymode.setLayout(new BoxLayout(easymode,BoxLayout.Y_AXIS));
        add("Center",easymode);
        setVisible(true);
    }
    void backFrame(){
        Select select = new Select();
        select.setVisible(true);
    }
    public static void main(String[] args) {
        Easy easy = new Easy();
    }
}


class Easymode extends JPanel implements MouseListener {

    public void mouseReleased(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }


    public int[][] data = {{1,2,3},{4,5,6},{7,8,0}};
    public Random rand;
    public Easymode() {
        addMouseListener(this);
        rand = new Random();
        for (int i = 0; i < 100; i++) {
            init();
        }
    }

    public void mousePressed(MouseEvent e) {
        int size = 117;
        int x = e.getX() / size;
        int y = e.getY() / size;
        move(x, y);
        checkanswer();
    }

    public void paint(Graphics g) {
        paintComponents(g);
        int size = 117;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
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
        for (x = 0; x < 3; x++) {
            for (y = 0; y < 3; y++) {
                if (n != data[x][y]) {
                    return;
                }
                if (n == 8) {
                    n = 0;
                } else {
                    n ++;
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
            if ((y + 1) <= 2) {
                if (data[y + 1][x] == 0) {
                    data[y + 1][x] = data[y][x];
                    data[y][x] = 0;
                    repaint();
                    return;
                }
            }
            if ((x + 1) <= 2) {
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


    public void init() {
        int count, x, y, ran;
        int temp;
        for (count = 0; count < 100; count++) {
            x = rand.nextInt(3);
            y = rand.nextInt(3);
            ran = rand.nextInt(4);
            try {
                if ((x + 1) <= 2 || (x - 1) >= 0 || (y + 1) <= 2 || (y - 1) >= 0) {
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
                        if ((x + 1) < 3) {
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
                        if ((y + 1) < 3) {
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