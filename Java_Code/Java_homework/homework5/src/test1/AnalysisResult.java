package test1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class AnalysisResult {
    public static void main(String[] args) {
        File fRead = new File("src\\test1\\score.txt");
        File fWrite = new File("src\\test1\\scoreAnalysis.txt");
        try {
            Writer out = new FileWriter(fWrite);
            BufferedWriter bufferWrite = new BufferedWriter(out);
            Reader in = new FileReader(fRead);
            BufferedReader bufferRead = new BufferedReader(in);
            String str = null;
            while ((str = bufferRead.readLine()) != null) {
                double totalScore = Fenxi.getTotalScore(str);
                str = str + "总成绩" + totalScore;
                System.out.println(str);
                bufferWrite.write(str);
                bufferWrite.newLine();
            }
            bufferRead.close();
            bufferWrite.close();
        } catch (IOException e) {
            System.out.println(e.toString());
            
        }
    }
}
