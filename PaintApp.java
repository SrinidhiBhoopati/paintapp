import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintApp extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel canvas;
    private JButton clearBtn, blackBtn, redBtn, greenBtn, blueBtn;
    private Color currentColor = Color.BLACK;
    private Point lastPoint;

    public PaintApp() {
        setTitle("Paint Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);

        canvas = new JPanel();
        canvas.setBackground(Color.WHITE);
        canvas.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                lastPoint = e.getPoint();
            }
        });
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Graphics g = canvas.getGraphics();
                g.setColor(currentColor);
                g.drawLine(lastPoint.x, lastPoint.y, e.getX(), e.getY());
                lastPoint = e.getPoint();
            }
        });
        add(canvas, BorderLayout.CENTER);

        JPanel controls = new JPanel();
        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(e -> {
            Graphics g = canvas.getGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            g.setColor(currentColor);
        });
        controls.add(clearBtn);

        blackBtn = new JButton("Black");
        blackBtn.addActionListener(e -> {
            currentColor = Color.BLACK;
        });
        controls.add(blackBtn);

        redBtn = new JButton("Red");
        redBtn.addActionListener(e -> {
            currentColor = Color.RED;
        });
        controls.add(redBtn);

        greenBtn = new JButton("Green");
        greenBtn.addActionListener(e -> {
            currentColor = Color.GREEN;
        });
        controls.add(greenBtn);

        blueBtn = new JButton("Blue");
        blueBtn.addActionListener(e -> {
            currentColor = Color.BLUE;
        });
        controls.add(blueBtn);

        add(controls, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new PaintApp();
    }
}