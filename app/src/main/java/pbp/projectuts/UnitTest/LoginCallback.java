package pbp.projectuts.UnitTest;

import pbp.projectuts.User;

public interface LoginCallback {
    void onSuccess(boolean value, User user);
    void onError();
}

