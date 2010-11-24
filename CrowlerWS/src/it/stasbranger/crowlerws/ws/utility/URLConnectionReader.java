package it.stasbranger.crowlerws.ws.utility;

import java.net.*;
import java.util.StringTokenizer;
import java.io.*;

public class URLConnectionReader {
        
        static public BufferedReader openConnection(String url){
                StringTokenizer st = new StringTokenizer(url.trim(),"://");
                if(!st.nextToken().equals("http")){
                        url = "http://" + url.trim();
                }
                
                try {
                URL u = new URL(url);
                URLConnection uc = u.openConnection();
                BufferedReader in = new BufferedReader(
                                        new InputStreamReader(
                                        uc.getInputStream()));
                return in;
                }catch (FileNotFoundException e){
                        e.printStackTrace();
                }catch (Exception e){
                        e.printStackTrace();
                }
                return null;
        }
        
        static public void closeConnection(BufferedReader in){
                try{
                        in.close();
                }catch (Exception e) {
                        e.printStackTrace();
                }
        }
        
        
        static public String getCleanURL(String url){
                
                StringTokenizer stUrl = new StringTokenizer(url.trim(),"/");
                String nt = stUrl.nextToken();
                if(nt.equals("http:")){
                        url = url.substring(7, url.length());
                }else if(nt.equals("https:")){
                        url = url.substring(8, url.length());
                }
                
                String lastChar = url.substring(url.length()-1, url.length());
                if(lastChar.equals("/")){
                        url = url.substring(0, url.length()-1);
                }
                return url;
        }
        
        static public String getFullURL(String url, String domain){
                
                String fullDomain = getCleanURL(url.trim());
                domain = getCleanURL(domain.trim());
//              String fullUrl = getCleanURL(url.trim());
                
                StringTokenizer stUrl = new StringTokenizer(url.trim(),"/");
                String nt = stUrl.nextToken();
                System.out.println(nt);
                if(!(nt.equals("http:"))){
                        if(nt.equals(domain) || nt.equals("www." + domain)){    
                                fullDomain = "http://" + url.trim();
                        }else if(nt.substring(0, 1).equals("/")){
                                fullDomain = "http://" + domain.trim() + url.trim();
                        }else {
                                fullDomain = "http://" + domain.trim() + "/" + url.trim();
                        }       
                }else{
                        fullDomain = url.trim();
                }
                
                return fullDomain;
        }
        
        static public String getContentsURL(String url){
                        
                StringTokenizer st = new StringTokenizer(url.trim(),"://");
                if(!st.nextToken().equals("http")){
                        url = "http://" + url.trim();
                }
                
                StringBuilder contents = new StringBuilder();
                try {
                URL u = new URL(url);
                URLConnection uc = u.openConnection();
                BufferedReader in = new BufferedReader(
                                        new InputStreamReader(
                                        uc.getInputStream()));
                try{
                String inputLine;
        
                while ((inputLine = in.readLine()) != null){
                        contents.append(inputLine);
                    contents.append(System.getProperty("line.separator"));
                }
              }finally{
                        in.close();
                }
                }       catch (FileNotFoundException e){
                                e.printStackTrace();  
                }catch (Exception e) {
                        e.printStackTrace();
                }
                return contents.toString();
        }
}

