/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mirea.student.shayko.bigdata_lab2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author joker
 */
public class CrossCorelation2 {
    public static class MyMapper extends Mapper<Object, Text, Text, Dict> {
        private final static IntWritable one = new IntWritable(1);
        private ArrayList<Text> products;
        
        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            products = new ArrayList<Text>();
            
            StringTokenizer st = new StringTokenizer(value.toString(), ",");
            
            while (st.hasMoreTokens()) {
                Text word = new Text();
                word.set(st.nextToken());
                products.add(word);
            }
            
            for(int i = 0; i < products.size(); ++i) {
                Dict map = new Dict();
                
                for(int j = 0; j < products.size(); ++j)
                    if (products.get(i) != products.get(j)) {
                        Text product = products.get(j);
                        map.put(product, one);
                    }
                
                context.write(products.get(i), map);
            }
            
        }
    }

    public static class MyReducer extends Reducer<Text, Dict, Text, Dict> {
    private Dict d1 = new Dict();
    
    public void reduce(Text key, Iterable<Dict> maps, Context context) throws IOException, InterruptedException {
      Dict h = new Dict();
      for (Dict map : maps) {
          if (map.toString().compareTo(d1.toString()) == 0)
              continue;

          d1.clear();
          d1.copy(map);

          Iterator<Text> it = map.keySet().iterator();
          while (it.hasNext()) {
              Text product = it.next();
              if (h.containsKey(product)) {
                  IntWritable val = h.get(product);
                  IntWritable i = new IntWritable(val.get() + 1);
                  h.put(product, i);
              } else {
                  h.put(product, new IntWritable(1));
              }
          }
      }
      
      context.write(key, h);
    }
  }
}
