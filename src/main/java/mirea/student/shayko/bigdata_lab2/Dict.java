/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mirea.student.shayko.bigdata_lab2;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import javafx.util.Pair;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author joker
 */
public class Dict implements WritableComparable<Dict> {
    public HashMap<Text,IntWritable> map = new HashMap<Text,IntWritable>();
    
    public int size() { return map.size(); }
    public boolean containsKey(Object key) { return map.containsKey(key); }
    public boolean containsValue(Object value) { return map.containsValue(value); }
    public IntWritable get(Object key) { return map.get(key); }
    public IntWritable put(Text key, IntWritable value) { return map.put(key, value); }
    public IntWritable remove(Object key) { return map.remove(key); }
    public void putAll(Map<? extends Text, ? extends IntWritable> m) { map.putAll(m); }
    public void clear() { map.clear(); }
    public Set<Text> keySet() { return map.keySet(); }
    public Collection<IntWritable> values() { return map.values(); }
    public Set<Map.Entry<Text, IntWritable>> entrySet() { return map.entrySet(); }
    public boolean isEmpty() { return map.isEmpty(); }
    
    public void copy(Dict d1) {
        Iterator it = d1.keySet().iterator();
        while (it.hasNext()) {
            Text key = (Text) it.next();
            IntWritable i = (IntWritable) d1.get(key);
            this.map.put(key, i);
        }
    }

    public void readFields(DataInput arg0) throws IOException {
        String input = arg0.readUTF();
        StringTokenizer st = new StringTokenizer(input, ",");
        while (st.hasMoreTokens()) {
            Text key = new Text(st.nextToken());
            IntWritable i = new IntWritable(Integer.parseInt(st.nextToken()));
            map.put(key, i);
        }
    }

    public void write(DataOutput arg0) throws IOException {
        String output = "";
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Text key = (Text) it.next();
            IntWritable i = (IntWritable) map.get(key);
            output += key.toString() + "," + i.toString() + ",";
            // map.remove(key, i);
        }

        arg0.writeUTF(output);
    }

    public int compareTo(Dict d1) {
        int k = this.map.toString().compareTo(d1.map.toString());

        Iterator it = map.keySet().iterator();
        Iterator it1 = d1.map.keySet().iterator();
        int b1 = 0;
        int b2 = 0;
        while (true) {
            if (!it1.hasNext() && it.hasNext())
                return -1;
            if (!it.hasNext() && it1.hasNext())
                return -2;
            if (!it.hasNext() && !it1.hasNext())
                return -3;
            Text key = (Text) it.next();
            Text key1 = (Text) it1.next();
            b1 = key.compareTo(key1);
            IntWritable i = this.map.get(key);
            IntWritable i1 = d1.map.get(key1);
            b2 = i.compareTo(i1);
            if (b1 != 0 && b2 != 0)
                return 0;
            else
                return -1;
        }
        
    }

    public String toString() {
        String output = "";
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Text key = (Text) it.next();
            IntWritable i = (IntWritable) map.get(key);
            output += "\n" + key.toString() + " : " + i.toString() + "\n";
        }
        
        return output;
    }
}
