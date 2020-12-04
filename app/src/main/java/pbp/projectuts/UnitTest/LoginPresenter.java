package pbp.projectuts.UnitTest;

public class LoginPresenter {
    private LoginView view;
    private LoginService service;
    private pbp.projectuts.UnitTest.LoginCallback callback;

    public LoginPresenter(LoginView view, LoginService service) {
        this.view = view;
        this.service = service;
    }

    public void onLoginClicked() throws InterruptedException {
        if (view.getEmail().isEmpty()) {
            view.showEmailError("Email tidak boleh kosong");
            return;
        } else if (view.getPassword().isEmpty()) {
            view.showPasswordError("Password tidak boleh kosong");
            return;
        } else {
            service.setUp();
            return;
        }
    }
}
