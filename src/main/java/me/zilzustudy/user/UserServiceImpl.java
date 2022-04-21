package me.zilzustudy.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class UserServiceImpl implements UserService {

    @Override
    public User getUserInfo(Long id) {

        return get(id);
    }

    public User get(Long id) {
        URI uri = UriComponentsBuilder
                .fromUriString("https://jsonplaceholder.typicode.com/users/{user}")
                .build()
                .expand(id)
                .toUri();
        System.out.println("uri.toString() = " + uri.toString());

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<User> forEntity = restTemplate.getForEntity(uri, User.class);

        User user = forEntity.getBody();

        System.out.println(forEntity.getStatusCode());
        System.out.println(forEntity.getHeaders());
        System.out.println(user.toString());

        return forEntity.getBody();
    }

}
