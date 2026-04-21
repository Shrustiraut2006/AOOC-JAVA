import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BouncingBallRunnable extends JPanel implements Runnable, MouseListener {

    private int x = 50, y = 50;    
    private int dx = 3, dy = 3;     
    private int radius = 20;

    private Thread thread;
    private boolean isRunning = false;

    public BouncingBallRunnable() {
        setBackground(Color.WHITE);
        addMouseListener(this);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(x, y, radius * 2, radius * 2);
    }
    @Override
    public void run() {
        while (isRunning) {
            x += dx;
            y += dy;

            if (x <= 0 || x + 2 * radius >= getWidth()) {
                dx = -dx;
            }
            if (y <= 0 || y + 2 * radius >= getHeight()) {
                dy = -dy;
            }
            repaint();
            try {
                Thread.sleep(10); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if (!isRunning) {
            isRunning = true;
            thread = new Thread(this);
            thread.start(); 
        }
    }
    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball with Runnable");
        BouncingBallRunnable panel = new BouncingBallRunnable();
        frame.add(panel);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}