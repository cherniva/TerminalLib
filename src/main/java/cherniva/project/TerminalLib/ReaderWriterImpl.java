package cherniva.project.TerminalLib;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReaderWriterImpl implements ReaderWriter {

    private final Logger LOG = Logger.getLogger(ReaderWriter.class.getName());

    private InputStream inputStream = System.in;

    private OutputStream outputStream = System.out;

    @Override
    public List<String> readLines() {
        final List<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = null;
            while ((line = in.readLine()) != null) {
                lines.add(line);
            }
        }
        catch(IOException e) {
            LOG.log(Level.WARNING, "IOException getLines()");
            throw new RuntimeException(e);
        }
        return lines;
    }

    @Override
    public String readLine() {
        String line = null;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(inputStream))) {
            line = in.readLine();
        }
        catch(IOException e) {
            LOG.log(Level.WARNING, "IOException getLine()");
            throw new RuntimeException(e);
        }
        return line;
    }

    @Override
    public void writeLines(List<String> lines) {
        try(BufferedWriter out = new BufferedWriter(new OutputStreamWriter(outputStream))) {
            for(String line : lines) {
                out.write(line);
            }
        }
        catch (IOException e) {
            LOG.log(Level.WARNING, "IOException writeLines()");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeLine(String line) {
        try(BufferedWriter out = new BufferedWriter(new OutputStreamWriter(outputStream))) {
            out.write(line);
        }
        catch (IOException e) {
            LOG.log(Level.WARNING, "IOException writeLine()");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void defaultInputStream(InputStream stream) {
        inputStream = stream;
    }

    @Override
    public void defaultInputStream(String path) {
        File file = new File(path);
        try (InputStream newInputStream = new FileInputStream(file)) {
            defaultInputStream(newInputStream);
        }
        catch (FileNotFoundException e) {
            LOG.log(Level.WARNING, "FileNotFoundException defaultInputStream()");
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            LOG.log(Level.WARNING, "IOException defaultInputStream()");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void defaultOutputStream(OutputStream stream) {
        outputStream = stream;
    }

    @Override
    public void defaultOutputStream(String path) {
        File file = new File(path);
        try (OutputStream newOutputStream = new FileOutputStream(file)) {
            defaultOutputStream(newOutputStream);
        }
        catch (FileNotFoundException e) {
            LOG.log(Level.WARNING, "FileNotFoundException defaultInputStream()");
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            LOG.log(Level.WARNING, "IOException defaultInputStream()");
            throw new RuntimeException(e);
        }
    }
}
