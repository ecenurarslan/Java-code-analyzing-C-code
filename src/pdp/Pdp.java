/**
*
* @author Berke VAROL-> berke.varol@ogr.sakarya.edu.tr
*         Ece Nur ARSLAN->ece.arslan1@ogr.sakarya.edu.tr
* @since  28.02.2019
* <p>
* C kaynak kodundaki operator fonksiyon ve parametreleri sayan, fonksiyon ve parametreleri listeleyen java programi
* </p>
*/

package pdp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Berke
 */
public class Pdp {

    public static int OperatorSay(String text){
        char[] array = {'+', '-', '&','=', '/', '*','<', '>','!','|' };
        /**/
        int operators =0;
        for (int i=0; i < text.length(); i++)
        {
            for (int j = 4; j < 7; j++) 
            {
                if (text.charAt(i) == array[j]) 
                {
                    operators++;
                }
            }
            if(text.charAt(i)== '+')
            {
                
                if(text.charAt(i+1)== '+')
                {
                    operators++;
                    i++;
                }
                
                else operators ++;
            }
            else if(text.charAt(i)== '-')
            {
                if(text.charAt(i+1)== '-')
                {
                    operators++;
                    i++;
                }
                else operators ++;
            }
            else if(text.charAt(i)== '&')
            {
                if(text.charAt(i+1)== '&')
                {
                    operators++;
                    i++;
                }
                else operators ++;
            }
            else if(text.charAt(i)== '=')
            {
                if(text.charAt(i+1)== '=')
                {
                    operators++;
                    i++;
                }
                else operators ++;
            }
            else if(text.charAt(i)== '!' && text.charAt(i+1)== '=')
            {
                operators++;
            }
            else if(text.charAt(i)== '|' && text.charAt(i+1)== '|')
            {
                operators++;
            }
            
        }
        return operators;
    }
    public static String Temizle(String text){
        //text = text.replaceAll("\\s+","");
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == '/' && text.charAt(i+1) == '*')
            {
            text = text.substring(0,text.indexOf("/*"))+text.substring(text.indexOf("*/")+2,text.length());
            }
        }
        return text;
    }
    public static void FonksiyonSay(String text){
        int intindex;
        int parantezindex;
        int kparantezindex;
        int parametreindex;
        int virgulindex;
        int parametresayisi = 0;
        ArrayList<String> fonksiyonlar = new ArrayList<String>();
        List d = new Stack();
        for (int i = 0; i < text.length(); i++) 
        {
            
            if(text.charAt(i) == 'd' && text.charAt(i+1) == 'o' && text.charAt(i+2) == 'u' && text.charAt(i+3) == 'b' && text.charAt(i+4) == 'l' && text.charAt(i+5) == 'e' && !Character.isLetterOrDigit(text.charAt(i-1)) && text.charAt(i-1) != '(')
          {
            intindex=i;
            while(text.charAt(i) != '(')
            {
                i++;   
            }
            parantezindex = i;
            if(!text.substring(intindex,parantezindex).contains(";") && !text.substring(intindex,parantezindex).contains("="))
            {  
                ArrayList<String> parametreler = new ArrayList<String>();
               
                while(text.charAt(i) == ' ')
                {
                    i++;
                }
                while(text.charAt(i) != ' ')
                {
                    i++;
                }
                while(text.charAt(i) == ' ')
                {
                    i++;
                }
                parametreindex=i;
                while(text.charAt(i)!= ')')
                {
                    i++;
                }
                kparantezindex = i;
                i=parametreindex;
                
                virgulindex = parantezindex;
                    while(text.substring(i+1,kparantezindex).contains(","))
                    {
                        virgulindex++;
                        while(text.charAt(virgulindex) == ' ')virgulindex++;
                        while(text.charAt(virgulindex) != ' ')virgulindex++;
                        while(text.charAt(virgulindex) == ' ')virgulindex++;
                        i++;
                        while(text.charAt(i) != ',')
                        {
                            i++;
                        }
                       
                        parametreler.add(text.substring(virgulindex, i));
                        virgulindex = i;
                        
                    }
                     while(text.charAt(virgulindex+1) == ' ')virgulindex++;
                     while(text.substring(virgulindex+1,kparantezindex).contains(" "))virgulindex++;
                    
                    parametreler.add(text.substring(virgulindex+1, kparantezindex));
                if(Temizle(text).charAt(parantezindex+1) == ')')
                {
                    fonksiyonlar.add(text.substring(intindex+6,parantezindex) + " - Parametreler:");
                    break;
                }
                fonksiyonlar.add(text.substring(intindex+6,parantezindex) + " - Parametreler:" + parametreler);
                parametresayisi+=parametreler.size();
            }
            else
            {
                i=intindex+1;
            }
          }
            if(text.charAt(i) == 's' && text.charAt(i+1) == 'h' && text.charAt(i+2) == 'o' && text.charAt(i+3) == 'r' && text.charAt(i+4) == 't' && !Character.isLetterOrDigit(text.charAt(i-1)) && text.charAt(i-1) != '(')
          {
            intindex=i;
            while(text.charAt(i) != '(')
            {
                i++;   
            }
            parantezindex = i;
            if(!text.substring(intindex,parantezindex).contains(";") && !text.substring(intindex,parantezindex).contains("="))
            {  
                ArrayList<String> parametreler = new ArrayList<String>();
               
                while(text.charAt(i) == ' ')
                {
                    i++;
                }
                while(text.charAt(i) != ' ')
                {
                    i++;
                }
                while(text.charAt(i) == ' ')
                {
                    i++;
                }
                parametreindex=i;
                while(text.charAt(i)!= ')')
                {
                    i++;
                }
                kparantezindex = i;
                i=parametreindex;
                virgulindex = parantezindex;
                    while(text.substring(i+1,kparantezindex).contains(","))
                    {
                        virgulindex++;
                        while(text.charAt(virgulindex) == ' ')virgulindex++;
                        while(text.charAt(virgulindex) != ' ')virgulindex++;
                        while(text.charAt(virgulindex) == ' ')virgulindex++;
                        i++;
                        while(text.charAt(i) != ',')
                        {
                            i++;
                        }
                       
                        parametreler.add(text.substring(virgulindex, i));
                        virgulindex = i;
                        
                    }
                     while(text.charAt(virgulindex+1) == ' ')virgulindex++;
                     while(text.substring(virgulindex+1,kparantezindex).contains(" "))virgulindex++;
                    
                    parametreler.add(text.substring(virgulindex+1, kparantezindex));
                if(Temizle(text).charAt(parantezindex+1) == ')')
                {
                    fonksiyonlar.add(text.substring(intindex+5,parantezindex) + " - Parametreler:");
                    break;
                }
                fonksiyonlar.add(text.substring(intindex+5,parantezindex) + " - Parametreler:" + parametreler);
                parametresayisi+=parametreler.size();
            }
            else
            {
                i=intindex+1;
            }
          }
            if(text.charAt(i) == 'f' && text.charAt(i+1) == 'l' && text.charAt(i+2) == 'o' && text.charAt(i+3) == 'a' && text.charAt(i+4) == 't' && !Character.isLetterOrDigit(text.charAt(i-1)) && text.charAt(i-1) != '(')
          {
            intindex=i;
            while(text.charAt(i) != '(')
            {
                i++;   
            }
            parantezindex = i;
            if(!text.substring(intindex,parantezindex).contains(";") && !text.substring(intindex,parantezindex).contains("="))
            {  
                ArrayList<String> parametreler = new ArrayList<String>();
               
                while(text.charAt(i) == ' ')
                {
                    i++;
                }
                while(text.charAt(i) != ' ')
                {
                    i++;
                }
                while(text.charAt(i) == ' ')
                {
                    i++;
                }
                parametreindex=i;
                while(text.charAt(i)!= ')')
                {
                    i++;
                }
                kparantezindex = i;
                i=parametreindex;
                virgulindex = parantezindex;
                    while(text.substring(i+1,kparantezindex).contains(","))
                    {
                        virgulindex++;
                        while(text.charAt(virgulindex) == ' ')virgulindex++;
                        while(text.charAt(virgulindex) != ' ')virgulindex++;
                        while(text.charAt(virgulindex) == ' ')virgulindex++;
                        i++;
                        while(text.charAt(i) != ',')
                        {
                            i++;
                        }
                       
                        parametreler.add(text.substring(virgulindex, i));
                        virgulindex = i;
                        
                    }
                     while(text.charAt(virgulindex+1) == ' ')virgulindex++;
                     while(text.substring(virgulindex+1,kparantezindex).contains(" "))virgulindex++;
                    
                    parametreler.add(text.substring(virgulindex+1, kparantezindex));
                if(Temizle(text).charAt(parantezindex+1) == ')')
                {
                    fonksiyonlar.add(text.substring(intindex+5,parantezindex) + " - Parametreler:");
                    break;
                }
                fonksiyonlar.add(text.substring(intindex+5,parantezindex) + " - Parametreler:" + parametreler);
                parametresayisi+=parametreler.size();
            }
            else
            {
                i=intindex+1;
            }
          }
            if(text.charAt(i) == 'c' && text.charAt(i+1) == 'h' && text.charAt(i+2) == 'a' && text.charAt(i+3) == 'r' && !Character.isLetterOrDigit(text.charAt(i-1)) && text.charAt(i-1) != '(')
          {
            intindex=i;
            while(text.charAt(i) != '(')
            {
                i++;   
            }
            parantezindex = i;
            if(!text.substring(intindex,parantezindex).contains(";") && !text.substring(intindex,parantezindex).contains("="))
            {  
                ArrayList<String> parametreler = new ArrayList<String>();
               
                while(text.charAt(i) == ' ')
                {
                    i++;
                }
                while(text.charAt(i) != ' ')
                {
                    i++;
                }
                while(text.charAt(i) == ' ')
                {
                    i++;
                }
                parametreindex=i;
                while(text.charAt(i)!= ')')
                {
                    i++;
                }
                kparantezindex = i;
                i=parametreindex;
                virgulindex = parantezindex;
                    while(text.substring(i+1,kparantezindex).contains(","))
                    {
                        virgulindex++;
                        while(text.charAt(virgulindex) == ' ')virgulindex++;
                        while(text.charAt(virgulindex) != ' ')virgulindex++;
                        while(text.charAt(virgulindex) == ' ')virgulindex++;
                        i++;
                        while(text.charAt(i) != ',')
                        {
                            i++;
                        }
                       
                        parametreler.add(text.substring(virgulindex, i));
                        virgulindex = i;
                        
                    }
                     while(text.charAt(virgulindex+1) == ' ')virgulindex++;
                     while(text.substring(virgulindex+1,kparantezindex).contains(" "))virgulindex++;
                    
                    parametreler.add(text.substring(virgulindex+1, kparantezindex));
                if(Temizle(text).charAt(parantezindex+1) == ')')
                {
                    fonksiyonlar.add(text.substring(intindex+4,parantezindex) + " - Parametreler:");
                    break;
                }
                fonksiyonlar.add(text.substring(intindex+4,parantezindex) + " - Parametreler:" + parametreler);
                parametresayisi+=parametreler.size();
            }
            else
            {
                i=intindex+1;
            }
          }
            if(text.charAt(i) == 'i' && text.charAt(i+1) == 'n' && text.charAt(i+2) == 't' && !Character.isLetterOrDigit(text.charAt(i-1)) && text.charAt(i-1) != '(')
          {
            intindex=i;
            while(text.charAt(i) != '(')
            {
                i++;   
            }
            parantezindex = i;
            if(!text.substring(intindex,parantezindex).contains(";") && !text.substring(intindex,parantezindex).contains("="))
            {  
                ArrayList<String> parametreler = new ArrayList<String>();
               
                while(text.charAt(i) == ' ')
                {
                    i++;
                }
                while(text.charAt(i) != ' ')
                {
                    i++;
                }
                while(text.charAt(i) == ' ')
                {
                    i++;
                }
                parametreindex=i;
                while(text.charAt(i)!= ')')
                {
                    i++;
                }
                kparantezindex = i;
                i=parametreindex;
                virgulindex = parantezindex;
                    while(text.substring(i+1,kparantezindex).contains(","))
                    {
                        virgulindex++;
                        while(text.charAt(virgulindex) == ' ')virgulindex++;
                        while(text.charAt(virgulindex) != ' ')virgulindex++;
                        while(text.charAt(virgulindex) == ' ')virgulindex++;
                        i++;
                        while(text.charAt(i) != ',')
                        {
                            i++;
                        }
                       
                        parametreler.add(text.substring(virgulindex, i));
                        virgulindex = i;
                        
                    }
                     while(text.charAt(virgulindex+1) == ' ')virgulindex++;
                     while(text.substring(virgulindex+1,kparantezindex).contains(" "))virgulindex++;
                    
                    parametreler.add(text.substring(virgulindex+1, kparantezindex));
                if(Temizle(text).charAt(parantezindex+1) == ')')
                {
                    fonksiyonlar.add(text.substring(intindex+3,parantezindex) + " - Parametreler:");
                    break;
                }
                fonksiyonlar.add(text.substring(intindex+3,parantezindex) + " - Parametreler:" + parametreler);
                parametresayisi+=parametreler.size();
            }
            else
            {
                i=intindex+1;
            }
          }
            if(text.charAt(i) == 'l' && text.charAt(i+1) == 'o' && text.charAt(i+2) == 'n' && text.charAt(i+3) == 'g' && !Character.isLetterOrDigit(text.charAt(i-1)) && text.charAt(i-1) != '(')
          {
            intindex=i;
            while(text.charAt(i) != '(')
            {
                i++;   
            }
            parantezindex = i;
            if(!text.substring(intindex,parantezindex).contains(";") && !text.substring(intindex,parantezindex).contains("="))
            {  
                ArrayList<String> parametreler = new ArrayList<String>();
               
                while(text.charAt(i) == ' ')
                {
                    i++;
                }
                while(text.charAt(i) != ' ')
                {
                    i++;
                }
                while(text.charAt(i) == ' ')
                {
                    i++;
                }
                parametreindex=i;
                while(text.charAt(i)!= ')')
                {
                    i++;
                }
                kparantezindex = i;
                i=parametreindex;
                virgulindex = parantezindex;
                    while(text.substring(i+1,kparantezindex).contains(","))
                    {
                        virgulindex++;
                        while(text.charAt(virgulindex) == ' ')virgulindex++;
                        while(text.charAt(virgulindex) != ' ')virgulindex++;
                        while(text.charAt(virgulindex) == ' ')virgulindex++;
                        i++;
                        while(text.charAt(i) != ',')
                        {
                            i++;
                        }
                       
                        parametreler.add(text.substring(virgulindex, i));
                        virgulindex = i;
                        
                    }
                     while(text.charAt(virgulindex+1) == ' ')virgulindex++;
                     while(text.substring(virgulindex+1,kparantezindex).contains(" "))virgulindex++;
                    
                    parametreler.add(text.substring(virgulindex+1, kparantezindex));
                if(Temizle(text).charAt(parantezindex+1) == ')')
                {
                    fonksiyonlar.add(text.substring(intindex+4,parantezindex) + " - Parametreler:");
                    break;
                }
                fonksiyonlar.add(text.substring(intindex+4,parantezindex) + " - Parametreler:" + parametreler);
                parametresayisi+=parametreler.size();
            }
            else
            {
                i=intindex+1;
            }
          }
          if(text.charAt(i) == 'v' && text.charAt(i+1) == 'o' && text.charAt(i+2) == 'i' && text.charAt(i+3) == 'd' && !Character.isLetterOrDigit(text.charAt(i-1)) && text.charAt(i-1) != '(')
          {
            intindex=i;
            while(text.charAt(i) != '(')
            {
                i++;   
            }
            parantezindex = i;
            if(!text.substring(intindex,parantezindex).contains(";") && !text.substring(intindex,parantezindex).contains("="))
            {  
                ArrayList<String> parametreler = new ArrayList<String>();
               
                while(text.charAt(i) == ' ')
                {
                    i++;
                }
                while(text.charAt(i) != ' ')
                {
                    i++;
                }
                while(text.charAt(i) == ' ')
                {
                    i++;
                }
                parametreindex=i;
                while(text.charAt(i)!= ')')
                {
                    i++;
                }
                kparantezindex = i;
                i=parametreindex;
                virgulindex = parantezindex;
                    while(text.substring(i+1,kparantezindex).contains(","))
                    {
                        virgulindex++;
                        while(text.charAt(virgulindex) == ' ')virgulindex++;
                        while(text.charAt(virgulindex) != ' ')virgulindex++;
                        while(text.charAt(virgulindex) == ' ')virgulindex++;
                        i++;
                        while(text.charAt(i) != ',')
                        {
                            i++;
                        }
                       
                        parametreler.add(text.substring(virgulindex, i));
                        virgulindex = i;
                        
                    }
                     while(text.charAt(virgulindex+1) == ' ')virgulindex++;
                     while(text.substring(virgulindex+1,kparantezindex).contains(" "))virgulindex++;
                    
                    parametreler.add(text.substring(virgulindex+1, kparantezindex));
                if(Temizle(text).charAt(parantezindex+1) == ')')
                {
                    fonksiyonlar.add(text.substring(intindex+4,parantezindex) + " - Parametreler:");
                    break;
                }
                fonksiyonlar.add(text.substring(intindex+4,parantezindex) + " - Parametreler:" + parametreler);
                parametresayisi+=parametreler.size();
            }
            else
            {
                i=intindex+1;
            }
            
          }
          
        }
        System.out.println("Toplam Fonksiyon Sayisi: " + fonksiyonlar.size());
        System.out.println("Toplam Parametre Sayisi: " + parametresayisi);
        System.out.println("Fonksiyon İsimleri: ");
        for (int i = 0; i < fonksiyonlar.size(); i++) {
            fonksiyonlar.set(i,fonksiyonlar.get(i).replaceAll("\\s+",""));   
            System.out.println(fonksiyonlar.get(i));
        }
        
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
       String location = "C:\\Users\\Berke\\Desktop\\Program.c";
       String line = "";
       String text = "";
       FileReader fileReader = new FileReader(location);
       BufferedReader bufferedReader = new BufferedReader(fileReader);
       while((line = bufferedReader.readLine()) != null) 
        {
            for(int i=0;i<line.length();i++)
            {
                if(line.charAt(i) == '/' && line.charAt(i+1) == '/')
                {
                    if(i!=0){
                    line = line.substring(0, i-1);
                    }
                    else line="";
                }   
            }
            text += line;
        }
        System.out.println("Toplam Operator Sayisi: " + OperatorSay(text));
        FonksiyonSay(text);        
    }
}        