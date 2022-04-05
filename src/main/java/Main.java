import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        String writeToFile;
        File newFile = new File("thisIsAnewFile.txt");

        //Write to file
        try {
            if(newFile.createNewFile()) {
                System.out.println("File is now created");
                FileWriter myWriter = new FileWriter("thisIsAnewFile.txt");
                System.out.println("Please enter what you want to write into the newly created file: ");
                Scanner scanner = new Scanner(System.in);
                writeToFile = scanner.nextLine();
                myWriter.write(writeToFile+ " \n ");
                myWriter.close();
                scanner.close();
            }
            else {
                //Append to file(no overriding)
                System.out.println("File already exists");
                FileWriter myWriter = new FileWriter("thisIsAnewFile.txt", true);
                System.out.println("Please enter what you want to write into the file: ");
                Scanner scanner = new Scanner(System.in);
                writeToFile = scanner.nextLine();
                myWriter.write(writeToFile+ " \n");
                myWriter.close();
                scanner.close();
            }

            //Read from file
            Scanner scanner = new Scanner(newFile);
            System.out.println("File contents: ");
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
            }
            scanner.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}


