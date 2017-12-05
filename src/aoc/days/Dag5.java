package aoc.days;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dag5 {

    public Dag5() throws IOException {
        Del2();


    }

    private void Del1() throws IOException {

        String everything = "";

        BufferedReader br = new BufferedReader(new FileReader("dag5"));
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

       // System.out.println("String: " + everything);



        List<String> list = new ArrayList<>(Arrays.asList(everything.split("\n")));



        ArrayList<String> lista = new ArrayList<>(list);



        ArrayList<Integer> result = new ArrayList<>();
        for(String stringValue : lista) {
            try {
                //Convert String to Integer, and store it into integer array list.
                result.add(Integer.parseInt(stringValue));
            } catch(NumberFormatException nfe) {
                //System.out.println("Could not parse " + nfe);

            }
        }

        //System.out.println("size: " + result.size());

        int pos = 0;
        int value;
        int oldpos = 0;
        int oldvalue = 0;
        int steps = 0;

        while (pos < result.size()) {

            oldpos = pos;
            oldvalue = result.get(pos);
            pos = pos + result.get(pos);

            result.set(oldpos, oldvalue + 1);

            steps++;

            //System.out.println("pos: " + pos);


        }

        System.out.println("Steps: " + steps);


    }

    private void Del2() throws IOException {

        String everything = "";

        BufferedReader br = new BufferedReader(new FileReader("dag5"));
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

        List<String> list = new ArrayList<>(Arrays.asList(everything.split("\n")));

        ArrayList<String> lista = new ArrayList<>(list);

        ArrayList<Integer> result = new ArrayList<>();
        for(String stringValue : lista) {
            try {
                result.add(Integer.parseInt(stringValue));
            } catch(NumberFormatException nfe) {

            }
        }

        int pos = 0;
        int oldpos;
        int oldvalue;
        int steps = 0;

        while (pos < result.size()) {

            oldpos = pos;
            oldvalue = result.get(pos);
            pos = pos + result.get(pos);

            if (result.get(oldpos) >= 3) {
                result.set(oldpos, oldvalue - 1);
            } else {
                result.set(oldpos, oldvalue + 1);
            }

            steps++;

        }

        System.out.println("Steps: " + steps);


    }

}
