package br.com.sistema.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField txtLogin = new JTextField(15);
    private JPasswordField txtSenha = new JPasswordField(15);
    private JButton btnEntrar = new JButton("Entrar");
    private JButton btnCadastrar = new JButton("Novo Usuário");
    private JLabel lblStatus = new JLabel(" ", SwingConstants.CENTER);

    public LoginView() {
        setTitle("Login - Sistema de Cadastro");
        setSize(380, 240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel painelCampos = new JPanel(new GridLayout(2, 2, 10, 10));
        painelCampos.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));
        painelCampos.add(new JLabel("Login:"));
        painelCampos.add(txtLogin);
        painelCampos.add(new JLabel("Senha:"));
        painelCampos.add(txtSenha);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        painelBotoes.add(btnEntrar);
        painelBotoes.add(btnCadastrar);

        JPanel centro = new JPanel(new BorderLayout());
        centro.add(painelCampos, BorderLayout.NORTH);
        centro.add(painelBotoes, BorderLayout.CENTER);

        add(centro, BorderLayout.CENTER);
        add(lblStatus, BorderLayout.SOUTH);
        getRootPane().setDefaultButton(btnEntrar);
    }

    public String getLogin() { return txtLogin.getText(); }
    public String getSenha() { return new String(txtSenha.getPassword()); }

    public void exibirMensagem(String msg, Color cor) {
        lblStatus.setForeground(cor);
        lblStatus.setText(msg);
    }

    public void addEntrarListener(ActionListener l) { btnEntrar.addActionListener(l); }
    public void addCadastrarListener(ActionListener l) { btnCadastrar.addActionListener(l); }
}
