
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.io.TemporaryFilesystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class DealingWithIO {

    public void CopyFromSrcToDes(){

        //refer FileHandler class in api
        //static void FileHandler.copy(java.io.File from, java.io.File to);
        //File class has many constructors. We take the method with pathname parameter

        try {
            File SrcFile = new File("/home/ashwin/IdeaProjects/Selenium Concepts2/Chapter 6/SampleDestDir/EmptyFile");

            File DestFile = new File("/home/ashwin/IdeaProjects/Selenium Concepts2/Chapter 6/SampleSrcDir/EmptyFileCopy");

            FileHandler.copy(SrcFile, DestFile);
        }catch(IOException ex){
            ex.printStackTrace();
        }

        //As you can see the srcFile got copied in DestFolder
    }

    public void CreateDir(){

        try {
            File Dir = new File("/home/ashwin/IdeaProjects/Selenium/Chapter 6/CreateDir");
            FileHandler.createDir(Dir);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void DeleteFileOrDir(){

        try {
            File NewFile = new File("/home/ashwin/IdeaProjects/Selenium Concepts2/Chapter 6/CreateDir/Dummyfile");
            File DirName = new File("/home/ashwin/IdeaProjects/Selenium Concepts2/Chapter 6/CreateDir");
            NewFile.createNewFile(); //File class in java api has a createNewFile method will create a new file

            //Now deleting this file or Directory
            FileHandler.delete(NewFile); //This deleted the file

            //Now deleting the directory
            FileHandler.delete(DirName); //It deleted the file.

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    //There are other methods also in FileHandler class of selenium like isZipped() and makeWritable(). easy
    //There is another api for Filehandler. At org.openqa.selenium it is not showing all the methods
    //http://javadox.com/org.seleniumhq.selenium/selenium-remote-driver/2.53.0/org/openqa/selenium/io/FileHandler.html

    public void ReadFile(){

        File fileToRead = new File("/home/ashwin/IdeaProjects/Selenium/Chapter 6/ToReadFile");
        //FileHandler.readAsString() This method is not available in Selenium FileHandler
        //So we use Java Files class and readAllBytes() method
        //https://docs.oracle.com/javase/7/docs/api/java/nio/file/Paths.html
        //Remember here Paths.get() method returns a Path static

        try {
            Path path = Paths.get("/home/ashwin/IdeaProjects/Selenium Concepts2/Chapter 6/ToReadFile");
            byte[] content = Files.readAllBytes(path); //it throws byte[] so we collect it
            System.out.println(new String(content)); //Yes this is the way
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }


    public void KnowingTempDir(){

        //There is sequence of methods to follow. getDefaultTmpFS() is the method. But we have to use a technique

        File f = TemporaryFilesystem.getDefaultTmpFS().createTempDir("prefix","suffix");
        //createTempDir throws an object of File so we are collecting it in a File f
        //getDefaultTmpFS() get Default temporary File system
        System.out.println("Now absolute path is: "+f.getAbsolutePath());
        //This dir get auto deleted when the script is done executed so thread to see such directory in the path
        try{
            Thread.sleep(30000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }


        //Creating Temporary Filesystem. Remember these directories auto delete after the script is done executed
        File tempDir = new File("/home/ashwin/IdeaProjects/Selenium Concepts2/Chapter 6");
        TemporaryFilesystem NewTmpFS = TemporaryFilesystem.getTmpFsBasedOn(tempDir);
        File NewDirHandler = NewTmpFS.createTempDir("prefix","suffix");
        System.out.println("Temp dir created path is: "+NewDirHandler.getAbsolutePath());

        try{
            Thread.sleep(30000);

        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

    }

    //There are 2 progs for zip files too but i think thats not needed. So here was all about TempFileSystem and its
    //nature

    public static void main(String[] args){

        DealingWithIO object = new DealingWithIO();
        //object.CopyFromSrcToDes();
        //object.CreateDir();
        //object.DeleteFileOrDir();
        //object.ReadFile();
        object.KnowingTempDir();
    }
}
