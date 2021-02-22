import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.*;

public class App extends JComponent {
    private static final ArrayList<Line> lines = new ArrayList<>();
    static Writer writer = new Writer();
    static JComboBox tvar;
    static int numberOfIterations = 0;
    static JLabel lblIteration;


    static Position position = new Position(640, 360);
    static int step = 10;
    static double alpha = Math.toRadians(270);

    public static void setStep(int step) {
        App.step = step;
    }

    static int centerX = 640;
    static int centerY = 360;

    private static final ArrayList<Position> stack = new ArrayList<>();

    public static void addToStack(Position position) {
        stack.add(position);
    }

    public static Position getLastStack() {
        return stack.get(stack.size() - 1);
    }

    public static void deleteLastLastStack() {
        stack.remove(stack.size() - 1);
    }

    public static void setAlpha(double alpha) {
        App.alpha = Math.toRadians(alpha);
    }

    public static final String[] getSystemy() {
        return new String[]{"Binary tree", "Crystal", "Kochova krivka", "Tree", "Gosperova krivka", "Pentaplexity", "Dragon Curve", "Rings"};
    }


    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        final App comp = new App();
        comp.setPreferredSize(new Dimension(1280, 720));
        frame.getContentPane().add(comp, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        JButton drawButton = new JButton("Draw");
        JButton clearButton = new JButton("Clear");
        JLabel numOfIterations = new JLabel("Počet iterací: ");
        lblIteration = new JLabel("0");

        controlPanel.add(numOfIterations);
        controlPanel.add(lblIteration);
        controlPanel.add(drawButton);
        controlPanel.add(clearButton);

        frame.getContentPane().add(controlPanel, BorderLayout.SOUTH);

        tvar = new JComboBox(getSystemy());
        tvar.setSelectedIndex(0);
        tvar.addActionListener(e -> setProperties());

        controlPanel.add(tvar);


        drawButton.addActionListener(e -> {

            numberOfIterations++;
            lblIteration.setText(String.valueOf(numberOfIterations));
            writer.newIteration(writer.returnLastLine());
            writer.sayTypeOfMethod();

            lines.clear();
            stack.clear();

            char[] rules = writer.getLastLine().toCharArray();

            if (writer.getTypeOfMethod().equals("Dragon curve")) {
                setAlpha(270);
                position = new Position(centerX, centerY);

                for (int i = 0; i < rules.length; i++) {

                    if (rules[i] == 'X') {
                        comp.addLine(position.x, position.y, (int) Math.round(position.x + step * Math.cos(alpha)), (int) Math.round(position.y + step * Math.sin(alpha)));
                        position = new Position((int) Math.round(position.x + step * Math.cos(alpha)), (int) Math.round(position.y + step * Math.sin(alpha)));
                    }

                    if (rules[i] == 'Y') {
                        comp.addLine(position.x, position.y, (int) Math.round(position.x + step * Math.cos(alpha)), (int) Math.round(position.y + step * Math.sin(alpha)));
                        position = new Position((int) Math.round(position.x + step * Math.cos(alpha)), (int) Math.round(position.y + step * Math.sin(alpha)));
                    }

                    if (rules[i] == '+') {
                        alpha -= Math.toRadians(90);
                    }

                    if (rules[i] == '-') {
                        alpha += Math.toRadians(90);
                    }
                }
            }

            if (writer.getTypeOfMethod().equals("Kochova krivka")) {
                position = new Position(centerX, centerY);

                for (int i = 0; i < rules.length; i++) {

                    if (rules[i] == 'F') {
                        comp.addLine(position.x, position.y, (int) Math.round(position.x + step * Math.cos(alpha)), (int) Math.round(position.y + step * Math.sin(alpha)));
                        position = new Position((int) Math.round(position.x + step * Math.cos(alpha)), (int) Math.round(position.y + step * Math.sin(alpha)));
                    }

                    if (rules[i] == '+') {
                        alpha -= Math.toRadians(60);
                    }

                    if (rules[i] == '-') {
                        alpha += Math.toRadians(60);
                    }
                }
            }

            if (writer.getTypeOfMethod().equals("Binary tree")) {
                setAlpha(270);
                position = new Position(centerX, centerY);

                for (int i = 0; i < rules.length; i++) {
                    if (rules[i] == 'F') {
                        comp.addLine(position.x, position.y, (int) Math.round(position.x + step * Math.cos(alpha)), (int) Math.round(position.y + step * Math.sin(alpha)));
                        position = new Position((int) Math.round(position.x + step * Math.cos(alpha)), (int) Math.round(position.y + step * Math.sin(alpha)));
                    }

                    if (rules[i] == 'G') {
                        comp.addLine(position.x, position.y, (int) Math.round(position.x + step * Math.cos(alpha)), (int) Math.round(position.y + step * Math.sin(alpha)));
                        position = new Position((int) Math.round(position.x + step * Math.cos(alpha)), (int) Math.round(position.y + step * Math.sin(alpha)));
                    }

                    if (rules[i] == '+') {
                        alpha -= Math.toRadians(45);
                    }

                    if (rules[i] == '-') {
                        alpha += Math.toRadians(45);
                    }

                    if (rules[i] == '[') {
                        position = new Position(position.x, position.y, (int) alpha);
                        addToStack(position);
                    }

                    if (rules[i] == ']') {
                        position = new Position(getLastStack().getX(), getLastStack().getY());
                        alpha = getLastStack().getAlpha();
                        deleteLastLastStack();
                    }
                }
            }

            if (writer.getTypeOfMethod().equals("Gosperova krivka")) {
                setAlpha(270);
                position = new Position(centerX, centerY);

                for (int i = 0; i < rules.length; i++) {
                    if (rules[i] == 'A' || rules[i] == 'B') {
                        comp.addLine(position.x, position.y, (int) Math.round(position.x + step * Math.cos(alpha)), (int) Math.round(position.y + step * Math.sin(alpha)));
                        position = new Position((int) Math.round(position.x + step * Math.cos(alpha)), (int) Math.round(position.y + step * Math.sin(alpha)));
                    }

                    if (rules[i] == '+') {
                        alpha -= Math.toRadians(60);
                    }

                    if (rules[i] == '-') {
                        alpha += Math.toRadians(60);
                    }
                }
            }

            if (writer.getTypeOfMethod().equals("Tree")) {
                setAlpha(270);
                position = new Position(centerX, centerY);

                for (int i = 0; i < rules.length; i++) {

                    if (rules[i] == 'F') {
                        comp.addLine(position.x, position.y, (int) Math.round(position.x + step * Math.cos(alpha)), (int) Math.round(position.y + step * Math.sin(alpha)));
                        position = new Position((int) Math.round(position.x + step * Math.cos(alpha)), (int) Math.round(position.y + step * Math.sin(alpha)));
                    }

                    if (rules[i] == 'X') {
                        comp.addLine(position.x, position.y, (int) Math.round(position.x + (step / 2) * Math.cos(alpha)), (int) Math.round(position.y + (step / 2) * Math.sin(alpha)));
                        position = new Position((int) Math.round(position.x + (step / 2) * Math.cos(alpha)), (int) Math.round(position.y + (step / 2) * Math.sin(alpha)));
                    }

                    if (rules[i] == '+') {
                        alpha -= Math.toRadians(22.5);
                    }

                    if (rules[i] == '-') {
                        alpha += Math.toRadians(22.5);
                    }

                    if (rules[i] == '[') {
                        position = new Position(position.x, position.y, (int) alpha);
                        addToStack(position);
                    }

                    if (rules[i] == ']') {
                        position = new Position(getLastStack().getX(), getLastStack().getY());
                        alpha = getLastStack().getAlpha();
                        deleteLastLastStack();
                    }
                }
            }

            if (writer.getTypeOfMethod().equals("Crystal")) {
                setAlpha(270);
                position = new Position(centerX, centerY);

                for (int i = 0; i < rules.length; i++) {
                    if (rules[i] == 'F') {
                        comp.addLine(position.x, position.y, (int) Math.round(position.x + step * Math.cos(alpha)), (int) Math.round(position.y + step * Math.sin(alpha)));
                        position = new Position((int) Math.round(position.x + step * Math.cos(alpha)), (int) Math.round(position.y + step * Math.sin(alpha)));
                    }
                    if (rules[i] == '+') {
                        alpha -= Math.toRadians(90);
                    }
                }
            }

            if (writer.getTypeOfMethod().equals("Pentaplexity")) {
                setAlpha(270);
                position = new Position(centerX, centerY);

                for (int i = 0; i < rules.length; i++) {
                    if (rules[i] == 'F') {
                        comp.addLine(position.x, position.y, (int) Math.round(position.x + step * Math.cos(alpha)), (int) Math.round(position.y + step * Math.sin(alpha)));
                        position = new Position((int) Math.round(position.x + step * Math.cos(alpha)), (int) Math.round(position.y + step * Math.sin(alpha)));
                    }
                    if (rules[i] == '+') {
                        alpha -= Math.toRadians(36);
                    }

                    if (rules[i] == '-') {
                        alpha += Math.toRadians(36);
                    }

                    if (rules[i] == '|') {
                        alpha -= Math.toRadians(180);
                    }
                }
            }

            if (writer.getTypeOfMethod().equals("Rings")) {
                setAlpha(270);
                position = new Position(centerX, centerY);

                for (int i = 0; i < rules.length; i++) {
                    if (rules[i] == 'F') {
                        comp.addLine(position.x, position.y, (int) Math.round(position.x + step * Math.cos(alpha)), (int) Math.round(position.y + step * Math.sin(alpha)));
                        position = new Position((int) Math.round(position.x + step * Math.cos(alpha)), (int) Math.round(position.y + step * Math.sin(alpha)));
                    }
                    if (rules[i] == '+') {
                        alpha -= Math.toRadians(90);
                    }
                    if (rules[i] == '-') {
                        alpha += Math.toRadians(90);
                    }
                }
            }

        });

        clearButton.addActionListener(e -> {
            comp.clearLines();
            stack.clear();
        });

        frame.pack();
        frame.setVisible(true);

        setProperties();

        ImageIcon icon = new ImageIcon(App.class.getResource("smallerturtle.png"));

        JOptionPane.showMessageDialog(null,
                "Z Comboboxu po pravé straně se vybere obrazec, který chceme vykreslit. \n" +
                        "Klikáním na tlačítko draw se generuje řetězec pravidel a zároveň vykresluje \n \n" +
                        "                                            Datum poslední úpravy: 3.5.2019 ",

                "Jan Chaloupka A3 L-systémy", JOptionPane.INFORMATION_MESSAGE, icon);
    }

    private static void setProperties() {
        lines.clear();
        numberOfIterations = 0;
        lblIteration.setText(String.valueOf(numberOfIterations));

        switch (tvar.getSelectedIndex()) {
            case 0:
                writer.setTypeOfMethod("Binary tree");
                setStep(10);
                writer.setFirstLine("F");
                centerX = 640;
                centerY = 700;
                writer.sayTypeOfMethod();
                break;

            case 1:
                setStep(5);
                writer.setTypeOfMethod("Crystal");
                writer.setFirstLine("F+F+F+F");
                centerX = 835;
                centerY = 600;
                writer.sayTypeOfMethod();
                break;

            case 2:
                writer.setTypeOfMethod("Kochova krivka");
                writer.setFirstLine("F");
                setStep(10);
                centerX = 250;
                centerY = 600;
                setAlpha(360);
                writer.sayTypeOfMethod();
                break;

            case 3:
                writer.setTypeOfMethod("Tree");
                writer.setFirstLine("X");
                setStep(8);
                centerX = 640;
                centerY = 700;
                setAlpha(270);
                writer.sayTypeOfMethod();
                break;

            case 4:
                writer.setTypeOfMethod("Gosperova krivka");
                setStep(10);
                writer.setFirstLine("A");
                writer.sayTypeOfMethod();
                centerX = 350;
                centerY = 300;
                break;

            case 5:
                writer.setTypeOfMethod("Pentaplexity");
                writer.setFirstLine("F++F++F++F++F");
                writer.sayTypeOfMethod();
                centerX = 880;
                centerY = 600;
                setStep(8);
                break;

            case 6:
                writer.setTypeOfMethod("Dragon curve");
                writer.setFirstLine("FX");
                centerX = 400;
                centerY = 260;
                setStep(4);
                break;

            case 7:
                writer.setTypeOfMethod("Rings");
                writer.setFirstLine("F+F+F+F");
                centerX = 880;
                centerY = 230;
                setStep(4);
                break;

        }
    }

    private static class Line {
        final int x1;
        final int y1;
        final int x2;
        final int y2;

        public Line(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    public void addLine(int x1, int y1, int x2, int y2) {
        lines.add(new Line(x1, y1, x2, y2));
        repaint();
    }

    public void clearLines() {
        lblIteration.setText("0");
        lines.clear();
        setProperties();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Line line : lines) {
            g.drawLine(line.x1, line.y1, line.x2, line.y2);
            repaint();
        }
    }


}
