import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class myframe extends JFrame  {
    int id =1,Rollnumber;
    String Gender,roll;
    Container c;
    JLabel head,l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4;
    JButton b1,b2,b3;
    JRadioButton r1,r2;
    JFrame frame;


    JTable table;

    //constructor
    myframe(){
        c= this.getContentPane();
        c.setBackground(Color.black);
        c.setLayout(null);


// label field
        head = new JLabel("Student management page");
        head.setBounds(300,0,500,35);
        Font font = new Font("Arial",Font.BOLD,35);
        head.setFont(font);
        head.setForeground(Color.white);
        c.add(head);

        l1 = new JLabel("Enter your details.....");
        l1.setBounds(0,50,500,30);
        Font font1 = new Font("Arial",Font.PLAIN,30);
        l1.setFont(font1);
        l1.setForeground(Color.white);
        c.add(l1);

        l2 = new JLabel("NAME");
        l2.setBounds(50,150,200,30);
        Font font3 = new Font("Arial",Font.PLAIN,25);
        l2.setFont(font3);
        l2.setForeground(Color.white);
        c.add(l2);

        l3 = new JLabel("ROLL NUMBER");
        l3.setBounds(50,250,200,30);
        l3.setFont(font3);
        l3.setForeground(Color.white);
        c.add(l3);

        l4 = new JLabel("COURSE ");
        l4.setBounds(50,350,200,30);
        l4.setFont(font3);
        l4.setForeground(Color.white);
        c.add(l4);


        l5 = new JLabel("CHOOSE YOUR SUBJECT ");
        l5.setBounds(50,575,500,30);
        l5.setFont(font3);
        l5.setForeground(Color.white);
        c.add(l5);

        l6 = new JLabel("SELECT GENDER");
        l6.setBounds(50,450,500,30);
        l6.setFont(font3);
        l6.setForeground(Color.white);
        c.add(l6);


//for Radio Button fields
        r1 = new JRadioButton("male");
        r1.setBounds(150,500,150,30);
        Font font4 = new Font("Arial",Font.PLAIN,15);
        r1.setFont(font4);
        r1.setForeground(Color.black);
        c.add(r1);

        r2 = new JRadioButton("female");
        r2.setBounds(350,500,150,30);
        r2.setFont(font4);
        r2.setForeground(Color.black);
        c.add(r2);


        ButtonGroup one = new ButtonGroup();
        one.add(r1);
        one.add(r2);


        //Action listener for Radio buttons
        r1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gender = r1.getText().toString();
            }
        });

        r2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gender = r2.getText().toString();
            }
        });
// text field work

        t1 = new JTextField(50);
        t1.setBounds(300,150,500,30);
        Font font5 = new Font("Arial",Font.PLAIN,20);
        t1.setFont(font5);
        t1.setForeground(Color.black);
        c.add(t1);

        t2 = new JTextField(50);
        t2.setBounds(300,250,500,30);
        t2.setFont(font5);
        t2.setForeground(Color.black);
        c.add(t2);

        t3 = new JTextField(50);
        t3.setBounds(300,350,500,30);
        t3.setFont(font5);
        t3.setForeground(Color.black);
        c.add(t3);

        t4 = new JTextField(50);
        t4.setBounds(300,610,500,30);
        t4.setFont(font5);
        t4.setForeground(Color.black);
        c.add(t4);



// for button fields

        b1 = new JButton("SAVE");
        b1.setBounds(50,800,150,50);
        b1.setFont(font3);
        b1.setForeground(Color.black);
        c.add(b1);


        b2 = new JButton("NEW");
        b2.setBounds(350,800,150,50);
        b2.setFont(font3);
        b2.setForeground(Color.black);
        c.add(b2);





        b3 = new JButton("EXIT");
        b3.setBounds(650,800,150,50);
        b3.setFont(font3);
        b3.setForeground(Color.black);
        c.add(b3);




        // creating table to store or save data
        Object[][] data = {
                {"SR. NO.","NAME","ROLL no.","BATCH","GENDER","COURSE"},
                {" "," "," "," "," "," "}
        };
        String[] column = {"SR. No.","NAME","ROLL no","BATCH","GENDER","COURSE"};
        DefaultTableModel model = new DefaultTableModel(data,column);
        table = new JTable(model);
        table.setBackground(Color.white);
        table.setFont(font5);
        table.setBounds(900,150,800,700);
        table.setVisible(true);

        c.add(table);
        validate();


//Save button Listener
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // to generate error to fill correct roll number
                try{
                    roll = t2.getText();
                    Rollnumber = Integer.parseInt(roll);

                }catch (Exception a){
                    JOptionPane.showMessageDialog(null,"Please a valid Roll Number","Error",JOptionPane.ERROR_MESSAGE);
                }

                // to ensure all text fields are properly filled..

                if(t1.getText().toString().isEmpty() || t2.getText().toString().isEmpty() || t3.getText().toString().isEmpty() || t4.getText().toString().isEmpty() || !(Rollnumber==Integer.parseInt(roll))){
                    JOptionPane.showMessageDialog(null,"Please fill all the field","Error",JOptionPane.ERROR_MESSAGE);
                }

               else {
                   // entering data to table
                    int Rollnumber = Integer.parseInt(t2.getText().toString());

                    int srno= id++;
                    String Name = t1.getText().toString();
                    String batch = t3.getText().toString();
                    String course = t4.getText().toString();
                    Object[] newrow = {srno,Name, Rollnumber, batch,Gender, course};
                    model.addRow(newrow);
                }
            }
        });
//new button Listener
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.setText(null);
                t2.setText(null);
                t3.setText(null);
                one.clearSelection();
                t4.setText(null);
            }
        });

// Exit button Listener
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame3 = new JFrame("EXIT");
                if(JOptionPane.showConfirmDialog(frame3,"Do you want to exit","Exit", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
                {
                    System.exit(0);
                }
            }
        });






    }



}



//main function

class studentmanagement{
    public static void main(String[] args) {
        myframe frame = new myframe();
        frame.setTitle("Student management page");
        frame.setBounds(100,10,1800,1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}