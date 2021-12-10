package member.view;

import member.controller.MemberController;
import member.model.MemberModel;

import javax.swing.*;
import java.util.ArrayList;

public class MemberView{

    JFrame jFrame = new JFrame();
    JPanel jPanel = new JPanel();
    JTextField textField1 = new JTextField();
    JTextField textField2 = new JTextField();
    JTextField textField3 = new JTextField();
    JTextField textField4 = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton btnInsert, btnSelect, btnUpdate, btnDelete, btnSearch;
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

        jPanel.add(btnInsert = new JButton("Insert"));
        btnInsert.setBounds(40,60,80,30);
        jPanel.add(btnSelect = new JButton("Select"));
        btnSelect.setBounds(145, 60, 80, 30);
        jPanel.add(btnUpdate = new JButton("Update"));
        btnUpdate.setBounds(250, 60, 80, 30);
        jPanel.add(btnDelete = new JButton("Delete"));
        btnDelete.setBounds(350, 60, 80, 30);
        jPanel.add(btnSearch = new JButton("Search"));
        btnSearch.setBounds(300, 100, 80, 30);

        MemberController controller = new MemberController();

        btnInsert.addActionListener(e -> {
            textArea.setText("");

            controller.insertMember(new MemberModel(textField1.getText(), textField2.getText(), textField3.getText()));

            textArea.append("입력 완료\n");
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
        });

        btnSelect.addActionListener(e -> {
            textArea.setText("");

            ArrayList<MemberModel> memberModels = controller.selectMember();
            textArea.append("\t" + "name" + "\t" + "birth" + "\t" + "tel\n");
            textArea.append("\t" + "------------------------------------------------------------\n");

            for (MemberModel memberModel : memberModels) {
                textArea.append("\t" + memberModel.getName() + " \t " + memberModel.getBirthday() + " \t " + memberModel.getTel() + "\n");
            }
        });

        btnUpdate.addActionListener(e -> {
            textArea.setText("");

            controller.updateMember(textField1.getText(), textField2.getText(), textField3.getText());
            textArea.append("수정 완료\n");
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
        });

        btnDelete.addActionListener(e -> {
            textArea.setText("");
            controller.deleteMember(textField1.getText());
            textArea.append("삭제 완료\n");

            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
        });

        btnSearch.addActionListener(e -> {
            textArea.setText("");

            ArrayList<MemberModel> memberModels = controller.searchMember(textField4.getText());
            textArea.append("\t" + "name" + "\t" + "birth" + "\t" + "tel\n");
            textArea.append("\t" + "------------------------------------------------------------\n");

            for(MemberModel model : memberModels) {
                textArea.append("\t" + model.getName() + "\t" + model.getBirthday() + "\t" + model.getTel());
            }

            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
        });
    }
}
