/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exarraybidimensional;
import java.util.Scanner;
/**
 *
 * @author Guillem
 */
public class ExArrayBidimensional {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner MiScanner = new Scanner(System.in);
       
        //Es defineix un array de 7 files i 24 columnes
        String agenda [][] = new String [7][24];
        
        buidaragenda(agenda);
        imprimiragenda(agenda);
        afegircita(agenda); 
        imprimiragenda(agenda);
        modificarcita(agenda);
        imprimiragenda(agenda);
        esborrarcita(agenda);
        imprimiragenda(agenda);
        quantslliure(agenda);
        quantsocupats(agenda);
        quantstotal(agenda);
    }
    
    public static void buidaragenda(String a[][])
    {
        int dia, hora;
        
        for(hora=0;hora<24;hora++)
        {
            for(dia=0;dia<7;dia++)
            {
                //Indiquem que tant el dia com l'hora mosrtrarà la paraula "Lliure"
                a[dia][hora]="Lliure";
            }  
        }
    }
    
    public static void imprimiragenda(String a[][])
    {
        int dia, hora;
        System.out.print("\tDL\tDM\tDX\tDJ\tDV\tDS\tDM\n");
        for(hora=0;hora<24;hora++)
        {
            if(hora<10)
            {
                //Definim un zero devant de tot (1-->01)
                System.out.print("0");
            }
            //\t, serveix per a fer tabuladors
            System.out.print(hora+":00\t");
            for(dia=0;dia<7;dia++)
            {
                System.out.print(a[dia][hora]+"\t");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    
    public static void afegircita(String a[][])
        {   
            Scanner MiScanner = new Scanner(System.in);
            int hora, dia, afegir;
    
            System.out.print("Vols afegir alguna cita? (0-No, 1-Si): ");
            afegir=MiScanner.nextInt();
            
            if(afegir==0)
            {
                System.out.print("No vols afegir ninguna cita.\n");
            }
            while(afegir==1)
            {
                System.out.print("Quin hora vols canviar? (0-23): ");
                hora=MiScanner.nextInt();
                System.out.print("Quin dia vols canviar? (0-6): ");
                dia=MiScanner.nextInt();

                System.out.print("Que vols afegir? : ");
                a[dia][hora]=MiScanner.next();
                
                imprimiragenda(a);
                
                System.out.print("Vols afegir alguna cita? (0-No, 1-Si): ");
                afegir=MiScanner.nextInt();
                
                if(afegir==0)
                {
                    System.out.print("No vols afegir ninguna cita.\n");
                }
            }
            
            //imprimiragenda(a);
        }
    
    public static void modificarcita(String a[][])
    {
        Scanner MiScanner = new Scanner(System.in);
        
        int resposta, hora, dia;
        
        
        System.out.print("Vols modificar alguna cita? (0-No, 1-Si): ");
        resposta=MiScanner.nextInt();
        
        while(resposta==1) 
        {          
            
            System.out.print("Quin hora vols canviar? (0-23): ");
            hora=MiScanner.nextInt();
            System.out.print("Quin dia vols canviar? (0-6): ");
            dia=MiScanner.nextInt();

            System.out.print("Quina nova cita vols afegir? : ");
            a[dia][hora]=MiScanner.next();
            
            imprimiragenda(a);
            
            System.out.print("Vols modificar alguna cita? (0-No, 1-Si): ");
            resposta=MiScanner.nextInt();
            
            if(resposta==0)
            {
                System.out.print("No vols modificar ninguna cita.\n");
            }
        }
        
        if(resposta==0)
        {
            System.out.print("No vols modificar ninguna cita.\n");
        }
    }
    
    public static void esborrarcita(String a[][])
    {
        Scanner MiScanner = new Scanner(System.in);
        int hora, dia, esborrar;
    
        System.out.print("Vols esborrar alguna cita? (0-No, 1-Si): ");
        esborrar=MiScanner.nextInt();
        
        while(esborrar==1)
        {
            System.out.print("Quin hora vols esborrar? (0-23): ");
            hora=MiScanner.nextInt();
            System.out.print("Quin dia vols esborrar? (0-6): ");
            dia=MiScanner.nextInt();
            
            a[dia][hora]="Lliure";
            
            imprimiragenda(a);
            
            System.out.print("Vols esborrar alguna cita? (0-No, 1-Si): ");
            esborrar=MiScanner.nextInt();
            
            if(esborrar==0)
            {
                System.out.println("No vols esborrar ninguna cita.");
            }
        }
        
        if(esborrar==0)
        {
            System.out.println("No vols esborrar ninguna cita.");
        }

    }
    
    public static int quantslliure(String a[][])
    {
        int dia, hora, ql=0;
        
        for(hora=0;hora<24;hora++)
        {
            for(dia=0;dia<7;dia++)
            {
                    if(a[dia][hora].equalsIgnoreCase("LLiure"))
                        ql++;
            }  
        }
        System.out.print("Tens "+ql+" lliure.\n");
        return ql;
    }
    
    public static int quantsocupats(String a[][])
    {
        return (a.length*a[0].length)-quantslliure(a);
    }
    
    public static void quantstotal(String [][]a)
    {
        int dia,hora;
        String paraules[]=new String[200];
        int nump=1;
        int i;
        boolean trobat=false;
        paraules[0]=a[0][0];
        
        for(dia=0;dia<7;dia++)
        {
            for(hora=0;hora<24;hora++)
            {
                if(!tinc(a[dia][hora],paraules))
                {
                    paraules[nump]=a[dia][hora];
                    nump++;
                }
            }
        }
        
        for(i=0;i<nump;i++)
        {
            System.out.print(paraules[i]+",");
            System.out.print("\n");
        }
    }
    
    public static boolean tinc(String p, String [] b)
    {
        int i;
        boolean r=false;
        for(i=0;i<b.length;i++)
        {
            if(p.equalsIgnoreCase(b[i]))
            {
                r=true;
            }
        }
        return r;
    }
}
