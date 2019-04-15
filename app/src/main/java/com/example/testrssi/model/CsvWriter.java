package com.example.testrssi.model;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class CsvWriter {

    private String path;
    private OutputStreamWriter writer;

    public CsvWriter(OutputStreamWriter writer){
        this.writer = writer;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath(){
        return path;
    }

    public void writeToFile(String data) throws IOException {
        writer.write(data);
        writer.close();
    }

    public void closeFile() throws IOException{
        writer.close();
    }

}
