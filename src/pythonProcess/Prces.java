package pythonProcess;

import java.io.*;
public class Prces {
    public static void main(String args[]) throws Exception {
      String command[] = {"echo, %cd%"};
      ProcessBuilder pb = new ProcessBuilder(command);
      pb.directory(new File("/Users/prathamaggarwal/Desktop/College/CSD213/Swing/src/com/"));
      try {
          Process p = pb.start();
          BufferedReader reader = new BufferedReader( new InputStreamReader(p.getInputStream()));
          String line;
          while((line = reader.readLine()) != null){
            System.out.println(line); }
          int exitCode = p.waitFor();
          System.out.println("Exited with code" + exitCode);
      } catch(Exception e) {
            e.printStackTrace();
      }
    }
}
