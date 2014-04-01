package com.nice.mapred;

import java.io.File;
import java.io.IOException;

import org.apache.avro.*;
import org.apache.avro.Schema.Type;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.mapred.*;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;

import com.nice.model.User;

public class UserNameCount extends Configured implements Tool {

    public static class UserNameMapper extends AvroMapper<User, Pair<CharSequence, Integer>> {
        @Override
        public void map(User user, AvroCollector<Pair<CharSequence, Integer>> collector, Reporter reporter)
                throws IOException {
            CharSequence username = user.getUsername();
            collector.collect(new Pair<CharSequence, Integer>(username, 1));
        }
    }

    public static class UserNameReducer extends AvroReducer<CharSequence, Integer,
            Pair<CharSequence, Integer>> {
        @Override
        public void reduce(CharSequence key, Iterable<Integer> values,
                           AvroCollector<Pair<CharSequence, Integer>> collector,
                           Reporter reporter)
                throws IOException {
            int sum = 0;
            for (Integer value : values) {
                sum += value;
            }
            collector.collect(new Pair<CharSequence, Integer>(key, sum));
        }
    }

    public int run(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: MapredUserNameCount <input path> <output path>");
            return -1;
        }

        JobConf conf = new JobConf(getConf(), UserNameCount.class);
        conf.setJobName("usernamecounter");

        FileInputFormat.setInputPaths(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));

        AvroJob.setMapperClass(conf, UserNameMapper.class);
        AvroJob.setReducerClass(conf, UserNameReducer.class);

        // Note that AvroJob.setInputSchema and AvroJob.setOutputSchema set
        // relevant config options such as input/output format, map output
        // classes, and output key class.
        AvroJob.setInputSchema(conf, User.getClassSchema());
        AvroJob.setOutputSchema(conf, Pair.getPairSchema(Schema.create(Type.STRING), Schema.create(Type.INT)));

        JobClient.runJob(conf);
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("ARGS: " + args);
        File file = new File(args[1]);
        if(file.exists()) {
            file.delete();
        }
        int res = ToolRunner.run(new Configuration(), new UserNameCount(), args);

        File outputAvroFile = new File(args[1] + "/" + "part-00000.avro");

        Schema pairSchema = Pair.getPairSchema(Schema.create(Type.STRING), Schema.create(Type.INT));

        GenericDatumReader<GenericRecord> reader = new GenericDatumReader<GenericRecord>(pairSchema);
        DataFileReader<GenericRecord> fileReader = new DataFileReader<GenericRecord>(outputAvroFile, reader);

        for (GenericRecord record : fileReader) {
            System.out.println(record);
        }

        System.exit(res);
    }
}