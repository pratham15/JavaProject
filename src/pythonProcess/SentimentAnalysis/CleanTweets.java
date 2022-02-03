package pythonProcess.SentimentAnalysis;

import java.io.*;
import java.util.Scanner;
import java.util.*;

class Read_CSV{
    Scanner file;

    Read_CSV(String fileName){
        try{
            this.file = new Scanner(new File("/Users/prathamaggarwal/desktop/college/Sem 2/CSD213/Swing/src/pythonProcess/SentimentAnalysis/" + fileName + ".txt"));
        } catch (Exception ex){
            System.out.println("ERROR!!! FILE NOT FOUND!");
            System.exit(-1);
        }
    }

    private String _get_next(){
        return this.file.nextLine();
    }

    ArrayList<String> get_list(){
        ArrayList<String> mainList = new ArrayList<String>();
        while(this.file.hasNextLine()){
            mainList.add(_get_next());
        }
        return mainList;
    }
    ArrayList<String> get_list(boolean clean){
        ArrayList<String> mainList = new ArrayList<String>();
        while(this.file.hasNextLine()){
            String s = _get_next();
            mainList.add(s);
        }
        return mainList;
    }

    void close(){
        this.file.close();
    }
}

public class CleanTweets{
    boolean countForTags = false;

    ArrayList<String> StringToListContains(String[] mainString, String check){
        countForTags = false;
        ArrayList<String> mainList = new ArrayList<String>();
        for(String temp: mainString){
            if(temp.contains(check)){
                countForTags=true;
                mainList.add(temp.substring(1).toLowerCase());
            }
        }
        return mainList;
    }

    HashMap NestedArraytoHashMap(ArrayList<ArrayList<String>> list){
        HashMap map = new HashMap();
        for(ArrayList<String> currentList: list){
            for(String currentString: currentList){
                String t = currentString.replaceAll("[^a-zA-Z]", "");
                if(map.get(t)==null)
                    map.put(t, 1);
                else
                    map.put(t, (int)map.get(t)+1);
            }
        }
        return map;
    }

    public HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public String[] get_related_list(String filename){
        Read_CSV file = new Read_CSV(filename);
        ArrayList<String> tweetListRaw = file.get_list();
        ArrayList<ArrayList<String>> tweetsProcessed = new ArrayList<ArrayList<String>>();
        for(String raw_tweet: tweetListRaw){
            ArrayList<String> tagsInTweet = StringToListContains(raw_tweet.split("\\s+"), "@");
            if(countForTags)
                tweetsProcessed.add(tagsInTweet);
        }

        HashMap numberOfTags = NestedArraytoHashMap(tweetsProcessed);
        Map<String, Integer> sortedMap = sortByValue(numberOfTags);
        String[] finalList = new String[5];

        int count = -1;
        for (Map.Entry<String, Integer> current : sortedMap.entrySet()) {
            if(count==5) break;
            if(count==-1){
                count+=1;
                continue;
            }
            finalList[count] = "@" + current.getKey();
            count+=1;
        }
        file.close();
        return finalList;
    }

    public String[] get_related_list(String filename, String tweets){

        Read_CSV bad_file = new Read_CSV(filename);
        Read_CSV tweetsCSV = new Read_CSV(tweets);
        ArrayList<String> badWordsList = bad_file.get_list(true);
        ArrayList<String[]> bad = new ArrayList<String[]>();
        for(String raw_tweet: badWordsList){
            bad.add(raw_tweet.split("\\s+"));
        }
        ArrayList<String> tweetListRaw = tweetsCSV.get_list();
        bad_file.close();
        tweetsCSV.close();

        String[] finalList = new String[3];
        int[] indexes = {-1, -1, -1, -1, -1};

        int j = 0;
        int i = 0;
        for(String tweet: tweetListRaw){
            if(i==3){
                break;
            }
            boolean skip = false;
            String[] listt = tweet.split("\\s+");
            for(String currentWord: listt){
                for(String[] x: bad){
                    for(String y: x){
                        if(currentWord.toUpperCase().compareTo(y.toUpperCase())==0){
                            skip=true;
                            break;
                        }
                    }
                }
            }

            if(skip){
                j+=1;
                continue;
            }
            indexes[i] = j;
            j+=1;
            i+=1;
        }

        for(int a=0;a<3;a++){
            int index = indexes[a];
            if(index==-1){
                finalList[a] = "NA";
                continue;
            } else{
                finalList[a] = tweetListRaw.get(index);
            }
        }
        return finalList;
    }
}