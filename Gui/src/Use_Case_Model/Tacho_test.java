package Use_Case_Model;

import java.awt.*;
import java.applet.Applet;
 

public class Tacho_test extends Applet  implements Runnable 
{
  Thread runner;
  int delayGlb= 0;            // the refresh/update time 
  int Mhe;
  int Mwi;
  int Hhe;
  int Dhe;
  int Ahe;
  double XMin;                            
  double XMax; 
  double XNew;
  double XOld; 
  boolean WHeader;   // true : with header
  boolean WDigital;     // true: with digital part
  boolean WAnalog;   // true: with analog part
  String Header;            
  String Unit;

  String iStr; 
   boolean CHANGED;

   //Colors
  Color HBGColor;     // Header Background 
  Color HFGColor;     // Header Foreground
  Color ABGColor;     // Analog Background
  Color AFGColor;    // Analog Foreground;
  Color DBGColor;     // Digital Background;
  Color DFGColor;     // Digital Foreground;
  Color ERRColor;       // Color if values are out of range
   int SCAColor;          //Color of scale (from scacolor to black)  

  //double-buffering
  Image oimg;
  Graphics og;

//INIT
 public void init()
 {   // Set Colors
       HBGColor = Color.lightGray;
       ABGColor = Color.lightGray;
       DBGColor = Color.lightGray;
 
       HFGColor = Color.black;
       AFGColor = Color.black;
       DFGColor = Color.black;
  
       ERRColor = Color.red;

       SCAColor = 3;      //blue

     // INIT  - PARAMETER
       iStr = getParameter("header");
       if (iStr != null) {WHeader = true;
                                    Header = iStr;
                                  }
       else {WHeader = false;
                  Header    = "";
                 }

       iStr = getParameter("unit");
       if (iStr != null) {Unit = iStr;}
       else {Unit = "";}

       iStr = getParameter("digital");
       if (iStr != null) {if  ( iStr.equals("false")) WDigital = false;
                                   else WDigital = true;
                                  }
       else {WDigital = true;}

       iStr = getParameter("analog");
       if (iStr != null) {if (iStr.equals("false")) WAnalog = false;
                                   else WAnalog = true;
                                  }
       else {WAnalog = true;}


       iStr = getParameter("xfrom");
       if  (iStr != null) {XMin = Float.valueOf(iStr).floatValue();}
       else {XMin = 0;}
       
       iStr = getParameter("xto");
       if  (iStr != null) {XMax = Float.valueOf(iStr).floatValue();}
       else {XMax = 100;}

      iStr = getParameter("x");
      if (iStr != null) {XNew = Float.valueOf(iStr).floatValue();}
      else {XNew = 0;}

    // COLOR-Parameters
     iStr = getParameter("hbgcol");
     if (iStr != null) {HBGColor = WhichColor(HBGColor,iStr);}


     iStr = getParameter("hfgcol");
     if (iStr != null) {HFGColor = WhichColor(HFGColor,iStr);}

     iStr = getParameter("abgcol");
     if (iStr != null) {ABGColor = WhichColor(ABGColor,iStr);}

     iStr = getParameter("afgcol");
     if (iStr != null) {AFGColor = WhichColor(AFGColor,iStr);}

     iStr = getParameter("dbgcol");
     if (iStr != null) {DBGColor = WhichColor(DBGColor,iStr);}

     iStr = getParameter("dfgcol");
     if (iStr != null) {DFGColor = WhichColor(DFGColor,iStr);}

     iStr = getParameter("errcol");
     if (iStr != null) {ERRColor = WhichColor(ERRColor,iStr);}

     iStr = getParameter("scacol");
     if (iStr != null) {SCAColor = CheckSCAColor(SCAColor,iStr);}


    //END of PARAMETER 

    Mhe = this.size().height;
    Mwi  = this.size().width;
    if (WHeader==true) {Hhe  = Mhe / 6;}                       // height of the header
    else Hhe=0;
    if (WDigital==true) {Dhe  = Mhe / 6;}                         // height of the digital instrument
    else Dhe = 0;
    if (WAnalog==true) {Ahe  = Mhe - Hhe - Dhe;}      // height of the analog instrument
    else
    { Ahe = 0; 
       if (WDigital==true) 
       { if (WHeader == true)
          {Hhe = Mhe /3;
            Dhe = Mhe - Hhe;
           }// DIGITAL with header
          else 
          {Hhe = 0;
            Dhe = Mhe;
          }// DIGITAL without header
       }// WITHOUT ANA
       else    // only header (!!!)
       {Hhe = Mhe;
       }
    }

     //double-buffering
     oimg = createImage(this.size().width,this.size().height);
     og      = oimg.getGraphics();

   
    
      XOld = XNew;

      CHANGED = true;

  } // END of INIT





// SETMETER
// Set the value of the meter via
//  document.meter.SetMeter(double V) (JavaScript)
 public void SetMeter(double V)
 { XNew = V; 
   CHANGED=true;
    repaint();    
  }// END of SETMETER


//GETX 
 public double GetX()
 { boolean DB = Changed();
     return XOld;
 }//End of GETX DOUBLE
 

// CHANGED
 public boolean Changed()
 {  boolean DB;
     if (CHANGED==true) {XOld = XNew;
                                               CHANGED = false;
                                                DB = true;
                                              }
    else {DB = false;}
    return DB;
  }// End of CHANGED 

//WhichColor
 public Color WhichColor(Color old, String s)
 { Color c = new Color(0,0,0);
    c = old; 
    
   String ds = s.toUpperCase();
    if (ds.equals("WHITE")==true) { c= Color.white;}
    else
    {if (ds.equals("BLACK")==true) {c =Color.black;}
      else
      {if (ds.equals("LIGHTGRAY")==true) {c = Color.lightGray;}
        else 
        {if (ds.equals("GRAY")==true) {c = Color.gray;}
          else
          {if (ds.equals("DARKGRAY")==true) {c = Color.darkGray;}
            else
            {if (ds.equals("RED")==true) {c= Color.red;}
              else 
              {if (ds.equals("GREEN")==true) {c= Color.green;}
                 else
                 {if (ds.equals("BLUE")==true) {c = Color.blue;}
                    else
                    {if (ds.equals("YELLOW")==true) {c = Color.yellow;}
                       else
                       {if (ds.equals("MAGENTA")==true) {c = Color.magenta;}
                         else
                          {if (ds.equals("CYAN")==true) {c = Color.cyan;}
                            else 
                            {if (ds.equals("PINK")==true) {c = Color.pink;}
                               else
                               {if (ds.equals("ORANGE")==true) {c = Color.orange;}
                               }    
                            } 
                          }
                       }  
                    }
                 }
              } 
            }
          }
        }   
       }
    } 
  return c;
  }//END of WhichCoor

//CheckSCAColor
 public int CheckSCAColor(int old, String s)
 {int c= old;
   String ds= s.toUpperCase();
   if (ds.equals("RED")==true){c=1;}
   else
   {if (ds.equals("GREEN")==true)  {c=2;}
    else 
     {if (ds.equals("BLUE")==true) {c=3;}
     }
   } 
 return c;
 }//End of CheckSCAColor




//SETCOLORS
 public void SetColors(String hbgcolor,
                                            String hfgcolor,
                                            String abgcolor,
                                            String afgcolor,
                                            String dbgcolor,
                                            String dfgcolor,
                                            String errcolor,
                                            String scacolor)
 {
      if (hbgcolor.length()!=0) HBGColor = WhichColor(HBGColor,hbgcolor);
      if (hfgcolor.length()!=0)  HFGColor =  WhichColor(HFGColor,hfgcolor);
      if (abgcolor.length()!=0) ABGColor = WhichColor(ABGColor,abgcolor);
      if (afgcolor.length()!=0)  AFGColor = WhichColor(AFGColor,afgcolor);
      if (dbgcolor.length()!=0) DBGColor = WhichColor(DBGColor,dbgcolor);
      if (dfgcolor.length()!=0)  DFGColor = WhichColor(DFGColor,dfgcolor);
      if (errcolor.length()!=0)  ERRColor = WhichColor(ERRColor,errcolor);
      if (scacolor.length()!=0) SCAColor = CheckSCAColor(SCAColor,scacolor);

     repaint();    

  }//End of SETCOLORS


//SETPARAMETER
// this method is used to set parameters via JavaScript by 
// using document.meter.SetParameter(list of parameter)
 public void SetParameter(String head,
                                                    String unit,
                                                    String digital,
                                                    String analog,
                                                    float xfrom,
                                                    float xto,
                                                    float x)
 { 
    Header = head;
    if (Header.length()==0)   WHeader=false;
                                        else  WHeader=true; 
    Unit = unit;
    if (digital.equals("false")==true) WDigital=false;
                                                 else         WDigital=true; 

    if (analog.equals("false")==true) WAnalog=false;
                                                  else         WAnalog=true;
    XMin = xfrom;
    XMax = xto;
    XNew = x;
    XOld = XNew;
    CHANGED=true; 

    //Recalculation
    if (WHeader==true) {Hhe  = Mhe / 6;}                       // height of the header
    else Hhe=0;
    if (WDigital==true) {Dhe  = Mhe / 6;}                         // height of the digital instrument
    else Dhe = 0;
    if (WAnalog==true) {Ahe  = Mhe - Hhe - Dhe;}      // height of the analog instrument
    else
    { Ahe = 0;
       if (WDigital==true) 
       { if (WHeader == true)
          {Hhe = Mhe /3;
            Dhe = Mhe - Hhe;
           }// DIGITAL with header
          else 
          {Hhe = 0;
            Dhe = Mhe;
          }// DIGITAL without header
       }// WITHOUT ANA
       else    // only header (!!!)
       {Hhe = Mhe;
       }
    }

    //
    repaint(); 


 } // End of SetParameter 

// RUN
 public void run()
 { repaint();
    if (delayGlb != 0)       // it will be used in the future
    {   while (true)
        { pause(delayGlb);
           if (Changed()==true)
           { repaint();
         }
    }//end of dealyGlb != 0
   } 
 }// End of RUN 


// START
 public void start()
 {if (runner == null)
      {runner = new Thread(this);
       runner.start();
     }
  }// End of START


// STOP 
 public void stop()
 {
     if (runner != null)
    {runner.stop();
     runner = null;
     }
  }// End of STOP 


// Pause
   void pause(int time)
   {
     try { Thread.sleep(time);}
     catch (InterruptedException e) {}
   }  

//UPDATE
public void update(Graphics g)
{paint(g);
}//End of update

// PAINT
 public void paint(Graphics g)
 { Font f;
    FontMetrics fm;
    String s;
     int i;
     int x,y;
     double XN;
     int Fhe,fhe;
     int xc,yc,r1,r2,lz;
     int x1,y1,x2,y2,dy;
     int x0,y0,re,gr,bl,w1,c1,c2,c3;
     int fx,fy,lx,ly;
     double dx;
     double xx;
     double VAlpha;
     double VAlphaRad; 
     boolean OutOfRange;
     

/* ============================= FRAMES =========================== */
    // draw the main frame 
    og.setColor(Color.black);
    og. drawRect(0,0,Mwi,Mhe);

   // draw the  frame around the header
  if  (WHeader ==true)
  {   og.setColor(HBGColor);
       og.fillRect(0,0,Mwi-1,Hhe-1);
       og.setColor(Color.black);
       og.drawRect(0,0,Mwi-1,Hhe-1);
  }
  // draw the frame around the anal. instr.
  if (WAnalog==true)
  {  og.setColor(ABGColor);
     og.fillRect(0,Hhe,Mwi-1,Ahe-1);
     og.setColor(Color.black);
     og.drawRect(0,Hhe,Mwi-1,Ahe-1);
  }
  // draw the frame around the dig. instr.
  if (WDigital==true)
  { og.setColor(DBGColor);
     og.fillRect(0,Hhe+Ahe,Mwi-1,Dhe-1);
     og.setColor(Color.black);
     og.drawRect(0,Hhe+Ahe,Mwi-1,Dhe-1);
   } 
  
  /*===================== HEADER ===========================*/ 
  // HEADER
  if (WHeader == true)
  {  Fhe = 21;  // Calculate the font
     do
     { Fhe--; 
        f     = new Font("TimesRoman",Font.PLAIN,Fhe);
        og.setFont(f);
        fm  = getFontMetrics(f);
        fhe= fm.getHeight();
    } while ((fhe+2)>Hhe);
 
       // print the header       
       x = (Mwi/2) - (fm.stringWidth(Header)/2);
       y = (Hhe/2) + (fhe/2) - 2;
       if (x>0) {og.setColor(HFGColor);
	  og.drawString(Header,x,y);
                     }

  } // End of HEADER  

/* ============================== ANALOG - SPEEDO ================ */
  // Speedometer
  if (WAnalog==true)
  {     fx=0; fy=0;lx=0;ly=0;   
        // Calculate the center and r1,r2
    
         if (Ahe < Mwi)
         { r1 = (Ahe / 2) - (Ahe/7);
            lz  = (Ahe/5) - 4;
            if (lz>10) {lz=10;}
           r2 = r1 - lz;
         }
         else
         { r1 = (Mwi / 2) - (Mwi/7);
            lz  = (Mwi/5)-4;
            if (lz>10) {lz=10;}
            r2 = r1 - lz;
          }          
        

          x0     = Mwi / 2 - r1;                           //x,y of the corner 1
          y0     = Mhe-Dhe-(Ahe/2)-r1;

          x1     = Mwi/2 - r2;                            // the corner of the inner circle
          y1     = Mhe - Dhe-(Ahe/2)-r2;


          //draw the arcs
            

          for (i=0;i<10;i++)
          { if (i<5)
            {c1 =204- i*51; 
             c2 =204-i*51;
             c3 = 255;
            }
            else
            {c1 = 0;
             c2 = 0;
             c3=255-(i-4)*51;
            }   
          re=0;gr=0;bl=255;
          switch (SCAColor)
          {case 1: {re=c3;gr=c2;bl=c1;
                }
                break;
            case 2: {re=c2;gr=c3;bl=c1;
                 }
                break;
            case 3: {re = c1;gr=c2;bl=c3;
                }
                break; 
          }
           w1 = 240-i*30;
           og.setColor(new Color(re,gr,bl));
           og.fillArc(x0,y0,2*r1,2*r1,w1,-30);
           og.setColor(AFGColor);
           og.drawArc(x0,y0,2*r1,2*r1,w1,-30);
          }
           og.setColor(ABGColor);
           og.fillOval(x1,y1,2*r2,2*r2);
           og.setColor(AFGColor);
           og.drawOval(x0,y0,2*r1,2*r1);
           og.drawOval(x1,y1,2*r2,2*r2);
           og.setColor(ABGColor);
           og.fillArc(x0-1,y0-1,2*(r1+1),2*(r1+1),240,60); 
          // end of draw arcs           


         og.setColor(AFGColor);          
         // draw the center point
         xc = Mwi/2;                                  // X-Center
         yc = Mhe - Dhe - (Ahe/2);        // Y-Center
         og.fillOval(xc-1,yc-1,2,2);


       //draw the markerlines
       dx =  (XMax - XMin) / 10.0; 
       for (i=1; i<=11;i++)
       { if (i==11) {xx = (XMax-XMin);}
         else {xx =  (i-1)*dx;}
        VAlpha =  240.0 - xx * (300 / (XMax - XMin)) ;
        // [GRAD] -> [RAD]
        VAlphaRad = (VAlpha * 2.0*Math.PI/360.0);
         //Begin
         x1 = xc + (int) (Math.round(r2*Math.cos(VAlphaRad))); 
         y1 = yc  - (int) (Math.round(r2*Math.sin(VAlphaRad)));
         //End
         x2 = xc + (int) (Math.round(r1*Math.cos(VAlphaRad))); 
         y2 = yc  - (int) (Math.round(r1*Math.sin(VAlphaRad)));
         //draw the line
         og.drawLine(x1,y1,x2,y2); 
         //notice the first and last x/y-position
         if (i==1)   {fx = x2; fy=y2;}
         if (i==11) {lx = x2; ly=y2;}                 
       }
       // end of draw markerlines

        //print the scale- text at th first and last position
         //calculate the font
           dy = Mhe - Dhe - fy;
           Fhe = 21;  // the large font
           do
           { Fhe--; 
              f     = new Font("TimesRoman",Font.PLAIN,Fhe);
              og.setFont(f);
              fm  = getFontMetrics(f);
              fhe= fm.getHeight();
            } while ((fhe+1)>(dy)); 
         //left
           s = String.valueOf(XMin);
           x =  fx-(fm.stringWidth(s)/2)-2;
           y =  fy+fm.getHeight();
           if (y > (Hhe+Ahe-3)) {y=Hhe+Ahe-3;}           // 1.01 
            if (x>0) { og.setColor(AFGColor);
                            og.drawString(s,x,y);
                          }
         
          //right
           s = String.valueOf(XMax);
           x = lx-(fm.stringWidth(s)/2)+2;
           y = ly+fm.getHeight();
           if (y > (Hhe+Ahe-3)) {y=Hhe+Ahe-3;}           //1.01
           if ((lx+(fm.stringWidth(s)/2))<Mwi) 
           {og.setColor(AFGColor);
            og.drawString(s,x,y);
            }                    
         
      // draw the value
         // Calculate VAlpha [GRAD]
         XN = GetX();
         if (XN < XMin) {XN = XMin;
                                      OutOfRange=true;
                                     }
         else
         { if (XN > XMax) {XN = XMax;
                                         OutOfRange=true;
                                        }
           else {OutOfRange=false;}
         }       
     
         VAlpha = 240.0 - (XN-XMin)* (300.0 / (XMax - XMin));
         if (VAlpha < 0.0)  {VAlpha = 360.0 + VAlpha;}


         // [GRAD] -> [RAD]
        VAlphaRad = (VAlpha * 2.0*Math.PI/360.0);

         // Calculate the positions x,y
         x = xc + (int) (Math.round((r2-2)*Math.cos(VAlphaRad))); 
         y = yc  - (int) (Math.round((r2-2)*Math.sin(VAlphaRad)));

         // draw the line
         if (OutOfRange==true) {og.setColor(ERRColor);}
         else {og.setColor(AFGColor);}
         og.drawLine(xc,yc,x,y);

       // End of draw value


  } // End of ANALOG


/* ============================= DIGITAL ======================== */
  //DIGITAL
  if (WDigital == true)
 {  Fhe = 21;  // Calculate the font
     do
     { Fhe--; 
        f     = new Font("TimesRoman",Font.PLAIN,Fhe);
        og.setFont(f);
        fm  = getFontMetrics(f);
        fhe= fm.getHeight();
    } while ((fhe+2)>Dhe);
 
       // print the value       
       XN = GetX(); 
       if (XN < XMin) {OutOfRange=true;}
       else 
       { if (XN > XMax) {OutOfRange=true;}
         else {OutOfRange=false;}
       }       

       if (fm.stringWidth(Unit) == 0) {s = String.valueOf(XN);}
       else {s = String.valueOf(XN) + " "+Unit;}
       x = (Mwi/2) - (fm.stringWidth(s)/2);
       y = Mhe - (Dhe/2) + (fhe/2) - 2;         
       if (x>0) 
      { if (OutOfRange==true) {og.setColor(ERRColor);}
        else {og.setColor(DFGColor);}
        og.drawString(s,x,y);
       }


  }  // End of DIGITAL

  //DOUBLE-BUFFERING
 g.drawImage(oimg,0,0,this);


 }// End of PAINT 


}