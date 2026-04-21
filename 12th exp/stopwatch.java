import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class StopwatchApp extends JFrame implements Runnable {
    private JLabel timeLabel;
    private JButton startBtn, stopBtn, resetBtn;
    private int seconds = 0;
    private int minutes = 0;
    private int hours = 0;
    private boolean running = false;
    private Thread thread;
    public StopwatchApp() {
        setTitle("Stopwatch");
        timeLabel = new JLabel("00:00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 40));
        startBtn = new JButton("Start");
        stopBtn = new JButton("Stop");
        resetBtn = new JButton("Reset");
        JPanel panel = new JPanel();
        panel.add(startBtn);
        panel.add(stopBtn);
        panel.add(resetBtn);
        add(timeLabel, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        startBtn.addActionListener(e -> start());
        stopBtn.addActionListener(e -> stop());
        resetBtn.addActionListener(e -> reset());
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(1000);
                seconds++;
                if (seconds == 60) {
                    seconds = 0;
                    minutes++;
                }
                if (minutes == 60) {
                    minutes = 0;
                    hours++;
                }
                updateTimeLabel();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void updateTimeLabel() {
        String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        SwingUtilities.invokeLater(() -> timeLabel.setText(time));
    }
    private void start() {
        if (!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }
    private void stop() {
        running = false;
    }
    private void reset() {
        running = false;
        seconds = 0;
        minutes = 0;
        hours = 0;
        timeLabel.setText("00:00:00");
    }
    public static void main(String[] args) {
        new StopwatchApp();
    }
}