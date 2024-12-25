package plinko;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class PlinkoGame extends JPanel {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BALL_RADIUS = 10;
    private static final int PEG_RADIUS = 8;
    private static final int ROW_COUNT = 10;
    private static final int PEG_SPACING = 60;

    private final ArrayList<Point> pegs;
    private final int[] bins;
    private Point ballPosition;
    private boolean gameActive;
    private int ballVelocityY;
    private final Random random;

    public PlinkoGame() {
        pegs = generatePegs();
        bins = new int[ROW_COUNT];
        ballPosition = null;
        gameActive = false;
        ballVelocityY = 5;
        random = new Random();

        Timer timer = new Timer(16, e -> gameLoop());
        timer.start();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!gameActive) {
                    ballPosition = new Point(WIDTH / 2, 0);
                    gameActive = true;
                }
            }
        });
    }

    private ArrayList<Point> generatePegs() {
        ArrayList<Point> pegs = new ArrayList<>();
        for (int row = 0; row < ROW_COUNT; row++) {
            int numPegs = (int) Math.pow(2, row);
            int rowWidth = numPegs * PEG_SPACING;
            int startX = (WIDTH - rowWidth) / 2 + PEG_SPACING / 2;
            int y = row * PEG_SPACING + PEG_SPACING / 2;

            for (int i = 0; i < numPegs; i++) {
                int x = startX + i * PEG_SPACING;
                pegs.add(new Point(x, y));
            }
        }
        return pegs;
    }

    private int normalDistributionChoice(double mean, double stdDev, int numChoices) {
        int value = (int) Math.max(0, Math.min(numChoices - 1, random.nextGaussian() * stdDev + mean));
        return value;
    }

    private void gameLoop() {
        if (gameActive && ballPosition != null) {
            ballPosition.y += ballVelocityY;

            for (Point peg : pegs) {
                double distance = ballPosition.distance(peg);
                if (distance < BALL_RADIUS + PEG_RADIUS) {
                    ballPosition.x += random.nextBoolean() ? -5 : 5;
                    break;
                }
            }

            if (ballPosition.y >= HEIGHT - 50) {
                int targetBin = normalDistributionChoice(ROW_COUNT / 2.0, 2, ROW_COUNT);
                ballPosition.x = (targetBin + 1) * (WIDTH / (ROW_COUNT + 1));
                gameActive = false;
            }
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(28, 28, 28)); // Тёмный фон
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Нарисовать контейнеры внизу
        g.setColor(Color.DARK_GRAY);
        int binWidth = WIDTH / ROW_COUNT;
        for (int i = 0; i < ROW_COUNT; i++) {
            g.fillRect(i * binWidth, HEIGHT - 50, binWidth - 2, 50);
        }

        // Нарисовать стержни
        g.setColor(Color.WHITE);
        for (Point peg : pegs) {
            g.fillOval(peg.x - PEG_RADIUS, peg.y - PEG_RADIUS, PEG_RADIUS * 2, PEG_RADIUS * 2);
        }

        // Нарисовать шарик
        if (ballPosition != null) {
            g.setColor(new Color(255, 69, 0)); // Оранжевый цвет шарика
            g.fillOval(ballPosition.x - BALL_RADIUS, ballPosition.y - BALL_RADIUS, BALL_RADIUS * 2, BALL_RADIUS * 2);
        }

        // Добавить текст для эффекта казино
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Arial", Font.BOLD, 32));
        g.drawString("PLINKO", WIDTH / 2 - 70, 40);

        // Подписи для контейнеров
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.setColor(Color.WHITE);
        for (int i = 0; i < ROW_COUNT; i++) {
            g.drawString("Bin " + (i + 1), i * binWidth + binWidth / 2 - 20, HEIGHT - 20);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Plinko Game");
        PlinkoGame gamePanel = new PlinkoGame();
        frame.add(gamePanel);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
