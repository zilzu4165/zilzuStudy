package me.zilzustudy.user;

public class ZilzuUserServiceImpl implements UserService {

    Geo geo = new Geo("36.5", "38");
    Address zilzuAddress = new Address("신사로 20길 10-14", "허브하우스 201호", "Seoul", "1234567890", geo);

    @Override
    public User getUserInfo(Long id) {
        return new User(1, "ParkSeongsu", "zilzu94@gmail.com", "zilzu", "01083662113", "zilzu.com", zilzuAddress);
    }
}
