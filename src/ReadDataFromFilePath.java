import java.io.IOException;
import java.nio.file.*;

public class ReadDataFromFilePath {
    /**
     * Citation: Function derived from "coursegrades" assignment.
     * Reads the json file from the given relative path.
     * @param filePath the name of the file
     * @return a String containing the file's contents
     * @throws IllegalArgumentException if input is null
     */
    public static String readFileWithRelativePath(String filePath) {

        if(filePath == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        try {
            final Path path = FileSystems.getDefault().getPath("Data", filePath);
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            return null;
        } catch (InvalidPathException e){
            return null;
        }
    }

    /**
     * Read the json file from a given absolute path.
     * @param path the file path
     * @return a String containing the file's contents
     * @throws IllegalArgumentException if input is null
     */
    public static String readFileWithAbsolutePath(String path){
        if(path == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }

        try{
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            return null;
        } catch (InvalidPathException e){
            return null;
        }
    }

    /**
     * Combines reading absolute and relative file path.
     * @param path of the file
     * @return the String contents of the file, otherwise null.
     * @throws IllegalArgumentException if input is null
     */
    public static String readFilePath(String path){
        if(path == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        String jsonAsString = readFileWithAbsolutePath(path);
        if(jsonAsString == null){
            jsonAsString = readFileWithRelativePath(path);
        }
        return jsonAsString;
    }
}
