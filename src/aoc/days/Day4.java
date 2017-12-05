package aoc.days;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 {

    public Day4() throws IOException {
        Del2();
    }

    private void Del1() throws IOException {
        String everything = "";

        BufferedReader br = new BufferedReader(new FileReader("dag4"));

        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }


        List<String> result = new ArrayList<>(Arrays.asList(everything.split("\n")));
        List<List<String>> accum = new ArrayList<List<String>>();

        int ok = 0;
        for (int i = 0; i < result.size(); i++) {
            List<String> temp = new ArrayList<>(Arrays.asList(result.get(i).split(" ")));
            int antal = temp.stream().distinct().collect(Collectors.toList()).size();

            if (antal == temp.size()) {
                ok++;
            }
        }

        System.out.println("Antal: " + ok);

    }

    private void Del2() throws IOException {
        String everything = "";

        BufferedReader br = new BufferedReader(new FileReader("dag4"));

        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }


        List<String> result = new ArrayList<>(Arrays.asList(everything.split("\n")));
        List<List<String>> accum = new ArrayList<List<String>>();

        int ok = 0;
        for (int i = 0; i < result.size(); i++) {
            List<String> temp = new ArrayList<>(Arrays.asList(result.get(i).split(" ")));
            int antal = temp.stream().distinct().collect(Collectors.toList()).size();

            boolean lika = false;

            for (int j = 0; j < temp.size(); j++) {

                char[] chars1 = temp.get(j).toCharArray();

                for (int k = 0; k < temp.size(); k++) {

                    if (j == k) {

                    } else {
                        char[] chars2 = temp.get(k).toCharArray();
                        Arrays.sort(chars1);
                        Arrays.sort(chars2);
                        String s1 = new String(chars1);
                        String s2 = new String(chars2);
                        System.out.println("Sort: " + s1 + ":" + s2);
                        if (new String(chars1).equals(new String(chars2))) {
                            lika = true;
                        }
                    }
                }
            }

            if (antal == temp.size() && !lika) {
                ok++;
            }
        }

        System.out.println("Antal: " + ok);
    }


}
