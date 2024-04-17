package DesignPattern;

// 사용자 정보를 관리하기 위해 모델 클래스
class User {
    private String username;
    private String email;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void updateUser(String username, String email) {
        this.username = username;
        this.email = email;
    }
}

// 사용자 정보를 표시하기 위한 뷰 클래스
class UserView implements UserView2 {
    @Override
    public void displayUserInfo(String username, String email) {
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
    }
}

// 사용자 입력을 처리하고 모델과 뷰를 조율하는 컨트롤러 클래스
class UserController {
    private User model;
    private UserView view;

    public UserController(User model, UserView view) {
        this.model = model;
        this.view = view;
    }

    public void updateUser(String username, String email) {
        model.updateUser(username, email);
    }

    public void displayUserInfo() {
        view.displayUserInfo(model.getUsername(), model.getEmail());
    }
}

// 메인 클래스
public class MvcPattern {
    public static void main(String[] args) {
        // 모델, 뷰, 컨트롤러 객체 생성
        User model = new User();
        model.updateUser("hyejin", "hyejin66@gmail.com");

        UserView view = new UserView();

        UserController controller = new UserController(model, view);

        // 사용자 정보 표시
        controller.displayUserInfo();

        // 사용자 정보 업데이트
        controller.updateUser("hyejin", "ddaru@gmail.com");

        // 업데이트된 사용자 정보 다시 표시
        controller.displayUserInfo();
    }
}
