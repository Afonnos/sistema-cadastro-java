package br.com.sistema.controller;

import br.com.sistema.model.AutenticacaoModel;
import br.com.sistema.model.UsuarioModel;
import br.com.sistema.view.CadastroView;
import br.com.sistema.view.LoginView;

import java.awt.Color;
import java.util.List;

public class LoginController {
    public LoginController(AutenticacaoModel authModel, LoginView loginView) {

        loginView.addEntrarListener(e -> {
            String login = loginView.getLogin();
            String senha = loginView.getSenha();

            if (login.trim().isEmpty() || senha.trim().isEmpty()) {
                loginView.exibirMensagem("Informe login e senha!", Color.RED);
                return;
            }

            if (authModel.autenticar(login, senha)) {
                loginView.dispose();

                UsuarioModel model = new UsuarioModel();
                CadastroView view = new CadastroView();

                List<String> salvos = model.getUsuarios();
                for (int i = 0; i < salvos.size(); i++) {
                    view.adicionarLinhaTabela(i + 1, salvos.get(i));
                }

                new CadastroController(model, view);
                view.setVisible(true);
            } else {
                loginView.exibirMensagem("Login/Senha incorretos!", Color.RED);
            }
        });

        loginView.addCadastrarListener(e -> {
            String login = loginView.getLogin();
            String senha = loginView.getSenha();

            if (login.trim().isEmpty() || senha.trim().isEmpty()) {
                loginView.exibirMensagem("Informe login e senha!", Color.RED);
                return;
            }

            if (authModel.cadastrarNovoUsuario(login, senha)) {
                loginView.exibirMensagem("Login cadastrado com sucesso!", new Color(0, 128, 0));
            } else {
                loginView.exibirMensagem("Erro ao cadastrar login!", Color.RED);
            }
        });
    }
}
