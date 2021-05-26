package com.example.GymKrabbler2.webCrawler;

public class SpiderTest
{
    /**
     * This is our test. It creates a spider (which creates spider legs) and crawls the web.
     * 
     * @param args
     *            - not used
     */
    public static void main(String[] args)
    {
        Spider spider = new Spider();
        spider.search("https://fit-in.de/", "Laufzeit");
        String kosten_fitIn = spider.getTreffer();
        
        
       
        
    }
}
