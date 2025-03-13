package zipper;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author vitor.rosmann on 13/03/2025
 * <br/><br/>
 * percebi q não tenho winrar instalado, então pensei cmg msm, pq n faço isso, já mexi com zip uma vez na vida.
 * <br/><br/>
 * Read all project files and zip them inside /output, zip name based on the latest "atividade" package
 */
public class ProjectZipper {
    private static final List<String> EXCLUDED_DIRS = List.of(
            "out", ".git", ".idea", ".settings", ".vscode", ".gradle"
    );

    private static final List<String> EXCLUDED_EXTENSIONS = List.of(
            ".class", ".jar", ".war", ".log"
    );

    private static final String ZIP_NAME = "VitorFraportiRosmann_Atividade%s";
    private static final String PATH = System.getProperty("user.dir");
    private static final String OUTPUT = "output/%s.zip";
    private static int current = 0;

    public static void main(String[] args) {
        File base = new File(PATH);
        List<File> files = new ArrayList<>();
        findFiles(base, files);

        String pathToSave = OUTPUT.formatted(ZIP_NAME
                .formatted(current < 10 ? "0"+current : current));

        try(FileOutputStream fos = new FileOutputStream(pathToSave);
            ZipOutputStream zip = new ZipOutputStream(fos)){

            zip.setLevel(9);

            for (File file : files) {
                String relativePath = file.getAbsolutePath().substring(PATH.length() + 1);
                relativePath = relativePath.replace('\\', '/');

                ZipEntry zipEntry = new ZipEntry(relativePath);
                zip.putNextEntry(zipEntry);

                try (FileInputStream fis = new FileInputStream(file)) {
                    zip.write(fis.readAllBytes());
                } catch (IOException e) {
                    System.err.println("Erro ao processar arquivo: " + file.getAbsolutePath());
                }

                zip.closeEntry();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void findFiles(File init, List<File> files){
        File[] fs = init.listFiles();
        if(fs == null){
            System.out.println("Erro XDD");
            return;
        }

        if(init.getName().equals("src")){
            Arrays.stream(fs).forEach(f->{
                if(f.getName().startsWith("atividade")){
                    int c = Integer.parseInt(f.getName().split("_")[1]);
                    if(c > current){
                        current = c;
                    }
                }
            });
        }

        for(File file: fs){
            if(file.isDirectory()){
                if(EXCLUDED_DIRS.contains(file.getName())){
                    continue;
                }

                findFiles(file, files);
            } else {
                String fileName = file.getName().toLowerCase();
                boolean excluded = false;

                for (String ext : EXCLUDED_EXTENSIONS) {
                    if (fileName.endsWith(ext)) {
                        excluded = true;
                        break;

                    }
                }

                if (!excluded) {
                    if (file.canRead()) {
                        files.add(file);
                    } else {
                        System.err.println("Sem permissão para ler: " + file.getAbsolutePath());
                    }
                }
            }
        }
    }
}
