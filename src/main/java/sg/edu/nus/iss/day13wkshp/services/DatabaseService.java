package sg.edu.nus.iss.day13wkshp.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.day13wkshp.models.Contact;

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

    public boolean save(Contact contact) {
        File file = new File(this.dataDir, contact.getId());
        try (OutputStream out = new FileOutputStream(file)) {
            PrintWriter pw = new PrintWriter(out);
            pw.println(contact.getId());
            pw.println(contact.getName());
            pw.println(contact.getEmail());
            pw.println(contact.getPhone());
            // pw.print(contact.toString());
            pw.flush();
            return true;
        } catch (IOException ex) {
            System.err.printf("Error: %s\n", ex.getMessage());
            ex.printStackTrace();
            return false;
        }
        // return false;
    }

    public Contact read(String fileId) {
        try {
            // File file = new File(this.dataDir, fileId);
            // Scanner myReader = new Scanner(file);
            // while (myReader.hasNextLine()) {
            // System.out.println(myReader.nextLine());
            // }
            // myReader.close();

            Contact contact = new Contact();

            Path filePath = new File(this.dataDir, fileId).toPath();
            Charset charset = Charset.forName("utf-8");
            List<String> stringVal = Files.readAllLines(filePath, charset);

            contact.setName(stringVal.get(1));
            contact.setEmail(stringVal.get(2));
            contact.setPhone(stringVal.get(3));
            
            return contact;

        } catch (IOException ex) {
            System.err.printf("Error: %s\n", ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}
