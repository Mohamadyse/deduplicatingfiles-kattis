package sigma.se;

import java.util.*;
import java.io.*;
public class Main {

    public static char hash(String str) {
        char hash = (char)0;

        for (int i = 0; i < str.length(); i++)
            hash ^= str.charAt(i);

        return hash;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String theAnswer="";
        while (true)
        {
            int files = Integer.parseInt(scan.readLine());

            if (files == 0)
                break;

            Set<String> uniqueFiles = new HashSet<String>();
            List<String> allFiles = new ArrayList<String>();

            for (int i = 0; i < files; i++) {
                String file = scan.readLine();
                uniqueFiles.add(file);
                allFiles.add(file);
            }

            int collision = 0;
            for (int i = 0; i < files; i++) {
                String currentfile = allFiles.get(i);
                int currentHashedFile = hash(currentfile);
                for (int j = i + 1; j < files; j++) {
                    String fileBelow = allFiles.get(j);
                    int belowHAshedFile = hash(fileBelow);
                    if (currentHashedFile == belowHAshedFile && !currentfile.equals(fileBelow))
                        collision++;
                }
            }


            theAnswer += uniqueFiles.size() + " " + collision+"\n";

        }
        System.out.println(theAnswer);
        scan.close();
    }
}