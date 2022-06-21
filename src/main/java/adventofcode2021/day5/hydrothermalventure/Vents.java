package adventofcode2021.day5.hydrothermalventure;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Vents {
    private final int[][] vents;

    public Vents(final int width, final int height) {
        this.vents = new int[width][height];
    }

    public void add(final Line line) {
        if (line.isHorizontal()) {
            addHorizontalLine(line);
        } else if (line.isVertical()) {
            addVerticalLine(line);
        } else {
            addDiagonalLine(line);
        }
    }

    public int countMultipleVentPoints() {
        var points = 0;
        for (final var row : vents) {
            for (final var count : row) {
                if (count >= 2) points++;
            }
        }
        return points;
    }

    private void addHorizontalLine(final Line line) {
        final var y = line.getY1();
        final var x1 = line.getX1();
        final var x2 = line.getX2();
        final var min = min(x1, x2);
        final var max = max(x1, x2);
        for (var x = min; x <= max; x++) {
            vents[y][x]++;
        }
    }

    private void addVerticalLine(final Line line) {
        final var x = line.getX1();
        final var y1 = line.getY1();
        final var y2 = line.getY2();
        final var min = min(y1, y2);
        final var max = max(y1, y2);
        for (var y = min; y <= max; y++) {
            vents[y][x]++;
        }
    }

    private void addDiagonalLine(final Line line) {
        var x1 = line.getX1();
        var y1 = line.getY1();
        var x2 = line.getX2();
        var y2 = line.getY2();
        if (x1 > x2) {
            x1 = line.getX2();
            y1 = line.getY2();
            x2 = line.getX1();
            y2 = line.getY1();
        }
        final var deltaY = y2 > y1 ? 1 : -1;
        for (int x = x1, y = y1; x <= x2; x++, y += deltaY) {
            vents[y][x]++;
        }
    }
}