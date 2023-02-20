/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package changefilename;

import java.io.File;

/**
 *
 * @author Administrator
 */
public class ChangeFilename {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ChangeFilename().changeName(new File("."));
    }

    private void changeName(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                changeName(file);
            } else {
                String pathString = file.getPath().toLowerCase();
                if (pathString.endsWith(".exx")) {
                    String newName = pathString.replaceAll(".exx", ".exe");
                    file.renameTo(newFile(newName));
                } else if (pathString.endsWith(".ddl")) {
                    String newName = pathString.replaceAll(".ddl", ".dll");
                    file.renameTo(newFile(newName));
                }
            }
        }
    }

    private File newFile(String newName) {
        System.out.println(newName);
        File f = new File(newName);
        if (f.exists()) {
            f.delete();
        }
        return f;
    }

}
