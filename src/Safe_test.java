import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Safe_test extends JFrame{

    public static void main(String[] args) {
        Safe_test F=new Safe_test();
        F.setVisible(true);
    }

    private JPasswordField PF=new JPasswordField();
    private JLabel l1=new JLabel("ACTIVATE");
    private JPanel P1=new JPanel(new GridLayout(3,4,3,3));
    private JButton[] JB=new JButton[12];
    private boolean activate=true;
    private String ENTER="";
    private final String pw = "23323456";

    private Safe_test(){
        init();
    }

    private void init() {
        this.setTitle("safe");
        this.setBounds(100,100,400,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container c1 = this.getContentPane();
        c1.setLayout(new BorderLayout(3,3));
        l1.setFont(new Font(null,Font.BOLD,20));
        PF.setFont(new Font(null,Font.BOLD,20));
        PF.setEditable(false);
        c1.add(l1,BorderLayout.SOUTH);
        c1.add(PF,BorderLayout.NORTH);
        c1.add(P1, BorderLayout.CENTER);
        String[] text={"1","2","3","4","5","6","7","8","9","0","送出","Exit"};
        for(int c=0;c<JB.length;c++)
        {
            JB[c]=new JButton(text[c]);
            JB[c].setFont(new Font(null,Font.BOLD,18));
            JB[c].addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton t=(JButton)e.getSource();
                    enter(t.getText());
                }
            });
            P1.add(JB[c]);
        }
    }

    private void enter(String in) {
        if(in.equals("Exit"))
            System.exit(0);
        else if(activate){
            if(in.equals("送出")){
                activate=false;
                if(ENTER.equals(pw)) {
                    l1.setForeground(Color.green);
                    l1.setText("CLEAR");
                }
                else
                {
                    l1.setForeground(Color.red);
                    l1.setText("ERROR");
                }
            }
            else {
                ENTER += in;
                PF.setText(ENTER);
            }
        }
    }

    private void re(){
        l1.setText("ACTIVATE");
        l1.setForeground(Color.BLACK);
        ENTER="";
        activate=true;
    }
}
