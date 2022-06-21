package adventofcode2021.day2.dive;

import java.util.List;

import static java.lang.Integer.parseInt;

public class Aim {
    private int position;
    private int depth;
    private int aim;

    public int getPosition() {
        return position;
    }

    public int getDepth() {
        return depth;
    }

    public int getAim() {
        return aim;
    }

    public void execute(final String command) {
        final var args = command.split(" ");
        if (args.length != 2) throw new UnsupportedOperationException("Invalid command: " + command);

        final var op = args[0];
        final var n = parseInt(args[1]);

        switch (op) {
            case "forward":
                position += n;
                depth += aim * n;
                break;
            case "up":
                aim -= n;
                break;
            case "down":
                aim += n;
                break;
            default:
                throw new UnsupportedOperationException("Invalid operation: " + op);
        }
    }

    public void execute(final List<String> commands) {
        for (final String command : commands) {
            execute(command);
        }
    }
}