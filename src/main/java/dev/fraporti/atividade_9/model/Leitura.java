package dev.fraporti.atividade_9.model;

import java.util.Scanner;

/**
 * @author vitor.rosmann on 07/04/2025
 */
public final class Leitura {
    /**
     * Utility class, not to be instanced
     */
    private Leitura() {}

    /**
     * Receives a String text that will be the label thant captures the nextLine with scanner and return it as String
     * @param label String label of the input
     * @return String nextLine from Scanner
     */
    public static String entDados(String label){
        Scanner scanner = new Scanner(System.in);
        System.out.print(label);
        return scanner.nextLine();
    }
}
