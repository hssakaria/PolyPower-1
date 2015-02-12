package edu.csupomona.cs480;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.csupomona.cs480.data.codeSubmit;


public class GoldSilverPrice
{
	 public static void main(String[] args) {
		 
			Document doc;
			try {
		 
				// need http protocol
				doc = Jsoup.connect("https://news.google.com/news").get();
		 
				// get page title
				String title = doc.title();
				System.out.println("title : " + title);
		 
				// get all links
				Elements links = doc.select("a[href]");
				
				for (Element link : links) {
		 
					// get the value from href attribute
					System.out.println("\nlink : " + link.attr("href"));
					System.out.println("text : " + link.text());
						 
				}
		 
			} catch (IOException e) {
				e.printStackTrace();
			}
		 
		  }
		 
		}
