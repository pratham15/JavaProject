package pythonProcess;

import java.io.*;
public class Prces {
    public static void main(String args[]) throws Exception {
        String cmds[] = {"@Dell", "@HCL", "@GoldmanSachs", "@TATA", "@Wipro"};
        //for(String company: cmds) {
            //String activateEnvironment[] = {"conda", "activate", "javaproject"};
            String command[] = {"python", "predict.py", "--company_name","MS"};
            //ProcessBuilder env = new ProcessBuilder(activateEnvironment);
            ProcessBuilder pb = new ProcessBuilder(command);
            pb.directory(new File("/Users/prathamaggarwal/Desktop/College/CSD213/Swing/src/pythonProcess/"));
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
        //}
    }
}
