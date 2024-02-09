package Producer;

import Requests.RequestsManager;
import Users.User;

public class Logic {
    RequestsManager requestsManager = new RequestsManager();
    public void producer() {
        User user = requestsManager.getUser();

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
