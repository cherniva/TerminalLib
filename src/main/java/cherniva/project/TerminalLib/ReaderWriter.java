package cherniva.project.TerminalLib;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public interface ReaderWriter {

    List<String> readLines();

    String readLine();

    void writeLines(List<String> lines);

    void writeLine(String line);

    void defaultInputStream(InputStream source);

    void defaultInputStream(String path);

    void defaultOutputStream(OutputStream stream);

    void defaultOutputStream(String path);
}
