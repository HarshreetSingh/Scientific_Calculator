
import java.awt.*;
import java.text.DecimalFormat;
import java.awt.event.*;
import javax.swing.*;

public class Welcome implements ActionListener 
{
	JFrame f,f1,f2;
	JButton b1,b2;
	JLabel l;
	ImageIcon img;
	Welcome(String s)
	{
		f=new JFrame(s);
		b1=new JButton("Basic Calculator");
		b2=new JButton("Scientific Calculator");
		b1.setBounds(50, 50, 50, 60);
		b1.setPreferredSize(new Dimension(200,60));
		b1.setFont(new Font("SansSerif",Font.BOLD,15));
		f.add(b1);
		b1.addActionListener(this); 
		b2.setBounds(120, 50, 50, 60);
		b2.setPreferredSize(new Dimension(200,60));
		b2.setFont(new Font("SansSerif",Font.BOLD,15));
		b2.addActionListener(this);
		f.add(b2);
			l=new JLabel(img);
		f.add(l);
		f.setBounds(200,200,100,200);
		f.setVisible(true);
		f.setLayout(new FlowLayout(FlowLayout.LEFT,100,100));
		f.setResizable(false);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{   
			/*f1=new JFrame("hello");
			f1.setSize(400,400);
			f1.setLayout(null);
			f1.setVisible(true);*/
			
			new Basic("BASIC CALCULATOR");
			f.dispose();
		}	
		if(e.getSource()==b2)
		{   
			/*f2=new JFrame("bye");
			f2.setSize(500,500);
			f2.setLayout(null);
			f2.setVisible(true);
			*/
			new Scientific("SCIENTIFIC CALCULATOR");
			f.dispose();
		}		
		}
	
	public static void main(String[] args) {
		
new Welcome("WELCOME TO CALCULATOR");
	}

}
class Basic implements ActionListener
{
JFrame f;
JTextField t;
int c;
DecimalFormat pat;
JButton b[],ba;
Panel p;
String calc[]={"C","BS","+/-","+","7","8","9","-","4","5","6","*","1","2","3","/","0",".","=","%"};
String s1,s2,op;
double n=0.0;
Basic(String s)
{
p=new Panel();
f=new JFrame(s);
t=new JTextField();
b=new JButton[20];
ba=new JButton(" GO FOR SCIENTIFIC CALCULATOR -->");
ba.setPreferredSize(new Dimension(300,35));
ba.addActionListener(this);
f.add(ba);
t.setPreferredSize(new Dimension(350,45));
t.setFont(new Font("SansSerif",Font.BOLD,25));
t.setHorizontalAlignment(JTextField.RIGHT);
f.add(t);
t.setForeground(Color.RED);
pat = new DecimalFormat("#######.###");

p.setLayout(new GridLayout(5,4,10,5));
for( c=0;c<b.length;c++)
{
	b[c]=new JButton(calc[c]);
	b[c].addActionListener(this);
	b[c].setPreferredSize(new Dimension(80,50));
	b[c].setFont(new Font("SansSerif",Font.BOLD,25));

	p.add(b[c]);
}
f.setResizable(false);
f.setLayout(new FlowLayout(FlowLayout.LEFT,10,50));
f.add(p);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setSize(400,550);
f.setVisible(true);
}
static boolean isInString(String s, char ch)  
{  
for(int i=0; i<s.length();i++) if(s.charAt(i)==ch) return true;  
return false;  
} 
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==ba)
	{
	new Scientific("SCIENTIFIC CALCULATOR");
	f.dispose();
	}
if(e.getSource()==b[16])
t.setText(t.getText().concat("0"));
if(e.getSource()==b[12])
t.setText(t.getText().concat("1"));
if(e.getSource()==b[13])
t.setText(t.getText().concat("2"));
if(e.getSource()==b[14])
t.setText(t.getText().concat("3"));
if(e.getSource()==b[8])
t.setText(t.getText().concat("4"));
if(e.getSource()==b[9])
t.setText(t.getText().concat("5"));
if(e.getSource()==b[10])
t.setText(t.getText().concat("6"));
if(e.getSource()==b[4])
t.setText(t.getText().concat("7"));
if(e.getSource()==b[5])
t.setText(t.getText().concat("8"));
if(e.getSource()==b[6])
t.setText(t.getText().concat("9"));
 
if(e.getSource()==b[17])
{ if(!isInString(t.getText(),'.'))  
		    t.setText(t.getText()+".");  
}
if(e.getSource()==b[3])
{
s1=t.getText();
 t.setText("");
 op="+";
}
if(e.getSource()==b[7])
{
s1=t.getText();
 t.setText("");
 op="-";
}
if(e.getSource()==b[11])
{
s1=t.getText();
 t.setText("");
 op="*";
}
if(e.getSource()==b[15])
{
s1=t.getText();
 t.setText("");
 op="/";
}
if(e.getSource()==b[19])
{
s1=t.getText();
 t.setText("");
 op="%";
}
if(e.getSource()==b[18])
{
s2=t.getText();
 switch(op)
{
case "+": n=Double.parseDouble(s1)+Double.parseDouble(s2);
t.setText(pat.format(n));
break;
case "-": n=Double.parseDouble(s1)-Double.parseDouble(s2);
t.setText(pat.format(n));
break;
case "*": n=Double.parseDouble(s1)*Double.parseDouble(s2);
t.setText(pat.format(n));
break;
case "/": try{
if(Double.parseDouble(s2)!=0)
{n=Double.parseDouble(s1)/Double.parseDouble(s2);
t.setText(pat.format(n));

}
else
t.setText("Infinite");
}
catch(ArithmeticException e1)
{}
break;
case "%": n=Double.parseDouble(s1)%Double.parseDouble(s2);
t.setText(pat.format(n));
}}
if(e.getSource()==b[0])
t.setText("");
if(e.getSource()==b[1])
{
String b=null;
if(t.getText().length()>0)
{
StringBuilder sb=new StringBuilder(t.getText());
sb.deleteCharAt(t.getText().length()-1);
b=sb.toString();
t.setText(b);
}
}
if(e.getSource()==b[2])
{	 try{
s1=t.getText();
char ch= s1.charAt(0);
if(ch==' ')
	t.setText("please enter a number first");
else
{
	double m=Double.parseDouble(t.getText());
	m*=-1;
	t.setText(String.valueOf(m));
}
}
catch(Exception e1)	{}
}
}
}

class Scientific implements ActionListener
{
	JFrame f;
	JTextField t;
	int c;
	DecimalFormat pat;
	JButton b[],si;
	Panel p;
	String calc[]={"C",	"BS", "+/-", "+", "x^2", "sin","sinh",
			"7", "8", "9", "-", "x^3", "cos","cosh",
			"4", "5", "6", "*", "sqrt", "tan","tanh",
			"1", "2", "3", "/", "1/x", "log","bin",
			"0", ".", "=", "MOD", "!", "ln","oct"   };
String s1,s2,op;
double n=0.0;
Scientific(String s)
{
p=new Panel();
f=new JFrame(s);
t=new JTextField();
b=new JButton[35];
si=new JButton(" <-- GO BACK TO BASIC CALCULATOR");

si.setPreferredSize(new Dimension(400,35));
si.addActionListener(this);
f.add(si);
t.setPreferredSize(new Dimension(1000,45));
t.setFont(new Font("SansSerif",Font.BOLD,25));
t.setHorizontalAlignment(JTextField.RIGHT);

f.add(t);
t.setForeground(Color.RED);
pat = new DecimalFormat("#######.###");

p.setLayout(new GridLayout(5,4,10,5));
for( c=0;c<b.length;c++)
{
b[c]=new JButton(calc[c]);
b[c].addActionListener(this);
b[c].setPreferredSize(new Dimension(140,50));
b[c].setFont(new Font("SansSerif",Font.BOLD,25));
p.add(b[c]);
}

f.setLayout(new FlowLayout(FlowLayout.LEFT,10,50));
f.add(p);
f.setResizable(false);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setSize(1090,600);
f.setVisible(true);
}
static boolean isInString(String s, char ch)  
{  
for(int i=0; i<s.length();i++) 
if(s.charAt(i)==ch) 	
	return true;  
return false;  
} 
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==si)
{
new Basic("simple");
f.dispose();
}
if(e.getSource()==b[0])
t.setText("");	
if(e.getSource()==b[28])
t.setText(t.getText().concat("0"));
if(e.getSource()==b[21])
t.setText(t.getText().concat("1"));
if(e.getSource()==b[22])
t.setText(t.getText().concat("2"));
if(e.getSource()==b[23])
t.setText(t.getText().concat("3"));
if(e.getSource()==b[14])
t.setText(t.getText().concat("4"));
if(e.getSource()==b[15])
t.setText(t.getText().concat("5"));
if(e.getSource()==b[16])
t.setText(t.getText().concat("6"));
if(e.getSource()==b[7])
t.setText(t.getText().concat("7"));
if(e.getSource()==b[8])
t.setText(t.getText().concat("8"));
if(e.getSource()==b[9])
t.setText(t.getText().concat("9"));
if(e.getSource()==b[29])
{	
if(!isInString(t.getText(),'.'))  
 t.setText(t.getText()+".");  
}
if(e.getSource()==b[1])
{
String b=null;
if(t.getText().length()>0)
{
	StringBuilder sb=new StringBuilder(t.getText());
	sb.deleteCharAt(t.getText().length()-1);
	b=sb.toString();
	t.setText(b);
}
}
if(e.getSource()==b[2])
{	 try{
s1=t.getText();
char ch= s1.charAt(0);
if(ch==' ')
	t.setText("please enter a number first");
else
{
	double m=Double.parseDouble(t.getText());
	m*=-1;
	t.setText(String.valueOf(m));
}
}
catch(Exception e1)	{}

}
if(e.getSource()==b[3])
{
s1=t.getText();
t.setText("");
op="+";
}
if(e.getSource()==b[10])
{
s1=t.getText();
t.setText("");
op="-";
}
if(e.getSource()==b[17])
{
s1=t.getText();
t.setText("");
op="*";
}
if(e.getSource()==b[24])
{
s1=t.getText();
t.setText("");
op="/";
}
if(e.getSource()==b[31])
{
s1=t.getText();
t.setText("");
op="%";
}

if(e.getSource()==b[4])
{   try{
		s1=t.getText();
		char ch= s1.charAt(0);
		if(ch==' ')
			t.setText("please enter a number first");
		else
		{
			t.setText(t.getText().concat("^2"));
			op="^2";
		}
	}
	catch( Exception e1)  {}
}
if(e.getSource()==b[11])
{   try{
		s1=t.getText();
		char ch= s1.charAt(0);
		if(ch==' ')
			t.setText("please enter a number first");
		else
		{
			t.setText(t.getText().concat("^3"));
			op="^3";
		}
	}
	catch(Exception e1)	{}
}
if(e.getSource()==b[18])
{    try{
		s1=t.getText();
		char ch= s1.charAt(0);
		if(ch==' ')
			t.setText("please enter a number first");
		else
		{	
			t.setText("sqrt  ".concat(s1));
			op="sqrt";
		}
	}
catch(Exception e1)	{}
}
if(e.getSource()==b[25])
{	 try{
s1=t.getText();
char ch= s1.charAt(0);
if(ch==' ')
	t.setText("please enter a number first");
else
{	
	t.setText("1/".concat(s1));
	op="1/x";
}
}
catch(Exception e1)	{}	
}
if(e.getSource()==b[32])
{    try{
		s1=t.getText();
		char ch= s1.charAt(0);
		if(ch==' ')
			t.setText("invalid");
		else
		{
			t.setText(t.getText().concat(" !"));
			op="!";
		}
	}
	catch(Exception e1)  {}
}
if(e.getSource()==b[5])
{   try{
s1=t.getText();
char ch= s1.charAt(0);
if(ch==' ')
	t.setText("please enter a number first");
else
{
	t.setText("sin ".concat(s1));
	op="sin";
}
}
catch(Exception e1)	{}
}

if(e.getSource()==b[12])
{   
try{
	s1=t.getText();
	char ch= s1.charAt(0);
	if(ch==' ')
		t.setText("please enter a number first");
	else
	{
		t.setText("cos ".concat(s1));
		op="cos";
	}
	}
	catch(Exception e1)	{}
}
if(e.getSource()==b[19])
{   
try{
		s1=t.getText();
		char ch= s1.charAt(0);
		if(ch==' ')
			t.setText("please enter a number first");
		else
		{
			t.setText("tan ".concat(s1));
			op="tan";
		}
	}
	catch(Exception e1)	{}
}
if(e.getSource()==b[26])
{    try{
		s1=t.getText();
		char ch= s1.charAt(0);
		if(ch==' ')
			t.setText("please enter a number first");
		else
		{
			t.setText("log ".concat(s1));
			op="log";
		}
	}
	catch(Exception e1)	{}
}
if(e.getSource()==b[33])
{    try
{
	s1=t.getText();
	char ch= s1.charAt(0);
	if(ch==' ')
	t.setText("please enter a number first");
	else
	{
	t.setText("ln ".concat(s1));
	op="ln";
	}
}
catch(Exception e1)	{}
}
if(e.getSource()==b[6])
{   try{
s1=t.getText();
char ch= s1.charAt(0);
if(ch==' ')
	t.setText("please enter a number first");
else
{
	t.setText("sinh ".concat(s1));
	op="sinh";
}
}
catch(Exception e1)	{}
}
if(e.getSource()==b[13])
{   try{
s1=t.getText();
char ch= s1.charAt(0);
if(ch==' ')
	t.setText("please enter a number first");
else
{
	t.setText("cosh ".concat(s1));
	op="cosh";
}
}
catch(Exception e1)	{}
}
if(e.getSource()==b[20])
{   try{
s1=t.getText();
char ch= s1.charAt(0);
if(ch==' ')
	t.setText("please enter a number first");
else
{
	t.setText("tanh ".concat(s1));
	op="tanh";
}
}
catch(Exception e1)	{}
}
if(e.getSource()==b[27])
{   try{
s1=t.getText();
char ch= s1.charAt(0);
if(ch==' ')
	t.setText("please enter a number first");
else
{
	t.setText("bin ".concat(s1));
	op="bin";
}
}
catch(Exception e1)	{}
}
if(e.getSource()==b[34])
{   try{
s1=t.getText();
char ch= s1.charAt(0);
if(ch==' ')
	t.setText("please enter a number first");
else
{
	t.setText("oct ".concat(s1));
	op="oct";
}
}
catch(Exception e1)	{}
}
if(e.getSource()==b[30])
{
s2=t.getText();
try
{
	if(s2!=null)
{switch(op)
{
	case "+": n=Double.parseDouble(s1)+Double.parseDouble(s2);
			  t.setText(pat.format(n));
			  break;
	case "-": n=Double.parseDouble(s1)-Double.parseDouble(s2);
			  t.setText(pat.format(n));
			  break;
	case "*": n=Double.parseDouble(s1)*Double.parseDouble(s2);
			  t.setText(pat.format(n));
			  break;
	case "/": try
			  {
				if(Double.parseDouble(s2)!=0)
				{
					n=Double.parseDouble(s1)/Double.parseDouble(s2);
					t.setText(pat.format(n));
				}
				else
					t.setText("Infinite");
			  }
			  catch(ArithmeticException e1) {}
			  break;
	case "%": n=Double.parseDouble(s1)%Double.parseDouble(s2);
			  t.setText(pat.format(n));
			  break;
	case "^2":n=Double.parseDouble(s1);
			  n=Math.pow(n, 2);
			  t.setText(pat.format(n));
			  break;
	case "^3":n=Double.parseDouble(s1);
		      n=Math.pow(n, 3);
		      t.setText(pat.format(n));
		      break;			
	case "sqrt":n=Double.parseDouble(s1);
				n=Math.pow(n, 0.5);
				t.setText(pat.format(n));
				break;	
	case "1/x":try
			   {
					if(Double.parseDouble(s1)!=0)
					{
						n=1/Double.parseDouble(s1);
						t.setText(pat.format(n));
					}
					else
						t.setText("Infinite");
			   }
			   catch(ArithmeticException e1)
			   {}
			   break;
	case "!": try{
					n=Integer.parseInt(s1);
					long m=1;
					if(n>0)
					{
						for(int x=1;x<=n;x++)
							m=m*x;
						t.setText(pat.format(m));
					}
					else
						t.setText("invalid!!");
				}
				catch(Exception e1){}
				break;
	case "sin":n=Double.parseDouble(s1);
			   n=n*Math.PI/180;
			   n=Math.sin(n);
			   t.setText(pat.format(n));
			   break;
	case "cos":n=Double.parseDouble(s1);
		       n=n*Math.PI/180;
		       n=Math.cos(n);
		       t.setText(pat.format(n));
		       break;
	case "tan":n=Double.parseDouble(s1);
			   n=n*Math.PI/180;
			   n=Math.tan(n);
			   t.setText(pat.format(n));
			   break;
	case "log":n=Double.parseDouble(s1);
			   n=Math.log10(n);
			   t.setText(pat.format(n));
			   break;
	case "ln":n=Double.parseDouble(s1);
			  n=Math.log(n);
			  t.setText(pat.format(n));
			  break;
	case "sinh":n=Double.parseDouble(s1);
		       //n=n*Math.PI/180;
		       n=Math.sinh(n);
		       t.setText(pat.format(n));
		       break;
	case "cosh":n=Double.parseDouble(s1);
		       //n=n*Math.PI/180;
		       n=Math.cosh(n);
		       t.setText(pat.format(n));
		       break;
	case "tanh":n=Double.parseDouble(s1);
		       //n=n*Math.PI/180;
		       n=Math.tanh(n);
		       t.setText(pat.format(n));
		       break;
	case "bin": n=Integer.parseInt(s1);
			String bi=" ";
					int rem1 = 0;
				 while((int)n!=0 )
			{
				   	 rem1 = (int)n%2;
				bi=rem1+bi;
						 n = n/2;
				 }
			t.setText(bi);
			break;
	case "oct": n=Integer.parseInt(s1);
			String oc=" ";
					 rem1 = 0;
				 while((int)n!=0 )
			{
				   	 rem1 = (int)n%8;
				oc=rem1+oc;
						 n = n/8;
				 }
			t.setText(oc);
			break;

					
}}
	else
		t.setText(s1);
}
catch(Exception e1){ }
}
}
}
