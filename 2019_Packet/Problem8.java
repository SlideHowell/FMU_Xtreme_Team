package com.company;
import java.util.*;

/*
Name:       Samuel Howell
Date:       12-11-2020
Packet:     2019
Problem:    Problem 8
 */

public class mp3Library
{

    public static void main(String[] args)
    {
        final ArrayList<String> timeArr = new ArrayList<>();


        Scanner sc = new Scanner(System.in);

        String input;
        ArrayList<String> songInfoList = new ArrayList<>();
        ArrayList<Song> songObjects = new ArrayList<>();;

        //  get input
        while(true)
        {
            input = sc.nextLine();
            if(input.equals("-1"))
                break;
            songInfoList.add(input);
        }

        //  create song objects based on the input
        for(String songInfo : songInfoList)
        {
            String[] songArr = songInfo.split(" ");
            Song song = new Song(songArr[0], songArr[1], songArr[2], songArr[3], songArr[4]);
            songObjects.add(song);
        };

        //find total time
        for(Song song : songObjects)
            timeArr.add(song.getTime());

        String totalTime = findTime(timeArr);
        timeArr.clear();    //  clear the timeArr to get it ready for adding time of individual albums

        //OUTPUT::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
        System.out.println(songObjects.size() + " MP3 files, " + totalTime + " of time");
        System.out.println();

        // finding unique album info
        Set albumSet = new TreeSet();   //  use treeset for alphabetical ordering, and not allowing duplicates

        for(Song song : songObjects)
        {
            albumSet.add(song.getAlbum());
        }

        int songCount = 0;                                  //  for keeping track of how many songs are in each album
        ArrayList<Song> songsInAlbum = new ArrayList<>();   //  keeping track of the specific songs in each album

        for(Object album : albumSet)
        {
            for(Song song : songObjects)
            {
                if (song.getAlbum().equals(album))
                {
                    songCount++;
                    timeArr.add(song.getTime());                    //adding up the time of the tracks

                    // sorting the album using the track number of the album's
                    // if the current song's track number is lower than the track number occupying the first position in the songsInAlbum arraylist, place the current track in that first spot
                    if(songsInAlbum.size() < 1)     // handles if the songsInAlbum is empty
                    {
                        songsInAlbum.add(song);
                    }
                    else if(Integer.parseInt(song.getTrack()) < Integer.parseInt(songsInAlbum.get(0).getTrack()))       //  current track num < first track num
                    {
                        songsInAlbum.add(0, song);
                    }
                    else                                                                                                //  current track num > first track num
                    {
                        songsInAlbum.add(song);
                    }
                }
            }

            System.out.println(album + ": " + songCount + ", " + findTime(timeArr));

            for(Song song : songsInAlbum)
            {
                System.out.println(" " + song.getTrack() + ". " + song.getTitle().replaceAll("_", " ") + " " + song.getTime());
            }

            //  reset everything to get it ready for the next album
            songCount = 0;
            timeArr.clear();
            songsInAlbum.clear();
        }
    }

    //  method to find time when given an array of elements in the format m:ss
    private static String findTime(ArrayList<String> timeArr)
    {
        String[] splitTime;
        int min = 0;
        int sec = 0;

        for(String time : timeArr)
        {
            splitTime = time.split(":");
            min += Integer.parseInt(splitTime[0]); //  add up all min
            sec += Integer.parseInt(splitTime[1]); // add up all sec
        }

        //  convert those seconds to min, with the modulo to signify seconds left
        int secToMin  = (sec / 60) % 60;
        int secRemaining = sec % 60;

        //  add the sec that were converted to min to the total min
        min += secToMin;

        if(secRemaining < 10)
        {
            return min + ":0" + secRemaining;           //formatting for remain secs

        }
        return  min + ":" + secRemaining;
    }

}

//  song class to store song objects with all the necessary variables
class Song
{
    private String title;
    private String time;
    private String album;
    private String genre;
    private String track;

    public Song(String title, String time, String album, String genre, String track)
    {
        this.title = title;
        this.time = time;
        this.album = album;
        this.genre = genre;
        this.track = track;
    }

    //  getters and setters for completeness
    public String getTitle()
    {
        return title;
    }

    public String getTime()
    {
        return time;
    }

    public String getAlbum()
    {
        return album;
    }

    public String getGenre()
    {
        return genre;
    }

    public String getTrack()
    {
        return track;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public void setAlbum(String album)
    {
        this.album = album;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public void setTrack(String track)
    {
        this.track = track;
    }
}
