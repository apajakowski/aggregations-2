import java.math.BigInteger;
import java.net.UnknownHostException;

import com.mongodb.*;

public class Main {
	public static void main(String[] args) throws UnknownHostException {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("test");
		DBCollection trainCollection = db.getCollection("train");
		DBCursor it = trainCollection.find();

		BigInteger noOfRecords = new BigInteger("0");
		for (DBObject oldRecord: it) {
			BasicDBList newRecord = new BasicDBList();
			for (String key : oldRecord.keySet()) {
				if (key.equals("Tags")) {
					String record = "" + oldRecord.get(key);
					String[] tags = record.toString().replace(".", "").split(" ");
					
					for(String el: tags) {
						newRecord.add(new BasicDBObject(el, el));
					}
				}
			}

			trainCollection.update(oldRecord, newRecord);
			noOfRecords = noOfRecords.add(new BigInteger("1"));
		}

		it.close();

		System.out.println("No of records parsed: " + noOfRecords);

	}
}
