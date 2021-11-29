package pythonProcess;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Env {
    public static void main(String args[]) throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder();
        // -- Linux --

        // Run a shell command
        processBuilder.command("bash", "-c", "conda activate javaproject");

        String command[] = {"python", "predict.py", "--company_name MS"};
        //ProcessBuilder env = new ProcessBuilder(activateEnvironment);
        ProcessBuilder pb = new ProcessBuilder(command);
        pb.directory(new File("/Users/prathamaggarwal/Desktop/College/CSD213/Swing/src/pythonProcess/"));

        try {

            Process process = processBuilder.start();

            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
                System.out.println(output);
                System.exit(0);
            } else {
                //abnormal...
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            //Process envAc = env.start();
            Process p = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            int exitCode = p.waitFor();
            System.out.println("Exited with code" + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
