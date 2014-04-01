package com.nice.mapred;

import com.nice.model.User;
import org.apache.avro.Schema;
import org.apache.avro.file.CodecFactory;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateData {


    public static void main(String[] args) throws IOException {

        User user1 = User.newBuilder()
                .setUsername("Ciccio")
                .setPassword("changeme")
                .build();

        User user2 = User.newBuilder()
                .setUsername("PluckedChicken")
                .setPassword("changeme")
                .build();


        User user3 = User.newBuilder()
                .setUsername("Wilson")
                .setPassword("changeme")
                .build();


        User user4 = User.newBuilder()
                .setUsername("Ettoreeeeee")
                .setPassword("changeme")
                .build();


        User user5 = User.newBuilder()
                .setUsername("Ciccio")
                .setPassword("changeme")
                .build();


        User user6 = User.newBuilder()
                .setUsername("Ciccio")
                .setPassword("changeme")
                .build();

        List<User> users = new ArrayList<User>(Arrays.asList(user1, user2, user3, user4, user5, user6));

        Schema schema = new Schema.Parser().parse(new File("src/main/avro/user.avsc"));

        GenericDatumWriter<GenericRecord> genericWriter = new GenericDatumWriter<GenericRecord>(schema);
        DataFileWriter<GenericRecord> fileWriter = new DataFileWriter<GenericRecord>(genericWriter);
        fileWriter.setCodec(CodecFactory.snappyCodec());
        fileWriter.create(schema, new File("src/main/dataOutput/generated.avro"));

        for (User user : users) {
            //Populating the writer and flushing the serialized data on disk
            fileWriter.append(user);
        }
        fileWriter.close();

    }

}
