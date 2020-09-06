package com.yong.petstore.client.bean;

import com.yong.petstore.client.model.Pet;
import com.yong.petstore.client.model.User;

public class Pet2User extends YongBeanConverter<Pet, User> {
    public Pet2User() {
        super(pet -> {
            User user = new User();
            user.setEmail(pet.getName());
            return user;
        });
    }
}
