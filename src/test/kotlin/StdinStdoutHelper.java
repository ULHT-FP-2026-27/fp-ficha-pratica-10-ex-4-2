import org.junit.Assert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

enum Channel {
    STDIN, STDOUT
}

class Command {

    private String text;
    private Channel channel;

    public Command(String text, Channel channel) {
        this.text = text;
        this.channel = channel;
    }

    public String getText() {
        return text;
    }

    public Channel getChannel() {
        return channel;
    }
}

public class StdinStdoutHelper {

    private List<Command> commands;

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut = System.out;
    private InputStream originalIn = System.in;

    private boolean showDetailedErrors = true;

    public StdinStdoutHelper() {
        this.commands = new ArrayList<Command>();
    }

    public StdinStdoutHelper(boolean showDetailedErrors) {
        this.commands = new ArrayList<Command>();
        this.showDetailedErrors = showDetailedErrors;
    }

    public StdinStdoutHelper simulateInput(String textToReadFromKeyboard) {
        commands.add(new Command(textToReadFromKeyboard, Channel.STDIN));
        return this;
    }

    public StdinStdoutHelper expectOuput(String expectedTextWrittenToConsole) {
        commands.add(new Command(expectedTextWrittenToConsole, Channel.STDOUT));
        return this;
    }

    public void start() {
        String commandsStr = "";
        for (Command command : commands) {
            if (command.getChannel() == Channel.STDIN) {
                commandsStr += command.getText() + System.lineSeparator();
            }
        }
        System.setIn(new ByteArrayInputStream(commandsStr.getBytes()));
        System.setOut(new PrintStream(outContent));
    }

    public void stop() {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new ByteArrayInputStream(outContent.toByteArray())));

        System.setOut(originalOut);
        System.setIn(originalIn);

        try {
            for (Command command : commands) {
                if (command.getChannel() == Channel.STDOUT) {
                    String line = reader.readLine();
                    Assert.assertNotNull("Output expected. Forgot some println()?", line);
                    if (showDetailedErrors) {
                        Assert.assertEquals(command.getText(), line);
                    } else {
                        if (!command.getText().equals(line)) {
                            fail("Incorrect output: " + line);
                        }
                    }
                }
            }
        } catch (IOException e) {
            Assert.fail("Strange error checking output");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        stop();
    }
}