package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Symbol> ParseInputFile(String filename) throws FileNotFoundException {
        List<Symbol> symbols = new ArrayList<>();
        Scanner fileInput = new Scanner(new File(filename));
        while(fileInput.hasNext())
        {
            String line = fileInput.nextLine();
            var splitLine= line.split(",");

            symbols.add(new Symbol(splitLine[0]));
        }
        return symbols;
    }
    public static void main(String[] args) throws IOException {
        Grammar g = Grammar.readFromFile("g2.txt");


        //ParseInputFile("PIF.out");
        //ParseInputFile("seq.out");
        BufferedWriter fileOutput = new BufferedWriter(new FileWriter("out2.txt"));

        fileOutput.write(g.parseInput(ParseInputFile("PIF.out")).toString());
        fileOutput.flush();

        //System.out.println(g.parseInput(ParseInputFile("seq.txt")));
        //System.out.println();
        /*var p = new ParsingOutput();
        p.addEntry(new ParsingOutputEntry(new Terminal("A"), -1, -1));
        p.addEntry(new ParsingOutputEntry(new Terminal("B"), 0, -1));
        System.out.println(p);*/
    }
}
