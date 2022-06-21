package adventofcode2021.day5.hydrothermalventure;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.nio.file.Files.readAllLines;
import static java.util.stream.Collectors.toList;

public class Line {
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public Line(final int x1, final int y1, final int x2, final int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public boolean isHorizontal() {
        return y1 == y2;
    }

    public boolean isVertical() {
        return x1 == x2;
    }

    public static Line parseLine(final String text) {
        final var parts = text.split(" -> ");
        final var point1 = parts[0].split(",");
        final var point2 = parts[1].split(",");
        return new Line(
                parseInt(point1[0]),
                parseInt(point1[1]),
                parseInt(point2[0]),
                parseInt(point2[1]));
    }

    public static List<Line> parseFile(final String path) throws IOException {
        return readAllLines(Paths.get(path))
                .stream()
                .map(Line::parseLine)
                .collect(toList());
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Line)) return false;
        final var line = (Line) obj;
        return x1 == line.x1 && y1 == line.y1 && x2 == line.x2 && y2 == line.y2;
    }

    @Override
    public String toString() {
        final var out = new StringBuilder();
        out.append(x1);
        out.append(',');
        out.append(y1);
        out.append(" -> ");
        out.append(x2);
        out.append(',');
        out.append(y2);
        return out.toString();
    }
}