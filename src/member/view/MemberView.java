package member.view;

import member.controller.MemberController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberView {

    JFrame jFrame = new JFrame();
    JPanel jPanel = new JPanel();
    JTextField textField1 = new JTextField();
    JTextField textField2 = new JTextField();
    JTextField textField3 = new JTextField();
    JTextField textField4 = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton btn1, btn2, btn3, btn4, btn5;
    JLabel labelName = new JLabel("이름 : ");
    JLabel labelBirthday = new JLabel("생년월일 :");
    JLabel labelPhone = new JLabel("전화번호 : ");
    JLabel labelSearch = new JLabel("검색내용 : ");

    public MemberView() {
        GUIInit();
    }

    public void GUIInit() {
        jFrame.setTitle("회원관리");
        jFrame.setBounds(50, 50, 480, 450);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        jPanel.setLayout(null);
        jFrame.add(jPanel);

        textField1.setBounds(75, 25, 70, 25);
        labelName.setBounds(37, 21, 70, 30);
        jPanel.add(textField1);
        jPanel.add(labelName);
        textField2.setBounds(213, 25, 70, 25);
        labelBirthday.setBounds(150, 21, 70, 30);
        jPanel.add(textField2);
        jPanel.add(labelBirthday);
        textField3.setBounds(352, 25, 80, 25);
        labelPhone.setBounds(290, 21, 70, 30);
        jPanel.add(textField3);
        jPanel.add(labelPhone);
        textField4.setBounds(213, 105, 80, 25);
        labelSearch.setBounds(150, 100, 70, 30);
        jPanel.add(textField4);
        jPanel.add(labelSearch);

        JScrollPane jScrollPane = new JScrollPane((textArea));
        jScrollPane.setBounds(23, 145, 420, 250);
        jPanel.add(jScrollPane);

        jPanel.add(btn1 = new JButton("Insert"));
        btn1.setBounds(40,60,80,30);
        jPanel.add(btn2 = new JButton("Select"));
        btn2.setBounds(145, 60, 80, 30);
        jPanel.add(btn3 = new JButton("Update"));
        btn3.setBounds(250, 60, 80, 30);
        jPanel.add(btn4 = new JButton("Delete"));
        btn4.setBounds(350, 60, 80, 30);
        jPanel.add(btn5 = new JButton("Search"));
        btn5.setBounds(300, 100, 80, 30);

        MemberController controller = new MemberController();

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
