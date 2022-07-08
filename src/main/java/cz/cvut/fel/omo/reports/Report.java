package cz.cvut.fel.omo.reports;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Report {
    
    private List<String> lines = new ArrayList<>();
    private Path path;
    
    protected void generateHeader(String name){
        lines.add(name);
        lines.add(new Date().toString());
        lines.add("-----------------------------------");
        
        path = Paths.get("generatedReports", name + ".txt");
    }


    protected void writeReport(){
        try{
            Files.write(this.getPath(), this.getLines(), StandardCharsets.UTF_8);
        }catch(IOException e){
            System.err.println("Error generating" + this.getPath());
            System.err.print(e);
        }
    }

    public void addLine(String line){
        lines.add(line);
    }
    
    public Path getPath(){
        return path;
    }
    
    public List<String> getLines(){
        return lines;
    }
}
