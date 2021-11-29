package pythonProcess.SentimentAnalysis;

import java.io.*;
public class Prces {
    public static void main(String args[]) throws Exception {
        String cmds[] = {"@Dell", "@Adobe", "@GoldmanSachs", "@SchindlerGroup", "@MorganStanley"};
        for(String company: cmds) {
            String command[] = {"python", "A.py", "--company_handle",company};
            ProcessBuilder pb = new ProcessBuilder(command);
            pb.directory(new File("/Users/prathamaggarwal/Desktop/College/CSD213/Swing/src/pythonProcess/SentimentAnalysis/"));
            try {
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
}
