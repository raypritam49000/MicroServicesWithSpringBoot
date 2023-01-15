package com.contact.service;

import com.contact.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    public static List<Contact> contacts;

    static {
        contacts = List.of(
                new Contact(1L, "raypritam345@gmail.com", "Pritam Ray", 1l),
                new Contact(2L, "amitkumar49023@gmail.com", "Amit Kumar", 2l),
                new Contact(3L, "rahulkumar345@gmail.com", "Rahul Kumar", 3l),
                new Contact(4L, "ajitkumar@gmail.com", "Ajit Kumar", 1l),
                new Contact(5L, "ajaysahani493@gmail.com", "Ajay Sahani", 2l),
                new Contact(6L, "rohitkumar345@gmail.com", "Rohit Kumar", 3l)
        );
    }

    @Override
    public List<Contact> getConatctByUserId(Long userId) {
        return contacts.stream().filter((contact) -> contact.getUserId().equals(userId)).collect(Collectors.toList());
    }
}
