package org.mkscrg.java_playground;

import java.util.Scanner;
import com.mongodb.*;

public class MongoRW {
    public static void main(String[] args)
      throws java.net.UnknownHostException {
        Scanner scanner = new Scanner(System.in);

        Mongo m = new Mongo();
        DB d = m.getDB("test");
        DBCollection coll = d.getCollection("docs");

        int i = 0;
        System.out.println("Reading docs from stdin...");
        while (scanner.hasNextLine()) {
            BasicDBObject doc = new BasicDBObject();
            doc.put("txt", scanner.nextLine());
            System.out.printf("Inserting %s into MongoDB...\n",
                    doc.toString());
            coll.insert(doc);
            i++;
        }
        System.out.printf("Inserted %d docs into MongoDB.\n\n", i);

        System.out.println("Reading documents from DB...");
        DBCursor curs = coll.find();
        System.out.printf("Found %d documents:\n", curs.count());
        for (Object obj : curs) {
            System.out.println(obj.toString());
        }
    }
}
