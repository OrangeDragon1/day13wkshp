package sg.edu.nus.iss.day13wkshp.services;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
    private File dataDir = new File("placeholder");

    public File getDataDir() {
        return dataDir;
    }

    public void setDataDir(File dataDir) {
        this.dataDir = dataDir;
    }

    // /Users/kok/vttp/data
    public boolean isDataDirValid() {
        return dataDir.exists() && dataDir.isDirectory() && dataDir.canWrite();
    }

}
