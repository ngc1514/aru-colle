package Weighted_ShortestPath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import java.io.IOException;
import java.io.FileNotFoundException;

// NOTE:
//  program arguments: test-inputs\Weighted_ShortestPath-input\test.txt

public class Driver {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide the testcase filename as a command line argument");
        }
        String inputFilename = args[0];

        Weighted_ShortestPath.Graph input = readFile(inputFilename);

        Shortest student = new Shortest(input.getStartNode(), input.getEndNode(), input.getGraph());

        //NOTE: start timing
        long startTime = System.nanoTime();

        ArrayList<Integer> studentSolution = student.outputPath();

        //NOTE: ends timing
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("duration: " + duration);

        System.out.println(studentSolution);
    }


    private static Weighted_ShortestPath.Graph readFile(String inputFilePath) {
        int startNode = 0;
        int endNode = 0;
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(inputFilePath));
        }
        catch (FileNotFoundException e) {
            System.err.println("Unable to open the file " + inputFilePath);
            e.printStackTrace();
        }

        try {
            startNode = Integer.valueOf(bufferedReader.readLine());
            endNode = Integer.valueOf(bufferedReader.readLine());
            int i = 0;
            String line;
            while((line = bufferedReader.readLine()) != null) {
                ArrayList<Integer> nodes = new ArrayList<>();
                for (String part : line.split("\\s+")) {
                    nodes.add(Integer.valueOf(part));
                }
                graph.put(i, nodes);
                i++;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return new Weighted_ShortestPath.Graph(startNode, endNode, graph);
    }
}
